<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/join.css">
</head>
<body>
	<header id="header">
				<div class="inner">
					<a href="/ptp/index.jsp" class="logo">pit-a-pet</a>
					<nav id="nav">
						<a href="<%=request.getContextPath() %>/index.jsp">Home</a>
						<a href="<%=request.getContextPath() %>/views/member/memberLogin.jsp">Login</a>
						<a href="<%=request.getContextPath() %>/views/member/join.jsp">Join</a>
					</nav>
				</div>
	</header>
</body>
</html>