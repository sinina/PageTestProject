package com.matajo.pitpet.message.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.message.model.service.MessageService;
import com.matajo.pitpet.message.model.vo.MessageVo;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

@WebServlet("/messageDetail.do")
public class MessageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MessageDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int msgCode = Integer.parseInt(request.getParameter("msgCode"));
		
		System.out.println("디테일 서블릿"+msgCode);
		int messageNo = Integer.parseInt(request.getParameter("messageNo"));
		ReservationVo res = (ReservationVo)new MessageService().getMessageDetail(messageNo,msgCode);
		RequestDispatcher view = null;
		
		if(res!=null){
			request.setAttribute("res", res);
			view = request.getRequestDispatcher("views/message/messageDetail.jsp");
			view.forward(request, response);
		}
	}

}
