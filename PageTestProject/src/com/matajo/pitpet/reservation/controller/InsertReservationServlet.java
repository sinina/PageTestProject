package com.matajo.pitpet.reservation.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.reservation.model.service.ReservationService;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;


@WebServlet("/insertReservation.do")
public class InsertReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertReservationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start =request.getParameter("start");
		String end = request.getParameter("end");
		//날짜만 저장되고 시간은 저장이 안됨
		//System.out.println(start);
		int price = Integer.parseInt(request.getParameter("price"));
		int petsNo = Integer.parseInt(request.getParameter("petsNo"));
		int petoNo = Integer.parseInt(request.getParameter("petoNo"));
		String[] animalNos = request.getParameterValues("animalNo[]");
		String[] animalKind = request.getParameterValues("animalKind[]");
		String msg = request.getParameter("msg");
		
		String animalNoCommon=String.join(",", animalNos);
		String animalKindCommon=String.join("/", animalKind);
		
		//System.out.println(end);
		ReservationVo res = new ReservationVo(petoNo, animalKindCommon, petsNo, price, start, end, msg, animalNoCommon);
		int result = new ReservationService().insertReservation(res);
		int resNo = new ReservationService().selectResNo(res);
		
		System.out.println("selectRes:"+resNo);
		
		RequestDispatcher view =null;
		if(result>0){
			request.setAttribute("res", res);
			request.setAttribute("resNo",resNo);
			view=request.getRequestDispatcher("/petoInsert.do");
			view.forward(request, response);
			//예약 요청 메시지insert 서블릿으로 이동
		}
		
	}

}
