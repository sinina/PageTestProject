package com.matajo.pitpet.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.MemberService;

@WebServlet("/reject.do")
public class RejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RejectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo= Integer.parseInt(request.getParameter("memberNo"));
		int selectNo = Integer.parseInt(request.getParameter("selectNo"));
		
		int result = new MemberService().updateMember(memberNo, selectNo);
		
		if(0<result){
			response.sendRedirect("/ptp/updateOkayN.do?memberNo="+memberNo+"&selectNo="+selectNo);
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "회원 삭제에 실패하였습니다.");
			view.forward(request, response);
		}
		
	}

}
