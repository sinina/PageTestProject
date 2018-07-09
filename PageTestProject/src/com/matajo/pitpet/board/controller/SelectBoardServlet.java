package com.matajo.pitpet.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.board.model.service.BoardService;
import com.matajo.pitpet.board.model.vo.BoardVo;





/**
 * Servlet implementation class SelectBoardServlet
 */
@WebServlet("/selectBoard.do")
public class SelectBoardServlet extends HttpServlet {
	 static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int no=Integer.parseInt(request.getParameter("p_no"));
		String name = request.getParameter("name");
		
		BoardVo board =new BoardService().selectBoard(no,name);
		
		RequestDispatcher view = null;
	
		if(board!=null){
			request.setAttribute("board", board);
			view =request.getRequestDispatcher("/views/board/boardDetail.jsp");
			view.forward(request, response);
			
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>alert('리스트를 가져오던중 문제가 발생하였습니다.'); location.href='/ptp/boardListAdd.do';</script>"); 
			out.flush();
			out.close();
		}
		
	}

}
