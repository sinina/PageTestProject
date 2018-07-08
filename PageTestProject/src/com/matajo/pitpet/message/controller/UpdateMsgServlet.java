package com.matajo.pitpet.message.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.message.model.service.MessageService;



@WebServlet("/updateMsg.do")
public class UpdateMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int msgCode = Integer.parseInt(request.getParameter("msgCode"));
		System.out.println(msgCode);
		int messageNo = Integer.parseInt(request.getParameter("messageNo"));
		int result = new MessageService().updateMsg(messageNo);
		RequestDispatcher view = null;
		//정상적으로 mes_flag가 y로 변경 될경우
		if(0<result){
			System.out.println("플래그 변경 완료");
			
			response.sendRedirect("/ptp/messageDetail.do?messageNo="+messageNo+"&msgCode="+msgCode);
		}else{
			
		}
	
	}
}
