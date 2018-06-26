package com.kh.java.admin.message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.admin.message.model.service.MessageService;

@WebServlet("/updateMsg.do")
public class UpdateMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int msgNo = Integer.parseInt(request.getParameter("msgNo"));
		int result = new MessageService().updateMsg(msgNo);
		
		//정상적으로 mes_flag가 y로 변경 될경우
		if(0<result){
			
		}else{
			
		}
	}

}
