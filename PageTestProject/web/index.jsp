<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>MATAZO</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />	
	</head>
	<body>

		<!-- Header -->
			<%@include file="/views/common/header.jsp"%>

		<!-- Banner -->
			<section id="banner">
				<div class="inner">
					 <h1><br></h1> 
					
				<ul class="actions">
						<li><a href="#" class="alt">맡아조?</a></li>
						<li><a href="#" class="alt">맡겨조!</a></li>
					</ul>
					<!-- <div>
					맡아조?
					</div>
					<div>
					맡겨조!
					</div> -->
					
					
				
				</div>
			</section>

		<!-- One -->
			<section id="three">
				<div class="inner">
					<article>
						<div class="content">
							<span class="icon fa-users"></span>
							<header>
								<h3>믿을 수 있는 펫시터</h3>
							</header>
							<p>저희가 직접 검증한 믿을수 있는 <br>펫시터를 만나보실수 있습니다.</p>
						</div>
					</article>
					<article>
						<div class="content">
							<span class="icon fa-diamond"></span>
							<header>
								<h3>1:1케어 서비스</h3>
							</header>
							<p>한 가정의 펫만 케어하기 때문에<br> 내 반려동물만을 위한 펫시팅이 가능합니다.</p>
						</div>
					</article>
					<article>
					<div class="content">
							<span class="icon fa-paw"></span>
							<header>
								<h3>세분화된 펫시터 서비스</h3>
							</header>
							<p>강아지 뿐만 아니라 다양한 동물들,<br> 위탁/방문 등 세분화된 펫시터 서비스를 경험하실 수 있습니다.</p>
						</div>
					</article>
				</div>
				 
			</section>

		<!-- Two -->
			<section id="two">
				<div class="inner">
					<article>
						<div class="content">
							<header>
								<h3>애견호텔</h3>
							</header>
							<div class="image fit">
								<img src="images/pic001.png" alt="" />
							</div>
							<p>낯선 공간에 남겨져 스트레스를 받아요.<br>한 장소에서 이뤄지는 행동들은 괴로워요</p>
						</div>
					</article>
					<article class="alt">
						<div class="content">
							<header>
								<h3>유치원</h3>
							</header>
							<div class="image fit">
								<img src="images/pic002.png" alt="" />
							</div>
							<p>다른 동물에게 괴롭힘을 당할 수 있어요.<br>다른 동물에게서 나쁜 습관을 배워올 수 있어요</p>
						</div>
					</article>
				</div>
			</section>

		<!-- Three -->
		<section id="one">
			<div class="inner">
				<header>
						<h2>내가 원하는 펫시터를 찾아 믿고 맡겨보세요</h2>
				</header>
					<ul class="actions">
						<li><a href="#" class="button alt">서비스 이용 방법</a></li>
					</ul>
			</div>
		</section>
			<section id="three_1">
				<div class="inner">
					<article>
						<div class="content">
							<span class="icon fa-calendar"></span>
							<header>
								<h3>예약 요청</h3>
							</header>
							<p>원하는 시간을 선택하여<br> 예약 요청을 보내세요!</p>
						</div>
					</article>
					<article>
						<div class="content">
							<span class="icon fa-envelope"></span>
							<header>
								<h3>메시지</h3>
							</header>
							<p>메시지를 통해 예약승인/거절을<br> 확인하세요!</p>
							
						</div>
					</article>
					<article>
					<div class="content">
							<span class="icon fa-home"></span>
							<header>
								<h3>사전 만남</h3>
							</header>
							<p>맡기기전 펫시터와 사전만남을 통하여 조건에 충족하는지 확인하세요!</p>
						</div>
					</article>
				</div>
			</section>

		<!-- Footer -->
			<section id="footer">
				<div class="inner">
					<header>
						<h2>Get in Touch</h2>
					</header>
					<form method="post" action="#">
						<div class="field half first">
							<label for="name">Name</label>
							<input type="text" name="name" id="name" />
						</div>
						<div class="field half">
							<label for="email">Email</label>
							<input type="text" name="email" id="email" />
						</div>
						<div class="field">
							<label for="message">Message</label>
							<textarea name="message" id="message" rows="6"></textarea>
						</div>
						<ul class="actions">
							<li><input type="submit" value="Send Message" class="alt" /></li>
						</ul>
					</form>
					<div class="copyright">
						&copy; Untitled Design: <a href="https://templated.co/">TEMPLATED</a>. Images <a href="https://unsplash.com/">Unsplash</a>
					</div>
				</div>
			</section>

		<!-- Scripts -->
			<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
			<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
			<script src="<%=request.getContextPath()%>/js/util.js"></script>
			<script src="<%=request.getContextPath()%>/js/main.js"></script>
	</body>
</html>