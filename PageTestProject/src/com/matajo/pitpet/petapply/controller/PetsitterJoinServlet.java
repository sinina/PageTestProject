package com.matajo.pitpet.petapply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.petapply.model.service.PetsitterService;
import com.matajo.pitpet.petapply.model.vo.PetsitterApplyVo;
import com.oreilly.servlet.MultipartRequest;

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
		
		int maxSize = 1024 * 1024 * 10;
		
		PrintWriter out=null;
		
		if(!ServletFileUpload.isMultipartContent(request)){
			out = response.getWriter();
			out.println("<script>alert('이미지 등록중 오류가 발생 했습니다.'); location.href='/ptp/index.jsp';</script>"); 
			out.flush();
			out.close();
		}
		String root = request.getServletContext().getRealPath("/");
		String path = root + "upload/petsitter";
		
		MultipartRequest mRequest = new MultipartRequest(request,
				path, maxSize, "UTF-8");
		
		ArrayList<String> list = new ArrayList<String>();
		//Enumeration<String> fileNameEnum = mRequest.getFileNames();
		String fileName1 = mRequest.getFilesystemName("petsitterImage1");
		String fileName2 = mRequest.getFilesystemName("petsitterImage2");
		String fileName3 = mRequest.getFilesystemName("petsitterImage3");
		String fileName4 = mRequest.getFilesystemName("petsitterImage4");
		
		list.add(fileName1);
		list.add(fileName2);	
		list.add(fileName3);	
		list.add(fileName4);	
			
		
		
		int type = Integer.parseInt(mRequest.getParameter("sitterType"));
		int openarea = Integer.parseInt(mRequest.getParameter("openArea"));
		int jobstyle = Integer.parseInt(mRequest.getParameter("fullTimeJob"));
		
		String adComment = mRequest.getParameter("adComment");
		String opportunity = mRequest.getParameter("opportunity");
		String activityHistory = mRequest.getParameter("activityHistory");
		
		int long_term = Integer.parseInt(mRequest.getParameter("long_term"));
		int pickup = Integer.parseInt(mRequest.getParameter("pickup"));
		
		String prContext = mRequest.getParameter("prContext");
		int sitterCareer = Integer.parseInt(mRequest.getParameter("sitterCareer"));
		
		String[] petSize = mRequest.getParameterValues("petSize[]"); 
		String[]petAge = mRequest.getParameterValues("petAge[]");
		
		String petSizecommon=String.join(",", petSize);
		String petAgecommon=String.join("", petAge);
		System.out.println(petAgecommon);
		System.out.println(petSizecommon);
		System.out.println(petAgecommon);
		int animalCheck = Integer.parseInt(mRequest.getParameter("animalCheck"));
		int animalCount = Integer.parseInt(mRequest.getParameter("animalCount"));
		
		int child = Integer.parseInt(mRequest.getParameter("child"));
		int camera = Integer.parseInt(mRequest.getParameter("camera"));
		
		int distance = Integer.parseInt(mRequest.getParameter("distance"));
		String hospital = mRequest.getParameter("hospital");
		String hospitalPhoneNumber = mRequest.getParameter("hospitalPhoneNumber");
		
		int oneDayCount = Integer.parseInt(mRequest.getParameter("oneDayCount"));
		
		String bank = mRequest.getParameter("bank");
		String bankName = mRequest.getParameter("bankName");
		String bankNumber = mRequest.getParameter("bankNumber");
		
		String license1 = mRequest.getParameter("license1");
		String license2 = mRequest.getParameter("license2");
		String license3 = mRequest.getParameter("license3");
		String license4 = mRequest.getParameter("license4");
		
		String licenseInfo1 =mRequest.getParameter("licenseInfo1");
		String licenseInfo2 =mRequest.getParameter("licenseInfo2");
		String licenseInfo3 =mRequest.getParameter("licenseInfo3");
		String licenseInfo4 =mRequest.getParameter("licenseInfo4");
		
		license1+=','+licenseInfo1;
		license2+=','+licenseInfo2;
		license3+=','+licenseInfo3;
		license4+=','+licenseInfo4;
		
		
		PetsitterApplyVo petSitterInfo = new PetsitterApplyVo(member.getNo(), type, openarea, jobstyle, adComment, opportunity, activityHistory, long_term, pickup, sitterCareer, petSizecommon, petAgecommon, animalCheck, animalCount, child, camera, distance, hospital, hospitalPhoneNumber, oneDayCount, bank, bankName, bankNumber,prContext,license1,license2,license3,license4,fileName1,fileName2,fileName3,fileName4);
		int result = new PetsitterService().insertPetsitterInfo(petSitterInfo,list);
		
		if(0<result){
			out = response.getWriter();
			out.println("<script>alert('신청이 정상적으로 되었습니다.'); location.href='/ptp/index.jsp?petsitremit=yes';</script>"); 
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
