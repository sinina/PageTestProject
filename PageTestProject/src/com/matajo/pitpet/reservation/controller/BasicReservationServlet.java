package com.matajo.pitpet.reservation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basicRes.do")
public class BasicReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BasicReservationServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Start =request.getParameter("start");
		String end = request.getParameter("end");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
	}

}
