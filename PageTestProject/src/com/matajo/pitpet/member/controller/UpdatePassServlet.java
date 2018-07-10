package com.matajo.pitpet.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.MemberService;

/**
 * Servlet implementation class UpdatePassServlet
 */
@WebServlet("/passUpdate.do")
public class UpdatePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userPwd =request.getParameter("userPwd");
		String id =request.getParameter("id");
		
		int result = new MemberService().updatePass(id,userPwd);
		PrintWriter out=null;
		if(0<result){
			out = response.getWriter();
			out.println("<script>alert('비밀번호 변경 완료 이메일 확인후 로그인해 주세요'); location.href='/ptp/views/member/memberLogin.jsp';</script>"); 
			out.flush();
			out.close();
		}else{
			out = response.getWriter();
			out.println("<script>alert('비밀번호 변경 실패'); location.href='/ptp/views/member/passSearch.jsp';</script>"); 
			out.flush();
			out.close();
		}
	}

}
