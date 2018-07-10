<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MATAZO</title>
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
  .pass{
	border-bottom:1px solid skyblue;
	margin-top:30px;
  }
  .pass1{
	float:left;
	line-height:2em;
	padding-top:23px;
  }
  .pp{
	width:300px;
	padding:25px;
	display:inline-block;
  }
  #edamilSearch{
	width:200px;
  }
.pass2{
	float:left;
	padding-top:23px;
}
.pp2{
	width:300px;
	float:left;
	line-height:2em;
	padding-top:25px;
}
#reciveEmail{
	width:200px;
}
.Btn{
	padding-left:400px;
	padding-bottom:100px;
}
#passSearchbtn{
	width:170px;
	height:auto;
}
.pa, .pb, .pc{
	width:100%;
}
</style>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<script>
$(function(){
});
function pat(){
	
			var inputpass = $("#edamilSearch").val();
			var req = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
		 	var patIdVal = $("#edamilSearch").val();
		 	if (req.test(inputpass)) {
		 	$.ajax({
				url : "/ptp/pwssCheck.do",
				type : "post",
				data : {userPwd : inputpass},
				success : function(data){
					if(data ==1){
						alert("비밀번호가 일치하지 않습니다.");
					}else{
						location.href = "views/member/myPage.jsp";
					}
				},error : function(e){
					console.log(e);
				}
			});
		 	 }else{
		 		 alert("비밀번호를 확인해주십시오.");
		 	 }
	
}
</script>
</head>
<body>
<div class="wrap">
<div id="head"><h4>비밀번호 확인</h4></div>
	<div class="inner">	
	<div class="idsearch">
	<div class="idsearchInner" style="width:100%;">	
	<div class="pa">
			<div  class="pc">
					<div class="pass">원래 비밀번호</div>  
					<div class="pass1">비밀번호 : </div>
					<div class="pp"><input type="password" name="emailSearch" id="edamilSearch">
					<button onclick="pat();" type="button" id="passSearchbtn">확인</button></div>		
			</div>
			</div>
			</div>
			</div> 
	</div>
	</div>
</body>
</html>