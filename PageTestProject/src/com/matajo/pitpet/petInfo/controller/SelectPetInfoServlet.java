package com.matajo.pitpet.petInfo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.patjoin.model.service.PatService;
import com.matajo.pitpet.patjoin.model.vo.PatVo;
import com.matajo.pitpet.reservation.model.vo.ReservationVo;

@WebServlet("/selectPetInfo.do")
public class SelectPetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectPetInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int petsNo = Integer.parseInt(request.getParameter("petsNo"));
		int petoNo = Integer.parseInt(request.getParameter("petoNo"));
		String petsName= request.getParameter("petsName");
		String petoName=request.getParameter("petoName");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int price = Integer.parseInt(request.getParameter("price"));
		int dayprice = Integer.parseInt(request.getParameter("dayprice"));
		int tax = Integer.parseInt(request.getParameter("tax"));
		int overpay = Integer.parseInt(request.getParameter("overpay"));
		System.out.println(price);
		
		ReservationVo rv = new ReservationVo(petsNo, petoNo, start, end, dayprice, tax, overpay, price, petsName, petoName);
		//펫시터 정보 리스트로 불러오기
		/*PatVo pInfo = new PatService().patSelect(petoNo);*/
		List<PatVo> pInfo = new PatService().patSelect(petoNo);
		
		
		RequestDispatcher view = null;
		
		if(pInfo!=null){
			System.out.println(pInfo.size());
			if(pInfo.size()==0){
				PrintWriter out = response.getWriter();
				out.println("<script>alert('반려동물을 등록해주세요.'); location.href='/ptp/boardListAdd.do';</script>"); 
				out.flush();
				out.close();
				
			}
			request.setAttribute("rv", rv);
			request.setAttribute("pInfo", pInfo);
			
			//예약 정보 확인 창으로 이동
			view = request.getRequestDispatcher("views/reservation/reservationConfirm.jsp");
			view.forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>alert('리스트를 가져오던중 문제가 발생하였습니다.'); location.href='/ptp/boardListAdd.do';</script>"); 
			out.flush();
			out.close();
		}
		
	}

}
