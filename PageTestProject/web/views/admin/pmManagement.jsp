<%@page import="com.matajo.pitpet.member.model.vo.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<MemberVo> list = (ArrayList<MemberVo>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펫시터 멤버 관리</title>
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
				<th >성별</th>
				<th >나이</th>
				<th >핸드폰 번호</th>
				<th >가입일</th>
				<th >관리</th>
				
			</tr>
			<%if(list.size() == 0){ %>
				<tr>
					<td colspan="8">조회 된 펫시터 회원이 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(MemberVo m : list){ %>
				<tr>
					<td><%=m.getNo() %></td>			
					<td><%=m.getId() %></td>	
					<td><%=m.getName() %></td>
					<td><%=m.getGender() %></td>
					<td><%=m.getAge() %></td>
					<td><%=m.getPhone() %></td>			
					<td><%=m.getEnrollDate() %></td>			
					<td>
						<button onclick="modifyMember();">수정</button>
						<button class="deleteMember">삭제</button>
						
					</td>			
				</tr>
				<%} %>
			<%} %>
		</table>
	</div>
	
</div>
</body>
<script>
	$(".deleteMember").click(function(){
		var delBtn =$(this);
		var tr = delBtn.parent().parent();
		var td = tr.children();
		var memberNo = td.eq(0).text();
		
		/* console.log(memberNo); */
		//selectNo 는 회원탈퇴 시키고 난후 탈퇴시킨 페이지로 이동하기 위한 파라미터
		location.href="/ptp/deleteMember.do?memberNo="+memberNo+"&selectNo=2";
	});
	
</script>
</html>