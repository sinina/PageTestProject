package com.matajo.pitpet.petapply.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.MemberService;

@WebServlet("/confirm.do")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConfirmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		//selectNo : 승인(1)/승인취소(2)를 구분하기위한 변수
		int selectNo = Integer.parseInt(request.getParameter("selectNo"));
		
		int result = new MemberService().updateMember(memberNo,selectNo);
		
		
		//펫시터 승인 완료
		if(0<result){
			
			//회원 코드 2로 변경후 리스트에서 안보이게 해야하므로 okayN 변경하는 서블릿으로 이동
			response.sendRedirect("/ptp/updateOkayN.do?memberNo="+memberNo+"&selectNo="+selectNo);
		}
		//펫시터 승인 실패
		else{
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "회원 삭제에 실패하였습니다.");
			view.forward(request, response);
			
		}
	}

}
