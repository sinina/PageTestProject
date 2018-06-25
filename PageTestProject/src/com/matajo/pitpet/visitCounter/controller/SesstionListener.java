package com.matajo.pitpet.visitCounter.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.matajo.pitpet.visitCounter.model.service.VisitCountService;

//web.xml에 listener 등록해야함-> 톰캣 실행되며녀서 리스너 실행 됨

@WebListener
public class SesstionListener implements HttpSessionListener {

	public SesstionListener() {
    }

    public void sessionCreated(HttpSessionEvent sessionEve)  { 
    	// 세션이 새로 생성되면 execute() 실행한다.
        if(sessionEve.getSession().isNew()){
            execute(sessionEve);
        }

    }
    
    
    private void execute(HttpSessionEvent sessionEve) 
    {
	    	// 전체 방문자 수 증가시키기
	    	int visit = new VisitCountService().setVisit();
    	
            // 총 방문자 수 가져오기
            int totalCount = new VisitCountService().getTotalCount();
            // 오늘 방문자 수 가져오기
            int todayCount = new VisitCountService().getTodayCount();
            
            
            
            //--방문자 추이 그래프 구글 api 
            //각 달 방문자수 변수 선언 후 메소드 호출
            //ex int count1= dao.getCount1();
            
            
            //db에 방문자수 insert 정상적으로 성공시, 세션에 방문자 수를 담는다
           if(0<visit){ 
            HttpSession session = sessionEve.getSession();
            
            // 세션에 방문자 수를 담는다.
            session.setAttribute("totalCount", totalCount); 
            session.setAttribute("todayCount", todayCount);
           }else{
        	   System.out.println("방문자 카운터 오류");
           }
        }
    

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    }
	
}
