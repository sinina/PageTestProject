<%@ page import="com.matajo.pitpet.member.model.vo.MemberVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo member = (MemberVo) session.getAttribute("user");	
%>
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
				<a href="/ptp/index.jsp" class="logo"><img src="/ptp/images/common/matajo_logo.png" height="85px"></a>
					<nav id="nav">
						<a href="<%=request.getContextPath() %>/index.jsp">Home</a>
						<a href="#three">Our Service</a>
						<a href="#one">How to Use</a>
						<!-- 관리자페이지 테스트위한 메뉴 -->
						<a href="<%=request.getContextPath() %>/views/admin/adminIndex.jsp">관리자페이지</a>
						<%if(member==null) {%>
						<a href="<%=request.getContextPath() %>/views/member/memberLogin.jsp">Login</a>
						<a href="<%=request.getContextPath() %>/views/member/join.jsp">Join</a>
						<%}else{ %>
							<a href="<%=request.getContextPath() %>/index.jsp" class="userName"><%=member.getName()%></a>
							<a href="<%=request.getContextPath() %>/logout.do">LogOut</a>
							<a href="<%=request.getContextPath() %>/views/member/petsitterJoin.jsp">펫시터 신청</a>
						<%} %>
					</nav>
				</div>
	</header>
</body>
</html>