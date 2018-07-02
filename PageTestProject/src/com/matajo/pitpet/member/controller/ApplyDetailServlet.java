package com.matajo.pitpet.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.PetsitterService;
import com.matajo.pitpet.member.model.vo.PetsitterApplyVo;

@WebServlet("/applyDetail.do")
public class ApplyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplyDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		PetsitterApplyVo apply = new PetsitterService().selectApplyDetail(memberNo);
		
		String url="";
		if(null!=apply){
			request.setAttribute("apply", apply);
			url = "views/admin/applyDetail.jsp";
		}else{
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "펫시터 신청글 상세조회에 실패하였습니다.");
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}

}
