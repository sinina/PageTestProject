<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://cdn.emailjs.com/sdk/2.2.4/email.min.js"></script>
<script type="text/javascript">
$(function(){
	var emailFlag=false;
	var tempPass="";
	var id = "";
	$("#idSearchBtn").on('click',function(){
		var name = $("#idSearch").val();
		$.ajax({
			url : "/ptp/nameCheck.do",
			type : "post",
			data : {userName : name},
			success : function(data){
				$("#idDiv").text(data);
			},error : function(e){
				console.log(e);
			}
		});
	});
	
	
	$("#edamilSearch").change(function(){
		var email = $("#edamilSearch").val();
	 	$.ajax({
			url : "/ptp/emailCheck.do",
			type : "post",
			data : {userEmail : email},
			dataType: "json",
			success : function(data){
				emailFlag=data.flag;
				tempPass=data.temppass;
				if(data.flag){
					id=email;
					$('#passSearchbtn').attr('disabled', false);
					$("#passDiv").text("");
				}else{
					$("#passDiv").text("아이디가 존재하지 않습니다. 다시 확인해 주세요");
					$('#passSearchbtn').attr('disabled', true);
				}
			},error : function(e){
				console.log(e);
			}
		});
	});
	
	
	$("#passSearchbtn").on('click',function(){
		 $reciveEmail = $("#reciveEmail");
    	 var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; 
    	 
    	  if($reciveEmail.val()==""|| !regExp.test( $reciveEmail.val() )){
    		alert("이메일 형식을 확인해 주세요");
    		$("#reciveEmail").focus();
    		return;
    	 }  
    
    	var emailC = {
    	reply_to : $reciveEmail,
        from_name : '안녕하세요 맡아조 입니다. 임시 비밀번호를 드립니다.',
        message_html:tempPass
     	}
   		emailjs.init("user_oFrhOPhXO8mSn9CnoAHXW");
   		emailjs.send("testgamil","template_85Caxus3",emailC)
   		.then(function(response) {
        console.log("SUCCESS. status=%d, text=%s", response.status, response.text);
     	}, function(err) {
        console.log("FAILED. error=", err);
 		});  
   		console.log("메일 보냄");
   		
   		
   		setTimeout(function() {
   			location.href="/ptp/passUpdate.do?tempPass="+tempPass+"&id="+id;
   		}, 3000);
    	
	});
	  
    	
	  
});

</script>


</head>
<body>
	<%@include file="../common/header.jsp" %>
	아이디 찾기<br>  
	이름 :<input type="text" name="idSearch" id="idSearch">
	<button type="button" id="idSearchBtn">아이디 찾기</button><br>
	<div id="idDiv"></div>
	비밀번호 찾기<br>
	아이디:<input type="text" name="emailSearch" id="edamilSearch">
	<div id="passDiv"></div>
	비밀번호를 받을 이메일 <input type="text" name="reciveEmail" id="reciveEmail">
	<button type="button" id="passSearchbtn"  disabled='disabled'>비밀번호 찾기</button>
	
</body>
</html>