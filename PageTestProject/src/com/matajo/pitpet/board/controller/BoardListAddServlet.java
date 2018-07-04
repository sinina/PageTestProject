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
import com.matajo.pitpet.petapply.model.vo.PetsitterApplyVo;

/**
 * Servlet implementation class BoardListAddServlet
 */
@WebServlet("/boardListAdd.do")
public class BoardListAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<BoardVo> list = new BoardService().selectaddList();
		RequestDispatcher view=null;
		
		if(0<list.size()){
			request.setAttribute("boardList", list);
			view = request.getRequestDispatcher("/views/board/boardList.jsp");
			view.forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>alert('리스트를 가져오던중 문제가 발생하였습니다.'); location.href='/ptp/index.jsp';</script>"); 
			out.flush();
			out.close();
			
		}
		
	}

}
