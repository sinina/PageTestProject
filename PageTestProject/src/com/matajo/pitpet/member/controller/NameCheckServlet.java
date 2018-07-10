package com.matajo.pitpet.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;

/**
 * Servlet implementation class NameCheckServlet
 */
@WebServlet("/nameCheck.do")
public class NameCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPhone = (String) request.getParameter("userPhone");
		
		MemberVo member = new MemberService().searchMember(userPhone);
		String WrappName="";
		if(null!=member){
			member.getId().substring(member.getId().lastIndexOf("@")/2,member.getId().lastIndexOf("@"));
			int index = member.getId().substring(member.getId().lastIndexOf("@")/2,member.getId().lastIndexOf("@")).length();
			String star="";
			for(int i=0;i<index;i++){
				star+="*";
			}
			WrappName = member.getId().replaceFirst(member.getId().substring(member.getId().lastIndexOf("@")/2,member.getId().lastIndexOf("@")), star); 
		}
		 
		
		
		if(null != member){
			
			response.getWriter().print(WrappName);
		}else{
			response.getWriter().println("계정이 존재하지 않습니다.");
		}
		
		
	}

}
