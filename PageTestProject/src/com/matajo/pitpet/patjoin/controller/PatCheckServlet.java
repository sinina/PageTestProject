package com.matajo.pitpet.patjoin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.patjoin.model.service.PatService;
import com.matajo.pitpet.patjoin.model.vo.PatVo;

@WebServlet("/patCheck.do")
public class PatCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		PatVo pat = new PatService().patSelect(id);
		
		int result = 0;
		if(null == pat){
			result =1;
		}
		
		response.getWriter().println(result);
	}

}
