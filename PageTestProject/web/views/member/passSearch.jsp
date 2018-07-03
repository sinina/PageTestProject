<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 html h4{
	color:black;
	border-bottom: 1px solid skyblue;	
	}
	html h5 ,html label{
	color:black;
	}
	 body .inner{
		width:800px;
		margin-left: auto;
		margin-right: auto;
		line-height: 2em;
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
	
	
	.wrap {
    border: 2px solid skyblue;
    border-radius: 20px;
    width: 900px;
    margin-right: auto;
    margin-left: auto;
    } 

  .idsearchInner {
  	width:200px;
  }
  .idsearchInner btn {
  	width:150px;
  }
   .idsearchInner  {
  	width:150px;
  }
</style>
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

<div class="wrap">
<div id="head"><h4>비밀번호 찾기</h4></div>
	<div class="inner">	
	<div class="idsearch">
	<div class="idsearchInner">
		<div>아이디 찾기</div>  
		<div style="float:left;">이름 :</div><div style="width:600px; float:right;"><input type="text" name="idSearch" id="idSearch"></div>
	</div>	
	<div class="idsearchInner"><button type="button" id="idSearchBtn">아이디 찾기</button></div>
	</div>
	
	<div id="idDiv"></div>
	비밀번호 찾기<br>
	아이디:<input type="text" name="emailSearch" id="edamilSearch">
	<div id="passDiv"></div>
	비밀번호를 받을 이메일 <input type="text" name="reciveEmail" id="reciveEmail">
	<button type="button" id="passSearchbtn"  disabled='disabled'>비밀번호 찾기</button>
	
	</div>
	</div>
</body>
</html>