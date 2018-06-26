<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/ptp/js/jquery-3.3.1.min.js"></script>
<title></title>
<link href="/ptp/css/default.css" rel="stylesheet" type="text/css" media="all" /> 
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
			<li><a href="#">펫시터 승인</a></li>
			<li><a href="#">예약 현황</a></li>
		</ul>
	</div>
</div>
</body>
</html>