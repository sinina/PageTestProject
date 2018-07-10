<%@page import="com.matajo.pitpet.reservation.model.vo.ReservationVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%ReservationVo res = (ReservationVo)request.getAttribute("res"); %>
<%int msgCode = (int)request.getAttribute("msgCode"); %> 
<title>쪽지 디테일</title>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.7.js">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
crossorigin="anonymous"></script>
<style>
	
	
</style>
</head>
<body>
<%@include file="/views/common/header.jsp"%>
<br>
	<%if(msgCode==2){%>
		<h1 align="center">예약 승인이 되었습니다.</h1>
	<%}else if(msgCode==1){%>
	 	<h1 align="center">예약 요청이 들어왔습니다.</h1>
		<% }else if(msgCode==3){%>
		<h1 align="center">예약이 거절되었습니다.</h1>
		<%}else{ %>
		<h1 align="center">결제가 완료되었습니다.</h1>
		<% }%>
	<div class="inner" >
	
		반려주 이름:<%=res.getPetoName() %><br>
		펫시팅 시간 :<%=res.getStart() %>~<%=res.getEnd() %><br>
		반려동물 종류: <%=res.getAnimalKind() %><br>
		결제 금액 : <%=res.getPrice() %><br>
		<%if(msgCode==1||msgCode==4){%>
		반려주 핸드폰 번호:<%=res.getPhone() %><br>
		<%} %>
		요청 사항 : <%=res.getRequest() %><br><br>
		<%-- 펫시터 no : <%=res.getPetsNo() %> --%>
	<div class="btnWrapper">
		<%if(msgCode==2){ %>
		<button onclick="kakaoPayment();">카카오 페이로 결제하기</button>
		<button onclick="payment();">결제하기</button>
		<button onclick="cancel();">목록으로</button>
		<%}else if(msgCode==1){ %>
		<button onclick="confirmRes();">승인</button>
		<button onclick="rejectRes();">거절</button>		
		<%}else{%>
			<button onclick="cancel();">목록으로</button>	
			<% } %>
	</div>
</div>
<script>
	function kakaoPayment(){
		//var IMP = window.IMP; // 생략가능

		  IMP.init('imp38166839'); 
		  IMP.request_pay({
			  pg : 'kakaopay', 
			  pay_method : 'card', //card(신용카드), trans(실시간계좌이체), vbank(가상계좌), phone(휴대폰소액결제)
		       merchant_uid : 'merchant_' + new Date().getTime(), //상점에서 관리하시는 고유 주문번호를 전달
		       name : '주문명:결제테스트',
		       amount : <%=res.getPrice() %>,
		       buyer_email : 'iamport@siot.do',
		       buyer_name : '구매자이름',
		       buyer_tel : '010-1234-5678', //누락되면 카드사 인증에 실패할 수 있으니 기입해주세요
		       buyer_addr : '서울특별시 강남구 삼성동',
		       buyer_postcode : '123-456'
		   }, function(rsp) {
		       if ( rsp.success ) {
		          alert("확인");
		          //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
		             var msg = '결제가 완료되었습니다.';
		                msg += '\n고유ID : ' + rsp.imp_uid;
		                msg += '\n상점 거래ID : ' + rsp.merchant_uid;
		                msg += '\결제 금액 : ' + rsp.paid_amount;
		                msg += '카드 승인번호 : ' + rsp.apply_num;
		                
		                alert(msg);
		                location.href="<%=request.getContextPath() %>/insertPayment.do?petoNo=<%=res.getPetoNo() %>&petsNo=<%=res.getPetsNo()%>&price=<%=res.getPrice()%>&resNo=<%=res.getResNo()%>&payKind=kakaoPay";
		          jQuery.ajax({
		             url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
		             type: 'POST',
		             dataType: 'json',
		             data: {
		                imp_uid : rsp.imp_uid
		                //기타 필요한 데이터가 있으면 추가 전달
		             }
		          
		          }).done(function(data) {
		             //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
		             if ( everythings_fine ) {
		                var msg = '결제가 완료되었습니다.';
		                msg += '\n고유ID : ' + rsp.imp_uid;
		                msg += '\n상점 거래ID : ' + rsp.merchant_uid;
		                msg += '\결제 금액 : ' + rsp.paid_amount;
		                msg += '카드 승인번호 : ' + rsp.apply_num;
		                
		                alert(msg);
		             } else {
		                //[3] 아직 제대로 결제가 되지 않았습니다.
		                //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
		             }
		          });
		       } else {
		           var msg = '결제에 실패하였습니다.';
		           msg += '에러내용 : ' + rsp.error_msg;
		           
		           alert(msg);
		       }
		   });
		  
	}
	function payment(){
		IMP.init('imp38166839'); 
		IMP.request_pay({
		    pg : 'html5_inicis', //ActiveX 결제창은 inicis를 사용
		    pay_method : 'card', //card(신용카드), trans(실시간계좌이체), vbank(가상계좌), phone(휴대폰소액결제)
		    merchant_uid : 'merchant_' + new Date().getTime(), //상점에서 관리하시는 고유 주문번호를 전달
		    name : '주문명:결제테스트',
		    amount : 10,
		    buyer_email : 'iamport@siot.do',
		    buyer_name : '구매자이름',
		    buyer_tel : '010-1234-5678', //누락되면 이니시스 결제창에서 오류
		    buyer_addr : '서울특별시 강남구 삼성동',
		    buyer_postcode : '123-456'
		}, function(rsp) {
		    if ( rsp.success ) {
		    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
		    	jQuery.ajax({
		    		url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
		    		type: 'POST',
		    		dataType: 'json',
		    		data: {
			    		imp_uid : rsp.imp_uid
			    		//기타 필요한 데이터가 있으면 추가 전달
		    		}
		    	}).done(function(data) {
		    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
		    		if ( everythings_fine ) {
		    			var msg = '결제가 완료되었습니다.';
		    			msg += '\n고유ID : ' + rsp.imp_uid;
		    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
		    			msg += '\n결제 금액 : ' + rsp.paid_amount;
		    			msg += '카드 승인번호 : ' + rsp.apply_num;
		    			
		    			location.href="<%=request.getContextPath() %>/insertPayment.do?petoNo=<%=res.getPetoNo() %>&petsNo=<%=res.getPetsNo()%>&price=<%=res.getPrice()%>&payKind=card";
		    			alert(msg);
		    			//결제 완료시 결제 db저장하는 서블릿으로 이동
		    		} else {
		    			//[3] 아직 제대로 결제가 되지 않았습니다.
		    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
		    		}
		    	});
		    } else {
		        var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		        
		        alert(msg);
		    }
		});
	}
	
	function confirmRes(){
		//예약 번호,승인거절 분별할수있는 번호 가지고 예약 승인하는 서블릿으로 이동
		location.href="confirmRes.do?resNo="+<%=res.getResNo()%>+"&accDny=1";
		
	}
	function rejectRes(){
		location.href="confirmRes.do?resNo="+<%=res.getResNo()%>+"&accDny=2";
	}
	function cancel(){
		location.href="<%=request.getContextPath() %>/selectMessage.do?memberNo=<%=member.getNo() %>";
	}
	
</script>

</body>
</html>