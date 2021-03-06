package com.matajo.pitpet.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userId = request.getParameter("userId");
			String userPwd = request.getParameter("userPwd");
			System.out.println(userPwd);
			MemberVo member = new MemberService().selectMember(userId);
			int memberCode=5;
			String url ="views/member/memberLogin.jsp";
			
			RequestDispatcher view = request.getRequestDispatcher(url);
			if(member!=null){
				memberCode = (int)member.getCode();
			}
			 
			
			if(null==member){
				request.setAttribute("flag", "false");
				view.forward(request, response);
			}else{
				if(userPwd.equals(member.getPwd())){
					System.out.println(member.getCode());
					if(memberCode=='0'){
						//관리자로 로그인할때 관리자 페이지로 넘어가게함
						response.sendRedirect("/ptp/selectMonth.do");
					}else{
					HttpSession session = request.getSession();
					session.setAttribute("user", member);
					response.sendRedirect("index.jsp");
					}
				}else{
					request.setAttribute("flag", "false");
					view.forward(request, response);
				}
			}
	}

}
