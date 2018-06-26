<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	
	<div class="block " style="height:320px;">
    <ul class="icons" style="height:35px;">
        <li><em style="font-weight: 700; font-size: 13px; color:#323232;">봄율맘</em></li>
        <li class="tool_click">
        <div class="isSafeArea" style="display: inline;">
            <!--<a>--><abbr title="안심펫시터:본인인증을 완료 & 온/오프라인 교육 수료한 펫시터"><img src="../images/badge_icon1.png" width="30" height="30" alt="icon" onerror="this.style.display='none'"></abbr><!--</a>-->
            <!--<a>--><abbr title="전문펫시터:반려동물 관련 경력,학위,자격증을 보유한 전문 펫시터"><img src="../images/badge_icon2.png" width="30" height="30" alt="icon" onerror="this.style.display='none'"></abbr><!--</a>-->
            <!--<a>--><abbr title="우수펫시터"><img src="../images/{{badge_super}}" width="30" height="30" alt="icon" onerror="this.style.display='none'"></abbr><!--</a>-->
        </div>
            <div class="tool_sec">
                <!--<div class="tool_block">
                    <h4><img src="../images/tool_header.png" width="54" height="12" alt="text"></h4>
                    <p><img src="../images/tool_text.png" width="131" height="30" alt="text"></p>
                    <strong><img src="../images/tool_top_arrow.png" width="11" height="7" alt="arrow"></strong>
                    <em><img src="../images/cross_icon.png" width="7" height="7" alt="cross"></em>
                </div>-->
            </div>
        </li>
    </ul>
    <ul class="stars">
        <li>
            <a href="#"><img src="../images/yellow_star.png" width="13" height="12" alt="yellow_star.png_star"></a>
        </li>
        <li>
            <a href="#"><img src="../images/yellow_star.png" width="13" height="12" alt="yellow_star.png_star"></a>
        </li>
        <li>
            <a href="#"><img src="../images/yellow_star.png" width="13" height="12" alt="yellow_star.png_star"></a>
        </li>
        <li>
            <a href="#"><img src="../images/yellow_star.png" width="13" height="12" alt="yellow_star.png_star"></a>
        </li>
        <li>
            <a href="#"><img src="../images/yellow_star.png" width="13" height="12" alt="yellow_star.png_star"></a>
        </li>
    </ul>
    <div class="clear"></div>
    <span>
    	<a href="../page/petsitter.php?id=219">
            <div style="width:270px; height:139px; overflow: hidden; position: relative;">
                <img src="../upload/sitter/201604141730140affddf6059f07df61e6e98b920afaab64575.jpg.thumb" alt="dog" style="width:100%; min-height:100%; top:-100%; bottom:-100%; left:-100%; right:-100%; margin:auto; position: absolute;">
            </div>

    	</a>
        <small>20000원~</small>
    </span>
    <p style="width:270px;height:44px; word-break: break-all; word-wrap: break-word; overflow: hidden; font-size:12px; line-height: 13px;">어려서부터 지금껏 평생 반려견과 함께 생활해 누구보다 반려인들의 마음을 잘 알기에 내집같이 쾌적하고 편한 환경에서 내아이처럼 정성껏 돌봐드리고자 이 일을 시작하게 되었답니다.
저희집은 아파트이지만 바로옆에 산책하기 좋은 동산들과 서울둘레길, 그리고 한강시민공원이 있어 매일 산책은 기본이구요, 간식도 저희 아이들과 똑같이 수제간식 만들어서 먹인답니다.
4개의 방을 비롯해 각 공간마다 안전문이 설치돼있어, 아이들 컨디션이나 성향에 따라 분리케어를 원하실 경우,보호자님과 상담후 협의하에 분리케어도 가능합니다. 
눈에 넣어도 아프지 않을 우리 아이들 엄마같은 따뜻한 펫시터에게 안심하고 맡겨주세요
※체크인은 오전9시부터 오후10시 이내까지 가능하고, 체크아웃은 오후 10시로 종료되며,초과시 케어시간과 관계없이 1박요금이 추가 청구됩니다
</p>

    <div style="display: inline-block;margin-top:5px; height:35px;">
        <img src="../images/state1.png" width="82" height="16" alt="icon" onerror="this.style.display='none'" style="margin-left:5px;">
        <img src="../images/{{isExistChild}}" width="82" height="16" alt="icon" onerror="this.style.display='none'" style="margin-left:5px;">
        <img src="../images/{{isExistCam}}" width="82" height="16" alt="icon" onerror="this.style.display='none'" style="margin-left:5px;">
        <img src="../images/state4.png" width="82" height="16" alt="icon" onerror="this.style.display='none'" style="margin-left:5px;">
        <img src="../images/state5.png" width="82" height="16" alt="icon" onerror="this.style.display='none'" style="margin-left:5px;">
    </div>

    <a class="pin" href="#" style="display: block; margin-top:10px;">서울 강동구</a>
    <img src="../images/host_type3.png" width="{{host_type_width}}" height="16" style="float: right;margin-top:-17px;">
</div>
	
</body>
</html>