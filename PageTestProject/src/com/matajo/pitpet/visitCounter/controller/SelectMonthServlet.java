package com.matajo.pitpet.visitCounter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.visitCounter.model.service.VisitCountService;
import com.matajo.pitpet.visitCounter.model.vo.VisitCountVo;

/**
 * Servlet implementation class SelectMonthServlet
 */
@WebServlet("/selectMonth.do")
public class SelectMonthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMonthServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = null;
		List<VisitCountVo> list = new VisitCountService().getMonthCount();
		if(list!=null){
			
		}else{
			
		}
		
		view.forward(request, response);
		
		
	}

}
