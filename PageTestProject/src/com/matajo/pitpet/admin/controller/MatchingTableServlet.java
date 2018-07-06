package com.matajo.pitpet.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.matajo.pitpet.admin.model.service.MatchingService;
import com.matajo.pitpet.admin.model.vo.MatchingVo;

@WebServlet("/matchingTable.do")
public class MatchingTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MatchingTableServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MatchingVo> list = new MatchingService().getMatching();
		
		Map<String, MatchingVo> result = new HashMap<String, MatchingVo>();
		
		for(MatchingVo m: list){
			result.put(m.getDate1(), m);
		}
	
		response.setContentType("application/json"); 
		new Gson().toJson(result,response.getWriter());
	}

}
