package com.matajo.pitpet.patjoin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.patjoin.model.service.PatService;
import com.matajo.pitpet.patjoin.model.vo.PatVo;

@WebServlet("/patList.do")
public class PatListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("userId");
		
		ArrayList<PatVo> list = new PatService().Selectpat(id);
		RequestDispatcher rd = null;
		if(null !=list){
			request.setAttribute("list", list);
			rd = request.getRequestDispatcher("views/member/patList.jsp");
		}else{
			request.setAttribute("msg", "에러");
		}
		rd.forward(request, response);
	}

}
