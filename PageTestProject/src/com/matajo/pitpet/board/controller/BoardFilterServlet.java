package com.matajo.pitpet.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.board.model.service.BoardService;
import com.matajo.pitpet.board.model.vo.BoardVo;

/**
 * Servlet implementation class BoardFilterServlet
 */
@WebServlet("/boardFilter.do")
public class BoardFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int searchService = Integer.parseInt(request.getParameter("searchService"));
		int searchPet = Integer.parseInt(request.getParameter("searchPet"));
		int searchGrade =  Integer.parseInt(request.getParameter("searchGrade"));
		
		//찾는 서비스 0 전체  1데이케어 2 장기
		//종류 모든0강아지1고양2그외3
		//등급 신규0  일반1 우수2
		
		ArrayList<BoardVo> list = new BoardService().selectaddList(searchService,searchPet,searchGrade);
		
		RequestDispatcher view=null;
		
		if(0<list.size()){
			request.setAttribute("boardList", list);
			view = request.getRequestDispatcher("/views/board/boardList.jsp");
			view.forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>alert('조회된 데이터가 없습니다.'); location.href='/ptp/index.jsp';</script>"); 
			out.flush();
			out.close();
			
		}
	}

}
