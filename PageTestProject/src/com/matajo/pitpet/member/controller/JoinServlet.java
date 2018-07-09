package com.matajo.pitpet.member.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;


@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("uid");
		String pwd = request.getParameter("upass");
		String userName = request.getParameter("patName");
		String phone = request.getParameter("patPhone");
		int bir = Integer.parseInt(request.getParameter("yy"));
		int jender = Integer.parseInt(request.getParameter("sex"));
		
		String address = request.getParameter("sample6_postcode") + ", " 
				+ request.getParameter("sample6_address") + ", "
				+ request.getParameter("sample6_address2");
		
		MemberVo member = new MemberVo();
		
		int year = new GregorianCalendar().get(Calendar.YEAR);
		int age = year - bir + 1;
		
		member.setId(id);
		member.setPwd(pwd);
		member.setName(userName);
		member.setPhone(phone);
		member.setAge(age);
		member.setAddress(address);
		member.setGender(jender==0?'M':'F');
	
		int result = new MemberService().insertMember(member);
		
		String url="/index.jsp";
		RequestDispatcher view = request.getRequestDispatcher(url);
		if(0<result){
			request.setAttribute("joinMsg", "성공");
		}else{
			request.setAttribute("joinMsg", "실패");
		}
		view.forward(request, response);
		
	}
}
