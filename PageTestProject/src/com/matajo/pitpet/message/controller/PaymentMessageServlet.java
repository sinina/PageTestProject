package com.matajo.pitpet.message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.message.model.service.MessageService;
import com.matajo.pitpet.message.model.vo.MessageVo;

@WebServlet("/paymentMsg.do")
public class PaymentMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentMessageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resNo = Integer.parseInt(request.getParameter("resNo"));
		int petoNo = Integer.parseInt(request.getParameter("petoNo"));
		int petsNo = Integer.parseInt(request.getParameter("petsNo"));
		
		MessageVo message = new MessageVo();
		
		message.setSenderNo(petoNo);
		message.setResverNo(petsNo);
		message.setRes_no(resNo);
		
		int result = new MessageService().paymentMsg(message);
		
		if(0<result){
			//예약 jsp로 이동
			response.sendRedirect("/ptp/selectMessage.do?memberNo="+petoNo);
		}else{
			
		}
	}

}
