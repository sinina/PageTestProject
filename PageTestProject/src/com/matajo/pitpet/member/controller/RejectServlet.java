package com.matajo.pitpet.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.PetsitterService;

@WebServlet("/reject.do")
public class RejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RejectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pNo = Integer.parseInt(request.getParameter("pNo"));
		
		int result = new PetsitterService().deletePetsitterInfo(pNo);
		
		if(0<result){
			
		}else{
			
		}
		
	}

}
