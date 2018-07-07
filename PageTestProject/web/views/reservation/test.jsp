<%@page import="com.matajo.pitpet.reservation.model.vo.ReservationVo"%>
<%@page import="com.matajo.pitpet.patjoin.model.vo.PatVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	PatVo pInfo =(PatVo) request.getAttribute("pInfo");
%>
<%
	ReservationVo rv =(ReservationVo) request.getAttribute("rv");
%>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>


예약 시간 : <%=rv.getStart() %>~<%=rv.getEnd() %><br>
반려동물 정보 <br>
펫 이름:<%=pInfo.getPatName() %>
펫 종류:<%=pInfo.getKinds() %>/<%=pInfo.getKinds_of() %>
펫 무게:<%=pInfo.getPatkg() %>Kg
펫 성별:<%=pInfo.getPatgender()%>
소개:<%=pInfo.getPatInfo()%>
특이사항:<%=pInfo.getUniquness() %>
자주가는 병원:<%=pInfo.getHospital() %>
가격:
<!-- (end-start)*30000+3000 -->
<form action="do" method="post">
요청 사항 : 
<!-- 히든 값으로 start, end, petoNo, petsNo, price, animalNo(p_no) 넘길것 -->
</form>



</body>
</html>