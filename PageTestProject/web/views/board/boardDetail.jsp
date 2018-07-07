<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.matajo.pitpet.board.model.vo.BoardVo" %>
<%
	BoardVo board =(BoardVo) request.getAttribute("board");
%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>


<style>
.detail-board-block {
	position: relative;
	width: 50%;
	height: 70%;
	margin: 50px auto;
}

.reserv-block {
	border: 1px solid #D8D8D8;
	width: 300px;
	height: 500px;
	position: absolute;
	left: 650px;
	top: 80px;
	display: inline-block;
}

.reserv-form {
	padding: 10px;
	text-align: center;
}

.reserv-form-text {
	margin: 10px 0 15px;
	font-size: 12px;
	font-weight: 600;
	text-align: center;
	color: #7d7d7d;
}

.reserv-form-date {
	position: relative;
	display: inline-block;
	width: 100%;
	height: 40px;
	border: 1px solid #D8D8D8;
	-webkit-border-radius: 0.5em;
	margin-bottom: 5px;
}

.reserv-form-date2 {
	display: inline-block;
	width: 45%;
	height: 100%;
	margin-left: 3px;
	-webkit-border-radius: 0.5em;
}

.reserv-form-date3 {
	display: inline-block;
	color: #696969;
}

.date-input {
	width: 120px !important;
	font-size: 14px;
	padding: 0px 0px !important;
	border: 0 !important;
	background-color: white !important;
	color: #7d7d7d !important;
	height: 15px !important;
	line-height: 0 !important;
}

.reserv-form-price {
	margin: 0 15px;
}

.reserv-form-price2 {
	border-bottom: 1px solid #F0F0F0;
}

.reserv-form-price-per-add {
	font-size: 15px;
	margin-top: -10px;
	color: #696969;
	margin-bottom: 10px;
}

.reserv-form-price-detail {
	color: #696969;
	font-size: 14px;
}

.reserv-dt {
	margin-right: 5px;
	text-align: left;
	width: 60%;
	padding: 3px 5px 3px 0;
	line-height: 200%;
	border-bottom: 1px solid #F0F0F0;
}

.reserv-dd {
	margin-right: 5px;
	text-align: right;
	width: 38%;
	margin-left: 60%;
	padding: 3px 5px 3px 0;
	line-height: 200%;
	border-bottom: 1px solid #F0F0F0;
}

.reserv-btn {
	width: 100%;
	background-color: #ff5050;
	-webkit-border-radius: 0.5em;
}

.reserv-btn:hover {
	background-color: #FE9A2E;
}

.reserv-btn-enq {
	width: 100%;
	font-size: 12px;
	color: #6fb9b5;
}

.detail-content-block {
	display: inline-block;
	width: 650px;
	/* border: 1px solid black; */
	position: absolute;
	margin-left: -30px;
}

.detail-content-top {
	border-bottom: 1px solid #D8D8D8;
	width: 100%;
	height: 70px;
	padding: 8px;
}

.detail-content-img {
	border-bottom: 1px solid #D8D8D8;
	width: 100%;
}

.detail-content-img-main {
	display: inline-block;
	width: 650px;
	height: 400px;
}

.detail-content-img-main .detail-mainImg {
	padding: 10px 20px;
	width: 650px;
	height: 380px;
}

.detail-content-img-list {
	list-style: none;
	height: 103px;
	margin-top: -10px;
}

.bg-size {
	display: block;
	width: 100%;
	height: 103px;
	margin-left: -10px;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}

.detail-content-intro {
	border-bottom: 1px solid #D8D8D8;
	width: 100%;
	padding: 20px 0;
}

.detail-content-intro-t {
	display: inline-block;
	color: #737373;
	text-align: justify;
	padding: 10px 0;
	font-size: 20px;
}

.detail-content-intro-c {
	display: inline-block;
	color: #737373;
	padding: 10px 0;
	font-size: 15px;
}

.detail-content-env {
	display: inline-block;
	border-bottom: 1px solid #D8D8D8;
	width: 100%;
	height: 250px;
	padding: 20px 0;
}

.detail-content-review {
	display: inline-block;
	width: 100%;
	padding: 20px 0;
}

.review-user-img {
	display: inline-block;
	padding: 5px 0;
	width: 25%;
	height: 300px;
	float: left;
}

.review-user-userImg {
	-webkit-border-radius: 10em;
	width: 80px;
	height: 80px;
	margin-left: 45px;
	overflow: hidden;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
	border: solid 3px #ffffff;
	box-shadow: 0 0 0 1px #FCBC4E, 0 0 0 1px #6eb9b5;
}

.sitter-review-text {
	position: relative;
	display: inline-block;
	padding: 10px 20px;
	width: 100%;
	float: left;
	color: #7d7d7d;
	font-size: 12px;
	line-height: 25px;
	border-bottom: 1px solid #D8D8D8;
}

.service-type {
	position: absolute;
	top: 0;
	right: 0;
	font-weight: normal;
	color: #7d7d7d;
	font-size: 12px;
}

.detail-content-review-plus {
	weight: 100px;
	font-size: 12px;
	color: #6fb9b5;
	text-align: center;
	padding: 20px;
}

.detail-content-userImg {
	-webkit-border-radius: 10em;
	width: 50px;
	height: 50px;
	margin-left: 10px;
	box-shadow: 0 0 0 2px #FCBC4E;
}

.detail-content-top2 {
	width: 10%;
	height: 50px;
	float: left;
}

.detail-content-top3 {
	width: 13%;
	height: 50px;
	float: left;
	padding: 5px;
	margin-left: -2.5px;
	font-size: 20px;
	color: #696969;
}

.detail-content-top4 {
	width: 47%;
	height: 50px;
	float: left;
	padding: 17px;
	margin-left: -25px;
	font-size: 12px;
	color: #696969;
}

.detail-content-top5 {
	width: 15%;
	height: 50px;
	float: left;
}

.detail-content-top6 {
	line-height: 1.6;
	text-align: center;
}

.house-type {
	background-image: url(/static/img/sitter-detail/house-type.png);
	background-size: 20px 21px;
}

.shade {
	background-color: #f0f0f0;
}

.pull-left {
	width: 45%;
	padding-left: 10px;
	background-repeat: no-repeat;
	background-position: left 8px center;
	font-weight: normal;
	line-height: 40px;
	font-size: 13px;
	color: #7d7d7d;
}

.pull-right {
	line-height: 40px;
	font-size: 13px;
	width: 55%;
	padding-right: 8px;
	font-weight: bold;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	color: #7d7d7d;
}

h4 {
	color: #FCBC4E !important;
}

dt {
	float: left;
	padding: 3px 0 3px 5px;
	border-top: 1px solid #F0F0F0;
	line-height: 200%;
}
</style>

<script>
	$(function(){
		var address = '<%=board.getAddress()%>';
		
		$(".detail-content-top3").append('<%=board.getName()%>');
		$(".detail-content-top4").append(address.substring(address.indexOf(",")+2,18));	
		$(".detail-content-userImg").attr('src','<%=request.getContextPath()%>/upload/petsitter/<%=board.getPhoto1()%>');
		var $group3 = $(".group3");
		for(var i = 0 ;i<$group3.length;i++){
			var $element = $group3.eq(i);
			 switch(i){
				case 0 :
					$element.attr('href','<%=request.getContextPath()%>/upload/petsitter/<%=board.getPhoto1()%>');
					 $element.children().eq(0).attr('src','<%=request.getContextPath()%>/upload/petsitter/<%=board.getPhoto1()%>');
					 break;
				case 1 :
					$element.attr('href','<%=request.getContextPath()%>/upload/petsitter/<%=board.getPhoto2()%>');
					 $element.children().eq(0).attr('src','<%=request.getContextPath()%>/upload/petsitter/<%=board.getPhoto2()%>');
					 break;
				case 2 :
					$element.attr('href','<%=request.getContextPath()%>/upload/petsitter/<%=board.getPhoto3()%>');
					 $element.children().eq(0).attr('src','<%=request.getContextPath()%>/upload/petsitter/<%=board.getPhoto3()%>');
					 break;
				case 3 :
					$element.attr('href','<%=request.getContextPath()%>/upload/petsitter/<%=board.getPhoto4()%>');
					 $element.children().eq(0).attr('src','<%=request.getContextPath()%>/upload/petsitter/<%=board.getPhoto4()%>');
					 break;		 
			} 
			 
		}
		$(".detail-content-intro-t").append('<%=board.getTitle()%>');
		
		$question =$(".question");
		for(var i = 0 ;i<$group3.length;i++){
			var $element = $question.eq(i);
			switch(i){
			case 0:
				$element.append('<%=board.getOpportunity()%>');
				break;
			case 1:
				$element.append('<%=board.getActivityhisotry()%>');
				break;
			case 2:
				$element.append('<%=board.getPrcontext()%>');
				break;
				
			}
		}
		$textright = $(".text-right");
			
		<%if(board.getPickup()==0){%>
		$textright.eq(0).append('가능합니다.');
		<%}else{%>
		$textright.eq(0).append('불가능합니다.');
		<%}%>
	
		<%if(board.getCamera()==0){%>
		$textright.eq(1).append('있습니다.');
		<%}else{%>
		$textright.eq(1).append('없습니다.');
		<%}%> 
		
		<%if(board.getChild()==0){%>
		$textright.eq(3).append('있습니다.');
		<%}else{%>
		$textright.eq(3).append('없습니다.');
		<%}%> 
		
		<%if(board.getJobstyle()==1){%>
		$textright.eq(4).append('펫시터가 직업입니다.');
		<%}else{%>
		$textright.eq(4).append('펫시터는 부업입니다.');
		<%}%> 
		
		<%if(board.getAnimalcheck()==0){%>
		$textright.eq(5).append('있습니다.');
		<%}else{%>
		$textright.eq(5).append('없습니다.');
		<%}%> 
		
		var licen2 = '<%=board.getLicense2()%>';
		var licen3 = '<%=board.getLicense3()%>';
		var licen4 = '<%=board.getLicense4()%>';		
				
		if(0<licen2.substring(0,licen2.indexOf(','))||0<licen3.substring(0,licen3.indexOf(','))||0<licen4.substring(4,licen3.indexOf(','))){
			$textright.eq(2).append('있습니다.');
		}else{
			$textright.eq(2).append('없습니다.');
		}		
			
				
				
		
		 		
		

		
		
		
	});
</script>


</head>
<body>



	<%@include file="../common/header.jsp"%>
	<!-- %@include file="../board/side-reserv.jsp" %-->

	<div class="detail-board-block">

		<div class="detail-content-block">



			<div class="detail-content-top">
				<div class="detail-content-top2">
					<img class="detail-content-userImg"
						src="">
				</div>
				<div class="detail-content-top3"></div>
				<div class="detail-content-top4">
					<img src="<%=request.getContextPath()%>/images/common/pin_icon.png">
					
				</div>
				<div class="detail-content-top5">
					<!-- <button
type="button"
style=" font-size:15px; color:white; background:#FCBC4E;; border-radius:1em; padding:0px 6px;  width:80px; "
onclick="alert('신고하시겠습니까?')">신고</button> -->
				</div>
				<div class="detail-content-top6">
					<dt style="color: #696969; font-size: 16px; margin-left: 20px;">펫시터
						총점</dt>
					<samll
						style=" font-size:15px; border-radius:1em;  padding:2px 13px; background:#cabbac; color:white; ">4.5/5</samll>
				</div>
			</div>


			<div class="detail-content-img">
				<div class="detail-content-img-main">
					<a class="group3" href=""
						rel="example1"> <img class="detail-mainImg"
						src="" />
					</a>
				</div>

				<ul class="detail-content-img-list"">
					<li class="col-xs-4"><a class="group3"
						href="../../upload/petsitter/2.jpg" rel="example1"> <span
							class="bg-size cover"
							style="background-image: url(../../upload/petsitter/2.jpg)"></span>
					</a></li>
					<li class="col-xs-4"><a class="group3"
						href="../../upload/petsitter/3.jpg" rel="example1"> <span
							class="bg-size cover"
							style="background-image: url(../../upload/petsitter/3.jpg)"></span>
					</a></li>
					<li class="col-xs-4"><a class="group3"
						href="../../upload/petsitter/4.jpg" rel="example1"> <span
							class="bg-size cover"
							style="background-image: url(../../upload/petsitter/4.jpg)"></span>
					</a></li>
				</ul>



			</div>




			<div class="detail-content-intro">
				<h4>펫시터 소개</h4>
				<div class="detail-content-intro-t"></div>
				<div class="detail-content-intro-c">

					Q. 펫시터를 어떻게 시작하게 되었나요?<br> 
					<div class="question"></div>
					----------------------------------------------------------------------------------------<br>
					<br>  Q. 펫시터 활동 이력을 말씀해주세요. 처음시작하시는 분이라면 각오를 적어주세요.<br>
					<div class="question"></div>
					----------------------------------------------------------------------------------------<br>
					<br> Q. 애견호텔이 아닌 저에게 맡겨주시면 아래와 같은 내용을 약속드립니다.<br> A.<br>
					<div class="question"></div>
					<br>
					<br>
					----------------------------------------------------------------------------------------<br>
					
				</div>
			</div>
			<div class="detail-content-env">
				<h4>돌봄 환경</h4>
				<dl class="col-sm-6 left" style="width: 50%; padding: 0 5px;">
					<dt class="pull-left house-type shade">픽업유무</dt>
					<dd class="pull-right text-right shade"></dd>
					<dt class="pull-left neighbor-subway">카메라유무</dt>
					<dd class="pull-right text-right"></dd>
					<dt class="pull-left house-yard shade">자격증유무</dt>
					<dd class="pull-right text-right shade"></dd>
				</dl>
				<dl class="col-sm-6 right" style="width: 50%; padding: 0 5px;">
					<dt class="pull-left kids shade">14세 미만 아동</dt>
					<dd class="pull-right text-right shade"></dd>
					<dt class="pull-left within-family">전업유무</dt>
					<dd class="pull-right text-right"></dd>
					<dt class="pull-left other-animal shade">다른 동물 유무</dt>
					<dd class="pull-right text-right shade"></dd>
				</dl>
			</div>
			<div class="detail-content-review">
				<h4>
					후기 (<span>1</span>개)
				</h4>

				<div class="sitter-review-text">
					<div class="review-user-img">
						<img class="review-user-userImg" src="/ptp/images/pic08.jpg">
					</div>
					<div class="sitter-review-user"
						style="font-size: 15px; font-weight: bold; margin-bottom: 8px;">이윤우</div>
					<div class="moreText">
						너무 너무 만족스러웠고 고마웠습니다!<br> 와이프 출산으로 2주가량 맡길 곳이 필요했는데 정말 걱정없이
						맘편히 저희집 강아지를 확인할 수있었습니다~<br> 매일매일 사진과 동영상, 일지 꼼꼼하게 보내주셔서 얼마나
						마음 놓였는지 모릅니다.<br> 낯 많이 가리고 사회성없는 아이로만 생각했는데 활기차게 지내는 새로운 모습들도
						볼 수 있었습니다^^ <br> 다음에 또 기회가 된다면 저희 강아지 봐주셨던 돌보미님과 다시한번 뵙고 싶네요!
						친절한 설명과 사랑으로 저희집 강아집 돌봐주셔서 정말 감사했습니다^^
					</div>
					<div class="sitter-review-date">2018. 06. 10.</div>
					<label class="service-type">24시간 돌봄</label>
				</div>

			</div>
			<div class="detail-content-review-plus">
				<a href="">다른 후기 더보기 (<span>62</span>개)
				</a>
			</div>

		</div>




		<div class="reserv-block">
			<form class="reserv-form">

				<div class="reserv-form-text">예약을 원하는 날짜와 시간을 선택해주세요.</div>

				<div class="reserv-form-date">

					<div class='reserv-form-date2'>
						<input type='text' class="date-input" id='datetimepicker4'
							placeholder="     시작날짜 00:00" />
					</div>
					<div class="reserv-form-date3">></div>
					<div class='reserv-form-date2'>
						<input type='text' class="date-input" id='datetimepicker5'
							placeholder="  마침날짜 00:00" />
					</div>
					<script type="text/javascript">
						$(function() {
							$('#datetimepicker4').datetimepicker({
								format : "YYYY-MM-DD HH:mm",
								locale : 'ko',
								minDate : 'moment',
								useCurrent : false,

							});
						});

						$(function() {
							$('#datetimepicker5').datetimepicker({
								format : "YYYY-MM-DD HH:mm",
								locale : 'ko',
								minDate : 'moment',
								useCurrent : false
							});

							$('#datetimepicker4').keyup(function() {
								$(this).val('');
							});
							$('#datetimepicker5').keyup(function() {
								$(this).val('');
							});
						});
					</script>

				</div>

				<div class="reserv-form-price">
					<div class="reserv-form-price2">
						<span style="color: #FCBC4E; font-size: 25px; font-weight: bold;">30,000원</span>
						<div class="reserv-form-price-per-add">
							반려견 추가 당 <span style="color: #FCBC4E;">25,000원</span>
						</div>
					</div>
					<dl class="reserv-form-price-detail">
						<dt class="reserv-dt">반려견 추가</dt>
						<dd class="reserv-dd">
							<span id="ctlADDSUM">0원</span>
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
						<dt class="reserv-dt" style="font-weight: bold;">총 합계</dt>
						<dd class="reserv-dd result" style="font-weight: bold";>
							<span>33,000원</span>
						</dd>
					</dl>

				</div>

				<button class="reserv-btn">예약요청하기</button>

				<a class="reserv-btn-enq"> 예약문의하기 </a>

			</form>
		</div>
	</div>

</body>
<script>
	$(".reserv-btn").click(function(){
		//보드의 디테일에 있는 M_MEMBER_NO값
		<%=board.getNo()%> 
	
		<%if(member==null){%>
		alert("로그인 이후 예약 가능합니다.");
		<%}else{%>
			var memberCode =<%=member.getCode()%>
		<%}%>
			if(memberCode==2){
				alert("반려주만 예약 가능합니다.");
		}else{
			location.href="/ptp/insertReservation.do?memberNo="+<%=member.getNo()%>;
		}
		<%-- <%=request.getContextPath()%>
		var start = $("#datetimepicker4").val();
		var end = $("#datetimepicker5").val();
		//예약 정보 저장할때 반려주No, 펫시터No 필요함!
		location.href="/ptp/basicRes.do?start="+start+"&end="+end+"&memberNo="+<%=member.getNo()%>; --%>
	});
</script>
<script>
	$(document)
			.ready(

					function() {
						//Examples of how to assign the Colorbox event to elements
						$(".group3").colorbox({
							rel : 'group3',
							transition : "none",
							width : "75%",
							height : "75%"
						});

						$(".ajax").colorbox();
						$(".youtube").colorbox({
							iframe : true,
							innerWidth : 640,
							innerHeight : 390
						});
						$(".vimeo").colorbox({
							iframe : true,
							innerWidth : 500,
							innerHeight : 409
						});
						$(".iframe").colorbox({
							iframe : true,
							width : "80%",
							height : "80%"
						});
						$(".inline").colorbox({
							inline : true,
							width : "50%"
						});
						$(".callbacks")
								.colorbox(
										{
											onOpen : function() {
												alert('onOpen: colorbox is about to open');
											},
											onLoad : function() {
												alert('onLoad: colorbox has started to load the targeted content');
											},
											onComplete : function() {
												alert('onComplete: colorbox has displayed the loaded content');
											},
											onCleanup : function() {
												alert('onCleanup: colorbox has begun the close process');
											},
											onClosed : function() {
												alert('onClosed: colorbox has completely closed');
											}
										});

						$('.non-retina').colorbox({
							rel : 'group5',
							transition : 'none'
						})
						$('.retina').colorbox({
							rel : 'group5',
							transition : 'none',
							retinaImage : true,
							retinaUrl : true
						});

						//Example of preserving a JavaScript event for inline calls.
						$("#click")
								.click(
										function() {
											$('#click')
													.css(
															{
																"background-color" : "#f00",
																"color" : "#fff",
																"cursor" : "inherit"
															})
													.text(
															"Open this window again and this message will still be here.");
											return false;
										});
					});
</script>
</html>