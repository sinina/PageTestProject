package com.matajo.pitpet.message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.message.model.service.MessageService;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

@WebServlet("/petsInsertMsg.do")
public class PetsInsertMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PetsInsertMessageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//펫시터가 반려주에게 쓰는 메시지 (예약 승인/거절)
		ReservationVo res = (ReservationVo)request.getAttribute("res");
		
		int result =new MessageService().insertPetsMsg(res);
		
		if(result>0){
			//메시지 리스트 화면으로 넘어감
			response.sendRedirect("/ptp/selectMessage.do?memberNo="+res.getPetsNo());
		}
	}

}
