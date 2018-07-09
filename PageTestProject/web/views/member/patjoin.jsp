<%@page import="com.matajo.pitpet.member.model.vo.MemberVo"%>
<%@page import="com.matajo.pitpet.patjoin.model.vo.PatVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		PatVo pv = (PatVo)request.getAttribute("pat");
		MemberVo user = (MemberVo)session.getAttribute("user");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반려동물 정보</title>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<style>
img.bg {
  /* Set rules to fill background */
  min-height: 100%;
  min-width: 1024px;
	
  /* Set up proportionate scaling */
  width: 100%;
  height: auto;
	
  /* Set up positioning */
  position: fixed;
  top: 0;
  left: 0;
}

@media screen and (max-width: 1024px) { /* Specific to this particular image */
  img.bg {
    left: 50%;
    margin-left: -512px;   /* 50% */
  }
}
#img{
		background:url("/ptp/images/image.jpg") no-repeat;
		background-size:cover;
	}
table.type08 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	border-left: 1px solid #ccc;
	margin: 20px 10px;
}

table.type08 thead th {
	padding: 10px;
	font-weight: bold;
	border-top: 1px solid #ccc;
	border-right: 1px solid #ccc;
	border-bottom: 2px solid #c00;
	background: #dcdcd1;
}

table.type08 tbody th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	background: #ececec;
}

table.type08 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

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
	border: 3px solid skyblue;
	border-radius: 20px;
	width: auto;
	height: 1000px;
	margin-left: 150px;
}

form {
	margin: 0;
	padding: 0;
	display: block;
}
.image {
	width: 200px;
}
h1{
	text-align:center;
}
td{
	border-radius: 20px;
}
.kg{
	width:250px;
}
textarea{
	width:500px;
	height:100px;
}
#pat {
	text-align: center;
	width: 613px;
	margin-left: auto;
	margin-right: auto;
	background: #e52770;
}
</style>
<script>
$(function(){
	//가입하기 이벤트
	$("#pat").hover(function(){
		$("#pat").css("background", "#20d63b"); 
		$("#pat").css("cursor","pointer" );
	}, function(){
		 $("#pat").css("background", "#e52770");
	});
	var i = 1;
	setInterval(function(){
		//background:url("/ptp/images/image.jpg") no-repeat;
		i %= 10;
		$("#img").css("background", "url('/ptp/images/img"+i+".jpg') no-repeat");
		$("#img").css("background-size", "cover");
		i++;
	}, 5000);
});
function pat(){
	$.ajax({
		url : "/ptp/patCheck.do",
		type : "get",
		data : {userId : '<%=user.getId()%>'},
		success : function(data){
			console.log(data);
			 if(data < 10){
				 $("#patjoinForm").submit();
			}else{
				alert("애완동물 10개까지가 최대입니다.");
			} 
		},error : function(e){
		}
	}); 
	 
} 
function validate(){
	if($("#attfile").val()==""){
		alert("이미지를 넣어주세요.");
		return false;
	}
	if($("#1").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#2").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#3").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#4").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#5").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#6").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#7").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	
	return true;
}

function setImage(obj){
	if(obj.files && obj.files[0]){
		var reader = new FileReader();
		reader.onload=function(e){
				$("#petImage").attr("src",e.target.result);

		}
		reader.readAsDataURL(obj.files[0]);
	}
}
</script>
</head>
<body>
<div id="img">
	<h1>반려동물 정보</h1>
	<div id="container">
		<div id="content">
			<form id="patjoinForm" method="post" action="/ptp/patjoin.do" enctype="multipart/form-data" onsubmit="return validate();">
				<table class="type08">
					<tr>
						<td rowspan="2" class="image">
							<input type="file" id="attfile" name="attfile" value="사진 등록" onchange="setImage(this);"/>
							<img id="petImage" src="/ptp/images/pic01.png" width="220" height="100"/>
						</td>
						<td>이름 : <input type="text" name="patname" maxlength="10" id="1"/></td>
					</tr>
					<tr>
						<td>나이<input type="text" name="age" id="2" placeholder="나이 입력" maxlength="2"/></td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="kg">무게<input type="text" id="3" name="kg" maxlength="2"/></td>
						<td>성별<select name="jender">
								<option selected value="0">암컷</option>
								<option value="1">수컷</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>애완동물 종류<select name="kind">
						<option selected value="강아지">강아지</option>
						<option value="고양이">고양이</option>
						<option value="그외">그외</option>
						</select></td>
					</tr>
					<tr>
						<td>종류<input name="kind_of" type="text" id="4" placeholder="견종, 묘종등 입력해주세요" maxlength="500"/></td>
					</tr>
					<tr>
						<td>중성화 수술 여부<select name="asd">
								<option value="1">했습니다</option>
								<option selected value="0">안했습니다</option>
						</select></td>
					</tr>
					<tr>
						<td>우리 애완동물 소개<textarea maxlength="500" id="5" name="we" style="background-color:transparent;" cols=40 rows=5 onclick="this.value=''">예) 반려동물의 짖음, 낯선사람 경계정도 등 알려주세요.</textarea>
					</tr>
					<tr>
						<td>특이사항<textarea maxlength="500" name="ae" id="6" style="background-color:transparent;" cols=40 rows=5 onclick="this.value=''">내용을 입력하세요</textarea></td>
					</tr>
					<tr><td>자주 다니는 동물병원<input type="text" name="hospital" id="7" maxlength="10"/></td></tr>
				</table>
				<br>
				<br>
				<br>
				<br>
				<br>
				
				<div id="pat" onclick="pat();">등록하기</div>
				</form>
		</div>
	</div>
	</div>
</body>
</html>