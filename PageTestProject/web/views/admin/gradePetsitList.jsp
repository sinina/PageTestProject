<%@page import="com.matajo.pitpet.admin.model.vo.PetsitInfoVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<%PetsitInfoVo pI = (PetsitInfoVo)request.getAttribute("pI"); %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/views/admin/adminHeader.jsp" %>
<div id="page" class="container">
 <div id="applyTable">
		<table align="center">
			<tr>
				<th class="no">회원번호</th>
				<th class="name">이름</th>
				<th class="type">펫시터 된 날짜</th>
				<th class="admin">관리</th>
				
			</tr>
			<%if(pI!=null){ %>
				<tr>
					<td colspan="5">등업 할 신규펫시터가 없습니다.</td>
				</tr>
			<%}else{ %>
				<tr>
					<td><%=pI.getP_i_no()%></td>			
					<td><a class="detail"><%=pI.getName()%></a></td>
					<td><%=pI.getP_i_up()%></td>	
					<td>
						<button class="confirm">등업하기</button>
						<button class="reject">거절</button>
						<%} %>
					</td>	
				</tr>
		</table>
	</div>
</div>
</body>
</html>