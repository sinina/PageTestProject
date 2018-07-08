<%@page import="com.matajo.pitpet.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%MemberVo mv = (MemberVo)request.getAttribute("mv"); %>
<%int selectNo = (int)request.getAttribute("selectNo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>회원수정 관리</title>
<style>
	
	body label{
		font-size:70%;
		display:inline-block;
		width: 120px;
		
	}
	html .inner{
		width:800px;
		margin-left: auto;
		margin-right: auto;
		overflow: hidden;
	}
	body input[type="text"],input[type="password"]{
		border : 1px solid black;
		display:inline-block;
		width:auto;
		font-size: 30px;
	}
	.wrap{
	font-size: 30px;
	}
	
</style>
</head>
<body>
<%@ include file="/views/admin/adminHeader.jsp" %>
<div id="page" class="container">
<h1 align="center"><%=mv.getName() %>회원님 정보</h1><br>
<div class="wrap">
	<form id="updateForm" method="post" action="/ptp/updateMemberInfo.do" 
	 align="center">
		<div id="ul">
		<div class="ide">
		<div id="patIde">
			<input type="text" id="patId" name="uid" value=<%=mv.getId() %> />
			<input type="hidden" id="patNo" name="uNo" value=<%=mv.getNo() %>>
			<input type="hidden" name="selectNo" value=<%=selectNo %>>
		</div>
								<div id="messageDiv"></div>
							</div>

							<div>
								<div id="pass">
									<input type="password" name="upass" maxlength="10"
										id="patpassword" value=<%=mv.getPwd() %>/> 
								</div>
								<div id="passMessageDiv"></div>
							</div>

							<div>
								<div id="passCheckMessDiv"></div>
								<br>
							</div>

							<div>
								<div id="patName">
									<input type="text" maxlength="15" name="patName" id="patname"
										value=<%=mv.getName() %> />
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
										value=<%=mv.getPhone() %> />
								</div>
								<div id="phonemessDiv"></div>
								<br>
							</div>
							<div id="age" class="line">
								<input type="text" id="patage" name="patAge" value=<%=mv.getAge() %>
								 />
							</div>
							<div id="addr">
								<input type="text" id="sample6_postcode" name="sample6_postcode"
									/>
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
							<button class="modify">수정</button>
							<button class="cancel">취소</button>
					</form>
					</div>
</body>
<script>
	$(".cancel").click(function(){
		location.href="/ptp/pmemberList.do";
	})
	
	$(".modify").click(function(){
		$("#updateForm").submit();
	})
	
	
	$(function(){
		
	 $("input:radio").each(function(){
			if($(this).val()=='<%=mv.getGender() %>'){
				$(this).prop("checked", true);
			}
		});
	 
	 var addr = '<%=mv.getAddress()%>'.split(',');
		$("#sample6_postcode").val(addr[0]);
		$("#sample6_address").val(addr[1]);
		$("#sample6_address2").val(addr[2]);
		
	})
</script>
</html>