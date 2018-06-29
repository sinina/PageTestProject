<%@page import="com.matajo.pitpet.petsiterApply.model.vo.PetsiterApplyVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% ArrayList<PetsiterApplyVo> list = (ArrayList<PetsiterApplyVo>)request.getAttribute("list"); %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/views/admin/adminHeader.jsp" %>
<div id="page" class="container">
    <div id="memberTable">
		<table align="center">
			<tr>
				<th>회원번호</th>
				<th >아이디(이메일)</th>
				<th >이름</th>
				<th >핸드폰 번호</th>
				<th >직업</th>
				<th >자격증</th>
				<th >자기소개</th>
				<th >관리</th>
				
			</tr>
			<%if(list.size() == 0){ %>
				<tr>
					<td colspan="8">조회 된 반려주 회원이 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(PetsiterApplyVo p : list){ %>
				<tr>
					<td><%=p.getMemberNo()%></td>			
					<td><%=p.getMemberId()%></td>	
					<td><%=p.getMemberName()%></td>
					<td><%=p.getPhone()%></td>
					<td><%=p.getJob()%></td>
					<td><%=p.getLicense()%></td>			
					<td><%=p.getInfo()%></td>			
					<td>
						<button class="confirm">승인</button>
						<button class="reject">거절</button>
						
					</td>			
				</tr>
				<%} %>
			<%} %>
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
		/* console.log(memberNo); */
	})
	
	
</script>
</html>