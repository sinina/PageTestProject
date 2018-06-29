package com.matajo.pitpet.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.matajo.pitpet.member.model.service.PetsitterService;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.member.model.vo.PetsitterApplyVo;

/**
 * Servlet implementation class PetsitterJoinServlet
 */
@WebServlet("/petsitterjoin.do")
public class PetsitterJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetsitterJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVo member = (MemberVo) session.getAttribute("user");
		
	
		int type = Integer.parseInt(request.getParameter("sitterType"));
		int openarea = Integer.parseInt(request.getParameter("openArea"));
		int jobstyle = Integer.parseInt(request.getParameter("fullTimeJob"));
		
		String adComment = request.getParameter("adComment");
		String opportunity = request.getParameter("opportunity");
		String activityHistory = request.getParameter("activityHistory");
		
		int long_term = Integer.parseInt(request.getParameter("long_term"));
		int pickup = Integer.parseInt(request.getParameter("pickup"));
		
		String prContext = request.getParameter("prContext");
		String sitterCareer = request.getParameter("sitterCareer");
		
		String[] petSize = request.getParameterValues("petSize[]"); 
		String[]petAge = request.getParameterValues("petAge[]");
		
		String petSizecommon=String.join(",", petSize);
		String petAgecommon=String.join(",", petAge);
		
		
		int animalCheck = Integer.parseInt(request.getParameter("animalCheck"));
		int animalCount = Integer.parseInt(request.getParameter("animalCount"));
		
		int child = Integer.parseInt(request.getParameter("child"));
		int camera = Integer.parseInt(request.getParameter("camera"));
		
		int distance = Integer.parseInt(request.getParameter("distance"));
		String hospital = request.getParameter("hospital");
		String hospitalPhoneNumber = request.getParameter("hospitalPhoneNumber");
		
		int oneDayCount = Integer.parseInt(request.getParameter("oneDayCount"));
		
		String bank = request.getParameter("bank");
		String bankName = request.getParameter("bankName");
		String bankNumber = request.getParameter("bankNumber");
		
		PetsitterApplyVo petSitterInfo = new PetsitterApplyVo(member.getNo(), type, openarea, jobstyle, adComment, opportunity, activityHistory, long_term, pickup, prContext, sitterCareer, petSizecommon, petAgecommon, animalCheck, animalCount, child, camera, distance, hospital, hospitalPhoneNumber, oneDayCount, bank, bankName, bankNumber);
		int result = new PetsitterService().insertPetsitterInfo(petSitterInfo);
		PrintWriter out=null;
		if(0<result){
			out = response.getWriter();
			out.println("<script>alert('신청이 정상적으로 되었습니다.'); location.href='/ptp/index.jsp';</script>"); 
			out.flush();
			out.close();
		}else{
			out =  response.getWriter();
			out.println("<script>alert('신청중 문제가 발생하였습니다.'); location.href='/ptp/index.jsp';</script>"); 
			out.flush();
			out.close();
		}
		
	}

}
