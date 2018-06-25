
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
<style>
html, body {
	height: 100%;
}

body {
	margin: 0px;
	padding: 0px;
	background: #F1E9D4 url(images/bg01.jpg) repeat;
	font-family: 'Open Sans', sans-serif;
	font-size: 10pt;
	color: #747474;
}

h1, h2, h3 {
	margin: 0;
	padding: 0;
}

p, ol, ul {
	margin-top: 0px;
}

p {
	line-height: 180%;
}

strong {
	
}

a {
	color: #706C53;
}

a:hover {
	text-decoration: none;
}

a img {
	border: none;
}

img.border {
	
}

img.alignleft {
	float: left;
}

img.alignright {
	float: right;
}

img.aligncenter {
	margin: 0px auto;
}

hr {
	display: none;
}

ul.style1 {
	margin: 0;
	padding: 0;
	list-style: none;
}

ul.style1 li {
	padding: 15px 0px 15px 0px;
	border-top: 1px solid #E5E5E5;
}

ul.style1 a {
	color: #747474;
}

ul.style1 .first {
	padding-top: 0;
	border-top: none;
}

/** WRAPPER */
#wrapper {
	
}

.container {
	width: 1200px;
	margin: 0px auto;
}

.clearfix {
	clear: both;
}

/* Header */
#header-wrapper {
	overflow: hidden;
	height: 600px;
}

#header {
	width: 960px;
	height: 200px;
	margin: 0 auto;
	padding: 0px 20px;
}

/* Logo */
#logo {
	overflow: hidden;
	padding: 3em 0em;
}

#logo h1, #logo p {
	text-align: center;
}

#logo h1 {
	padding: 0px 0px 0px 0px;
	text-transform: lowercase;
	font-size: 4em;
	font-weight: 600;
	color: #706C53
}

#logo p {
	margin-top: -20px;
	padding: 0px 0px 0px 5px;
	font-size: 20px;
	font-weight: 300;
	color: #696969;
}

#logo p a {
	color: #696969;
}

#logo a {
	border: none;
	background: none;
	text-decoration: none;
	color: #3C342E;
}

/* Menu */
#menu-wrapper {
	height: 52px;
	margin-bottom: 4em;
	border-top: 1px solid #D7CFAD;
	border-bottom: 1px solid #D7CFAD;
}

#menu {
	height: 52px;
}

#menu ul {
	margin: 0;
	padding: 0px 0px 0px 0px;
	list-style: none;
	line-height: normal;
	text-align: center;
}

#menu li {
	display: inline-block;
}

#menu a {
	display: block;
	padding: 0px 30px;
	line-height: 52px;
	border: none;
	text-decoration: none;
	text-transform: lowercase;
	text-align: center;
	text-transform: uppercase;
	font-size: 14px;
	font-weight: 300;
	color: #706C53;
}

#menu ul ul {
	display: none;
	position: absolute;
}

#menu ul li:hover ul {
	display: block;
}

#menu a:hover {
	background: #D7CFAD;
	text-decoration: none;
	color: #706C53;
}

/** PAGE */
#page {
	overflow: hidden;
	width: 1100px;
	margin-bottom: 3em;
	padding: 5em 50px;
	background: #FFF;
	border: 1px solid #D9D2A5;
}

.visitCount {
	float: left;
	width: 450px;
	margin-right: 70px;
	margin-bottom: 30px;
}

.visitToday {
	float: left;
	width: 250px;
}

.visitTotal {
	float: right;
	width: 250px;
}

/* 추가 css */
.matching {
	width: 450px;
}

.sales {
	width: 450px;
	float: right;
}

.count {
	width: 200px;
	height: 200px;
	/* border: 1px solid; */
	font-size: 80px;
	text-align: center;
}
/** CONTENT */
#content {
	
}

/** SIDEBAR */
#sidebar {
	
}
</style>
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
		<!-- <div style="clear: both;">&nbsp;</div> -->
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
