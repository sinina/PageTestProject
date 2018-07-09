<%@page import="com.matajo.pitpet.member.model.vo.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.matajo.pitpet.patjoin.model.vo.PatVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    MemberVo mv = (MemberVo) session.getAttribute("user");
    ArrayList<PatVo> list = (ArrayList<PatVo>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MATAZO</title>
<style>
#player{
	margin-left:auto;
	margin-right:auto;
}
</style>
<script src="/ptp/js/jquery-3.3.1.min.js"></script>
<script>
function pat(){
	location.href="/ptp/views/member/patjoin.jsp";	
}
$(function(){
	$(".tableArea td").mouseenter(function(){
		$(this).parent().css("background","#00ff7f");
		$(this).parent().css("cursor","pointer");
	}).mouseout(function(){
		$(this).parent().css("background","none");
	});
});

function callPetInfo(no){
	location.href = "/ptp/patjoinsu.do?userId=" + no;
}
// 2. This code loads the IFrame Player API code asynchronously.
var tag = document.createElement('script');

tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

// 3. This function creates an <iframe> (and YouTube player)
//    after the API code downloads.
var player;
function onYouTubeIframeAPIReady() {
  player = new YT.Player('player', {
    height: '360',
    width: '640',
    videoId: 'AS-O9etZ_qo',
    events: {
      'onReady': onPlayerReady,
      'onStateChange': onPlayerStateChange
    }
  });
}

// 4. The API will call this function when the video player is ready.
function onPlayerReady(event) {
  event.target.playVideo();
}

// 5. The API calls this function when the player's state changes.
//    The function indicates that when playing a video (state=1),
//    the player should play for six seconds and then stop.
var done = false;
function onPlayerStateChange(event) {
  if (event.data == YT.PlayerState.PLAYING && !done) {
    setTimeout(stopVideo, 6000);
    done = true;
  }
}
function stopVideo() {
  player.stopVideo();
}
</script>
</head>
<body>
	<div class="tableArea">
		<table align="center" class="table">
		<%if(list.size() == 0){ %>
				<tr>
					<td>반려동물 정보가 없습니다.</td>
					   
				</tr>
		<%}else{ %>
			<%for(PatVo n : list){ %>
				<tr onclick="callPetInfo(<%=n.getNo()%>);">
				<td><img id="petImage" src="/ptp/PatImage/<%=n.getPatImage() %>" width="220" height="80"/></td>
				<td><%=n.getPatName() %></td>
				<td><%=n.getKinds() %></td>
				</tr>
			<%} %>
		<%} %>
		</table>
		<div id="player"></div>
	</div>
	<button id="pat" onclick="pat();">등록하기</button>
	<img class="mySlides" src="/ptp/images/banner/image1.jpg">
	<img class="mySlides" src="/ptp/images/banner/image2.jpg">
	<img class="mySlides" src="/ptp/images/banner/image3.jpg">
	<img class="mySlides" src="/ptp/images/banner/image4.jpg">
	<img class="mySlides" src="/ptp/images/banner/image5.jpg">
	<img class="mySlides" src="/ptp/images/banner/image6.jpg">
	<img class="mySlides" src="/ptp/images/banner/image7.jpg">
	<img class="mySlides" src="/ptp/images/banner/image8.jpg">
	<img class="mySlides" src="/ptp/images/banner/image9.jpg">
	<img class="mySlides" src="/ptp/images/banner/image10.jpg">
	<img class="mySlides" src="/ptp/images/banner/image11.jpg">
	<img class="mySlides" src="/ptp/images/banner/image12.jpg">
	<img class="mySlides" src="/ptp/images/banner/image13.jpg">
	<img class="mySlides" src="/ptp/images/banner/image14.jpg">
	<img class="mySlides" src="/ptp/images/banner/image15.jpg">
	 <script>
  var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
    showDivs(slideIndex += n);
}

function showDivs(n) {
    var i;
    var x = document.getElementsByClassName("mySlides");
    if (n > x.length) {slideIndex = 1} 
    if (n < 1) {slideIndex = x.length} ;
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none"; 
    }
    x[slideIndex-1].style.display = "block"; 
}
$(function(){
	setInterval(function(){
		plusDivs(1);
	},1000);
})
  </script>
</body>
</html>