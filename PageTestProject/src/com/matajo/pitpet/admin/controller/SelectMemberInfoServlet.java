package com.matajo.pitpet.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;

@WebServlet("/selectMemberInfo.do")
public class SelectMemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMemberInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int selectNo = Integer.parseInt(request.getParameter("selectNo"));
		
		MemberVo mv = new MemberService().selectMemberInfo(memberNo);
		
		
		RequestDispatcher view = null;
		if(mv!=null){
			request.setAttribute("selectNo", selectNo);
			request.setAttribute("mv", mv);
			//회원 정보 가지고 회원정보 수정 페이지로 이동
			view=request.getRequestDispatcher("/views/admin/memberInfo.jsp");
			view.forward(request, response);
		}
	}

}
