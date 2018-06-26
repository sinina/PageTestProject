package com.kh.java.admin.message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.admin.message.model.service.MessageService;
import com.kh.java.admin.message.model.vo.MessageVo;

@WebServlet("/writeMsg.do")
public class WriteMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int senderNo =Integer.parseInt(request.getParameter("senderNo"));
		int resverNo =Integer.parseInt(request.getParameter("resverNo"));
		//예약jsp에서 예약 버튼 누르면 content= 예약승인을 해주세요
		//예약승인/거절 jsp에서 버튼 누르면 승인일때 content=예약이 승인되었습니다 .결제해주세요
		//거절일때 content=예약이 거절되었습니다.
		
		String content = request.getParameter("content");
		
		//값 객체에 넣음
		MessageVo message = new MessageVo();
		
		message.setSenderNo(senderNo);
		message.setResverNo(resverNo);
		message.setContent(content);
		
		//객체로 값 전달
		int result = new MessageService().writeMsg(message);
		
		//정상적으로 db에 쪽지가 저장 될경우
		if(0<result){
			
		}else{
			
		}
	}

}
