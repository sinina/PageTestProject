package com.matajo.pitpet.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;

@WebServlet("/updateMemberInfo.do")
public class UpdateMemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMemberInfoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("uid");
		String pwd = request.getParameter("upass");
		String userName = request.getParameter("patName");
		String phone = request.getParameter("patPhone");
		int age = Integer.parseInt(request.getParameter("patAge"));
		int jender = Integer.parseInt(request.getParameter("sex"));
		
		String address = request.getParameter("sample6_postcode") + ", " 
				+ request.getParameter("sample6_address") + ", "
				+ request.getParameter("sample6_address2");
		int no = Integer.parseInt(request.getParameter("uNo"));
		int selectNo = Integer.parseInt(request.getParameter("selectNo"));
		
		MemberVo mv = new MemberVo();
		mv.setId(id);
		mv.setPwd(pwd);
		mv.setName(userName);
		mv.setPhone(phone);
		mv.setAge(age);
		mv.setAddress(address);
		mv.setGender(jender==0?'M':'F');
		mv.setNo(no);
		int result = new MemberService().updateMemberInfo(mv);
		
		if(0<result){
			if(selectNo==1){
				response.sendRedirect("/ptp/omemberList.do");
			}else if(selectNo==2){
				response.sendRedirect("/ptp/pmemberList.do");
			}
		}
	}

}
