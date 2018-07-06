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
		int searchService=0;
		int searchPet=0;
		int searchGrade=0;
		int index=0;
		
		if(request.getParameter("index")!=null)
		{
			 index = Integer.parseInt(request.getParameter("index"));
		}else{
			searchService = Integer.parseInt(request.getParameter("searchService"));
			 searchPet = Integer.parseInt(request.getParameter("searchPet"));
			 searchGrade =  Integer.parseInt(request.getParameter("searchGrade"));
		}
		
		 
		
		//찾는 서비스 5 전체  0장기 1 데이케어
		//모든 5 등급 신규0  일반1 우수2
		//종류 모든5  강아지1고양2그외3
		
		
		
		ArrayList<BoardVo> list =null;
		ArrayList<Integer> indexList=null;
		if(request.getParameter("index")!=null)
		{
			 if(index==0){
				 list = new BoardService().selectaddList();
			 }else{
				 list = new BoardService().selectaddList(index);
			 }
			 
		}else{
			if(searchService==5&&searchGrade==5&&searchPet==5){
				list = new BoardService().selectaddList();
			}else{
				list = new BoardService().selectaddList(searchService,searchPet,searchGrade);
			}
			
			if(0<list.size()){
				indexList = new ArrayList<Integer>(); 
			 
			 	indexList.add(searchService);
				indexList.add(searchPet);
				indexList.add(searchGrade);
		}
		}
		
		 
		
		

		RequestDispatcher view=null;
		
		if(0<list.size()){
			request.setAttribute("boardList", list);
			request.setAttribute("indexList", indexList);
			view = request.getRequestDispatcher("/views/board/boardList.jsp");
			view.forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>alert('조회된 데이터가 없습니다.'); location.href='/ptp/boardListAdd.do';</script>"); 
			out.flush();
			out.close();
			
		}
	}

}
