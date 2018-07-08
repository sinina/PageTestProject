package com.matajo.pitpet.reservation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.reservation.model.service.ReservationService;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

@WebServlet("/confirmRes.do")
public class ConfirmReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConfirmReservationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//예약 번호
		int resNo = Integer.parseInt(request.getParameter("resNo"));
		//승인 시 , accDny==1
		int accDny = Integer.parseInt(request.getParameter("accDny"));
		//승인/거절한 결과값
		int result = new ReservationService().updateAccDny(resNo,accDny);
		//예약 번호 가지고 예약 정보 얻어옴
		ReservationVo res = new ReservationService().selectResInfo(resNo);
		
		RequestDispatcher view = null;
		if(result>0){
			//펫시터->반려주 메시지 insert서블릿으로 넘어감
			request.setAttribute("res", res);
			view=request.getRequestDispatcher("/petsInsertMsg.do");
			view.forward(request, response);
		}
		
		
	}

}
