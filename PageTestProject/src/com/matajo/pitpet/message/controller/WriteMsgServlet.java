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
		//insertReservationInfo 서블릿에서 넘어올때 getattribute("res"res); 해야함
		ReservationVo res = (ReservationVo)request.getAttribute("res"); 
		
		int senderNo =res.getPetoNo();
		int resverNo =res.getPetsNo();
		
		int msgCode = Integer.parseInt(request.getParameter("msgCode"));
		
		String content ="";
		if(msgCode==1){
			content="예약 요청이 들어왔습니다.";
		}else if(msgCode==2){
			content="예약 승인이 되었습니다.";
		}else{
			content="예약이 거절되었습니다.";
		}
		
		//값 객체에 넣음
		MessageVo message = new MessageVo();
		
		message.setSenderNo(senderNo);
		message.setResverNo(resverNo);
		
		message.setContent(content);
		message.setMsgCode(msgCode);
		
		//객체로 값 전달
		int result = new MessageService().writeMsg(message);
		
		//정상적으로 db에 쪽지가 저장 될경우
		if(0<result){
			//예약 jsp로 이동
		}else{
			
		}
	}

}
