package com.matajo.pitpet.patjoin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.patjoin.model.service.PatService;
import com.matajo.pitpet.patjoin.model.vo.PatVo;

@WebServlet("/patjoinsu.do")
public class PatJoinSu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatJoinSu() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String patNo = request.getParameter("userId");
		PatVo pat = new PatService().Patjoin(patNo);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("views/member/patPage.jsp");
		request.setAttribute("pat", pat);
		rd.forward(request, response);
		
	}

}
