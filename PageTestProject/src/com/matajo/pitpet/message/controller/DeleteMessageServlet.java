package com.matajo.pitpet.message.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.message.model.service.MessageService;

@WebServlet("/deleteMsg.do")
public class DeleteMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMessageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messageNo = Integer.parseInt(request.getParameter("messageNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int result = new MessageService().deleteMsg(messageNo);
		RequestDispatcher view = null;
		
		if(0<result){
			
			view = request.getRequestDispatcher("/selectMessage.do?memberNo="+memberNo);
			view.forward(request, response);
		}else{
			
		}
	}

}
