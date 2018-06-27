<%@page import="com.matajo.pitpet.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫시터 신청</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css">
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<style>
		.wrapper{
			background-color:rgb(223,192,145);
		}
		.applyFormWrapper{
			background: white;
			width:50%;
			height:auto;
			margin-left: auto;
			margin-right:auto;
			
		}
	</style>
</head>
<body>
<%@include file="../common/header.jsp" %>
<div class="wrapper">
	<div class="applyFormWrapper">
	<h1 align="center">MATAJO 펫시터에 도전해보세요!</h1>
		<form id="applyForm" method="post" action="/ptp/petsiterApply.do">
		<input type="hidden" name="memberNo" value="<%=member.getNo()%>"/> 
			<table>
				<tr>
					<th>성명</th>
					<td >
						<input type="text" name="name" size="33"/>
					</td>
				</tr>
				<tr>
					<th>직업</th>
					<td>
						<input type="text" name="job"/>
					</td>
				</tr>
				<tr>
					<th>자격증</th>
					<td>
						<input type="text" name="license"/>
					</td>
				</tr>
				<tr>
					<th>자기소개서</th><br>
					<td colspan="4">
						<textarea name="info" cols="45" rows="15"></textarea>
					</td>
				</tr>
			</table>
			<div align="center">
				<input type="button" value="작성" onclick="applyPage();"/>
				<input type="button" value="취소" onclick="indexPage();"/>
			</div>
		</form>
	</div>
	</div>
<script>
	function indexPage(){
		location.href="<%=request.getContextPath() %>/index.jsp";
	}
	function applyPage(){
		console.log(<%=member.getCode()%>);
		 if(<%=member.getCode()%>==2){
			alert("이미 펫시터회원입니다.");
		}else{
			$("#applyForm").submit();
		}
	}
</script>
</body>
</html>