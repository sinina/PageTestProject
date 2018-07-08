package com.matajo.pitpet.message.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.message.model.service.MessageService;
import com.matajo.pitpet.message.model.vo.MessageVo;

@WebServlet("/selectMessage.do")
public class SelectMessgaeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMessgaeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//메시지 리스트불러오기
		int memberNo= Integer.parseInt(request.getParameter("memberNo"));
		List<MessageVo> list = new MessageService().getMessageList(memberNo);
		RequestDispatcher view = null;
		
		if(null!=list){
			request.setAttribute("list", list);
			view = request.getRequestDispatcher("views/message/message.jsp");
			view.forward(request, response);
			
		}else{
			
		}
	}

}
