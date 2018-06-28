package com.matajo.pitpet.petsiterApply.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		request.setCharacterEncoding("utf-8");
		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String job = request.getParameter("job");
		String license = request.getParameter("license");
		String info = request.getParameter("info");
		
		PetsiterApplyVo apply = new PetsiterApplyVo();
		
		apply.setMemberNo(memberNo);
		apply.setJob(job);
		apply.setLicense(license);
		apply.setInfo(info);
		
		//펫시터신청 테이블에 db저장
		int result = new PetsiterApplyService().writeApply(apply);
		
		if(0<result){
			PrintWriter out = response.getWriter();
			
			//오류-신청 완료후 인덱스 페이지로 안넘어감 
			out.println("<script>alert('신청이 정상적으로 되었습니다.'); location.href='/ptp/index.jsp';</script>"); 
			out.close();
			
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>alert('신청에 실패하였습니다.');</script>"); 
			out.close();
		}
		
	}

}
