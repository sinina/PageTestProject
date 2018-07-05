package com.matajo.pitpet.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.patjoin.model.service.PatService;
import com.matajo.pitpet.patjoin.model.vo.PatVo;

@WebServlet("/MemberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
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
	
		int result = new MemberService().UpdateMember(member);
		HttpSession session;
	
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		if(0<result){
			//현재 member정보로 session값 수정
			session = request.getSession();
			session.setAttribute("user", member);
			//회원정보 수정페이지 -> 인덱스페이지
			response.sendRedirect("index.jsp");
		}else{
			rd.forward(request, response);
		}
		
	}

}
