package com.matajo.pitpet.member.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;

/**
 * Servlet implementation class EmailCheckServlet
 */
@WebServlet("/emailCheck.do")
public class EmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getParameter("userEmail");
		MemberVo member = new MemberService().selectMember(email);
		boolean flag=true;
		
		StringBuffer buffer = new StringBuffer();

		Random random = new Random();
		String chars[] = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9".split(",");

		for (int i = 0; i < 8; i++) {
		buffer.append(chars[random.nextInt(chars.length)]);
		}

		JSONObject obj = new JSONObject();

        
       
		if(null != member){
			obj.put("flag",flag);
			obj.put("temppass", buffer.toString());
			response.getWriter().print(obj);
			
		}else{
			obj.put("flag",!flag);
			obj.put("temppass", buffer.toString());
			response.getWriter().print(obj);
		}
		
		
			
	}

}
