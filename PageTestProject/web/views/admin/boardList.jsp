<%@page import="com.matajo.pitpet.board.model.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<% ArrayList<BoardVo> list = (ArrayList<BoardVo>)request.getAttribute("list"); %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/views/admin/adminHeader.jsp" %>
<div id="page" class="container">
<!-- 펫시터 유형 검색 기능 넣을 자리 -->
	
    <h1>펫시팅 글 관리</h1><br>
    <div id="applyTable">
		<table align="center">
			<tr>
				<th class="no">글번호</th>
				<th class="name">이름</th>
				<th class="type">유형</th>
				<th class="title">제목</th>
				<th class="admin">관리</th>
				
			</tr>
			<%if(list.size() == 0){ %>
				<tr>
					<td colspan="5">조회 된 펫시팅 글이 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(BoardVo b : list){ %>
				<tr>
					<td><%=b.getNo()%></td>			
					<td><%=b.getMemberNo()%></td>	
					<td>
						<%if(Integer.parseInt(b.getType())==1){ %>
							위탁 펫시터<%}else if(Integer.parseInt(b.getType())==2){%>
							방문 펫시터<%}else{%>위탁,방문 펫시터<%}%>
					</td>
					<td><a class="detail"><%=b.getTitle()%></a></td>
					<td>
						<button class="modify">수정</button>
						<button class="delete">삭제</button>
					</td>	
				</tr>
					<%} } %>	
		</table>
	</div>
	</div>
</body>
</html>