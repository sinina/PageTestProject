<%@page import="com.matajo.pitpet.member.model.vo.MemberVo"%>
<%@page import="com.matajo.pitpet.patjoin.model.vo.PatVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		PatVo pv = (PatVo)request.getAttribute("pat");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반려동물 정보</title>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<style>
body{
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
	border: 3px solid #00ff43;
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
#pat, #pat2 {
	text-align: center;
	width: 613px;
	margin-left: auto;
	margin-right: auto;
	background: #e52770;
}
</style>
<script>
$(function(){

	//수정하기 이벤트
	$("#pat").hover(function(){
		$("#pat").css("background", "#20d63b"); 
		$("#pat").css("cursor","pointer" );
	}, function(){
		 $("#pat").css("background", "#e52770");
	});
	$("#pat2").hover(function(){
		$("#pat2").css("background", "#20d63b"); 
		$("#pat2").css("cursor","pointer" );
	}, function(){
		 $("#pat2").css("background", "#e52770");
	});
});

function pat(){
	  $("#patjoinForm").submit();
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
function patearlse(){
	location.href = "/ptp/patearlse.do?userId=<%=pv.getNo()%>";
 }
</script>
</head>
<body>
	<h1>반려동물 정보</h1>
	<div id="container">
		<div id="content">
			<form id="patjoinForm" method="post" action="/ptp/patpage.do" enctype="multipart/form-data" onsubmit="return validate();">
				<table class="type08">
					<tr>
						<td rowspan="2" class="image">
							<input type="file" value="사진 등록" onchange="setImage(this);"/>
							<img id="petImage" src="/ptp/PatImage/<%=pv.getPatImage() %>" width="220" height="100"/>
						</td>
						<td>이름 : <input type="text" name="patname" maxlength="10" id="1" value="<%=pv.getPatName()%>"/></td>
					</tr>
					<tr>
						<td>나이<input type="text" name="age" id="2" placeholder="나이 입력" maxlength="2" value="<%=pv.getPatage()%>"/></td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="kg">무게<input type="text" id="3" name="kg" maxlength="2" value="<%=pv.getPatkg()%>"/></td>
						<td>성별<select name="jender">
								<option selected value="0" <%=pv.getPatgender()=='F'?"selected":"" %>>암컷</option>
								<option value="1" <%=pv.getPatgender()=='M'?"selected":"" %>>수컷</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>반려동물 종류<select name="kind">
						<option selected value="강아지" <%=pv.getKinds()=="강아지"?"selected":"" %>>강아지</option>
						<option value="고양이" <%=pv.getKinds()=="고양이"?"selected":"" %>>고양이</option>
						<option value="그외"<%=pv.getKinds()=="그외"?"selected":"" %>>그외</option>
						</select></td>
					</tr>
					<tr>
						<td>종류<input name="kind_of" type="text" id="4" placeholder="견종, 묘종등 입력해주세요" maxlength="500" value="<%=pv.getKinds_of()%>"/></td>
					</tr>
					<tr>
						<td>중성화 수술 여부<select name="asd">
								<option value="1" <%=pv.getOperation()=='Y'?"selected":"" %>>했습니다</option>
								<option selected value="0"<%=pv.getOperation()=='N'?"selected":"" %>>안했습니다</option>
						</select></td>
					</tr>
					<tr>
						<td>우리 애완동물 소개<textarea maxlength="500" id="5" name="we" style="background-color:transparent;" cols=40 rows=5 onclick="this.value=''"><%=pv.getPatInfo()%></textarea>
					</tr>
					<tr>
						<td>특이사항<textarea maxlength="500" name="ae" id="6" style="background-color:transparent;" cols=40 rows=5 onclick="this.value=''"><%=pv.getUniquness() %></textarea></td>
					</tr>
					<tr><td>자주 다니는 동물병원<input type="text" value="<%=pv.getHospital() %>" name="hospital" id="7" maxlength="10"/></td></tr>
				</table>
				<br>
				<br>
				<br>
				<br>
				<br>
				<div id="pat" onclick="pat();">수정하기</div>
				<div id="pat2" onclick="patearlse();">지우기</div>
				</form>
		</div>
	</div>
</body>
</html>