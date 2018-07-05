package com.matajo.pitpet.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.matajo.pitpet.board.model.service.BoardService;

/**
 * Servlet implementation class LocalDistriServlet
 */
@WebServlet("/localdistri.do")
public class LocalDistriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocalDistriServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> list = new BoardService().selectDistri();
		
		
		JSONObject obj = new JSONObject();
		
		obj.put("all",list.get(0));
		obj.put("soul",list.get(1));
		obj.put("gyeonggi",list.get(2));
		obj.put("incheon",list.get(3));
		obj.put("other", list.get(4));
		
		PrintWriter out = response.getWriter();
		out.print(obj.toString());
	}

}
