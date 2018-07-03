package com.matajo.pitpet.petapply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.petapply.model.service.PetsitterService;



@WebServlet("/updateOkayN.do")
public class UpdateOkayNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateOkayNServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo=Integer.parseInt(request.getParameter("memberNo"));
		int selectNo= Integer.parseInt(request.getParameter("selectNo"));
		int result = new PetsitterService().updateOkayN(memberNo,selectNo);
		
		
		if(0<result){
			//selectNo:(1)승인/(2)승인취소/(3)거절/(4)거절 취소
			if(selectNo==1||selectNo==3){
				response.sendRedirect("/ptp/applyList.do?okayN=0");
			}else if(selectNo==2){
				response.sendRedirect("/ptp/applyList.do?okayN=1");
			}else{
				response.sendRedirect("/ptp/applyList.do?okayN=2");
			}
		}else{
			
		}
	}

}
