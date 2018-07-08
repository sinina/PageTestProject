package com.matajo.pitpet.payment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.payment.model.service.PaymentService;
import com.matajo.pitpet.payment.model.vo.PaymentVo;

@WebServlet("/insertPayment.do")
public class InsertPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertPaymentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int petoNo = Integer.parseInt(request.getParameter("petoNo"));
		int petsNo = Integer.parseInt(request.getParameter("petsNo"));
		int price = Integer.parseInt(request.getParameter("price"));
		String payKind=request.getParameter("payKind");
		
		System.out.println("서블릿"+petsNo);
		PaymentVo pv = new PaymentVo(payKind, petoNo, petsNo, price);
		
		int result = new PaymentService().insertPayment(pv);
		
		if(result>0){
			response.sendRedirect("/ptp/selectMessage.do?memberNo="+petoNo);
		}
	}

}
