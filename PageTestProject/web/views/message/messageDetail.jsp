<%@page import="com.matajo.pitpet.reservation.model.vo.ReservationVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%ReservationVo res = (ReservationVo)request.getAttribute("res"); %>
<title>쪽지 디테일</title>

</head>
<body>
<%@include file="/views/common/header.jsp"%>
<br>
<h1 align="center">예약 승인이 되었습니다.</h1>
<div >
 펫시팅 시간 :<%=res.getStartTime() %>~<%=res.getEndTime() %><br>
반려동물 종류: <%=res.getAnimalKind() %>
요청 사항 : 
<br>
<button onclick="payment();">결제하기</button>
<button>취소</button>

<script>
	function payment(){
		location.href="/ptp/views/payment/payment.jsp";
	}
</script>
</div>
</body>
</html>