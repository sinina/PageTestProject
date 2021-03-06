
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.matajo.pitpet.board.model.vo.BoardVo" %>
<%@ page import="java.util.ArrayList" %>    
<%
	ArrayList<BoardVo> boardList = (ArrayList<BoardVo>)request.getAttribute("boardList");
%>

<%
	ArrayList<Integer> indexList = (ArrayList<Integer>)request.getAttribute("indexList");
%>

<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">


<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->


	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/common/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/common/jquery-ui-1.11.4/jquery-ui.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/bower_components/select2/dist/js/select2.min.js"></script>
	<%-- <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/common/common.js?v=1"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/common/popup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/dog_common.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/slick-carousel/slick/slick.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/slick-lightbox/dist/slick-lightbox.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/jquery-sticky/jquery.sticky.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/moment/min/moment.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/bower_components/moment/locale/ko.js"></script>

<script type="text/javascript">

	
	
		$(function(){
			
		
			var e = $('.add');
			
			<%for(int i=1;i<boardList.size();i++){%>
				var i = <%=boardList.size()%>-<%=i%>;
				console.log(i);
				if(5<i){
					e.attr('class','content hide add'+parseInt(i));	
				}else{
					e.attr('class','content add'+parseInt(i));	
				}
				e.clone().insertAfter(e);
		    <%}%>
			e.attr('class','content add'+0);
			
			
			
			
			var $local_distribution = $("#local_distribution").children(":first").children().children();
			
			
			
			if($local_distribution.text()==""){
				 $.ajax({
						url : "/ptp/localdistri.do",
						type : "get",
						data : null,
						dataType: "json",
						success : function(data){
							 $local_distribution.append(data.all);
							 $("#local_distribution").children().eq(1).children().children().append(data.soul);
							 $("#local_distribution").children().eq(2).children().children().append(data.gyeonggi);
							 $("#local_distribution").children().eq(3).children().children().append(data.incheon); 
							 $("#local_distribution").children().eq(4).children().children().append(data.other); 
						},error : function(e){
							console.log(e);
						}
					}); 
			}
		
			
			$(window).scroll(function(){
				if(Math.round($(window).scrollTop()) + $(window).height() + 5 > $(document).height()){
					var $testhide = $(".hide");
					console.log($testhide.length);
					for(var i = 0 ;i<=$testhide.length;i++){
						var $element = $testhide.eq(i);
						if(i<5){
							$element.removeClass("hide");	
						}
					}  
					
				}
				
				
			});
		
		<%for(int i=0;i<boardList.size();i++){%>
		var str = <%=i%>+"";
		var add = '.add'+str;
		var grade = (<%=boardList.get(i).getLevel()%>==0?'신규 회원':<%=boardList.get(i).getLevel()%>==1?'일반 회원':'우수 회원');
		
		var address = '<%=boardList.get(i).getAddress()%>';

		$(add).find(".content_img").attr('src','<%=request.getContextPath()%>/upload/petsitter/<%=boardList.get(i).getPhoto1()%>');
		$(add).find(".content_location").append(address.substring(address.indexOf(",")+2,18));
		$(add).find(".text_title").children().eq(0).append("["+address.substring(address.indexOf(",")+2,18)+"]"+'<%=boardList.get(i).getTitle()%>');
		$(add).find(".text_pay_block").children().eq(0).append('day care / 20,000원');
		$(add).find(".text_pay_block").children().eq(1).append('1박 / 30,000원');
		$(add).find(".text_name_block").children().eq(0).append(grade);
		$(add).find(".text_name_block").children().eq(1).append('<%=boardList.get(i).getName()%>');
		$(add).find(".text_title").children().eq(0).attr('onclick','callDetail('+<%=i%>+')');
		<%}%>
		
		
		
		<%if(indexList!=null){ %>
			var $fix = $(".fix-select");
		<%for(int i =0;i<indexList.size();i++){%>
			var $element = $fix.eq(<%=i%>);
			$element.val(<%=indexList.get(i)%>);
		<%}%>
		<%}%>
		
		
	});
</script>
<script>
function callDetail(index){
	
	<%if(boardList!=null){%>
	<%for(int i=0;i<boardList.size();i++){%>
		if(index==<%=i%>){
			location.href ="<%=request.getContextPath()%>/selectBoard.do?name=<%=boardList.get(i).getName()%>&p_no=<%=boardList.get(i).getNo()%>";
		}
		
	<%}%>
	<%}%>
}
</script>
<style>


.filter-tabs {
	
    padding: 0;	
    margin: 0 auto;
    clear: both;
    position: relative;
    text-align: center;
    
}

.states-tabs .visible-xs-block {
  background-color: #fff;
  padding: 15px 0 20px;
  border-bottom: solid 1px #ccc;
}
.states-tabs .visible-xs-block .btn {
  margin: 0 auto !important;
  padding: 9px 20px 8px !important;
  border-radius: 5px;
  border-color: #fbbe53;
  color: #fac058;
  font-weight: 300;
}
.states-tabs .promotion {
  position: absolute;
  top: 14px;
  right: 18px;
  line-height: 16px;
  font-size: 12px;
  color: #61c2d9;
  font-weight: 400;
  vertical-align: middle;
}
.states-tabs .promotion:hover {
  color: #FAC058;
}
.states-tabs .promotion .badge {
  margin-top: -2px;
  margin-right: 5px;
  font-size: 9px;
  background-color: #70c7dc;
  color: #fef187;
  font-weight: 300;
}


  .states-tabs {
	position: fixed;
	float:left;
 	z-index: 97;
	}
	.states-tabs .nav-tabs {
		margin-top: 0px;
		border: none;
		border-bottom: solid 1px #ccc;
		will-change: margin-top;
		transition: margin-top 200ms linear;
		z-index: 5;
		background-color: white;
	}
	.states-tabs .nav-tabs.headroom--unpinned {
		margin-top: -50px;
	}
	.visible-banner-top .states-tabs .nav-tabs,
	.visible-banner-top .states-tabs .dropdown-menu {
		margin-top: 60px;
	}
	.visible-banner-top .states-tabs .nav-tabs.headroom--unpinned {
		margin-top: 0px;
	}
	.states-tabs .nav-tabs>li {
		width: 25%;
	}
	.states-tabs .nav-tabs>li>a {
		padding: 15px 0 14px;
	}
	.states-tabs .nav-tabs>li.open>a:after, .states-tabs .nav-tabs>li.open>a:before {
		bottom: 0;
	}
	.states-tabs .dropdown-menu {
		width: 100%;
	}
	.states-tabs .dropdown-menu li {
		width: 33.3333%;
	}
	.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label {
		width: 100%;
	}
	.states-tabs .btn {
		display: block;
		margin: 20px auto 5px !important;
	}
	.states-tabs .btn.btn-link {
		margin-top: 0 !important;
	}
	.states-tabs .close {
		margin: -35px 0 -10px 0 !important;
		padding: 0 5px !important;
		font-size: 40px;
    font-weight: 100;
	}
	
	
	
.states-tabs .nav-tabs {
	min-height: 41px;
	min-width: 1000px;
	margin-top: 35px;
	border: solid 1px #fbbe53;
	background-color: #f5f5f5;
	font-size: 15px;
}
.states-tabs .nav-tabs>li {
	width: 120px;
	position: static;
	margin-bottom: 0;
}
.states-tabs .nav-tabs>li>a,
.states-tabs .nav-tabs>li>a:focus,
.states-tabs .nav-tabs>li>a:hover {
	margin: 0;
	border-radius: 0;
	border: none;
	border-right: solid 1px #ededed;
	color: #699769;
}
.states-tabs .nav-tabs>li>a>span {
	margin-left: 5px;
	color: #fac058;
	font-weight: bold;
}
.states-tabs .nav-tabs>li.active>a,
.states-tabs .nav-tabs>li.active>a:focus,
.states-tabs .nav-tabs>li.active>a:hover,
.states-tabs .nav-tabs>li.open>a,
.states-tabs .nav-tabs>li.open>a:focus,
.states-tabs .nav-tabs>li.open>a:hover,
.states-tabs .nav-tabs>li.active>a>span,
.states-tabs .nav-tabs>li.open>a>span {
	background-color: #fac058;
	color: #fff;
}
.states-tabs .nav-tabs>li.open>a {
	position: relative;
}
.states-tabs .nav-tabs>li.open>a:after, .states-tabs .nav-tabs>li.open>a:before {
	bottom: -7px;
	left: 50%;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
	z-index: 1001;
}
.states-tabs .nav-tabs>li.open>a:after {
	border-color: rgba(255, 255, 255, 0);
	border-bottom-color: #fff;
	border-width: 6px;
	margin-left: -6px;
}
.states-tabs .nav-tabs>li.open>a:before {
	border-color: rgba(249, 194, 93, 0);
	border-bottom-color: #f9c25d;
	border-width: 7px;
	margin-left: -7px;
}
.states-tabs .dropdown-menu {
	width: 875px;
	padding: 8px 10px 15px 20px;
	top: 47px;
	border-radius: 0;
	border: solid 1px #f9c25d;
	font-size: 13px;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label {
	width: 105px;
	margin-right: 0 !important;
	padding: 10px 0 10px 25px;
	color: #696969;
	font-weight: normal;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label:before,
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label:after {
	top: 11px;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox]:checked + label {
	font-weight: bold;
}
.states-tabs .btn {
	margin-top: 15px !important;
	padding: 8px 15px 7px !important;
	color: #fff;
	font-weight: 400;
}
.states-tabs .btn-mint {
	width: 90px;
}
.states-tabs .btn-link {
	color: #696969;
	text-decoration: underline;
}


.header-member + .dropdown-menu {
	min-width: auto;
	top: 85%;
	left: 162px;
}
.sitter-approved .header-member + .dropdown-menu {
	left: 205px;
}
.visible-block-sitters-only {
	display: none;
}
.sitter-approved .visible-block-sitters-only {
	display: block;
}
.header-member + .dropdown-menu a {
	color: #868686;
    padding: 0 20px;
    line-height: 230%;
	font-weight: normal;
}
.header-menu-inner .dropdown-menu:before {
  position: absolute;
  top: -7px;
  left: 60%;
  display: inline-block;
  border-right: 7px solid transparent;
  border-bottom: 7px solid #ccc;
  border-left: 7px solid transparent;
  border-bottom-color: rgba(0, 0, 0, 0.2);
  content: '';
}
.header-menu-inner .dropdown-menu:after {
  position: absolute;
  top: -6px;
  left: 61%;
  display: inline-block;
  border-right: 6px solid transparent;
  border-bottom: 6px solid #ffffff;
  border-left: 6px solid transparent;
  content: '';
}


.header-message .dropdown-menu {
	width: 450px;
	padding: 0;
	left: -240px;
	border-radius: 0;
}
.header-message .dropdown-menu:before {
	left: 272px;
}
.header-message .dropdown-menu:after {
	left: 273px;
}
.header-message .dropdown-menu li {
	border-top: solid 1px #dcdcdc;
}
.header-message .dropdown-menu li:first-child {
	border-top: none;
}
.header-message .dropdown-menu a {
	padding: 20px 15px;
	position: relative;
	color: #7d7d7d;
}
.header-message .dropdown-menu .profile-photo {
	width: 50px;
	height: 50px;
	position: absolute;
	top: 20px;
	left: 15px;
	border-radius: 50%;
	border: solid 1px #dcdcdc;
	background-size: cover;
    background-position: center 50%;
    background-repeat: no-repeat;
}
.header-message .dropdown-menu dl {
	margin: 5px 0 2px 60px;
}
.header-message .dropdown-menu dt label {
	font-weight: 700;
}
.header-menu .header-menu-inner .header-message .dropdown-menu dt span {
	margin-right: 5px;
	height: 20px;
	font-size: 12px;
	font-weight: 500;
}
.header-message .dropdown-menu dd {
	font-size: 12px;
	font-weight: normal;
	text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
}
.header-message .dropdown-menu .no-content {
	line-height: 80px;
}

.states-tabs .dropdown-menu {
	width: 875px;
	padding: 8px 10px 15px 20px;
	top: 47px;
	border-radius: 0;
	border: solid 1px #f9c25d;
	font-size: 13px;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label {
	width: 105px;
	margin-right: 0 !important;
	padding: 10px 0 10px 25px;
	color: #696969;
	font-weight: normal;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label:before,
.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label:after {
	top: 11px;
}
.states-tabs .dropdown-menu input.checkbox[type=checkbox]:checked + label {
	font-weight: bold;
}

.visible-banner-top .states-tabs .dropdown-menu {
		margin-top: 60px;
	}

.states-tabs .dropdown-menu {
		width: 100%;
	}
	.states-tabs .dropdown-menu li {
		width: 33.3333%;
	}
	.states-tabs .dropdown-menu input.checkbox[type=checkbox] + label {
		width: 100%;
	}
	
	.header-menu .header-menu-inner .header-message .dropdown-menu dt span {
		margin: 2px 0 3px 0;
	}
	.header-message .dropdown-menu {
		width: 100%;
		margin-top: -1px;
		left: 0;
	}
	.header-message .dropdown-menu:before, .header-message .dropdown-menu:after {
		content: none;
	}
	.header-message .dropdown-menu a {
		padding: 20px 12px;
	}
	.header-message .dropdown-menu .profile-photo {
		left: 12px;
	}
	.header-message .dropdown-menu dl {
		margin: 3px 0 2px 60px;
	}
	.header-message .dropdown-menu dt label {
		font-size: 16px
	}
	.header-message .dropdown-menu dd {
		font-size: 14px
	}
	
	
	.info-tabs{
	
	border: solid 1px #dcdcdc;
	min-width:1000px;
	height:130px;
	
	
	
	}
	
	
	.fix{
	height: 100%;
	width:150px;
	float:left;
	font-size: 15px;
	color: #699769;
	padding: 15px;
	
	}
	.fix-select{
	width: 130px;
	font-size: 13px;
	    color: #696969;
	}
	
	
	.price_range {
    display: inline-block;
    padding :15px;
    font-size: 15px;
    height: 130px;
    width: 300px;
    float:left;
    color: #699769;
	}
	
	.range_input .price_input{
    display: inline-block;
    width: 100px;
    height: 34px;
    border: 1px solid #dcdcdc;
    background-color: #fff;
    color: #959595;
    
}

.main-wrap{
	display: inline-block;
	width: 1000px;
	
	margin:10px 20%;
	
}

.filter-reset{
	width:1000px;
	height: 70px;
}

.content-tabs{
	
	width: 1000px;
	height: 100%;
	
	
}

.content{
	display: inline-block;
	
	width: 320px;
	height: 390px;
	
	/* border: 1px solid pink; */
	margin: 5px;
	-webkit-border-bottom-left-radius: 0.5em;
	-webkit-border-top-left-radius: 0.5em;
	-webkit-border-bottom-right-radius: 0.5em;
	-webkit-border-top-right-radius: 0.5em;
}


.img_wrapper {
	position: relative;
	}
.content_img{
	width: 310px;
	height: 200px;
	/* -webkit-border-bottom-left-radius: 0.5em;
	-webkit-border-top-left-radius: 0.5em;
	-webkit-border-bottom-right-radius: 0.5em;
	-webkit-border-top-right-radius: 0.5em; */
	
}

.content_text{
	width: 290px;
	margin : -5px 14px -5px 0px;
}

.inner2 {
    padding: 0;
    margin: 0 auto;
    clear: both;
    position: relative;
    display: block;
    width: 550px;
    margin-left: auto;
    margin-right: auto;
}

 .name1{
 	display:inline;
 	border: 0;
    outline: 0;
    font-size:15px;
    width: 100px;
    vertical-align: baseline;
    background: transparent;
    
  	
 }
 .text_pay{
 	display:inline;
 	font-size:15px;
 	
 }
 .text_pay_block{
 
 	width: 290px;
 	hight:50px;
 }
 
 .text_title{
 	
	width: 280px;
 	height:72px;
 	/*  border: 1px solid #f9c25d; */
 	font-size:18px;
 	margin :0px 8px;
 }
 
 .text_name_block{
 border-top: 1px solid #f9c25d;
 	margin :0px 8px;
 }
 
 
    .content_location{
    display: inline-block;
    padding-right: 15px;
    position: absolute;
    top: 0;
    left: 0;
    background-color: rgba(0, 0, 0, 0.5);
    color: #fff;
    line-height: 35px;
 
    pointer-events: none;
    vertical-align: middle;
    font-size: 14px;
    
    }




</style>


</head>
<body>

<%@include file="../common/header.jsp" %>
<div class= "main-wrap">
<div class="filter-tabs">
<div class="states-tabs inner2">
      <ul class="nav nav-tabs" role="tablist" id="local_distribution">
       <li role="presentation"><a href="boardFilter.do?index=0" >전체<span></span></a></li>
       <li role="presentation"><a href="boardFilter.do?index=1">서울<span></span></a></li>
       <li role="presentation"><a href="boardFilter.do?index=2">경기<span></span></a></li>
       <li role="presentation"><a href="boardFilter.do?index=3">인천<span></span></a></li>
         <li role="presentation"><a href="boardFilter.do?index=4">그외지역<span></span></a></li>
      </ul>
    	
			
			
	</div>
	
	<div class="info-tabs inner2">
	<form action="/ptp/boardFilter.do" method="get" >
	<div class="fix">
     <dt>서비스</dt>
	<select class="fix-select" name="searchService">
    <option class=fix-option; value="5">모든 서비스</option>
    <option class=fix-option; value="0">24시간 돌봄</option>
    <option class=fix-option; value="1">데이케어</option>
	</select>
	</div>
	<div class="fix">
	<dt>위탁 동물 종류</dt>
	<select class="fix-select" name="searchPet">
    <option class=fix-option; value="5">모든 반려동물</option>
    <option class=fix-option; value="1">강아지</option>
    <option class=fix-option; value="2">고양이</option>
    <option class=fix-option; value="3">기타</option>
	</select>
	</div>
	<div class="fix">
	<dt>펫시터 등급</dt>
	<select class="fix-select" name="searchGrade">
    <option class=fix-option; value="5">모든 등급</option>
    <option class=fix-option; value="0">신규회원</option>
    <option class=fix-option; value="1">일반회원</option>
    <option class=fix-option; value="2">우수회원</option>
	</select>
	</div>
	
	
	<div class="price_range">
            <dt>가격 입력</dt>
            <span class="range_input" ><input type="text"  class="price_input" title="최소가격 입력"  name="min_p" placeholder="원" readonly="readonly"></span>
            <span class="range_at">~</span>
            <span class="range_input" ><input type="text"  class="price_input" title="최대가격 입력"  name="max_p" placeholder="원" readonly="readonly"></span>
     </div>
     <div class="fix">
			<button type="submit" data-loading="검색 중..." class="btn btn-mint" style="margin: 18px;" >펫시터 검색</button>
			
	</div>
	</form>
	</div>
	</div>
	<div class="filter-reset">
	
	</div>
	
	<div class="content-tabs">
	
	 

	
	<div class="content hide add" >
	<div class= "img_wrapper" >
		<img class="content_img" src=""/>
		
		<div class="content_location">
	<img src="<%=request.getContextPath()%>/images/common/navi_map_icon.png" style="margin-right: -10px; margin-bottom: -15px;"/>
	</div>
	</div>
	<div class="content_text">
	<div class="text_title">
	
					
				<a  href="javascript:void(0);"  class="hidden-xs" style="color:#696969; font-weight: bold; ">
							</a>
							
			</div>		
			<div class="text_pay_block">
							<label class="text_pay" style="color:#696969; margin-left:10px;">
								</label>
							<label class="text_pay" style="color:#fac058; margin-left:20px;">
								</label>
			</div>			
			
			<div class="text_name_block">	
							<label class="name1" style="color:#696969; margin-left:5px;">
								</label>
							<label class="name1" style="color:#696969; margin-left:145px;">
								</label>
			</div>	
	</div>
	 </div>
	 
	
	
	
	
	
	
	
	</div>
	</div>

	


</body>
</html>