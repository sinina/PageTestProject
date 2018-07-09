<%@page import="com.matajo.pitpet.member.model.vo.MemberVo"%>
<%@page import="com.matajo.pitpet.patjoin.model.vo.PatVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		PatVo pv = (PatVo)request.getAttribute("pat");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반려동물 정보</title>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<style>
body{
		background:url("/ptp/images/image.jpg") no-repeat;
		background-size:cover;
	}
table.type08 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	border-left: 1px solid #ccc;
	margin: 20px 10px;
}

table.type08 thead th {
	padding: 10px;
	font-weight: bold;
	border-top: 1px solid #ccc;
	border-right: 1px solid #ccc;
	border-bottom: 2px solid #c00;
	background: #dcdcd1;
}

table.type08 tbody th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	background: #ececec;
}

table.type08 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

#container {
	min-height: 900px;
	padding-top: 52px;
	margin-top: 30px;
	margin-left: 80px;
	font-size: 150%;
	font-weight: bold;
	position: relative;
	width: 768px;
	min-width: 460px;
	margin: 0 auto;
}

#content {
	display: block;
	border: 3px solid #00ff43;
	border-radius: 20px;
	width: auto;
	height: 1000px;
	margin-left: 150px;
}

form {
	margin: 0;
	padding: 0;
	display: block;
}
.image {
	width: 200px;
}
h1{
	text-align:center;
}
td{
	border-radius: 20px;
}
.kg{
	width:250px;
}
textarea{
	width:500px;
	height:100px;
}
#pat, #pat2 {
	text-align: center;
	width: 613px;
	margin-left: auto;
	margin-right: auto;
	background: #e52770;
}
</style>
<script>
$(function(){

	//수정하기 이벤트
	$("#pat").hover(function(){
		$("#pat").css("background", "#20d63b"); 
		$("#pat").css("cursor","pointer" );
	}, function(){
		 $("#pat").css("background", "#e52770");
	});
	$("#pat2").hover(function(){
		$("#pat2").css("background", "#20d63b"); 
		$("#pat2").css("cursor","pointer" );
	}, function(){
		 $("#pat2").css("background", "#e52770");
	});
	setInterval(function(){
		//background:url("/ptp/images/image.jpg") no-repeat;
		i %= 10;
		$("#img").css("background", "url('/ptp/images/img"+i+".jpg') no-repeat");
		$("#img").css("background-size", "cover");
		i++;
	}, 60000);
});

function pat(){
	  $("#patjoinForm").submit();
} 
function validate(){
	if($("#attfile").val()==""){
		alert("이미지를 넣어주세요.");
		return false;
	}
	if($("#1").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#2").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#3").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#4").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#5").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#6").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	if($("#7").val() ==""){
		alert("모든 항목을 채워주세요.");
		return false;
	}
	
	return true;
}

function setImage(obj){
	if(obj.files && obj.files[0]){
		var reader = new FileReader();
		reader.onload=function(e){
				$("#petImage").attr("src",e.target.result);

		}
		reader.readAsDataURL(obj.files[0]);
	}
}
function patearlse(){
	location.href = "/ptp/patearlse.do?userId=<%=pv.getNo()%>";
 }
</script>
</head>
<body>
	<h1>반려동물 정보</h1>
	<div id="container">
		<div id="content">
			<form id="patjoinForm" method="post" action="/ptp/patpage.do" enctype="multipart/form-data" onsubmit="return validate();">
				<table class="type08">
					<tr>
						<td rowspan="2" class="image">
							<input type="file" value="사진 등록" onchange="setImage(this);"/>
							<img id="petImage" src="/ptp/PatImage/<%=pv.getPatImage() %>" width="220" height="100"/>
						</td>
						<td>이름 : <input type="text" name="patname" maxlength="10" id="1" value="<%=pv.getPatName()%>"/></td>
					</tr>
					<tr>
						<td>나이<input type="text" name="age" id="2" placeholder="나이 입력" maxlength="2" value="<%=pv.getPatage()%>"/></td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="kg">무게<input type="text" id="3" name="kg" maxlength="2" value="<%=pv.getPatkg()%>"/></td>
						<td>성별<select name="jender">
								<option selected value="0" <%=pv.getPatgender()=='F'?"selected":"" %>>암컷</option>
								<option value="1" <%=pv.getPatgender()=='M'?"selected":"" %>>수컷</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>반려동물 종류<select name="kind">
						<option selected value="강아지" <%=pv.getKinds()=="강아지"?"selected":"" %>>강아지</option>
						<option value="고양이" <%=pv.getKinds()=="고양이"?"selected":"" %>>고양이</option>
						<option value="그외"<%=pv.getKinds()=="그외"?"selected":"" %>>그외</option>
						</select></td>
					</tr>
					<tr>
						<td>종류<input name="kind_of" type="text" id="4" placeholder="견종, 묘종등 입력해주세요" maxlength="500" value="<%=pv.getKinds_of()%>"/></td>
					</tr>
					<tr>
						<td>중성화 수술 여부<select name="asd">
								<option value="1" <%=pv.getOperation()=='Y'?"selected":"" %>>했습니다</option>
								<option selected value="0"<%=pv.getOperation()=='N'?"selected":"" %>>안했습니다</option>
						</select></td>
					</tr>
					<tr>
						<td>우리 애완동물 소개<textarea maxlength="500" id="5" name="we" style="background-color:transparent;" cols=40 rows=5 onclick="this.value=''"><%=pv.getPatInfo()%></textarea>
					</tr>
					<tr>
						<td>특이사항<textarea maxlength="500" name="ae" id="6" style="background-color:transparent;" cols=40 rows=5 onclick="this.value=''"><%=pv.getUniquness() %></textarea></td>
					</tr>
					<tr><td>자주 다니는 동물병원<input type="text" value="<%=pv.getHospital() %>" name="hospital" id="7" maxlength="10"/></td></tr>
				</table>
				<br>
				<br>
				<br>
				<br>
				<br>
				<div id="pat" onclick="pat();">수정하기</div>
				<div id="pat2" onclick="patearlse();">지우기</div>
				<!--  <div id="gangnamStyleIframe"></div>
     
 
 
    <button type="button" onclick="playYoutube();">Play</button>
     
 
    <button type="button" onclick="pauseYoutube();">Pause</button>
     
 
    <button type="button" onclick="stopYoutube();">Stop</button>
     
 
    <button type="button" onclick="changeVideoAndStart();">ChangeVideo And Start</button>
     
 
    <button type="button" onclick="changeVideoObjectAndStart();">ChangeVideoObject And Start</button>
     
 
    <button type="button" onclick="changeVideoListAndStart();">ChangeVideoList And Start</button>
     
 
    <button type="button" onclick="changeVideoListObjectAndStart();">ChangeVideoListObject(Video IDs) And Start</button>
     
 
    <button type="button" onclick="changeVideoListObjectAndStart2();">ChangeVideoListObject(playlist ID) And Start</button>
 
    <script type="text/javascript">
        /**
         * Youtube API 로드
         */
        var tag = document.createElement('script');
        tag.src = "http://www.youtube.com/iframe_api";
        var firstScriptTag = document.getElementsByTagName('script')[0];
        firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
 
        /**
         * onYouTubeIframeAPIReady 함수는 필수로 구현해야 한다.
         * 플레이어 API에 대한 JavaScript 다운로드 완료 시 API가 이 함수 호출한다.
         * 페이지 로드 시 표시할 플레이어 개체를 만들어야 한다.
         */
        var player;
        function onYouTubeIframeAPIReady() {
            player = new YT.Player('gangnamStyleIframe', {
                height: '315',            // <iframe> 태그 지정시 필요없음
                width: '560',             // <iframe> 태그 지정시 필요없음
                videoId: '9bZkp7q19f0',   // <iframe> 태그 지정시 필요없음
                playerVars: {             // <iframe> 태그 지정시 필요없음
                    controls: '2'
                },
                events: {
                    'onReady': onPlayerReady,               // 플레이어 로드가 완료되고 API 호출을 받을 준비가 될 때마다 실행
                    'onStateChange': onPlayerStateChange    // 플레이어의 상태가 변경될 때마다 실행
                }
            });
        }
        function onPlayerReady(event) {
            console.log('onPlayerReady 실행');
        }
        var playerState;
        function onPlayerStateChange(event) {
            playerState = event.data == YT.PlayerState.ENDED ? '종료됨' :
                    event.data == YT.PlayerState.PLAYING ? '재생 중' :
                    event.data == YT.PlayerState.PAUSED ? '일시중지 됨' :
                    event.data == YT.PlayerState.BUFFERING ? '버퍼링 중' :
                    event.data == YT.PlayerState.CUED ? '재생준비 완료됨' :
                    event.data == -1 ? '시작되지 않음' : '예외';
 
            console.log('onPlayerStateChange 실행: ' + playerState);
 
            // 재생여부를 통계로 쌓는다.
            collectPlayCount(event.data);
        }
 
        function playYoutube() {
            // 플레이어 자동실행 (주의: 모바일에서는 자동실행되지 않음)
            player.playVideo();
        }
        function pauseYoutube() {
            player.pauseVideo();
        }
        function stopYoutube() {
            player.seekTo(0, true);     // 영상의 시간을 0초로 이동시킨다.
            player.stopVideo();
        }
        var played = false;
        function collectPlayCount(data) {
            if (data == YT.PlayerState.PLAYING && played == false) {
                // todo statistics
                played = true;
                console.log('statistics');
            }
        }
 
        /**
         * loadVideoById 함수는 지정한 동영상을 로드하고 재생한다.
         * 인수구문: loadVideoByUrl(mediaContentUrl:String, startSeconds:Number, suggestedQuality:String):Void
         * 개체구문: loadVideoByUrl({mediaContentUrl:String, startSeconds:Number, endSeconds:Number, suggestedQuality:String}):Void
         * loadVideoById 함수 뿐만 아니라 다른 대체적인 함수들도 개체구문이 기능이 더 많다.
         */
        function changeVideoAndStart() {
            player.loadVideoById("iCkYw3cRwLo", 0, "large");
        }
        function changeVideoObjectAndStart() {
            // 0초부터 10초까지 재생을 시킨다.
            player.loadVideoById({
                'videoId': 'bHQqvYy5KYo',
                'startSeconds': 0,
                'endSeconds': 10
            });
        }
 
        /**
         * loadPlaylist 함수는 지정한 재생목록을 로드하고 재생한다.
         * 인수구문: loadPlaylist(playlist:String|Array, index:Number, startSeconds:Number, suggestedQuality:String):Void
         * 개체구문: loadPlaylist({list:String, listType:String, index:Number, startSeconds:Number, suggestedQuality:String}):Void
         * [주의: 개체구문의 loadPlaylist 함수에서의 재생목록ID 와 동영상ID 의 사용방법이 다르다.]
         */
        function changeVideoListAndStart() {
            player.loadPlaylist(['wcLNteez3c4', 'LOsNP2D2kSA', 'rX372ZwXOEM'], 0, 0, 'large');
        }
        function changeVideoListObjectAndStart() {
            player.loadPlaylist({
                'playlist': ['9HPiBJBCOq8', 'Mp4D0oHEnjc', '8y1D8KGtHfQ', 'jEEF_50sBrI'],
                'listType': 'playlist',
                'index': 0,
                'startSeconds': 0,
                'suggestedQuality': 'small'
            });
        }
        function changeVideoListObjectAndStart2() {
            player.loadPlaylist({
                'list': 'UUPW9TMt0le6orPKdDwLR93w',
                'listType': 'playlist',
                'index': 0,
                'startSeconds': 0,
                'suggestedQuality': 'small'
            });
        }
 
    </script> -->
				</form>
		</div>
	</div>
</body>
</html>