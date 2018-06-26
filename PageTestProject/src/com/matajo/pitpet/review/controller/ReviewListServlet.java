package com.matajo.pitpet.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.review.model.service.ReviewService;
import com.matajo.pitpet.review.model.vo.ReviewVo;

@WebServlet("/reviewList.do")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService rs = new ReviewService();
		ArrayList<ReviewVo> list = rs.selectReviewList();
		
		String url="";
		if(null!=list){
			url = "리뷰목록.jsp";
			request.setAttribute("list", list);
		}else{
			url ="views/common/errorPage.jsp";
			request.setAttribute("msg", "후기 목록 조회 중 에러발생");
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}

}
