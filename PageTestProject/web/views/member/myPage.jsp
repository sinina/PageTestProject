<%@page import="com.matajo.pitpet.patjoin.model.vo.PatVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberVo mv = (MemberVo) session.getAttribute("user");
	PatVo pv = (PatVo)request.getAttribute("su");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/join.css">
<style>
#container {
	min-height: 900px;
	padding-top: 52px;
	margin-top: 30px;
	margin-left: 80px;
	font-size: 150%;
	font-weight: bold;
	position: relative;
	width: 768px;
	min-width: 460px;
	margin: 0 auto;
}

#content {
	display: block;
}

.join_content {
	width: 500px;
	margin: auto;
}

form {
	margin: 0;
	padding: 0;
	display: block;
}

li {
	width: 500px;
	margin-left: auto;
	margin-right: auto;
	list-style: none;
	display: inline-block;
}

div.line {
	list-style: none;
	display: inline-block;
}

form {
	margin: 0;
	padding: 0;
}

#pat{
	text-align: center;
	width: 540px;
	margin-left: auto;
	margin-right: auto;
	background: #e52770;
}
#out{
	text-align: center;
	width: 540px;
	margin-left: auto;
	margin-right: auto;
	background: #f442f4;
}
#patinout{
	text-align: center;
	width: 540px;
	margin-left: auto;
	margin-right: auto;
	background: #e900ff;
}
#patin{
	text-align: center;
	width: 540px;
	margin-left: auto;
	margin-right: auto;
	background: #e900ff;
}
.jender {
	position: relative;
	z-index: 10;
	display: block;
	float: left;
	width: 49.8%;
	height: 31px;
	border-right: solid 1px #dcdcdc;
}

#age {
	display: inline-block;
	width: 60px;
}

#addr {
	display: inline-block;
	width: 100px;
}

#yy {
	margin-left: 30px;
}

#mm {
	margin-left: 60px;
	height: 50px;;
}

#dd {
	margin-left: 52px;
}

#styl {
	width: 500px;
	height: 30px;
	background: yellow;
}

#patIde {
	
}

#patId {
	
}

#cc {
	
}

#test {
	height: 40px;
	margin-left: 50px;
}

#ul {
	padding-left: 0;
}

#ul li {
	padding-left: 0;
}

div {
	margin-top: -3px;
}

#messageDiv, #passMessageDiv, #passCheckMessDiv, #NameMessageDiv,
	#phonemessDiv {
	height: auto;
}

.reverse {
	background: black;
}

#patName, #jenderCheck, #patPhone {
	margin-top: 0px;
}

#jenderCheck {
	padding-top: 15px;
	height: 70px;
}

#man+label:before {
	border-radius: 0%;
}

#woman+label:before {
	border-radius: 0%;
}
#patId, #patpassword, #patpasswordcheck, #patname, #man, #woman, #patphone, #patage, #yy, #mm, #dd, #sample6_postcode, #sample6_address, #sample6_address2{
	border-color: #00e870;
}
</style>
<!--정규표현식
	아이디 정규표현식
	<!--
	  var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
      if( !idReg.test( $("input[name=uid]").val() ) ) {
          alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
          return;
      }else{
    	  alert("Error");
      }
      
      -------------------------------------
      나이정규표현식
      /* //년 널값체크
     var birVal = $("#yy").val();
      if(birVal == ""){
		return false;
     }
//월 널값체크
     var mmVal = $("#mm").val();
     if(mmVal == ""){
		return false;
     }
//일 널값체크
     var ddVal = $("#dd").val();
     if(ddVal == ""){
		return false;
     } */
     -------------------------------------
     전화번호 정규표현식
     /* //전화번호 널값체크
     var patphoneVal = $("#patphone").val();
     if(patphoneVal==""){
		return false;
     } */
-->
<script>
<!--다음 우편번호api-->
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('sample6_address').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('sample6_address2').focus();
        }
    }).open();
}
 

/* $(function(){
	var pat = $("#patId");
	pat.focus(function(){
		//pat.val("포커스 얻음");
	});
	pat.blur(function(){
		//pat.val("포커스 잃음");
	});
	//$('input[name="sex"]').val();
});
 */
 $(function(){
	 
	 //라디오값 가져와서 넣어주기
	 $("input:radio").each(function(){
			if($(this).val()=='<%=mv.getGender() %>'){
				$(this).prop("checked", true);
			}
		});
	 
	 var addr = '<%=mv.getAddress()%>'.split(',');
		$("#sample6_postcode").val(addr[0]);
		$("#sample6_address").val(addr[1]);
		$("#sample6_address2").val(addr[2]);
		
	 $("#patId").change(function(){
			var inputId = $("#patId").val();
		 	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		 	var patIdVal = $("#patId").val();
		 	
		 	if (regExp.test(inputId)) {
		 	$.ajax({
				url : "/ptp/idCheck.do",
				type : "get",
				data : {userId : inputId},
				success : function(data){
					if(data ==1){
						$("#messageDiv").text("사용가능한 아이디입니다.");		
						$("#messageDiv").css("color", "green");
					}else{
						$("#messageDiv").text("아이디가 중복 됨");		
						$("#messageDiv").css("color", "red");			

			
					}
				},error : function(e){
					console.log(e);
				}
			});
		 	 }
});
	 
	 //수정하기 이벤트
	 $("#pat").hover(function(){
		$("#pat").css("background", "#20d63b"); 
		$("#pat").css("cursor","pointer" );
	 }, function(){
		 $("#pat").css("background", "#e52770");
	 });
	 
	 //탈퇴하기
	 $("#out").hover(function(){
			$("#out").css("background", "#eef442"); 
			$("#out").css("cursor","pointer" );
		 }, function(){
			 $("#out").css("background", "#f442f4");
		 });
	 //애완동물
	  $("#patinout").hover(function(){
			$("#patinout").css("background", "#ff3700"); 
			$("#patinout").css("cursor","pointer" );
		 }, function(){
			 $("#patinout").css("background", "#e900ff");
		 });
	 //애완동물 수정
	  $("#patin").hover(function(){
			$("#patin").css("background", "#ff3700"); 
			$("#patin").css("cursor","pointer" );
		 }, function(){
			 $("#patin").css("background", "#e900ff");
		 });
	 //비밀번호 정규표현식
	 $("#patpassword").change(function(){
		var pass = $("#patpassword").val();
 		//비밀번호 최소 8자, 대문자 하나 이상, 소문자 하나 및 숫자 하나입니다.
 		var req = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
		 if(req.test(pass)){
			 $("#passMessageDiv").text("사용가능한 비밀번호입니다.");
		 }else{
			 $("#passMessageDiv").text("비밀번호 최소 8자, 대문자 하나 이상, 소문자 하나 및 숫자 하나입니다.");			 
		 }
	 });
	 
	 //비밀번호 포커스
	 $("#patpassword").blur(function(){
		 var pass = $("#patpassword").val();
	 	 var req = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
	 	 if(req.test(pass)){
	 		$("#passMessageDiv").empty();
	 	 }else{
	 		$("#passMessageDiv").text("비밀번호가 입력되지 않았습니다.");
	 	 }
	 });
	 
	 //전화번호 포커스
	 $("#patphone").blur(function(){
		 var patphoneVal = $("#patphone").val();
		 var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	 	 if(regExp.test(patphoneVal)){
	 		$("#phonemessDiv").empty();
	 	 }else{
	 		$("#phonemessDiv").text("전화번호가 입력되지 않았습니다.");
	 	 }
	 });
	 
	 //이름 정규표현식
	 $("#patname").change(function(){
		 var Name = $("#patname").val();
		 var pattern = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
		 if(pattern.test(Name)){
			 $("#NameMessageDiv").text("사용가능한 이름입니다.");
		 }else{
			 $("#NameMessageDiv").text("한글은 2 ~ 4글자(공백 없음) , 영문은 Firstname(2 ~ 10글자) (space) Lastname(2 ~10글자)");			 
		 }
	 });
	 //이름 포커스
	 $("#patname").blur(function(){
		 var Name = $("#patname").val();
		 var pattern = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
		 if(pattern.test(Name)){
			 $("#NameMessageDiv").empty();
		 }else{
			 $("#NameMessageDiv").text("이름을 입력해주십시오.");			 
		 }
	 });
	 //비밀번호 일치여부 포커스
	 $("#patpasswordcheck").blur(function(){
		 if($("#patpassword").val() != $("#patpasswordcheck").val()){
				$("#passCheckMessDiv").text("입력하신 비밀번호가 일치하지 않습니다.");
				return false;
			}else{
				$("#passCheckMessDiv").empty();		
			}
	});
	 //전화번호 정규표현식
	 $("#patphone").change(function(){
		 var patphoneVal = $("#patphone").val();
		 var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	 	 if(regExp.test(patphoneVal)){
	 		$("#phonemessDiv").text("잘 입력했습니다.");
	 	 }else{
	 		$("#phonemessDiv").text("잘못된 휴대폰 번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.");
	 	 }
	 });
 });
 
 function validate(){

	 //아이디 널값체크
	 var patIdVal = $.trim($("#patId").val());
	  if(patIdVal == "" || null == patIdVal){
		  alert("아이디를 입력해주십시오.");
		  $("#messageDiv").text("아이디를 입력해주십시오");
		  return false;
	  }
	//아이디 정규표현 리턴확인
	 var inputId = $("#patId").val();
	 var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	 var idMessage = $("#messageDiv").text();
	 if (!regExp.test(inputId)||idMessage=="아이디가 중복 됨") {
		 return false;
		 }
	 
//아이디 정규표현식
 	 /*  var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	  if (!regExp.test(patIdVal)) {
		return false;
	  } */
	  
 //비밀번호 널값 체크
	 
 	var patpassword = $("#patpassword").val();
 	if(patpassword=""){
 		patpassword.focus();
 		return false;
 	}
//비밀번호 일치여부
 	if($("#patpassword").val() != $("#patpasswordcheck").val()){
		$("#patpasswordcheck").focus();
		return false;
	}
//이름 널값체크
     var patnameVal = $("#patname").val();
     if(patnameVal==""){
    	 alert("이름을 입력해주세요.");
    	 patnameVal.focus();
		return false;
     }

//우편번호 널값체크
     var sample6_postcodeVal = $("#sample6_postcode").val();
     if(sample6_postcodeVal==""){
    	 alert("우편번호를 입력해주세요.");
    	 sample6_postcodeVal.focus();
		return false;
     }
//상세주소 널값체크
     var sample6_address2Val = $("#sample6_address2").val();
     if(sample6_address2Val==""){
    	 alert("상세주소를 입력해주세요.");
    	 sample6_address2Val.focus();
		return false;
     }
	return true;
} 

 function pat(){
	  $("#MemberUpdateForm").submit();
} 
 function out(){
	location.href = "/ptp/memberDelete.do?userId=<%=mv.getId()%>";
 }
 function patinout(){
	 location.href = "views/member/patjoin.jsp";
 }
 function patin(){
	 location.href = "/ptp/patjoinsu.do?userId=<%=mv.getId()%>";
 }

</script>
</head>
<body>
	<!-- Header -->
	<%@include file="../common/header.jsp"%>
	<div id="container">
		<div id="content">
			<div class="join_content">
				<div class="join_form">
					<form id="MemberUpdateForm" method="post" action="/ptp/MemberUpdate.do"
						onsubmit="return validate();">
						<div id="ul">
							<div class="ide">
								<div id="patIde">
									<input type="text" id="patId" name="uid" placeholder="아이디"
										readonly  value="<%=mv.getId()%>"/>
								</div>
								<div id="messageDiv"></div>
							</div>

							<div>
								<div id="pass">
									<input type="password" name="upass" maxlength="10"
										id="patpassword" placeholder="비밀번호" />
								</div>
								<div id="passMessageDiv"></div>
							</div>

							<div>
								<div id="passCheck">
									<input type="password" name="upassCheck" maxlength="10"
										id="patpasswordcheck" placeholder="비밀번호 확인" />
								</div>
								<div id="passCheckMessDiv"></div>
								<br>
							</div>

							<div>
								<div id="patName">
									<input type="text" maxlength="15" name="patName" id="patname"
										placeholder="이름" value="<%=mv.getName()%>"/>
								</div>
								<div id="NameMessageDiv"></div>
							</div>
							<div>
								<div id="jenderCheck">
									<span class="jender"> <input type="radio" id="man"
										<%=mv.getGender() == 'M'?"checked":"" %> readonly name="sex" value="0"><label
										id="manLb" for="man">남자 </label>
									</span> <span class="jender"> <input type="radio" id="woman"
										readonly name="sex" value="1" <%=mv.getGender() == 'F'?"checked":"" %>> <label id="womanLb"
										for="woman">여자 </label>
									</span>
								</div>
							</div>
							<div>
								<div id="patPhone">
									<input type="text" maxlength="13" name="patPhone" id="patphone"
										placeholder="전화번호" value="<%=mv.getPhone()%>"/>
								</div>
								<div id="phonemessDiv"></div>
								<br>
							</div>

							<div id="age" class="line">
								<input type="text" id="patage" name="patAge" placeholder="나이"
									readonly />
							</div>
							<div class="line">
								<input type="text" id="yy" name="yy" maxlength="4" value="<%=mv.getAge() %>" readonly>
							</div><br>
							
							<div id="addr">
								<input type="text" id="sample6_postcode" name="sample6_postcode"
									placeholder="우편번호">
							</div>
							<div id="addr cc">
								<input type="button" onclick="sample6_execDaumPostcode();"
									value="우편번호 찾기">
							</div>
							<div>
								<input type="text" id="sample6_address" name="sample6_address"
									placeholder="주소">
							</div>
							<div>
								<input type="text" id="sample6_address2" name="sample6_address2"
									placeholder="상세주소">
							</div>
						</div>
						<br>
						<div id="pat" onclick="pat();">수정</div>
						<div id="out" onclick="out();">탈퇴</div>
						<div id="patinout" onclick="patinout();">애완동물 관리</div>
						<%if(pv!= null){ %>
						<div id="patin" onclick="patin();">애완동물 수정</div>
						<%} %>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@include file="../common/footer.jsp"%>
</body>
</html>