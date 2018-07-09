package com.matajo.pitpet.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.common.PageInfo;
import com.matajo.pitpet.member.model.service.MemberService;
import com.matajo.pitpet.member.model.vo.MemberVo;

@WebServlet("/omemberList.do")
public class OMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OMemberListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService ms = new MemberService();
		//페이징 처리 변수
		int currentPage;	//현재 페이지의 번호
		int limitPage;		//한페이지에 출력할 페이지 갯수
		//1~10
		int maxPage;		//가장 마지막 페이지
		int startPage;		//시작 페이지 변수
		int endPage;		//마지막 페이지 변수
		int limit;				//한페이지에 출력할 글에 갯수
		
		limit = 10;
		limitPage = 10;
		
		if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else{
			currentPage = 1;
		}
		
		//게시글의 총 갯수
		int listCount = ms.selectBoardTotalCount();
		//134 -> 14
		maxPage = (int)((double)listCount / limit + 0.9);
		
		//현재 페이지 번호
		//12 - 10
		startPage = (int)(currentPage / limitPage * limitPage) + 1;
		
		//11~20  -> 134 -> 14
		endPage = startPage + limitPage - 1;
		if(maxPage < endPage){
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, limitPage, maxPage,
																startPage, endPage, listCount);
		
		
		//1. 한글 전송 값이 존재 할경우 인코딩 처리 X
		//2. 전송 값 변수에 저장 X
		//3. 비지니스 로직 호출(서비스 호출)
		int selectNo = 1;
		List<MemberVo> list = new MemberService().getMemberList(selectNo); 
		//멤버 조회 값 확인
		/*for(MemberVo vo : list){
			System.out.println(vo.toString());
		}*/
		//4. 로직 결과 처리(응답 페이지 처리)
		RequestDispatcher view = null;
		if(list!= null){
			request.setAttribute("list", list);
			view = request.getRequestDispatcher("views/admin/omManagement.jsp");
		}else{
			request.setAttribute("msg", "멤버 불러오기를 실패하셧습니다.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		view.forward(request, response);
	}

}
