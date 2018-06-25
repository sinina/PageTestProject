<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title></title>
</head>
<body>
<div id="logo" class="container">
	<h1><a href="#">관리자페이지</a></h1>
</div>
<div id="menu-wrapper">
	<div id="menu" class="container">
		<ul>
			<li><a href="#">홈</a></li>
			<li><a href="#">회원 관리</a>
				<ul>
					<li><a href="<%=request.getContextPath() %>/views/admin/adminIndex.jsp">펫시터 관리</a></li>
					<li><a>반려주 관리</a></li>
					<li><a>회원 통계</a></li>
				</ul>
			</li>
			<li><a href="#">게시글 관리</a>
				<ul>
					<li><a>펫시팅 글 관리</a></li>
					<li><a>후기글 관리</a></li>
					<li><a>신고 관리</a></li>
				</ul>
			</li>
			<li><a href="#">펫시터 승인</a></li>
			<li><a href="#">예약 현황</a></li>
		</ul>
	</div>
</div>
</body>
</html>