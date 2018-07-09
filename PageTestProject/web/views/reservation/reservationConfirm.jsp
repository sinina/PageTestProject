<%@page import="java.util.ArrayList"%>
<%@page import="com.matajo.pitpet.reservation.model.vo.ReservationVo"%>
<%@page import="com.matajo.pitpet.patjoin.model.vo.PatVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
ArrayList<PatVo> pInfo = (ArrayList<PatVo>)request.getAttribute("pInfo");
%>
<%
	ReservationVo rv =(ReservationVo) request.getAttribute("rv");
%>
</head>

<style>

.reserv-confirm{
	position:absolute;
	top:150px;
	left:30%;
	display: block;
	width: 800px;
	margin-bottom:100px;
}

.reserv-confirm-top{
	height:120px;
	width: 100%;
	
	font-size:15px;
	color:#737373 ;

}

.reserv-confirm-info{
	height:400px;
	width: 100%;
	border: 1px solid #D8D8D8;
	padding:25px;

}
.reserv-confirm-info2{
display:inline-block;
margin-top:10px;
margin-left : 10px;
border: 1px solid #D8D8D8;
padding:10px;
font-size:15px;
-webkit-border-radius: 0.5em;
color: #737373;
}

.reserv-confirm-info3{
margin-top:30px;
padding: 15px;

}




.reserv-confirm-caution{
	height:300px;
	width: 100%;
	
	padding:30px 25px;
	font-size:15px;
	margin-top:30px;
	background-color:#FBEFEF;
}


.reserv-confirm-massage{
	height:200px;
	width: 100%;
	padding:20px 0;

}
.reserv-confirm-massage2{
height:100%;
resize:none;

}


.reserv-confirm-btn{
	
	height:100px;
	width: 100%;
	
	text-align: center;
	padding:20px 0 !important;
}

.reserv-confirm-btn2{
	
	background-color: #ff5050;
	-webkit-border-radius: 0.5em;
}

.reserv-confirm-btn2:hover {
	background-color: #FE9A2E;
}


.review-user-img {
	display: inline-block;
	padding: 5px 0;
	width: 12%;
	height: 100%;
	float: left;
}

.review-user-userImg {
	-webkit-border-radius: 10em;
	width: 80px;
	height: 80px;
	margin-left: 5px;
	margin-top:10px;
	overflow: hidden;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
	border: solid 3px #ffffff;
	box-shadow: 0 0 0 1px #FCBC4E, 0 0 0 1px #6eb9b5;

}

.reserv-confirm-top-text{
display:inline-block;
 margin-top: 25px;
}

h4{
color:#737373 !important;
font-size:20px !important;
font-weight:normal !important;
margin-bottom:0px !important;

}


.reserv-dt {
    margin-right: 5px;
    text-align: left;
    width: 60%;
    padding: 3px 5px 3px 0;
    line-height: 200%;
}

.reserv-dd {
	text-align: right;
	margin-left: 60%;
	padding: 3px 5px 3px 0;
	line-height: 200%;
}

dt {
	float: left;
	padding: 3px 0 3px 5px;
	border-top: 1px solid #F0F0F0;
	line-height: 200%;
}

.result{
font-weight: bold; 
color: #FCBC4E;
font-size:25px;

}

</style>


<body>
<%@include file="../common/header.jsp"%>

<div class="reserv-confirm">
<form id="resInfo" action="insertReservation.do" method="post">
<h4><span>맡기실 반려동물을 선택해주세요.</span></h4>
	
	<span class="input-chk"> 
	<%for(int i=0;i<pInfo.size();i++){ %>
	<input type="checkbox" name="animalNo[]" value=<%=pInfo.get(i).getNo() %> id="petCheckId<%=i%>"/> 
	<label for= "petCheckId<%=i%>"><%=pInfo.get(i).getPatName() %></label>
	<input type="hidden"  name="animalKind[]" id="animalKind" value=<%=pInfo.get(i).getKinds() %>,<%=pInfo.get(i).getKinds_of() %>>
	<% }%>
	</span><br>

<div class="reserv-confirm-top">
	<div class="review-user-img">
		<img class="review-user-userImg" src="/ptp/images/pic08.jpg">
	</div>
	
	
	
	<br>
	<div class="reserv-confirm-top-text">
		<h4><span style="font-weight:bold;'"><%=rv.getPetsName()%></span>님에게 예약요청 메시지를 보냅니다.</h4>
		아래 예약 내역을 확인 후 돌보미에게 문의하세요!
	</div>

</div>
<div class="reserv-confirm-info">
<div class="reserv-confirm-info2">
체크인 <span style="margin-left:55px; font-weight:bold;"><%=rv.getStart() %></span>
</div>
<div class="reserv-confirm-info2">
체크아웃 <span style="margin-left:45px; font-weight:bold;"><%=rv.getEnd() %></span>
</div>
<div class="reserv-confirm-info2">
반려견 <span style="margin-left:30px; font-weight:bold;">1마리</span>
</div>

<div class="reserv-confirm-info3">
<dl class="reserv-form-price-detail">
						<dt class="reserv-dt" >반려견 추가</dt>
															
						<dd class="reserv-dd">
							<span>0원</span>
						</dd>
						<dt class="reserv-dt">
							<span>1박</span>
						</dt>
						<dd class="reserv-dd">
							<span>30,000원</span>
						</dd>
						<dt class="reserv-dt">초과금액</dt>
						<dd class="reserv-dd">
							<span>0원</span>
						</dd>
						<dt class="reserv-dt">부가세</dt>
						<dd class="reserv-dd">
							<span>3,000원</span>
						</dd>
						<dt class="reserv-dt result" >최종금액</dt>
						<dd class="reserv-dd result">
							<span><%=rv.getPrice() %>원</span>
						</dd>
					</dl>



</div>


</div>
<div class="reserv-confirm-caution">
<h5 style="font-size:20px; line-height:10px">예약요청 전 꼭 확인해주세요!</h5>
* 예약을 위해 강아지에 대한 내용을 펫시터에게 상세히 적어주세요.</br>
* 예약완료를 위해 펫시터의 예약 승인 후 2시간 이내로 입금해주셔야합니다.</br>
   ( 늦어질 경우 고객센터로 연락주세요.)


</div>

	<input type="hidden"  name="start" id="start" value=<%=rv.getStart() %>>
	<input type="hidden"  name="end" id="end" value=<%=rv.getEnd() %>>
	<input type="hidden"  name="petsNo" id="petsNo" value=<%=rv.getPetoNo()%>>
	<input type="hidden"  name="petoNo" id="petoNo" value=<%=rv.getPetsNo() %>>
	<input type="hidden" name="price" id="price" value=<%=rv.getPrice() %>>
<!-- 히든 값으로 start, end, petoNo, petsNo, price, animalNo(p_no) 넘길것 -->
<div class="reserv-confirm-massage">
<textarea class="reserv-confirm-massage2" name="msg" placeholder="펫시터에게 요청 사항을 입력해주세요."></textarea>
</div>
<div class="reserv-confirm-btn ">
<button class="reserv-confirm-btn2 ">예약 메세지 확인</button>

</div>
</form>
</div>
</body>
<script>
	$(".reserv-confirm-btn2").click(function(){
		$("#resInfo").submit();
	})
</script>
</html>