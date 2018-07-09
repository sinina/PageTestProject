<%@page import="com.matajo.pitpet.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%MemberVo mv = (MemberVo)request.getAttribute("mv"); %>
<%int selectNo = (int)request.getAttribute("selectNo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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
		margin:5px;
	}
	body label{
		font-size:25px;
	}
	.button{
		font-family: Arial, sans-serif;
    font-weight: bold;
    font-size: 20px;
     color: black;
    box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
	bezier(0.390, 0.500, 0.150, 1.360);
    display: block;
    margin: 10px auto;
    max-width: 50px;
    text-decoration: none;
    border-radius: 4px;
    padding: 20px 30px;
	}
	.button:hover{
	color: rgba(255, 255, 255, 0.85);
	cursor:pointer;
    box-shadow: #747474 0 0px 0px 40px inset;
	}
</style>

</head>
<body>
<%@ include file="/views/admin/adminHeader.jsp" %>
<div id="page" class="container">
<h1 align="center"><%=mv.getName() %>회원님 정보</h1><br>
<div >
	<form id="updateForm" method="post" action="/ptp/updateMemberInfo.do" 
	 align="center">
		<div id="ul">
		<div class="ide">
		<div id="patIde">
			<label>아이디</label><input type="text" id="patId" name="uid" value=<%=mv.getId() %> />
			<input type="hidden" id="patNo" name="uNo" value=<%=mv.getNo() %>>
			<input type="hidden" name="selectNo" value=<%=selectNo %>>
		</div>
							</div>

							<div>
								<div id="pass">
									<label>비밀번호</label><input type="password" name="upass" maxlength="10"
										id="patpassword" value=<%=mv.getPwd() %>/> 
								</div>
								<div id="passMessageDiv"></div>
							</div>


							<div>
								<div id="patName">
									<label>이름</label><input type="text" maxlength="15" name="patName" id="patname"
										value=<%=mv.getName() %> />
								</div>
								<div id="NameMessageDiv"></div>
							</div>
							<div>
								
								<div id="jenderCheck">
								<label>성별</label>
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
									<label>핸드폰</label><input type="text" maxlength="13" name="patPhone" id="patphone"
										value=<%=mv.getPhone() %> />
								</div>
								<div id="phonemessDiv"></div>
								<br>
							</div>
							<div id="age" class="line">
								<label>나이</label><input type="text" id="patage" name="patAge" value=<%=mv.getAge() %>
								 />
							</div>
							<div id="addr">
								<label>우편번호</label><input type="text" id="sample6_postcode" name="sample6_postcode"
									/>
							</div>
							<div id="addr cc">
								<input type="button" onclick="sample6_execDaumPostcode();"
									value="우편번호 찾기">
							</div>
							<div>
								<label>주소</label><input type="text" id="sample6_address" name="sample6_address"
									placeholder="주소">
							</div>
							<div>
								<label>상세주소</label><input type="text" id="sample6_address2" name="sample6_address2"
									placeholder="상세주소">
							</div>
						</div>
						<br>
						<div class="wrap">
							<div class="button" id="modify">수정</div>
							<div class="button "id="cancel">취소</div>
						</div>
					</form>
					</div>
</body>
<script>
	$("#cancel").click(function(){
		location.href="/ptp/pmemberList.do";
	})
	
	$("#modify").click(function(){
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
</script>
</html>