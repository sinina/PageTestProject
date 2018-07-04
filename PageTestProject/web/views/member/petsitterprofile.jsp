<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<meta charset="UTF-8">
<title>돌보미등록하기</title>

<style>
	html h4{
	color:black;
	border-bottom: 1px solid skyblue;	
	}
	html h5 ,html label{
	color:black;
	}
	html .inner{
		width:800px;
		margin-left: auto;
		margin-right: auto;
		overflow: hidden;
	}
	
	body li{
		list-style: none;
	
	}
	body label{
		font-size:70%;
		display:inline-block;
		width: 120px;
		
	}
	body input[type="text"]{
		border : 1px solid black;
		display:inline-block;
		width:auto;
	}
	
	.dub  input[type="text"],.dub label{
		width :auto;
		display: block;
	}

	.wrap{
		border: 2px solid skyblue;
		border-radius: 20px;
		width: 900px;
		margin-right: auto;
		margin-left:auto;
	}
	#head{
		background-repeat:repeat-x;
		height:50px;
		background: skyblue;
		border-radius:  17px 17px 0 0;
	}
	#head h4{
		margin-left: 50px;
		line-height: 2.5;
		border:none;
	}
	
	.bankInfo{
		float:left;
		margin-left: 1px;
		margin-right: 109px;
		padding:15;
	}
	/* body input[type="checkbox"]:checked+label:before, body input[type="radio"]:checked+label:before
	{
	content: ;
	}
	
	body input[type="checkbox"]+label:before, body input[type="radio"]+label:before {
	border-radius: 0;
	border: solid 1px;
	content: '';
	display: inline-block;
	height: 1em;
	left: 0;
	line-height: em;
	position: absolute;
	text-align: center;
	top: 0;
	width: 1em;
	} */
	
}
}
</style>
<script>
	$(function(){
		$("#adComment").val("sd");
		$("#opportunity").val("sd");
		$("#activityHistory").val("as");
		$("#prContext").val("asd");
		$("#sitterCareer").val(1);
		$("#distance").val(1);
		 $("#hospital").val("사랑");
		 $("#hospitalPhoneNumber").val(1);
		 $("#oneDayCount").val(3);
		 $("#bank").val(4);
			 $("#bankName").val("사람인");
			 $("#bankNumber").val("110-22-1123");
	});
	
	function validate(){
		var $adComment = $("#adComment");
		var $opportunity = $("#opportunity");
		var $activityHistory = $("#activityHistory");
		var $prContext = $("#prContext");
		var $sitterCareer = $("#sitterCareer");
		var $distance = $("#distance");
		var $hospital = $("#hospital");
		var $hospitalPhoneNumber = $("#hospitalPhoneNumber");
		var $oneDayCount = $("#oneDayCount");
		var $bank = $("#bank");
		var $bankName = $("#bankName");
		var $bankNumber = $("#bankNumber");
		
		 if($adComment.val()==""){
			alert("펫시터 소개 제목을 입력해 주세요");
			$adComment.focus();
			return;
		}
		
		if($adComment.val().length>200){
			alert("펫시터 소개 제목은 20자를 넘을수 없습니다.");
			$adComment.focus();
			return;
		}	
		
		if($opportunity.val()==""){
			alert("펫시터 소개1번을 입력해 주세요");
			$opportunity.focus();
			return;
		}
		
		 if($opportunity.val().length>200){
			alert("펫시터 소개는 200자를 넘을수 없습니다.");
			$opportunity.focus();
			return;
		}	 
		 
		if($activityHistory.val()==""){
				alert("펫시터 소개2번을 입력해 주세요");
				$activityHistory.focus();
				return;
		}
			
		if($activityHistory.length>200){
				alert("펫시터 소개 제목은 200자를 넘을수 없습니다.");
				$activityHistory.focus();
				return;
		}		
		
		if($prContext.val()==""){
			alert("인터뷰질문에 답해주세요!~");
			$prContext.focus();
			return;
	}
		
	if($prContext.length>200){
			alert("인터뷰 내용은 200자를 넘을수 없습니다.");
			$prContext.focus();
			return;
	}		
	
	if($sitterCareer.val()==0){
		alert("경력 사항을 선택해 주세요");
		$sitterCareer.focus();
		return;
	}
	
	if($("input[name='petSize[]']:checked").length==0){
		alert("수용가능한 펫 크기를 하나 이상 체크 해주세요");
		$("#small").focus();
		return;
	}
	
	if($("input[name='petAge[]']:checked").length==0){
		alert("수용가능한 펫 연령을 하나 이상 체크 해주세요");
		$("#baby").focus();
		return;
	}
	
	if($distance.val()==""){
		alert("가까운 동물병원 거리까지의 시간을 입력해 주세요");
		$distance.focus();
		return;
	}
	
	if($hospital.val()==""){
		alert("가까운 동물병원 을 입력해 주세요");
		$hospital.focus();
		return;
	}
	
	if($hospitalPhoneNumber.val()==""){
		alert("가까운 동물병원 전화를 입력해 주세요");
		$hospitalPhoneNumber.focus();
		return;
	}
	
	if($oneDayCount.val()==""){
		alert("맡을수 있는 동물의 수를 입력해 주세요");
		$oneDayCount.focus();
		return;
	}
	if($bank.val()==0){
		alert("은행을 선택하여 주세요");
		$bank.focus();
		return;
	}
	if($bankName.val()==""){
		alert("이름을 입력해 주세요");
		$bankName.focus();
		return;
	} 
	
	if($bankNumber.val()==""){
		alert("계좌 번호를 입력해 주세요");
		$bankNumber.focus();
		return;
	}  
	
		if($("#petsitterImage1").val()==""){
			alert("사진을 모두 동록 해야 합니다.");
			$("#petsitterImage1").focus();
			return;
		}
		if($("#petsitterImage2").val()==""){
			alert("사진을 모두 동록 해야 합니다.");
			$("#petsitterImage2").focus();
			return;
		}
		if($("#petsitterImage3").val()==""){
			alert("사진을 모두 동록 해야 합니다.");
			$("#petsitterImage3").focus();
			return;
		}
		if($("#petsitterImage4").val()==""){
			alert("사진을 모두 동록 해야 합니다.");
			$("#petsitterImage4").focus();
			return;
		}
		
		defaultProfile();
	}
	
	function defaultProfile(){
		$("#petsitterProfile").submit();
	}

	
	
</script>
</head>
<body>	
	  <%@include file="../common/header.jsp" %>
	<div class="wrap">
	<div id="head"><h4>펫시터 신청서</h4></div>
		<div class="inner">			
			<form id="petsitterProfile" action="/ptp/petsitterjoin.do" method="post"  enctype ="multipart/form-data" > 
				
				<div>
					<h4>기본정보</h4>
					<ul>

						<li><label>펫시터링 유형</label> <span class="radio-chk"> <input
								type="radio" id="petsitter1" name="sitterType" value="1" checked />
								<label for="petsitter1">위탁 펫시터</label> <input type="radio"
								id="petsitter2" name="sitterType" value="2" /> <label
								for="petsitter2">방문 펫시터</label> <input type="radio"
								id="petsitter3" name="sitterType" value="3" /> <label
								for="petsitter3">위탁 &amp; 방문</label>
						</span></li>

						<li class="large"><label>개인정보 공개범위</label> <span
							class="radio-chk"> <input type="radio" id="phone"
								name="openArea" value="1" checked /> <label for="phone">휴대폰번호</label>
								<input type="radio" id="kakaotalk" name="openArea" value="2" />
								<label for="kakaotalk">이메일</label> <input type="radio"
								id="openBoth" name="openArea" value="3" /> <label for="openBoth">둘
									다</label>
						</span></li>

						<li class="large"><label>전업 펫시터 여부</label> <span
							class="radio-chk"> <input type="radio" id="fullTime"
								name="fullTimeJob" value="1" checked /> <label for="fullTime">전업펫시터</label>
								<input type="radio" id="twoJob" name="fullTimeJob" value="2" />
								<label for="twoJob">부업,투잡</label>
						</span></li>
					</ul>

					<h4>펫시터 소개 제목</h4>
					<ul class="info-list none address">
						<li class="dub"><label for="adComment">펫시터로서 나를 50자
								이내로 표현해주세요. <br />
						</label> <input type="text" style="width: 600px;" name="adComment"
							value="" placeholder="강아지,고양이에 대한 애정이 깊은 펫시터입니다." id="adComment" />
						</li>
					</ul>

					<h4>펫시터 소개 (인터뷰)</h4>
					<ul class="info-list none address interview">
						<li class="dub"><label style="font-weight: 600;">펫시터를
								시작하게된 계기, 활동이력, 반려하고 있는 동물 소개 등과 함께 반려동물을 사랑하는 마음이 담긴 본인소개를
								해주세요. <span style="color: #FF7289; font-size: 13px;">(펫시터의
									전화번호나 카카오톡 아이디는 본문에 기재하지 말아주세요.)</span>
						</label> <label>1. 펫시터를 어떻게 시작하게 되었나요?</label> <input type="text"
							style="width: 600px;" name="opportunity" value=""
							id="opportunity"></li>
						<li class="dub"><label>2. 펫시터 활동 이력을 말씀해주세요. 처음시작하시는
								분이라면 각오를 적어주세요.</label> <input type="text" style="width: 600px;"
							name="activityHistory" value="" id="activityHistory"></li>

						<li><label style="width: 245px;">3. 장기 시터링도 가능하신가요?</label> <span
							class="radio-chk"> <input type="radio" id="yes1"
								name="long_term" value="0" checked /> <label for="yes1" style="">예</label>
								<input type="radio" id="no1" name="long_term" value="1" /> <label
								for="no1">아니오</label>
						</span></li>
						<li><label style="width: 245px;">4. 픽업 가능하신가요?</label> <span
							class="radio-chk"> <input type="radio" id="yes2"
								name="pickup" value="0" checked /> <label for="yes2" style="">예</label>
								<input type="radio" id="no2" name="pickup" value="1" /> <label
								for="no2">아니오</label>
						</span></li>
						<li class="dub"><label>5. 반려동물을 사랑하는 마음이 듬~뿍 담긴 소개
								부탁드립니다^^</label> <textarea name="prContext" id="prContext"></textarea></li>
					</ul>

					<h4>경력 및 활동지역</h4>
					<ul class="info-list none address">
						<li><label>펫시터 경력</label> <span> <select
								title="경력을 선택해주세요" name="sitterCareer" id="sitterCareer">
									<option value="0">- 선택 -</option>
									<option value="1">없음</option>
									<option value="2">6개월 미만</option>
									<option value="3">6개월 이상 ~ 1년 미만</option>
									<option value="4">1년 이상 ~ 3년 미만</option>
									<option value="5">3년 이상 ~ 5년 미만</option>
									<option value="6">5년 이상 ~ 10년 미만</option>
									<option value="7">10년 이상</option>
							</select>
						</span></li>
					</ul>

					<h4>상세정보</h4>
					<ul class="info-list none address label-ico">
						<li><label class="size">수용 가능한 펫 크기<span>(복수선택
									가능)</span></label> <span class="input-chk"> <input type="checkbox"
								id="small" name="petSize[]" value="1" /> <label for="small">소형(5kg미만)</label>
								<input type="checkbox" id="mid" name="petSize[]" value="2" /> <label
								for="mid">중형(5kg~10kg)</label> <input type="checkbox" id="big"
								name="petSize[]" value="3" /> <label for="big">대형(10kg이상)</label>
						</span></li>
						<li><label class="pet name">수용 가능한 펫 연령<span>(복수선택
									가능)</span></label> <span class="input-chk"> <input type="checkbox"
								id="baby" name="petAge[]" value="1" /> <label for="baby">베이비(1살미만)</label>
								<input type="checkbox" id="junior" name="petAge[]" value="2" />
								<label for="junior" style="width: 127px; ">주니어(1~7살미만)</label> <input
								type="checkbox" id="senior" name="petAge[]" value="3" /> <label
								for="senior">시니어(7살 이상)</label>
						</span></li>

						<li class="is_pet"><label>반려동물유무</label> <span
							class="radio-chk animal_layout"> <input type="radio"
								id="yes3" name="animalCheck" value="0" checked /> <label
								for="yes3">있음</label> <span id="ok_pet" style="display: none;">
									<input type="text" name="animalCount"
									style="width: 50px; height: 30px;" value="0">마리 <!--   <a href="../page/profile_pet.php" target="_blank"><span style="border:1px solid #FF94A8; color:#FF94A8; border-radius: 4px; padding: 4px; margin:0 40px 0 5px;">펫등록하러가기</span></a>-->
							</span> <input type="radio" id="no3" name="animalCheck" value="1" /> <label
								for="no3">없음</label>
						</span></li>
						<li><label style="font-size:68%">13세 이하 아이 유무</label> <span class="radio-chk">
								<input type="radio" id="yes4" name="child" value="0" checked />
								<label for="yes4">있음</label> <input type="radio" id="no4"
								name="child" value="1" /> <label for="no4">없음</label>
						</span></li>
						<li><label>감시카메라</label> <span class="radio-chk"> <input
								type="radio" id="yes5" name="camera" value="0" checked /> <label
								for="yes5">있음</label> <input type="radio" id="no5" name="camera"
								value="1" /> <label for="no5">없음</label>
						</span></li>
						<li><label for="distance" class="dise1">인근 동물병원 거리</label> <span><input
								type="text" id="distance" name="distance" value=""  style="width:25px;"/>분 거리</span></li>
						<li><label for="hospital" class="dise2">인근 동물병원 정보</label> <span>
								<input type="text" id="hospital" name="hospital"
								placeholder="이름" value="" style="width:100px;"/> <input style="width:100px" type="text"
								id="hospitalPhoneNumber" name="hospitalPhoneNumber" value=""
								placeholder="숫자만 가능" />
						</span></li>
						<li><label for="sitter" style="font-size:13px">1일 최대 위탁가능 수</label> <span><input
								style="width:25px" type="text" id="oneDayCount" name="oneDayCount" value="" />마리</span></li>
					</ul>
					<h4>입금 정보</h4>
					<ul class="bankInfo">
						<li class="dub"><label>계좌정보 입력 <br />
							<span>시터링 비용을 입금받을 계좌를 등록해주세요 (예금주와 펫시터 성함이 일치해야 합니다.) </span></label></li>
							 <li>
							 <select class="bankInfo"
							id="bank" name="bank" style="width:90px;">
								<option value='0' selected='selected'>은행선택</option>
								<option value='1'>NH은행</option>
								<option value='2'>국민은행</option>
								<option value='3'>우리은행</option>
								<option value='4'>신한은행</option>
								<option value='5'>하나은행</option>
								<option value='6'>기업은행</option>
								<option value='7'>SC은행</option>
								<option value='8'>씨티은행</option>
								<option value='9'>외환은행</option>
								<option value='10'>대구은행</option>
								<option value='11'>광주은행</option>
								<option value='12'>전북은행</option>
								<option value='13'>부산은행</option>
								<option value='14'>경남은행</option>
								<option value='15'>수협은행</option>
								<option value='16'>새마을금고</option>
						</select> <input type="text" placeholder="예금주명" id="bankName"
							name="bankName" value="" style="margin-left: 10px; width: 100px;" />
							<input type="text" placeholder="계좌번호" id="bankNumber"
							name="bankNumber" value=""
							style=" width: 288px;" /></li>
					</ul>
					<h4>펫시터 자격증</h4>
					<ul class="file-data">
                                <li>
                                    <h5 class="title">
                                        1) 관련학과 재학/휴학/졸업
                                    </h5>
                                    <div class="detail">
                                        <select title="선택해주세요" name="license1" onchange="selectCheck()">
                                            <option value='0' selected='selected'>- 선택 -</option><option value='1'>수의과</option><option value='2'>반려동물 관련학과</option><option value='3'>축산학과</option><option value='4'>야생동물학과</option><option value='5'>기타</option>                                        </select>
                                        <input type="text" name="licenseInfo1" placeholder="'학교명'과 '학과명'을 입력해주세요." value=""/>
                                    </div>
                                </li>
                                <li>
                                    <h5 class="title">
                                        2-1) 자격증 취득 정보
                                    </h5>
                                    <div class="detail">
                                        <select title="선택해주세요" name="license2">
                                            <option value='0' selected='selected'>- 선택 -</option><option value='1'>동물간호복지사</option><option value='2'>동물교감사</option><option value='3'>동물매개복지사</option><option value='4'>동물매개심리상담사</option><option value='5'>동물사육사</option><option value='6'>동물행동교정사</option><option value='7'>반려동물관리사</option><option value='8'>수의사</option><option value='9'>애견미용사 1/A급 이상</option><option value='10'>애견미용사 2/B급</option><option value='11'>애견미용사 3/C급</option><option value='12'>애견핸들러 1급 이상</option><option value='13'>애견핸들러 2급</option><option value='14'>애견핸들러 3급</option><option value='15'>애견훈련사 1급 이상</option><option value='16'>애견훈련사 2급</option><option value='17'>애견훈련사 3급</option><option value='18'>펫아로마상담사</option><option value='19'>펫케어상담사</option><option value='20'>기타</option>                                        </select>
                                        <input type="text" name="licenseInfo2" placeholder="'자격번호'를 입력해주세요." value=""/>
                                    </div>
                                </li>
                                <li>
                                    <h5 class="title">
                                        2-2) 자격증 취득 정보
                                    </h5>
                                    <div class="detail">
                                        <select title="선택해주세요" name="license3">
                                            <option value='0' selected='selected'>- 선택 -</option><option value='1'>동물간호복지사</option><option value='2'>동물교감사</option><option value='3'>동물매개복지사</option><option value='4'>동물매개심리상담사</option><option value='5'>동물사육사</option><option value='6'>동물행동교정사</option><option value='7'>반려동물관리사</option><option value='8'>수의사</option><option value='9'>애견미용사 1/A급 이상</option><option value='10'>애견미용사 2/B급</option><option value='11'>애견미용사 3/C급</option><option value='12'>애견핸들러 1급 이상</option><option value='13'>애견핸들러 2급</option><option value='14'>애견핸들러 3급</option><option value='15'>애견훈련사 1급 이상</option><option value='16'>애견훈련사 2급</option><option value='17'>애견훈련사 3급</option><option value='18'>펫아로마상담사</option><option value='19'>펫케어상담사</option><option value='20'>기타</option>                                        </select>
                                        <input type="text" name="licenseInfo3" placeholder="'자격번호'를 입력해주세요."  value=""/>
                                    </div>
                                </li>
                                <li>
                                    <h5 class="title">
                                        2-3) 자격증 취득 정보
                                    </h5>
                                    <div class="detail">
                                        <select title="선택해주세요" name="license4">
                                            <option value='0' selected='selected'>- 선택 -</option><option value='1'>동물간호복지사</option><option value='2'>동물교감사</option><option value='3'>동물매개복지사</option><option value='4'>동물매개심리상담사</option><option value='5'>동물사육사</option><option value='6'>동물행동교정사</option><option value='7'>반려동물관리사</option><option value='8'>수의사</option><option value='9'>애견미용사 1/A급 이상</option><option value='10'>애견미용사 2/B급</option><option value='11'>애견미용사 3/C급</option><option value='12'>애견핸들러 1급 이상</option><option value='13'>애견핸들러 2급</option><option value='14'>애견핸들러 3급</option><option value='15'>애견훈련사 1급 이상</option><option value='16'>애견훈련사 2급</option><option value='17'>애견훈련사 3급</option><option value='18'>펫아로마상담사</option><option value='19'>펫케어상담사</option><option value='20'>기타</option>                                        </select>
                                        <input type="text" name="licenseInfo4" placeholder="'자격번호'를 입력해주세요."  value=""/>
                                    </div>
                                </li>
                            </ul>
					
				</div>
			

			<h4>펫시터 활동 사진</h4>
			<ul class="info-list none address">
				<li class="dub"><label> 펫시터의 활동 사진을 등록해주세요. <br /> <span>
							이미지 확장자는 꼭 <span style="color: #FF4A63;">jpg</span>로만
							등록해주세요. (예시) image.jpg
					</span> <span>최적의 사이즈는 <span style="color: #FF4A63;">가로
								376px 세로 320px</span> 입니다.
					</span>
				</label>
				
						<div id="fileArea">
				<input type="file" id="petsitterImage1" name="petsitterImage1" 
							/> 
				<input type="file" id="petsitterImage2" name="petsitterImage2" 
							/> 
				<input type="file" id="petsitterImage3" name="petsitterImage3" 
							/> 
				<input type="file" id="petsitterImage4" name="petsitterImage4" 
							/> 
				</div>	
				<div class="btnArea" align="center">
			
			<button type="button" onclick="validate();">작성</button>
			<button type="button" onclick="cancel();">취소</button>
			
			</div>
			
					</li>
			</ul>
			</form>
		</div>
		
	</div>
	
	
</body>

</html>