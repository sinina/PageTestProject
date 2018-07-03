<%@page import="com.matajo.pitpet.review.model.vo.ReviewVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<% ArrayList<ReviewVo> list = (ArrayList<ReviewVo>)request.getAttribute("list"); %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/views/admin/adminHeader.jsp" %>
<div id="page" class="container">
<h1>후기글 관리</h1><br>
    <div id="applyTable">
		<table align="center">
			<tr>
				<th class="no">후기글번호</th>
				<!-- <th class="no">펫시팅글번호</th> -->
				<th class="name">이름</th>
				<th class="admin">작성일</th>
				<th class="admin">관리</th>
				
			</tr>
			<%if(list.size() == 0){ %>
				<tr>
					<td colspan="4">조회 된 후기 글이 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(ReviewVo r : list){ %>
				<tr>
					<td><%=r.getNo()%></td>		
					<td><%=r.getMemberName()%></td>	
					<td><%=r.getEnrollDate() %></td>
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