package com.matajo.pitpet.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		BoardVo board =null;
		String name= request.getParameter("name");
		String address= request.getParameter("address");
		String title = request.getParameter("title");
		String photo1 = request.getParameter("photo1");
		String photo2 = request.getParameter("photo2");
		String photo3 = request.getParameter("photo3");
		String photo4 = request.getParameter("photo4");
		int level = Integer.parseInt(request.getParameter("level"));
		String opportunity =request.getParameter("opportunity");
		 String activityhisotry=request.getParameter("activityhisotry");
		 String prcontext=request.getParameter("prcontext");
		 int pickup = Integer.parseInt(request.getParameter("pickup"));
		 int camera= Integer.parseInt(request.getParameter("camera"));
		 String license1=request.getParameter("license1");
		 String license2=request.getParameter("license2");
		 String license3=request.getParameter("license3");
		 String license4=request.getParameter("license4");
		 int child= Integer.parseInt(request.getParameter("child"));
		 int jobstyle= Integer.parseInt(request.getParameter("jobstyle"));
		 int animalcheck= Integer.parseInt(request.getParameter("animalcheck"));
		
		 int member = Integer.parseInt(request.getParameter("member"));
		 board = new BoardVo(member, name, address, title, photo1, photo2, photo3, photo4, level, opportunity, activityhisotry, prcontext, pickup, camera, license1, license2, license3, license4, child, jobstyle, animalcheck);
		
		RequestDispatcher view = null;
		
		if(board.getName()!=null){
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
