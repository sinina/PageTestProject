<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/ptp/js/fullcal/fullcalendar.min.css" rel="stylesheet" type="text/css"/> 
<link href="/ptp/css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="/ptp/js/fullcal/fullcalendar.print.min.css" rel="stylesheet" media='print'/> 
<script type="text/javascript" src="/ptp/js/fullcal/lib/moment.min.js"></script>
<script type="text/javascript" src="/ptp/js/fullcal/lib/jquery.min.js"></script>
<script type="text/javascript" src="/ptp/js/fullcal/fullcalendar.js"></script>
<style>
	 body {
    margin: 40px 10px;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 0 auto;
  }
</style>
</head>
<body>
<div id="logo" class="container">
	<h1><a href="#">관리자페이지</a></h1>
</div>
<div id="menu-wrapper">
	<div id="menu" class="container">
		<ul>
			<li><a href="#">홈</a>
				<ul>
					<li><a href="<%=request.getContextPath() %>/views/admin/adminIndex.jsp">관리자 페이지 홈</a></li>
					<li><a href="<%=request.getContextPath() %>/index.jsp">사용자 페이지 홈</a></li>
				</ul>
			</li>
			<li><a href="#">회원 관리</a>
				<ul>
					<li><a href="/ptp/pmemberList.do">펫시터 관리</a></li>
					<li><a href="/ptp/omemberList.do">반려주 관리</a></li>
					<li><a href="<%=request.getContextPath() %>/views/admin/memberChart.jsp">회원 통계</a></li>
				</ul>
			</li>
			<li><a href="#">게시글 관리</a>
				<ul>
					<li><a href="/ptp/boardList.do">펫시팅 글 관리</a></li>
					<li><a href="#">후기글 관리</a></li>
					<li><a href="#">신고 관리</a></li>
				</ul>
			</li>
			<li><a href="#">펫시터 신청자 관리</a>
				<ul>
					<li><a href="/ptp/applyList.do?okayN=0">미승인된 펫시터 신청자</a></li>
					<li><a href="/ptp/applyList.do?okayN=1">승인된 펫시터 신청자</a></li>
					<li><a href="/ptp/applyList.do?okayN=2">거절된 펫시터 신청자</a></li>
				</ul>
			</li>
			<li><a href="<%=request.getContextPath() %>/views/admin/reservationCalendar.jsp">예약 현황</a></li>
		</ul>
	</div>
</div>
<div id="page" class="container">
	<div id="calendar">
	
	</div>

</div>
</body>
<script>
       $(document).ready(function(){
            
            $.ajax({
               url : "/ptp/calendarSelect.do",
               type : "get",
               success : function(data){
                  console.log("성공",data);
                  
                  calendarSel(data);
               },error : function(e){
                  console.log("error",e);
               }
            });

           });
           function calendarSel(data){
              $('#calendar').fullCalendar({
                  header: {
                    left: 'title',
                    center: '',
                    right: 'prev,next'
                  },
                  navLinks: true, // can click day/week names to navigate views
                  editable: true,
                  eventLimit: true, // allow "more" link when too many events
                  businessHours: true,
                  local:'ko',
                  events: data
                });
           }
</script>
</html>