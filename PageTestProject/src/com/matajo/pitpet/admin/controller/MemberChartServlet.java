package com.matajo.pitpet.admin.controller;

import java.io.IOException;
import com.google.gson.Gson;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.admin.model.service.MemberChartService;

@WebServlet("/selectArea.do")
public class MemberChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberChartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		String area = request.getParameter("area");
        int oList = new memberChartService().getOMemberCount(area);
        int pList = new memberChartService().getPSMemberCount(area);

        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        resultMap.put("oList", oList);
        resultMap.put("pList", pList);

        if(pList != 0){
            response.setContentType("application/json");
            new Gson().toJson(resultMap, response.getWriter());
        	}
	}

}
