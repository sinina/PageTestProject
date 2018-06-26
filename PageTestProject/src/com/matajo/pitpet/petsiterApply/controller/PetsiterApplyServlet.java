package com.matajo.pitpet.petsiterApply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.petsiterApply.model.service.PetsiterApplyService;
import com.matajo.pitpet.petsiterApply.model.vo.PetsiterApplyVo;

@WebServlet("/petsiterApply.do")
public class PetsiterApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PetsiterApplyServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String petAJob = request.getParameter("petsJob");
		int member = Integer.parseInt(request.getParameter("memberNo"));
		String info = request.getParameter("info");
		String license = request.getParameter("license");
		
		PetsiterApplyVo apply = new PetsiterApplyVo();
		
		/*apply.setPetsJob(petAJob);
		apply.setMemberNo(member);
		apply.setInfo(info);
		apply.setLicense(license);*/
		
		//펫시터신청 테이블에 db저장
		int result = new PetsiterApplyService().writeApply(apply);
		
		
		if(0<result){
			
		}else{
			
		}
		
	}

}
