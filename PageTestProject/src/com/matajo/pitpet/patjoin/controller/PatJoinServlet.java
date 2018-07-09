package com.matajo.pitpet.patjoin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.patjoin.model.service.PatService;
import com.matajo.pitpet.patjoin.model.vo.PatVo;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/patjoin.do")
public class PatJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatJoinServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 파일 사이즈 설정
		int maxSize = 1024 * 1024 * 10;
		//2. 파일 전송 시 enctype 정상적으로 설정 되었는지 확인
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)){
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "전송 데이터의 타입을 확인하십시오!!");
			view.forward(request, response);
		}
		//3. 파일 저장 경로 설정
		String root = request.getServletContext().getRealPath("/");
		String path = root + "PatImage";
		//4. request -> multipartrequest
		MultipartRequest mRequest = new MultipartRequest(request,
																		path, maxSize, "UTF-8");
		
		String patname = mRequest.getParameter("patname");//이름
		String kg = mRequest.getParameter("kg");//무게
		String we = mRequest.getParameter("we");//펫소개
		String hospital = mRequest.getParameter("hospital");//병원
		String jender = mRequest.getParameter("jender");//성별
		String asd = mRequest.getParameter("asd");//중성화수술여부
		String kinds = mRequest.getParameter("kind");//애완동물 종류
		String kind_of = mRequest.getParameter("kind_of");//견종, 묘종
		String uniquness = mRequest.getParameter("ae");//특이사항
		String attfile = mRequest.getFilesystemName("attfile");//이미지 파일
		int age = Integer.parseInt(mRequest.getParameter("age"));
		HttpSession session = request.getSession();
		MemberVo mv = (MemberVo)session.getAttribute("user");
		
		PatVo pat = new PatVo();
		pat.setPatImage(attfile);
		pat.setPatName(patname);
		pat.setPatkg(kg);
		pat.setHospital(hospital);
		pat.setUniquness(uniquness);
		pat.setKinds(kinds);
		pat.setKinds_of(kind_of);
		pat.setPatgender(jender.equals("0")?'F':'M');
		pat.setPatInfo(we);
		pat.setOperation(asd.equals("1")?'Y':'N');
		pat.setOwner_no(mv.getNo());
		pat.setPatage(age);
		
		int result = new PatService().insertPat(pat);
		
		
		ArrayList<PatVo> list = new PatService().Selectpat(mv.getId());
		
		RequestDispatcher rd = null;
		if(0<result){
			request.setAttribute("pat", "예");
			request.setAttribute("list", list);
			rd = request.getRequestDispatcher("views/member/patList.jsp");
		}else{
			request.setAttribute("exit", "아니요");
		}
		rd.forward(request, response);
	}

}
