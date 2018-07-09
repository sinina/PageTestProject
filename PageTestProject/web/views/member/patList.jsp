<%@page import="com.matajo.pitpet.member.model.vo.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.matajo.pitpet.patjoin.model.vo.PatVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    MemberVo mv = (MemberVo) session.getAttribute("user");
    ArrayList<PatVo> list = (ArrayList<PatVo>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MATAZO</title>
<style>
.table{
}
#pat{
}
</style>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<script>
function pat(){
	location.href="/ptp/views/member/patjoin.jsp";	
}
$(function(){
	$(".tableArea td").mouseenter(function(){
		$(this).parent().css("background","darkgray");
		$(this).parent().css("cursor","pointer");
	}).mouseout(function(){
		$(this).parent().css("background","none");
	});
});

function callPetInfo(no){
	location.href = "/ptp/patjoinsu.do?userId=" + no;
}
</script>
</head>
<body>
	<div class="tableArea">
		<table align="center" class="table">
		<%if(list.size() == 0){ %>
				<tr>
					<td>반려동물 정보가 없습니다.</td>
				</tr>
		<%}else{ %>
			<%for(PatVo n : list){ %>
				<tr onclick="callPetInfo(<%=n.getNo()%>);">
				<td><img id="petImage" src="/ptp/PatImage/<%=n.getPatImage() %>" width="220" height="80"/></td>
				<td><%=n.getPatName() %></td>
				<td><%=n.getKinds() %></td>
				</tr>
			<%} %>
		<%} %>
		</table>
	</div>
	<button id="pat" onclick="pat();">등록하기</button>
</body>
</html>