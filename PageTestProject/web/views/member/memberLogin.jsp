<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맡아줘 로그인</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
</head>
<body>
	
 <div class="login-wrap">
            <div class="logo"><a href="<%=request.getContextPath()%>/"><img src="../../images/common/matajo_logo.png" alt="Matajo"/></a></div>
            <div class="form-wrap">
                <div class="login-thum">
                <p>더이상<br />반려동물을<br />외롭게<br />하지마세요</p><img src="../../images/common/login_img1.jpg" />                </div>
                <div class="login-form">
                    <form>
                        <input class="form-control form-mail" type="text" name="" placeholder="이메일" id="txtMEM_EMAIL" value="">
                        <input class="form-control form-pwd" type="password" name="" placeholder="비밀번호" id="txtMEM_PASS">

                        <input class="checkbox" type="checkbox" name="chkEMAIL_SAVE" id="checkbox"/><label for="checkbox">이메일저장</label>
                        <span class="forgot-pwd"><a href="/forgotpwd/">비밀번호 찾기</a></span>
                        <button class="btn-dogmate btn-orange login-btn" type="button" name="" id="btnLOGIN"><label>로그인</label></button>
                        <p class="form-caption">아직도 도그메이트 계정이 없으세요? <a href="/signup/signup">가입하기</a></p>
                    </form>
                </div>
            </div>
        </div>
	
</body>
</html>