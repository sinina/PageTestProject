<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% ArrayList<MessageVo> list = (ArrayList<MessageVo>)request.getAttribute("list"); %>

<title>Insert title here</title>
<style>
	.detail{
		cursor: pointer;
	}
</style>
</head>
<body>
<%@include file="/views/common/header.jsp"%>
<div id="page" class="container">
<br>
<h1>내 쪽지함</h1><br>
<div >
<table align="center" id="messageTable">
			<tr>
				<th>쪽지 번호</th>
				<th class="name">보내는 사람</th>
				<th class="type">내용</th>
				<th class="title">날짜</th>
				<th class="admin">수신확인</th>
				<th class="admin">관리</th>
				<th style="display:none">메시지코드</th>
				
			</tr>
			<%if(list.size() == 0){ %>
				<tr>
					<td colspan="6">조회 된 메시지가 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(MessageVo m : list){ %>
				<tr>
					<td><%=m.getMsgNo()%></td>
					<td><%=m.getSenderName()%></td>			
					<td><a class="detail"><%=m.getContent()%></a></td>	
					<td><%=m.getWriteDate() %></td>
					<td><%=m.getMsgFlag() %></td>
					<td>
						<button class="delete">삭제</button>
					</td>	
					<td style="display:none"><%=m.getMsgCode() %></td>
				</tr>
				<%}} %>
		</table>
</div>
</div>
</body>
<script>
$(".detail").click(function(){
	var conBtn=$(this);
	var tr=conBtn.parent().parent();
	var td = tr.children();
	var messageNo = td.eq(0).text(); 
	
	var msgCode = td.eq(6).text();
	//alert(messageCode);
	//플래그 바꾸는 서블릿으로 이동
	location.href="/ptp/updateMsg.do?messageNo="+messageNo+"&msgCode="+msgCode;
	
})

$(".delete").click(function(){
	var conBtn=$(this);
	var tr=conBtn.parent().parent();
	var td = tr.children();
	var messageNo = td.eq(0).text();
	//삭제 서블릿으로 이동
	location.href="/ptp/deleteMsg.do?messageNo="+messageNo+"&memberNo="+<%=member.getNo() %>;
})
</script>
</html>