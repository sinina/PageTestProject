<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서비스 이용안내</title>
<style>
	.wrap{
		width:70%;
		margin-left: auto;
		margin-right: auto;
		margin-top: 60px;
		margin-botton:50px;
	}
	.service{
		font-family: 20px;
		margin-botton:50px;
	}
</style>
</head>
<body>
<%@include file="../../views/common/header.jsp"%>
<div class="wrap">
 
 <h4>MATAJO는 펫시터가  고객님의 집으로 찾아가거나,<br> 펫시터 집에서 고객님의 반려동물을 돌봐주는 서비스 입니다.<br></h4>
 <div class="service">

 1. 로그인 먼저 해주세요<br>
 <img src="/ptp/images/service/login.png"/><br>
 2. 마음에 드는 펫시터를 찾으셨다면 맡기는 날짜를 선택하고 예약 요청버튼을 눌러주세요.<br>
 3. 예약 정보가 맞는지 한번 더 확인해주세요.<br>
 4. 펫시터에게 답변이 도착하면 홈페이지 상단의 메시지 아이콘이 변경 되어 답변을 확인 가능합니다.<br>
  <img src="/ptp/images/service/messageIcon.PNG" width= 400px/><br>
   <img src="/ptp/images/service/message.png"/><br>
 5. 예약이 확정 되었으면 결제해주세요.<br><br>
 
 
 MATAJO 서비스를 통해 이제 반려동물을 외롭게 하지 마세요:)<br>
 </div>
 </div>
 <%@include file="../../views/common/footer.jsp"%>
</body>
</html>