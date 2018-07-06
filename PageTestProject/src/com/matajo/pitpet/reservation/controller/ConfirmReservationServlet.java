package com.matajo.pitpet.reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.reservation.model.service.ReservationService;

@WebServlet("/confirmRes.do")
public class ConfirmReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConfirmReservationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//예약 번호
		int resNo = Integer.parseInt(request.getParameter("resNo"));
		int accDny = Integer.parseInt(request.getParameter("accDny"));
		
		int result = new ReservationService().updateAccDny(resNo,accDny);
		
		if(result>0){
			//펫시터->반려주 메시지 insert서블릿으로 넘어감
			response.sendRedirect("ptp/petsInsertMsg.do?resNo="+resNo+"&accDny="+accDny);
		}
		
		
	}

}
