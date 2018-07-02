<%@page import="com.matajo.pitpet.member.model.vo.PetsitterApplyVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% ArrayList<PetsitterApplyVo> list = (ArrayList<PetsitterApplyVo>)request.getAttribute("list"); %>
<%int okayN =(int)request.getAttribute("okayN"); %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/views/admin/adminHeader.jsp" %>
<div id="page" class="container">

<!-- 펫시터 유형 검색 기능 넣을 자리 -->

    <h1><%if(okayN==0){ %>미승인된 펫시터 신청자<%}else if(okayN==1){ %>
    승인된 펫시터 신청자<%}else{ %>거절된 펫시터 신청자<%} %></h1><br>
    <div id="applyTable">
		<table align="center">
			<tr>
				<th class="no">회원번호</th>
				<th class="name">이름</th>
				<th class="type">유형</th>
				<th class="title">제목</th>
				<th class="admin">관리</th>
				
			</tr>
			<%if(list.size() == 0){ %>
				<tr>
					<td colspan="5">조회 된 펫시터 신청자가 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(PetsitterApplyVo p : list){ %>
				<tr>
					<td><%=p.getNo()%></td>			
					<td><%=p.getName()%></td>	
					<td>
						<%if(p.getType()==1){ %>
							위탁 펫시터<%}else if(p.getType()==2){%>
							방문 펫시터<%}else{%>위탁,방문 펫시터<%}%>
					</td>
					<td><a class="detail"><%=p.getAdComment()%></a></td>
					<td>
						<%if(okayN==0){ %>
						<button class="confirm">승인</button>
						<button class="reject">거절</button>
						<%}else if(okayN==1){ %>
						<button class="confirmCancel">승인 취소</button>
						<%}else {%>
						<button class="rejectCancel">거절 취소</button>
						<%} %>
					</td>	
					<%} }%>	
				</tr>
		</table>
	</div>
</div>
</body>
<script>
	$(".confirm").click(function(){
		var conBtn=$(this);
		var tr=conBtn.parent().parent();
		var td = tr.children();
		var memberNo = td.eq(0).text();
		
		location.href="/ptp/confirm.do?memberNo="+memberNo+"&selectNo=1";
	})
	
		$(".confirmCancel").click(function(){
		var conBtn=$(this);
		var tr=conBtn.parent().parent();
		var td = tr.children();
		var memberNo = td.eq(0).text();
		
		location.href="/ptp/confirm.do?memberNo="+memberNo+"&selectNo=2";
	})
	
	$(".reject").click(function(){
		var conBtn=$(this);
		var tr=conBtn.parent().parent();
		var td = tr.children();
		var memberNo = td.eq(0).text();
		
		location.href="/ptp/updateOkayN.do?memberNo="+memberNo+"&selectNo=3";
	})
	
	$(".rejectCancel").click(function(){
		var conBtn=$(this);
		var tr=conBtn.parent().parent();
		var td = tr.children();
		var memberNo = td.eq(0).text();
		
		location.href="/ptp/updateOkayN.do?memberNo="+memberNo+"&selectNo=4";
	})

	$(".detail").click(function(){
		var conBtn=$(this);
		var tr=conBtn.parent().parent();
		var td = tr.children();
		var memberNo = td.eq(0).text();
		
		location.href="/ptp/applyDetail.do?memberNo="+memberNo;
	})
</script>
</html>