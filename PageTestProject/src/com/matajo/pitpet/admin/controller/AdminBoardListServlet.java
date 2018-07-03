package com.matajo.pitpet.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.board.model.service.BoardService;
import com.matajo.pitpet.board.model.vo.BoardVo;

@WebServlet("/adminBoardList.do")
public class AdminBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminBoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postN = Integer.parseInt(request.getParameter("postN"));
		System.out.println(postN);
		List<BoardVo> list = new BoardService().getBoardList(postN);
		RequestDispatcher view = null;
		
		if(list!=null){
			request.setAttribute("list", list);
			request.setAttribute("postN", postN);
			view = request.getRequestDispatcher("views/admin/boardList.jsp");
			view.forward(request, response);
		}
	}

}
