package com.matajo.pitpet.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.admin.model.service.PetsitInfoService;

@WebServlet("/updateGradePets.do")
public class UpdateGradePetsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateGradePetsServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		int result = new PetsitInfoService().updatePetsGrade(memberNo);
		
		if(result>0){
			response.sendRedirect("/ptp/gradeSitterList.do");
		}
	
	}

}
