package com.matajo.pitpet.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;

@WebServlet("/pwssCheck.do")
public class PassCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PassCheckServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pass = request.getParameter("userPwd");
		MemberVo user = (MemberVo)(request.getSession().getAttribute("user"));
		MemberVo member = new MemberService().selectPass(user.getId(), pass);
		
		int result = 0;
		if(null == member){
			result =1;
		}
		
		response.getWriter().println(result);
	}

}
