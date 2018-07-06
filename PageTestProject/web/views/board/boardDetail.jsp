<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



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




</head>
<body>
	<%@include file="../common/header.jsp"%>
	<!-- %@include file="../board/side-reserv.jsp" %-->

	<div class="detail-board-block">

		<div class="detail-content-block">



			<div class="detail-content-top">
				<div class="detail-content-top2">
					<img class="detail-content-userImg"
						src="<%=request.getContextPath()%>/images/pic08.jpg">
				</div>
				<div class="detail-content-top3">이주은</div>
				<div class="detail-content-top4">
					<img src="<%=request.getContextPath()%>/images/common/pin_icon.png">
					경기 김포시 김포한강11로
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
					<a class="group3" href="../../upload/petsitter/1.jpg"
						rel="example1"> <img class="detail-mainImg"
						src="../../upload/petsitter/1.jpg" />
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
				<div class="detail-content-intro-t">인공항 가까운집!!! 인천 서구 검암동 펫시터
					입니다</div>
				<div class="detail-content-intro-c">

					Q. 왜 도그메이트 펫시터를 하게 되었나요?<br> A.<br> 1박이상 집을비우게될경우<br>
					가족중에 스케쥴이 안맞아 지원요청이안되면<br> 정말 맡길곳이 없더라구요 <br> 사건사고많은 호텔이나
					카페는 정말 못맡기겠고...저와같으신분들에게 도움이 되고싶다는 생각을하게되어 펫시터를 하게되었습니다.<br>
					----------------------------------------------------------------------------------------<br>
					<br> Q. 반려견을 키운 경험에 대해 알려주세요. 현재 반려견을 키우고 계시다면 자세히 소개해주세요!<br>
					A.<br> 첫째.둥이<br> 진돗개+래브라도리트리버 믹스견 15.01.25일생 여자아이입니다.<br>
					20kg나가요~집에 택배아저씨나 낯선사람이 오면 짖습니다.남자사람을 좋아하지않아요. 특히 나이있는 아저씨한테
					낯가려요.젊은오빠는 좋아라함.<br> 처음에만 짖을뿐 사회성이 없는아이는 아닙니다~방문하셨을때 첫째가짖더라도
					놀라지말아주세요~<br> 깔끔한 성격이라 비가오면 젖기싫어 테라스잘안나감.<br> 물을 별로 안좋아함.<br>
					<br> 둘째.초코송이 <br> 래브라도리트리버 17.03.04일생 여자아이
					입니다.36kg나가요~초특급순둥이 접대견입니다. 집에오는 사람이던 강아지던 가리지않고 좋아라합니다.짖는소릴 들어본게 손에
					꼽혀요.<br> 테라스 텃밭 딸기를 잘훔쳐먹어요<br> 텃밭도둑!!!그래서 강제 유기농재배ㅎㅎㅎ텃밭
					울타리치기.<br> 물을 너무좋아해서 비가와 뜯어말려도 테라스에나가놀아요<br> 덕분에 애들수건은 늘
					만땅준비중.여름엔 수영장설치.<br> <br>
					----------------------------------------------------------------------------------------<br>
					<br> Q. 애견호텔이 아닌 저에게 맡겨주시면 아래와 같은 내용을 약속드립니다.<br> A.<br>
					*내 아이들처럼 돌봐드리겠습니다~<br> *아이와 같이 열심히 놀겠습니다~<br> *건강하게
					먹이겠습니다~<br> *안전하게 돌보겠습니다~원하시면 분리돌봄 가능합니다.<br> *넓은실외테라스와
					실내 출입이 자유롭습니다~<br> *너무 멀지않다면 무료픽업 가능합니다~<br> <br> <br>
					----------------------------------------------------------------------------------------<br>
					<br> ※ 아래 유형의 아이들은 돌봄이 어려울 수 있습니다.<br> -전염성 질병이있는아이<br>
					-공격성 또는 입질이 있는아이<br> -실내마킹이 심한 수컷<br>
					----------------------------------------------------------------------------------------
				</div>
			</div>
			<div class="detail-content-env">
				<h4>돌봄 환경</h4>
				<dl class="col-sm-6 left" style="width: 50%; padding: 0 5px;">
					<dt class="pull-left house-type shade">돌봄공간</dt>
					<dd class="pull-right text-right shade">아파트</dd>
					<dt class="pull-left neighbor-subway">인근지하철역</dt>
					<dd class="pull-right text-right">없습니다.</dd>
					<dt class="pull-left house-yard shade">마당유무</dt>
					<dd class="pull-right text-right shade">없습니다</dd>
				</dl>
				<dl class="col-sm-6 right" style="width: 50%; padding: 0 5px;">
					<dt class="pull-left kids shade">14세 미만 아동</dt>
					<dd class="pull-right text-right shade">없습니다</dd>
					<dt class="pull-left within-family">가족 동거 유무</dt>
					<dd class="pull-right text-right">가족과 함께 살고 있어요</dd>
					<dt class="pull-left other-animal shade">다른 동물 유무</dt>
					<dd class="pull-right text-right shade">없습니다</dd>
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
	//예약 정보 db에 저장하는 서블릿으로 이동
		location.href="/ptp/";
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