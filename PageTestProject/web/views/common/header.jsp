<%@page import="com.matajo.pitpet.message.model.vo.MessageVo"%>
<%@ page import="com.matajo.pitpet.member.model.vo.MemberVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo member = (MemberVo) session.getAttribute("user");	
%>
<%
	MessageVo message = (MessageVo)request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/join.css">
<style>
a.message{
padding:0px;
}
</style>
<script>
	function Petcheck() {
		
		<%if(member != null){%>
			var memberCode = <%=member.getCode()%>;	
		<%}%>
		
		if(memberCode==2){
			alert("이미 펫시터 이십니다.");
			return false;	
		}
		return true;
	}
	
	$(function(){
	<%if(member!=null){%>
			$.ajax({
				type:'get',
				url:'/ptp/selectMsgFlag.do?memberNo=<%=member.getNo()%>',
				success:function(data){
					//console.log("성공",data);
					if(data=="ok"){
					//	alert("성공!")
						$("#msgIcon").attr("src","/ptp/images/common/message.png")
					}
				},error:function(e){
					console.log("에러",e);
				}
			});
		<%}%>
	}) 
	
	
</script>
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
						<a href="<%=request.getContextPath() %>/selectMonth.do">관리자 페이지</a>
						<%if(member==null) {%>
						<a href="<%=request.getContextPath() %>/views/member/memberLogin.jsp">Login</a>
						<a href="<%=request.getContextPath() %>/views/member/join.jsp">Join</a>
						<%}else{ %>
							<a href="<%=request.getContextPath() %>/patjoinab.do?userId=<%=member.getId()%>"><%=member.getName()%></a>
								<a href="<%=request.getContextPath() %>/selectMessage.do?memberNo=<%=member.getNo() %>" >
								<img src="/ptp/images/common/message1.jpg" height="20px" id="msgIcon"/></a>
							<a href="<%=request.getContextPath() %>/logout.do">LogOut</a>
							<a href="<%=request.getContextPath() %>/views/member/petsitterJoin.jsp" style="color:red" onclick="return Petcheck();">펫시터 신청</a>
						<%} %>
					</nav>
				</div>
	</header>
</body>
</html>