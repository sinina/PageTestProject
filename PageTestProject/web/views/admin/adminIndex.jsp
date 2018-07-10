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

<style>
        table.matchingT {
            border-collapse: collapse;
            text-align: left;
            line-height: 1.5;
            border-left: 1px solid #ccc;
            margin: 20px 10px;
        }

        table.matchingT thead th {
            padding: 10px;
            font-weight: bold;
            border-top: 1px solid #ccc;
            border-right: 1px solid #ccc;
            border-bottom: 2px solid #c00;
            background: #dcdcd1;
        }
        table.matchingT tbody th {
            width: 150px;
            padding: 10px;
            font-weight: bold;
            vertical-align: top;
            border-right: 1px solid #ccc;
            border-bottom: 1px solid #ccc;
            background: #ececec;
        }
        table.matchingT td {
            width: 350px;
            padding: 10px;
            vertical-align: top;
            border-right: 1px solid #ccc;
            border-bottom: 1px solid #ccc;
        }
    </style>
</head>
<script>
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	
	
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
 	function salesData() {
 		$.ajax({
			url:"/ptp/salesData.do",
			type:"get",
			success:function(list){
				google.charts.load('current', {'packages':['corechart']});
				google.charts.setOnLoadCallback(drawChart1);
				
				function drawChart1(){
					var dataChart=[['month','sales']];
					
						/* console.log("성공");
						console.log(list); */
						$.each(list,function(i,item){
							/* console.log(item) */
							dataChart.push([item.month, item.number]);
						});
					
				var data=google.visualization.arrayToDataTable(dataChart);
			 	var view =new google.visualization.DataView(data); 
		        var options = {
		        		pointSize:5,
		        	curveType: 'function',
		          legend: { position: 'bottom' },
		          hAxis: {maxValue:12,minValue:1, ticks: [1,2,3,4,5,6,7,8,9,10,11,12]} 
		        };
        var chart = new google.visualization.LineChart(document.getElementById('salesChart'));
        chart.draw(view, options);
				}
        
			},error:function(e){
				console.log(e);
			}
		});


      } ;
	
	
	$(function(){
			$.ajax({
				url:"/ptp/matchingTable.do",
				type:"get",
				success:function(data){
					//console.log(data);
					$table = $(".matchingT");
					var resultStr = "<tr><th>기간</th><th>예약 요청</th><th>예약 승인</th><th>결제 완료</th></tr>"
					//보낼때 설정한 키값이 for에서 나옴
					for(var key in data){
						//console.log(key);
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
	 <table class="matchingT"></table>
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
