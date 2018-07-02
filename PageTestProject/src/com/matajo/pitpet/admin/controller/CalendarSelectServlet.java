package com.matajo.pitpet.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.matajo.pitpet.reservation.model.service.ReservationService;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

@WebServlet("/calendarSelect.do")
public class CalendarSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalendarSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ReservationVo> list = (ArrayList<ReservationVo>) new ReservationService().getReservation();
		
		if(list!=null){
			response.setContentType("application/json; charset=utf-8");
			new Gson().toJson(list, response.getWriter());
			
		}else{
			
		}
		
	}

}
