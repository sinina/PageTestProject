package com.matajo.pitpet.patjoin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.patjoin.model.service.PatService;
import com.matajo.pitpet.patjoin.model.vo.PatVo;

@WebServlet("/patjoinab.do")
public class PatJoinabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatJoinabServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("userId");
		PatVo pat = new PatService().patSelect(id);
		
		
		request.setAttribute("su", pat);
		RequestDispatcher view = request.getRequestDispatcher("views/member/myPage.jsp");
		view.forward(request, response);
	}

}
