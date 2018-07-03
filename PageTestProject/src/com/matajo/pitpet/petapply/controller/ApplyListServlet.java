package com.matajo.pitpet.petapply.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.petapply.model.service.PetsitterService;
import com.matajo.pitpet.petapply.model.vo.PetsitterApplyVo;

public class ApplyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplyListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//okayN 0,1,2 (미승인,승인,거절)
		int okayN = Integer.parseInt(request.getParameter("okayN"));
		List<PetsitterApplyVo> list = new PetsitterService().getApplyList(okayN); 
		RequestDispatcher view = null;
		if(list!= null){
			request.setAttribute("list", list);
			request.setAttribute("okayN", okayN);
			view = request.getRequestDispatcher("views/admin/applyList.jsp");
		}else{
			request.setAttribute("msg", "멤버 불러오기를 실패하셧습니다.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		view.forward(request, response);
	}

}
