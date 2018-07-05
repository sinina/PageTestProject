package com.matajo.pitpet.patjoin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.patjoin.model.service.PatService;

@WebServlet("/patearlse.do")
public class PatEaelseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatEaelseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("userId"));
		
		int result = new PatService().PatEarlse(id);
		RequestDispatcher rd = request.getRequestDispatcher("views/member/myPage.jsp");
		if(0<result){
			request.setAttribute("pat", "예");
		}else{
			request.setAttribute("exit", "아니요");
		}
		rd.forward(request, response);
	}

}