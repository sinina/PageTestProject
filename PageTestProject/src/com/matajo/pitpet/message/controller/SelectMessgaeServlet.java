package com.matajo.pitpet.message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectMessage.do")
public class SelectMessgaeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMessgaeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(){
			response.sendRedirect("views/message/message.jsp");
			
		}else{}
	}

}
