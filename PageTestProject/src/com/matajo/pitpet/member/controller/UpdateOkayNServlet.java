package com.matajo.pitpet.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.PetsitterService;

@WebServlet("/updateOkayN.do")
public class UpdateOkayNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateOkayNServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo=Integer.parseInt(request.getParameter("memberNo"));
		
		int result = new PetsitterService().updateOkayN(memberNo);
		
		if(0<result){
			
		}else{
			
		}
	}

}
