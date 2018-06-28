<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/ptp/js/fullcal/fullcalendar.css" rel="stylesheet" type="text/css"/> 
<link href="/ptp/css/default.css" rel="stylesheet" type="text/css" media="all" /> 
<link href="/ptp/js/fullcal/fullcalendar.print.min.css" rel="stylesheet" type="text/css"/> 
<script type="text/javascript" src="/ptp/js/fullcal/lib/moment.min.js"></script>
<script type="text/javascript" src="/ptp/js/fullcal/lib/jquery.min.js"></script>
<script type="text/javascript" src="/ptp/js/fullcal/fullcalendar.js"></script>
<style>
	 .fc-day-number.fc-sat.fc-past { color:#0000FF; }
    .fc-day-number.fc-sun.fc-past { color:#FF0000; }
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
					<li><a href="#">펫시팅 글 관리</a></li>
					<li><a href="#">후기글 관리</a></li>
					<li><a href="#">신고 관리</a></li>
				</ul>
			</li>
			<li><a href="/ptp/applyList.do">펫시터 승인</a></li>
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
$(document).ready(function() {
	
	
	
    $("#calendar").fullCalendar({
    	
    	header:{
    		left: 'title',
            center: '',
            right: 'today prev,next'
		},
    	defaultDate : new Date(),
    	navLinks: true,
        editable : false,
        eventLimit : true,
        events: [
            {
                  title : "All Day Event"
                , start : "2018-06-01"
            },
            {
                  title : "Long Event"
                , start : "2016-05-07"
                , end : "2016-05-10"
            },
            {
                  id : 999
                , title : "Repeating Event"
                , start : "2016-05-09T16:00:00"
            },
            {
                  id : 999
                , title : "Repeating Event"
                , start : "2016-05-16T16:00:00"
            },
            {
                  title : "Conference"
                , start : "2016-05-11"
                , end : "2016-05-13"
            },
            {
                  title : "Meeting"
                , start : "2016-05-12T10:30:00"
                , end : "2016-05-12T12:30:00"
            },
            {
                  title : "Lunch"
                , start : "2016-05-12T12:00:00"
            },
            {
                  title : "Meeting"
                , start : "2016-05-12T14:30:00"
            },
            {
                  title : "Happy Hour"
                , start : "2016-05-12T17:30:00"
            },
            {
                  title : "Dinner"
                , start : "2016-05-12T20:00:00"
            },
            {
                  title : "Birthday Party"
                , start : "2016-05-13T07:00:00"
            },
            {
                  title : "Click for Google"
                , url : "http://google.com/"
                , start : "2016-05-28"
            }
        ]
    });
    
    // 왼쪽 버튼을 클릭하였을 경우
    jQuery("button.fc-prev-button").click(function() {
        var date = jQuery("#calendar").fullCalendar("getDate");
        convertDate(date);
    });

    // 오른쪽 버튼을 클릭하였을 경우
    jQuery("button.fc-next-button").click(function() {
        var date = jQuery("#calendar").fullCalendar("getDate");
        convertDate(date);
    });
});

    

</script>
</html>