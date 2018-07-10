<%@page import="com.matajo.pitpet.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		MemberVo user = (MemberVo)session.getAttribute("user");
	%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>돌보미등록하기</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<script>
function insert(){
	
	var yes = localStorage.getItem('yes');
	
	if(<%=user.getP_okay()%>==0||yes==0){
		alert('이미 펫시터 신청을 하셨습니다.!');
		return false;
	}
	if(<%=user.getP_okay()==5%>){
		return true;
	}
}
</script>
</head>
<body>
		  <%@include file="../common/header.jsp" %>
			
		<!-- wrapper starts -->
<div class="wrapper">
    <div class="banner-inner join"> <!-- 배경이미지 서비스 안내 일때 클래스명 join 따로 제어 -->
        <div class="container">
            <div class="bnr-inner">
                <h5>펫시터 가입하기</h5>
                <a href="#">맡아죠의 펫시터가 되어보세요</a>
            </div>
        </div>
    </div>

    <!-- maincontent Starts -->
    <div class="container-wrap">
        <h3 class="tit-service">맡아죠 <strong class="txt-pink">펫시터가</strong> <strong class="txt-green">되어보세요</strong></h3>
        <ol class="step-care join">
            <li>
                <em>하나.</em>
                <img src="http://clara051.cdn3.cafe24.com/petsitter_info/step-join01.png" alt="펫시터가 되면" />
                <p>사랑스러운 <span style="font-weight: 600">동물들과 시간</span>을 보내면서<br/> 동시에 <span style="font-weight: 600">수익을 창출</span>할 수 있습니다.</p>
            </li>
            <li>
                <em>둘.</em>
                <img src="http://clara051.cdn3.cafe24.com/petsitter_info/step-join02.png" alt="펫시터가 되면" />
                <p>맡아죠의 <span style="font-weight: 600">각종교육기회</span>로<br />펫시터로서의 <span style="font-weight: 600">전문성을 함양</span>할 수 있습니다.</p>
            </li>
            <li>
                <em>셋.</em>
                <img src="http://clara051.cdn3.cafe24.com/petsitter_info/step-join03.png" alt="펫시터가 되면" />
                <p>펫시터로서의 <span style="font-weight: 600">홍보와 스케줄 및</span><br /><span style="font-weight: 600">후기관리</span>를 무료로 할 수 있습니다.</p>
            </li>
        </ol>
        <!-- //펫시터가 되면 -->
        <div class="petssiter-care">
            <div>
                <h3 class="tit-service">맡아죠<br /><strong class="txt-purple">펫시터가 해야할 일 !</strong></h3>
                <ul class="list-care">
                    <li>
                        <strong>신속한 고객응대</strong>고객이 펫시팅 문의시 신속하게 답장
                    </li>
                    <li>
                        <strong>펫 상태 보고</strong>1일 1회 이상 펫의 상태, 사진, 영상 등을 반드시 전달
                    </li>
                    <li>
                        <strong>서비스 책임수행</strong>예약된 스케쥴에 대한 사명감 있는 수행
                    </li>
                </ul>
            </div>
        </div>
        <!-- //펫시터가 하는일 -->
        <h3 class="tit-service">맡아죠 <strong class="txt-green">펫시터 되기</strong></h3>
        <div class="do-petssiter">
            <ul>
                <li class="left-align step01">
                    <strong>Step.01</strong>펫시터 회원 5단계 가입 프로세스 완료
                </li>
                <li class="right-align step02">
                    <strong>Step.02</strong>관리자 승인 후 펫시터로 등록 완료
                </li>
                <li class="left-align step03">
                    <strong>Step.03</strong>로그인 후 펫시터 온라인 강좌 수강
                </li>
                <li class="right-align step04">
                    <strong>Step.04</strong>고객의 문의에 응대하며, 펫시터 예약 스케쥴링
                </li>
                <li class="left-align step05">
                    <strong>Step.05</strong>약속된 시간에 펫시터 수행
                </li>
            </ul>
            <p>
                <strong>펫시터 예약시, 고객이 펫시터 비용 선결제</strong>
                - 예약내용을 바탕으로 펫시터 예약내역서 제공<br/>
                - 고객과 사전미팅 또는 예약당일 대면 시, 위탁계약서 작성
            </p>
        </div>
        <div class="benefit">
            <p class="tit"><strong class="txt-pink">맡아죠의 펫시터를 위한</strong> 또 하나의 혜택 </p>
            <div class="pink-box">
                <h3 class="tit-service" style="font-size:25px;">맡아죠의<br /> <strong class="txt-pink">펫시터 커뮤니티에 가입하고 교류하세요!</strong></h3>
                <p class="first-con">
                    맡아죠의 펫시터로 등록되시면,<br />
                    펫시터 커뮤니티 가입 초대장이 발송됩니다.
                    <br /><br />
                    맡아죠에서 활동하고 있는 많은 펫시터들이<br />
                    커뮤니티에 가입되어 있습니다~<br />

                    <br /><br />
                    이곳에서 다른 펫시터들과 교류하며 친목을 쌓고,<br />
                    펫시팅에 대한 조언과 정보를 공유하세요.
                </p>
                <p>
                    맡아죠의 운영진도 시터링에 도움되는 정보들을 <br />
                    가장 먼저 커뮤니티를 통해 공유드리고,<br />

                    <br /><br />
                    각종 오프라인 세미나, 펫시터 대상의 이벤트 등도<br />
                    커뮤니티를 통해 한발 앞서 알려드립니다 : )
                    <br /><br />
                    펫시터님의 가입을 기다리고 있습니다 ♡
                </p>
            </div>
        </div>
        <!-- // 펫시터 되기 -->
        <div class="bg-badge">
            <h3 class="tit-service">맡아죠만의 <strong class="txt-pink">특별한 뱃지 시스템</strong></h3>
            <div>
                <dl class="badge-info" style="width:1000px;">
                    <dt style="margin:0px 180px 15px; width:580px;">
                    <ul>
                        <li>
                            <img src="http://clara051.cdn3.cafe24.com/service/badge-safe-small.png" alt="안심펫시터" />
                            <strong>우수 펫시터</strong>
                        </li>
                        <li class="license-badge" style="margin:0 110px;">
                            <img src="http://clara051.cdn3.cafe24.com/service/badge-pro-small.png" alt="전문펫시터" />
                            <strong>일반 펫시터</strong>
                        </li>
                        <li>
                            <img src="http://clara051.cdn3.cafe24.com/service/badge-super-small.png" alt="우수펫시터" />
                            <strong>신규 펫시터</strong>
                        </li>
                    </ul>
                    </dt>
                    <dd>
                        <ul style="display:inline-flex; font-size:14px; margin-left: -65px;">
                            <li>
                                본인인증을 완료하고<br/>온오프라인 교육을 수료한 펫시터
                            </li>
                            <li style="width:220px;">
                                펫시터 경력이 있고<br/>관련 자격증을 보유한 펫시터
                            </li>
                            <li>
                                의뢰인들의 만족도가 높고<br/>리뷰가 많이 축적된 펫시터
                            </li>
                        </ul>
                    </dd>
                </dl>
                <a class="btn-pink" onClick="return insert();" href="<%=request.getContextPath()%>/views/member/petsitterprofile.jsp">"펫시터 등록하러 가기</a>
            </div>
        </div>
        <!-- // 뱃지 시스템 -->
    </div>
    <!-- container-wrap ends -->
		
</body>
</html>