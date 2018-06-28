package com.matajo.pitpet.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;
import com.matajo.pitpet.petsiterApply.model.service.PetsiterApplyService;
import com.matajo.pitpet.petsiterApply.model.vo.PetsiterApplyVo;

@WebServlet("/applyList.do")
public class ApplyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplyListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글 전송 값이 존재 할경우 인코딩 처리 X
		//2. 전송 값 변수에 저장 X
		//3. 비지니스 로직 호출(서비스 호출)
		List<PetsiterApplyVo> list = new PetsiterApplyService().getApplyList(); 
		//4. 로직 결과 처리(응답 페이지 처리)
		RequestDispatcher view = null;
		if(list!= null){
			request.setAttribute("list", list);
			view = request.getRequestDispatcher("views/admin/applyList.jsp");
		}else{
			request.setAttribute("msg", "멤버 불러오기를 실패하셧습니다.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		view.forward(request, response);
	}

}
