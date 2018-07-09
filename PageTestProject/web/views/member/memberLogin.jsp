<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String flag =String.valueOf(request.getAttribute("flag")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맡아줘 로그인</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css?ver=1">
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script>
	
		
		$(function(){	
			var text = localStorage.getItem('id');
			
			if(text!=null){
				$("#txtMEM_EMAIL").val(text);
				$("#checkbox").attr("checked", true);
			}
			var localFlag=false;
			
			$("#checkbox").change(function(){
				if($(this).prop("checked")){
					if(null != localStorage){
						localFlag=true;
					}else{
						alert("아이디를 저장할수 없는 브라우저 입니다. 다른 브라우저를 사용하여 주세요");
					}
				}
			});		
			
			
			$("#btnLOGIN").click(function() {
				 if(localFlag){
					var key = 'id';
					var value = $("#txtMEM_EMAIL").val();
					localStorage.setItem(key, value);
				}else{
					localStorage.clear();
				}
				$("#loginForm").submit(); 
			});
			
			$(".form-pwd").keypress(function(e){
				if(e.which == 13){
					if(localFlag){
						var key = 'id';
						var value = $("#txtMEM_EMAIL").val();
						localStorage.setItem(key, value);
					}else{
						localStorage.clear();
					}
					$("#loginForm").submit();
				}
			});

		});
	</script>
</head>
<body>
	
 <div class="login-wrap">
            <div class="logo"><a href="<%=request.getContextPath()%>/"><img src="<%=request.getContextPath()%>/images/common/matajo_logo.png" alt="Matajo"/></a></div>
            <div class="form-wrap">
                <div class="login-thum">
                <p>더이상<br />반려동물을<br />외롭게<br />하지마세요</p><img src="<%=request.getContextPath()%>/images/common/login_img1.jpg" />                </div>
                <div class="login-form">
                	<%if(flag.equals("false")){%><p class="false-user"  style="color: red; text-align:center;">아이디와 비밀번호를 확인해 주세요</p><%}%>
                    <form action="<%=request.getContextPath() %>/login.do" method="post" id="loginForm">
                        <input class="form-control form-mail" type="text" name="userId" placeholder="이메일" id="txtMEM_EMAIL" value="">
                        <input class="form-control form-pwd" type="password" name="userPwd" placeholder="비밀번호" id="txtMEM_PASS">

                        <input class="checkbox" type="checkbox" name="chkEMAIL_SAVE" id="checkbox"/><label for="checkbox">이메일저장</label>
                        <span class="forgot-pwd"><a href="<%=request.getContextPath()%>/views/member/passSearch.jsp">비밀번호 찾기</a></span>
                        <button class="btn-dogmate btn-orange login-btn" type="button" name="" id="btnLOGIN"><label>로그인</label></button>
                        <p class="form-caption">아직도 MATAJO 계정이 없으세요? <a href="<%=request.getContextPath()%>/views/member/join.jsp">가입하기</a></p>
                    </form>
                </div>
            </div>
        </div>
	
</body>
</html>