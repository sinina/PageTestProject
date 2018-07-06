<%@page import="java.util.ArrayList"%>
<%@page import="com.matajo.pitpet.admin.model.vo.PetsitInfoVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<% ArrayList<PetsitInfoVo> pI = (ArrayList<PetsitInfoVo>)request.getAttribute("pI"); %>
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
			<%if(pI==null){ %>
				<tr>
					<td colspan="5">등업 할 신규펫시터가 없습니다.</td>
				</tr>
			<%}else{ %>
				<tr>
				<%for(PetsitInfoVo p:pI){ %>
					<td><%=p.getP_i_no()%></td>			
					<td><a class="detail"><%=p.getName()%></a></td>
					<td><%=p.getP_i_up()%></td>	
					<td>
						<button class="confirm">등업하기</button>
						
					</td>	
				</tr>
						<%}} %>
		</table>
	</div>
</div>
<script>
	$(".confirm").click(function(){
		//신규펫시터-> 일반펫시터로 등업
		var conBtn=$(this);
		var tr=conBtn.parent().parent();
		var td = tr.children();
		
		var memberNo = td.eq(0).text();
		
		location.href="/ptp/updateGradePets.do?memberNo="+memberNo;
		
	});
	
</script>
</body>
</html>