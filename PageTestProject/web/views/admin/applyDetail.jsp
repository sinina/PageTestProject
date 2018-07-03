<%@page import="com.matajo.pitpet.petapply.model.vo.PetsitterApplyVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<%PetsitterApplyVo apply = (PetsitterApplyVo)request.getAttribute("apply");%>
<title>펫시터 신청서 상세보기</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
</head>
<body>
<div class="inner">
	<form id= "petsitterProfile" action="/ptp/petsitterjoin.do"method="post">
		<div>
		<h4>기본정보</h4>
			<ul>
				<li>
					<label>펫시터링 유형</label>	
					<span class="radio-chk">
					<%if(apply.getType()==1){ %>
                      <input type="radio" id="petsitter1" name="sitterType" value="1" checked />
                      <label for="petsitter1">위탁 펫시터</label><%}else if(apply.getType()==2){ %>
                      <input type="radio" id="petsitter2" name="sitterType" value="2" checked/>
                      <label for="petsitter2">방문 펫시터</label><%}else{ %>
                      <input type="radio" id="petsitter3" name="sitterType" value="3" checked/>
                      <label for="petsitter3">위탁 &amp; 방문</label><%} %>
                    </span>
				</li>
				
				 <li class="large">
                      <label>개인정보 공개범위</label>
                      <span class="radio-chk">
                      <%if(apply.getOpenarea()==1){ %>
                         <input type="radio" id="phone" name="openArea" value="1" checked/>
                         <label for="phone">휴대폰번호</label><%}else if(apply.getType()==2){ %>
                         <input type="radio" id="kakaotalk" name="openArea" value="2" checked/>
                         <label for="kakaotalk">이메일</label><%}else{ %>
                         <input type="radio" id="openBoth" name="openArea" value="3" checked/>
                         <label for="openBoth">둘 다</label><%} %>
                      </span>
                 </li>
                 
				<li class="large">
                     <label>전업 펫시터 여부</label>
                     <span class="radio-chk">
                     <%if(apply.getJobstyle()==1){ %>
                         <input type="radio" id="fullTime" name="fullTimeJob" value="1" checked/>
                         <label for="fullTime">전업펫시터</label><%}else{ %>
                         <input type="radio" id="twoJob" name="fullTimeJob" value="2" checked/>
                         <label for="twoJob">부업,투잡</label><%} %>
                                    </span>
                </li>
			</ul>
			
			<h4>펫시터 소개 제목</h4>
                 <ul class="info-list none address">
                 <li class="dub">
                 <label for="adComment">펫시터로서 나를 50자 이내로 표현해주세요. <br/></label>
                 <input type="text" style="width:600px;" name="adComment" value="<%=apply.getAdComment()%>"
                 readonly/>
                  </li>
                  </ul>
		
		 <h4>펫시터 소개 (인터뷰)</h4>
                 <ul class="info-list none address interview">
                 <li class="dub">
                 <label style="font-weight: 600;">펫시터를 시작하게된 계기, 활동이력, 반려하고 있는 동물 소개 등과 함께 반려동물을 사랑하는 마음이 담긴 본인소개를 해주세요. <span style="color:#FF7289; font-size: 13px;">(펫시터의 전화번호나 카카오톡 아이디는 본문에 기재하지 말아주세요.)</span></label>

                 <label>1. 펫시터를 어떻게 시작하게 되었나요?</label>
                      <input type="text" style="width:600px;" name="opportunity" value="<%=apply.getOpportunity() %>" id="opportunity" readonly>
                      </li>
                      <li class="dub">
                      <label>2. 펫시터 활동 이력을 말씀해주세요. 처음시작하시는 분이라면 각오를 적어주세요.</label>
                      <input type="text" style="width:600px;" name="activityHistory" value="<%=apply.getActivityHistory() %>" id="activityHistory" readonly>
                      </li>
					 <li>
                         <label style="width:245px;">3. 장기 시터링도 가능하신가요?</label>
                         <span class="radio-chk">
                         <%if(apply.getLong_term()==0){ %>
                         <input type="radio" id="yes1" name="long_term" value="0" checked/>
                         <label for="yes1" style="20%;">예</label><%}else{ %>
                         <input type="radio" id="no1" name="long_term" value="1" checked/>
                         <label for="no1">아니오</label><%} %>
                         </span>
                     </li>
                     <li>
                         <label style="width:245px;">4. 픽업 가능하신가요?</label>
                         <span class="radio-chk">
                         <%if(apply.getLong_term()==0){ %>
                         <input type="radio" id="yes2" name="pickup" value="0" checked/>
                         <label for="yes2" style="20%;">예</label><%}else{ %>
                         <input type="radio" id="no2" name="pickup" value="1" checked/>
                         <label for="no2">아니오</label><%} %>
                         </span>
                     </li>
                        <li class="dub">
                           <label>5. 반려동물을 사랑하는 마음이 듬~뿍 담긴 소개 부탁드립니다^^</label>
                           <textarea name="prContext" id="prContext"  readonly><%=apply.getPrContext() %></textarea>
                     </li>
                   </ul>
		
		<h4>경력 및 활동지역</h4>
                 <ul class="info-list none address">
                 <li>
                 <label>펫시터 경력</label>
                    <span>
                    <select title="경력을 선택해주세요" name="sitterCareer" id="sitterCareer">
                    
                     <option value="0" selected>- 선택 -</option>
                     <option value="1" selected>없음</option>
                     <option value="2" selected>6개월 미만</option>
                     <option value="3" selected>6개월 이상 ~ 1년 미만</option>
                     <option value="4" selected>1년 이상 ~ 3년 미만</option>
                     <option value="5" selected>3년 이상 ~ 5년 미만</option>
                     <option value="6" selected>5년 이상 ~ 10년 미만</option>
                     <option value="7" selected>10년 이상</option>
                   </select>
                   </span>
                 </li>
                 </ul>
		
		<h4>상세정보</h4>
                <ul class="info-list none address label-ico">
                <li>
                 <label class="size">수용 가능한 펫 크기<span>(복수선택 가능)</span></label>
                 <span class="input-chk">
                 <%for (int i =0;i<apply.getPetSize().length();i++){
                 } %>   
                 <input type="checkbox" id="small" name="petSize[]" value="1" checked readonly/>
                 <label for="small">소형(5kg미만)</label>
                 <input type="checkbox" id="mid" name="petSize[]" value="2" checked readonly/>
                 <label for="mid">중형(5kg~10kg)</label>
                 <input type="checkbox" id="big" name="petSize[]" value="3" checked readonly/>
                 <label for="big">대형(10kg이상)</label>
                 </span>
                </li>
                <li>
                                        <label class="pet name">수용 가능한 펫 연령<span>(복수선택 가능)</span></label>
                                    <span class="input-chk">
                                                                                <input type="checkbox" id="baby" name="petAge[]" value="1" />
                                        <label for="baby">베이비(1살미만)</label>
                                        <input type="checkbox" id="junior" name="petAge[]" value="2" />
                                        <label for="junior" style="width:127px">주니어(1살~7살미만)</label>
                                        <input type="checkbox" id="senior" name="petAge[]" value="3" />
                                        <label for="senior">시니어(7살 이상)</label>
                                    </span>
                                    </li>

                                    <li class="is_pet">
              <label>반려동물유무</label>
              <span class="radio-chk animal_layout"">
               <%if(apply.getAnimalCheck()==0){ %>
              <input type="radio" id="yes3" name="animalCheck" value="0" checked/>
              <label for="yes3">있음</label><%}else{ %>
              <span id="ok_pet" style="display: none;">
              <input type="text" name="animalCount" style="width:50px; height:30px;" value="0">마리
               </span>
              <input type="radio" id="no3" name="animalCheck" value="1" checked/>
              <label for="no3">없음</label><%} %>
              </span>
               </li>
                <li>
                <label>13세 이하 아이 유무</label>
                 <span class="radio-chk">
                  <%if(apply.getChild()==0){ %>
               <input type="radio" id="yes4" name="child" value="0" checked/>
              <label for="yes4">있음</label><%}else{ %>
              <input type="radio" id="no4" name="child" value="1" checked/>
              <label for="no4">없음</label><%} %>
                  </span>
                </li>
                <li>
                <label>감시카메라</label>
                <span class="radio-chk">
                <%if(apply.getCamera()==0){ %>
                <input type="radio" id="yes5" name="camera" value="0" checked/>
                <label for="yes5">있음</label><%}else{ %>
                <input type="radio" id="no5" name="camera" value="1" checked/>
                <label for="no5">없음</label><%} %>
                </span>
                </li>
              <li>
                <label for="distance" class="dise1">인근 동물병원 거리</label>
                <span><input type="text"  id="distance" name="distance" value="<%=apply.getHospitalPhoneNumber()%>"/>분 거리</span>
              </li>
              <li>
                <label for="hospital" class="dise2">인근 동물병원 정보</label>
                <span>
                  <input type="text" id="hospital" name="hospital" placeholder="이름" value="<%=apply.getHospital()%>"/>
                  <input type="text" id="hospitalPhoneNumber" name="hospitalPhoneNumber" value="" placeholder="숫자만 가능"/>
                </span>
              </li>
              <li>
                  <label for="sitter">1일 최대 위탁가능 수</label>
                  <span><input type="text" id="oneDayCount" name="oneDayCount" value="<%=apply.getOneDayCount()%>"/>마리</span>
              </li>
              </ul>
                 <h4>입금 정보</h4>
              <ul class="info-list none address">
                 <li class="dub">
                   <label for="bank">계좌정보 입력 <br /><span>시터링 비용을 입금받을 계좌를 등록해주세요 (예금주와 펫시터 성함이 일치해야 합니다.) </span></label>
                   <%if(Integer.parseInt(apply.getBank())==1){ %><input type="text" value="NH은행"/><%}else if(Integer.parseInt(apply.getBank())==2){ %><input type="text" value="국민은행"/>
                   <%}else if(Integer.parseInt(apply.getBank())==3){ %><input type="text" value="우리은행"/><%}else if(Integer.parseInt(apply.getBank())==4){ %><input type="text" value="신한은행"/>
                   <%}else if(Integer.parseInt(apply.getBank())==5){ %><input type="text" value="하나은행"/><%}else if(Integer.parseInt(apply.getBank())==6){ %><input type="text" value="기업은행"/>
                   <%}else if(Integer.parseInt(apply.getBank())==7){ %><input type="text" value="SC은행"/><%}else if(Integer.parseInt(apply.getBank())==8){ %><input type="text" value="씨티은행"/>
                   <%}else if(Integer.parseInt(apply.getBank())==9){ %><input type="text" value="외환은행"/><%}else if(Integer.parseInt(apply.getBank())==10){ %><input type="text" value="대구은행"/>
                   <%}else if(Integer.parseInt(apply.getBank())==11){ %><input type="text" value="광주은행"/><%}else if(Integer.parseInt(apply.getBank())==12){ %><input type="text" value="전북은행"/>
                   <%}else if(Integer.parseInt(apply.getBank())==13){ %><input type="text" value="부산은행"/><%}else if(Integer.parseInt(apply.getBank())==14){ %><input type="text" value="경남은행"/>
                   <%}else if(Integer.parseInt(apply.getBank())==15){ %><input type="text" value="수협은행"/><%}else { %><input type="text" value="새마을금고"/><%} %>
                     <input type="text" id="bankName" name="bankName" value="<%=apply.getBankName()%>" style="margin-left:10px; width:150px;"/>
                     <input type="text" id="bankNumber" name="bankNumber" value="<%=apply.getBankNumber()%>" style="margin-left:10px; width:288px;"/>
                  </li>
              </ul> 
		</div>
	</form>
	
	<h4>펫시터 활동 사진</h4>
                            <ul class="info-list none address">
                                <li class="dub">
                                    <label>
                                        펫시터의 활동 사진을 등록해주세요. <br />
                                        <span>최대 8장까지만 등록해주세요. 이미지 확장자는 꼭 <span style="color:#FF4A63;">jpg</span>로만 등록해주세요. (예시) image.jpg</span>
                                        <span>최적의 사이즈는 <span style="color:#FF4A63;">가로 376px 세로 320px</span> 입니다.</span>
                                    </label>
                                    <form action="../php/uploadDrop.php" class="dropzone" id="my-dropzone" style="height: 385px;">
                                        <div class="fallback">
                                            <input name="file" type="file" multiple />
                                        </div>
                                    </form>
                                </li>
                            </ul>	
    	<button onclick="applyList();">목록으로</button>
	</div>
</body>
<script>
	function applyList(){
		location.href="/ptp/applyList.do?okayN=0";
	}
</script>
</html>