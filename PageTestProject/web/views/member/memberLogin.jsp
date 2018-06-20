<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/main.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/join.css">
<style>
.logo {
	width: 175px;
	margin-bottom: 25px;
}

.login-wrapper {
	width: 700px;
	margin-left: auto;
	margin-right: auto;
	padding-top:200px;
}

.login-thum {
	width: 399px;
	height: 398px;
	float: right;
	/*background-image: url(../img/login/login_img.png);
	background-image: url(../img/login/login_img_ie8.png)\9;*/
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;
}

.login-thum p {
	position: absolute;
	top: 50%;
	margin: -4em 0 0 30px !important;
	color: #ffffff;
	font-size: 200%;
	line-height: 200%;
	text-shadow: #666666 1px 1px 3px;
	-ms-filter:
		"progid:DXImageTransform.Microsoft.DropShadow(color=#666666,offx=1,offy=1)";
	display: block;
}

.login-form {
	width: 399px;
	height: 398px;
	display: table-cell;
	vertical-align: middle;
	padding-top: 30px;
	background: rgb(255,255,204);

}

.login-form form {
	padding: 0 30px;
}

.forgot-pwd a {
	font-weight: bold;
	float: right;
	margin-right: 10px;
}

.login-form .btn-dogmate {
	margin: 20px 0 !important;
}

.login-form form p {
	text-align: center;
}

form .form-control {
	width:100%;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	height: 45px;
	padding:0 35px 0 10px;
	text-align: left;
	margin:20px;
	margin-left:auto;
	margin-right:auto;
}
</style>
</head>
<body>
	<%-- <%@include file="../common/header.jsp" %> --%>
	<div class="login-wrapper" align="center">
		<div class="login-form">
			<form id="loginForm" action="/mwp/login.do" method="post">
				<input class="form-control form-mail" type="text" name=""
					placeholder="이메일" id="txtMEM_EMAIL" value=""> <input
					class="form-control form-pwd" type="password" name=""
					placeholder="비밀번호" id="txtMEM_PASS"><br> <input
					class="checkbox" type="checkbox" name="chkEMAIL_SAVE" id="checkbox" /><label
					for="checkbox">이메일저장</label> <span class="forgot-pwd"><a
					href="/forgotpwd/">비밀번호 찾기</a></span>
				<button class="btn-dogmate login-btn" type="button" name=""
					id="btnLOGIN">
					<label>로그인</label>
				</button>
				<p class="form-caption">
					아직도 계정이 없으세요? <a
						href="<%=request.getContextPath()%>/views/member/join.jsp">가입하기</a>
				</p>
			</form>
			<!--현재 작업 영역  -->
			<div class="login-tume">
				<img class="image">
			</div>
		</div>
	</div>

	<%-- 	<!-- Footer -->
			<%@include file="../common/footer.jsp" %> --%>
</body>
</html>