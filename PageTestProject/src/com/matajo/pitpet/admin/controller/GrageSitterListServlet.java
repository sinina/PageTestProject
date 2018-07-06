package com.matajo.pitpet.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.admin.model.service.PetsitInfoService;
import com.matajo.pitpet.admin.model.vo.PetsitInfoVo;

@WebServlet("/gradeSitterList.do")
public class GrageSitterListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GrageSitterListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PetsitInfoVo pI = new PetsitInfoService().getGradePetsit();
		
		RequestDispatcher view = null;
		
		if(pI!=null){
			request.setAttribute("pI", pI);
			view = request.getRequestDispatcher("views/admin/gradePetsitList.jsp");
			view.forward(request, response);
			
		}
	
	}

}
