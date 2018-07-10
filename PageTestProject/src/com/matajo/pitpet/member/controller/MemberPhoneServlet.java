package com.matajo.pitpet.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;

@WebServlet("/phoneCheck.do")
public class MemberPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberPhoneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String phone = request.getParameter("userPhone");
		MemberVo member = new MemberService().selectPhone(phone);
		int result = 0;
		if(null == member){
			result =1;
		}
		
		response.getWriter().println(result);
	}

}
