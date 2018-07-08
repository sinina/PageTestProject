package com.matajo.pitpet.message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.message.model.service.MessageService;
import com.matajo.pitpet.message.model.vo.MessageVo;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

@WebServlet("/petoInsert.do")
public class PetoInsertMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PetoInsertMessageServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//예약 요청 메시지 작성
		ReservationVo res = (ReservationVo)request.getAttribute("res"); 
		int resNo = (int) request.getAttribute("resNo");
		int senderNo =res.getPetoNo();
		int resverNo =res.getPetsNo();
		//값 객체에 넣음
		MessageVo message = new MessageVo();
		
		message.setSenderNo(senderNo);
		message.setResverNo(resverNo);
		message.setRes_no(resNo);
		
		
		//객체로 값 전달
		int result = new MessageService().writeMsg(message);
		
		//정상적으로 db에 쪽지가 저장 될경우
		if(0<result){
			//예약 jsp로 이동
			response.sendRedirect("/ptp/boardListAdd.do");
		}else{
			
		}
	}

}
