package com.matajo.pitpet.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.matajo.pitpet.admin.model.service.SalesService;
import com.matajo.pitpet.admin.model.vo.SalesVo;

@WebServlet("/salesData.do")
public class SalesDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalesDataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SalesVo> list = new SalesService().getSales();
		
		Map<String, SalesVo> result = new HashMap<String, SalesVo>();
		
		for(SalesVo s :list){
			result.put(s.getMonth(), s);
		}
		
		response.setContentType("application/json; charset=utf-8"); 
		new Gson().toJson(result,response.getWriter());
	}

}
