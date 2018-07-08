package com.matajo.pitpet.message.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.message.model.service.MessageService;
import com.matajo.pitpet.message.model.vo.MessageVo;

@WebServlet("/selectMsgFlag.do")
public class SelectMessageFlagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMessageFlagServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//안읽은 메시지 확인하여 ajax로 메시지 아이콘 바뀌게함
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		MessageVo count = new MessageService().getMessageFlag(memberNo);
		RequestDispatcher view = null;
		
		String msg ="";
	/*	System.out.println(count.getnFlagCnt()+"서블릿");*/
		//안읽은 메시지가 0개 이상일경우
		if(count.getnFlagCnt()>0){
			msg="ok";
		}
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(msg);
	}

}
