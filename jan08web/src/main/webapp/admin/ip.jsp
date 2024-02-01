<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지 - 댓글관리</title>
<link href="../css/admin.css?ver=0.19" rel="stylesheet" />
<link href="../css/member.css" rel="stylesheet" />
<script type="text/javascript" src="../js/menu.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">

<!--차트그리기 -->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'iip');
        data.addColumn('number', 'Count');
        data.addRows([
        	<c:forEach items="${list2 }" var="row">
        		['${row.iip}', ${row.count}],
        	</c:forEach>
        ]);

        // Set chart options
        var options = {'title':'가장 많이 접속한 ip는?',
                       'width':1000,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<div class="wrap">
		<!-- menu -->
		<%@ include file="menu.jsp"%>
		<div class="main">
			<article>
				<h2>IP관리</h2>
				0. 중복없이 ip리스트 뽑기 <br> 
				1. 최다 접속 ip 5개 출력. <br>
				2. 그래프 그리기 - 구글차트 -ip당 접속 건수 10개?<br>
			<table>
				<thead>
					<tr>
						<th>IP</th>
						<th>접속숫자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list2 }" var="row">
						<tr class="row">
							<td class="title">${row.iip }</td>
							<td class="title">${row.count }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				<div id="chart_div"></div>





				<hr>
				<div class="nav-lists">
					<ul class="nav-lists-group">
						<li class="nav-lists-item" onclick="url('./ip?del=1')"><i class="xi-close-circle-o"></i> 보임</li>					
						<li class="nav-lists-item" onclick="url('./ip?del=0')"><i class="xi-close-circle-o"></i> 숨김</li>					
					</ul>
					<div class="search">
						<input type="text" id="search">
						<button id="searchBtn">검색</button>
					</div>
					<button onclick="location.href='./ip'">초기화</button>
				</div>
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>IP</th>
							<th>날짜</th>
							<th>URL</th>
							<th>기타정보</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${list1 }">
							<tr >
								<td class="b1">${row.ino }</td>
		                       	<td class="b1" onclick="url('./ip?ip=${row.iip}')">${row.iip}</td>
		                        <td class="b2">${row.idate}</td>
		                        <td class="b1">${row.iurl}</td>
		                        <td class="b2">${row.idata}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</article>
		</div>
	</div>
</body>
</html>