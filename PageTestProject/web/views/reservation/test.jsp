<%@page import="com.matajo.pitpet.reservation.model.vo.ReservationVo"%>
<%@page import="com.matajo.pitpet.patjoin.model.vo.PatVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="/ptp/js/jquery-3.3.1.min.js"></script>
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
<style>
textarea{
width: 100%;
    height: 270px;
    color: #868686;
    line-height: 1.5em;
    padding: 20px;
    margin-bottom: 40px;
    border: 1px solid #dcdcdc;
resize: none;}

.request-message-detail {
    margin: 40px 0 0;
    padding: 25px;
    background-color: #f5f5f5;
    border-top: solid 1px #dfdfdf;
    line-height: 1.6;
    }
    .request-main {
    padding: 30px;
    border: solid 1px #dcdcdc;
}
    .btnRes label {
    cursor: pointer;
    display: block;
    padding: 15px 0 !important;
}
.btnRes{
    background-color: #FCBC4E;
    border: none;
    color: #ffffff;
    font-weight: bold;
    font-size: 120%;
    line-height: normal;
    border-radius: 5px;
    cursor: pointer;
    width: 330px;}
</style>
</head>
<body>
<div class="inner">

예약 정보 확인 창 (학원가서 큰별오빠가 만든 창으로 바꿀것)
<div class="request-main">
예약 시간 : <%=rv.getStart() %>~<%=rv.getEnd() %><br>
반려동물 정보 <br>
펫 이름:<%=pInfo.getPatName() %><br>
펫 종류:<%=pInfo.getKinds() %>/<%=pInfo.getKinds_of() %><br>
펫 무게:<%=pInfo.getPatkg() %>Kg<br>
펫 성별:<%=pInfo.getPatgender()%><br>
소개:<%=pInfo.getPatInfo()%><br>
특이사항:<%=pInfo.getUniquness() %><br>
자주가는 병원:<%=pInfo.getHospital() %><br>
가격:

<script>
$(document).ready(function() {
	var startT="<%=rv.getStart().substring(0, 10) %>";
	var endT="<%=rv.getEnd().substring(0, 10) %>";
	
	var arr1 = startT.split("-");
	var arr2 = endT.split("-");
	var dat1 = new Date(arr1[0], arr1[1], arr1[2]);
	var dat2 = new Date(arr2[0], arr2[1], arr2[2]);

	var diff = dat2 - dat1;
	var currDay=24*60*60*1000;
	var price= parseInt(diff/currDay)*30000+3000;
	$("#price").val(price);
});
</script>
</div>
<div class="request-message-detail">
<h4>예약 요청 전 꼭 확인해주세요!</h4>
</div>
<form id="resInfo" action="insertReservation.do" method="post">
<input type="hidden"  name="price" id="price">
<input type="hidden"  name="start" id="start" value=<%=rv.getStart() %>>
<input type="hidden"  name="end" id="end" value=<%=rv.getEnd() %>>
<input type="hidden"  name="petsNo" id="petsNo" value=<%=rv.getPetoNo()%>>
<input type="hidden"  name="petoNo" id="petoNo" value=<%=rv.getPetsNo() %>>
<input type="hidden"  name="animalNo" id="animalNo" value=<%=pInfo.getNo() %>>
<input type="hidden"  name="animalKind" id="animalKind" value=<%=pInfo.getKinds() %>,<%=pInfo.getKinds_of() %>>
<!-- 히든 값으로 start, end, petoNo, petsNo, price, animalNo(p_no) 넘길것 -->
<textarea name="msg" placeholder="펫시터에게 요청 사항을 입력해주세요."></textarea>
<button class="btnRes">
<label>예약 요청 보내기</label>
</button>
</form>

</div>
</body>
<script>
	$(".btnRes").click(function(){
		$("#resInfo").submit();
	})
</script>
</html>