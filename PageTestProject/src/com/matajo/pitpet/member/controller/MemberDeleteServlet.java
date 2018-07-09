package com.matajo.pitpet.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.matajo.pitpet.member.model.service.MemberService;

@WebServlet("/memberDelete.do")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDeleteServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("userId");
		
		int result = new MemberService().MemberDelete(id);
		
		if(0<result){
			HttpSession session = request.getSession(false); // false 일 경우 기존 세션이 있다면 기존세션 리턴, 없다면 null 리턴
			if(session != null){
				//session값 삭제
				session.invalidate();			
			}
			response.sendRedirect("index.jsp");
		}else{
			request.setAttribute("msg", "회원 탈퇴중 문제가 발생하였습니다.");
			RequestDispatcher rs = request.getRequestDispatcher("views/member/error.jsp");
			rs.forward(request, response);
		}
	}

}
