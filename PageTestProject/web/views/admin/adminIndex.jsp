<%@page import="com.matajo.pitpet.visitCounter.model.vo.VisitCountVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<% 
	ArrayList<VisitCountVo> list = (ArrayList<VisitCountVo>)request.getAttribute("list"); 
%>
<title></title>
<!-- 구글 차트 api 라이브러리 선언 -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700" rel="stylesheet" type="text/css">
<link href="/ptp/css/default.css" rel="stylesheet" type="text/css" media="all" /> 
<script type="text/javascript" src="/ptp/js/jquery-3.3.1.min.js"></script>
</head>
<script>
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	google.charts.setOnLoadCallback(salesData);
	
	
	// 방문자 추이
	
	function drawChart(data) {
    var data = google.visualization.arrayToDataTable([
         <%for(VisitCountVo v:list){%>
    	  ['month', '방문자 수(명)'],
          ['1월', <%=v.getJan()%> ],
          ['2월',  <%=v.getFeb()%>],
          ['3월',  <%=v.getMar()%>],
          ['4월',  <%=v.getApr()%>],
          ['5월', <%=v.getMay()%>],
          ['6월', <%=v.getJun()%>],
          ['7월',  <%=v.getJul()%>],
          ['8월',  <%=v.getAug()%>],
          ['9월',  <%=v.getSep()%>],
          ['10월',  <%=v.getOut()%>],
          ['11월',  <%=v.getNov()%>],
          ['12월',  <%=v.getDec()%>]
    	  <%}%>
        ]); 

        var options = {
          curveType: 'function',
          legend: { position: 'bottom' }
        }; 
		
        var chart = new google.visualization.LineChart(document.getElementById('chartVisit'));

        chart.draw(data, {
        	pointSize:5,
        	left:10,top:20,width:"100%",height:"100%"
        });
      } 
	
	//매출 현황
/* 	function drawChart1() {
        var data = google.visualization.arrayToDataTable([
          ['month', '매출(만원)'],
          ['1월',  20],
          ['2월',  10],
          ['3월',  50],
          ['4월',  15],
          ['5월',  20],
          ['6월',  20],
          ['7월',  20],
          ['8월',  20],
          ['9월',  20],
          ['10월',  20],
          ['11월',  20],
          ['12월',  20]
        ]);

        var options = {
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('salesChart'));

        chart.draw(data, options);
      } */
	
	
	$(function(){
			$.ajax({
				url:"/ptp/matchingTable.do",
				type:"get",
				success:function(data){
					console.log(data);
					$table = $(".matchingT");
					var resultStr = "<tr><th>기간</th><th>예약 요청</th><th>예약 승인</th><th>결제 완료</th></tr>"
					//보낼때 설정한 키값이 for에서 나옴
					for(var key in data){
						console.log(key);
						var matching = data[key];
						resultStr+="<tr>";
						resultStr+="<td>"+matching.date1+"</td>";
						resultStr+="<td>"+matching.res+"</td>";
						resultStr+="<td>"+matching.resC+"</td>";
						resultStr+="<td>"+matching.resR+"</td>";
						resultStr+="</tr>";
						
					}
					$table.html(resultStr).css("text-align","center");
				},error:function(e){
					console.log(e);
				}
			});
			
			salesData();
	});
	
	function salesData(){
		$.ajax({
			url:"/salesData.do",
			type:"get",
			success:function(data){
				var dataChart=[['month','sales']];
				if(data.length!=0){
					console.log("성고");
					$.each(data,function(i,item){
						datachart.push([item.item, item,number]);
					});
				}
				var data=google.visualization.arrayToDataTable(dataChart);
				var view =new google.visualization.DataView(data);
                var options = {
                        title: "제목옵션",
                        width: 900, // 넓이 옵션
                        height: 300, // 높이 옵션
                };
                var chart = new google.visualization.PieChart(document.getElementById('linechart'));
                chart.draw(view, options);
			}
		})
	}
</script>
<body>
<%@ include file="/views/admin/adminHeader.jsp" %>
<div id="page" class="container">
	<div  class="visitCount">
		<h1>방문자 추이</h1>
		<div id="chartVisit"></div>
	</div>
	
	<div class="visitToday">
		<h1>오늘 방문자수</h1>
		<div class="count"><%=session.getAttribute("todayCount") %></div>
	</div>
	
	<div class="visitTotal">
		<h1>총 방문자수</h1>
		<div class="count"><%=session.getAttribute("totalCount") %></div>
	</div>
	
	 <div class="matching">
		<h1>매칭 현황</h1><br>
	 <table class="matchingT" border="1" cellpadding="5" cellspacing="3"></table>
		<p><a href="<%=request.getContextPath() %>/views/admin/reservationCalendar.jsp">더보기</a></p>
	</div>
	
	<div class="sales">
		<h1>매출 현황</h1>
		<div id="salesChart">
		</div>
	</div> 
</div>

</body>
</html>
