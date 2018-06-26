<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<!-- 구글 차트 api 라이브러리 선언 -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700" rel="stylesheet" type="text/css">
<link href="/ptp/css/default.css" rel="stylesheet" type="text/css" media="all" /> 

</head>
<script>
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	google.charts.setOnLoadCallback(drawChart1);
	
	// 방문자 추이
	function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['month', '방문자 수(명)'],
          ['1월',  2],
          ['2월',  10],
          ['3월',  5],
          ['4월',  20]
        ]);

        var options = {
       /*    title: 'Company Performance', */
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('chartVisit'));

        chart.draw(data, options);
      }
	
	//매출 현황
	function drawChart1() {
        var data = google.visualization.arrayToDataTable([
          ['month', '매출(만원)'],
          ['1월',  20],
          ['2월',  10],
          ['3월',  50],
          ['4월',  15]
        ]);

        var options = {
       /*    title: 'Company Performance', */
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('salesChart'));

        chart.draw(data, options);
      }
	
</script>
<body>
<%@ include file="/views/admin/adminHeader.jsp" %>
<div id="page" class="container">
	<div  class="visitCount">
		<h1>방문자 추이</h1>
		<div id="chartVisit">
		</div>
	</div>
	
	<div class="visitToday">
		<h1>오늘 방문자수</h1>
		<div class="count"><%=session.getAttribute("todayCount") %></div>
	</div>
	
	<div class="visitTotal">
		<h1>총 방문자수</h1>
		<div class="count"><%=session.getAttribute("totalCount") %></div>
	</div>
	
	 <div class="matching">
		<h1>매칭 현황</h1>
		<table border="1px solid ">
			<tr>
				<td>기간</td><td>예약 요청</td><td>예약 승인</td>
				<td>결제완료</td><td>예약 취소</td><td>최종 매칭</td>
			</tr>
			<tr>
				<td>기간</td><td>예약 요청</td><td>예약 승인</td>
				<td>결제완료</td><td>예약 취소</td><td>최종 매칭</td>
			</tr>
			<tr>
				<td>기간</td><td>예약 요청</td><td>예약 승인</td>
				<td>결제완료</td><td>예약 취소</td><td>최종 매칭</td>
			</tr>
			<tr>
				<td>기간</td><td>예약 요청</td><td>예약 승인</td>
				<td>결제완료</td><td>예약 취소</td><td>최종 매칭</td>
			</tr>
		</table>
		<p><a href="메뉴중 예약현황페이지">더보기</a></p>
	</div>
	
	<div class="sales">
		<h1>매출 현황</h1>
		<div id="salesChart">
		</div>
	</div> 
</div>

</body>
</html>
