<%@page import="com.kgb4232.dbcon.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>l</title>
<link href="./css/menu.css" rel="stylesheet" />
<link href="./css/index.css" rel="stylesheet" />
<script type="text/javascript" src="./js/menu.js"></script>
</head>
<body>
	<div class="container">
		<header>
			<%-- <%@ include file="menu.jsp"%>  아래와 동일한 방법--%>
			<%@ include file="menu.jsp"%>
			<%-- <jsp:include page="menu.jsp"></jsp:include> --%>
			<!-- jsp":은 출력 결과만 화면에 나옵니다. -->
		</header>
		<div class="main">
			<div>
				<article>
				
					<c:set var="number" value="105"/>
					
					<c:out value="${number }"/><br>
					
					<c:forEach begin="1" end="10" var="row" step="2">
						2 X ${row } = ${row * 2 }<br>
					</c:forEach>	
					
					<c:if test="${number eq 105 }">
						number는 105입니다.<br>
						중요하다.
						eq 11 == 5 같은 값? false<br>
						ne 11 != 5 			true<br>
						lt 11〈5 보다 작아	false<br>
						gt 11〉5			true<br>
						le 11〈= 5			false<br>
						ge 11〉= 5			true<br>
						&& <br>
						|| <br>
						empty <br>
						not empty <br>
					</c:if>
				</article> 
				<article>
					<hr>
					<c:forEach begin="1" end="44" var="row" step="2">
						${row + 1 }</t>
					</c:forEach>	
					
					<hr>
					<c:forEach begin="1" end="45" var="even">
        				<c:if test="${even % 2 eq 0 }">
       						 ${even } <br>
        				</c:if>
        			</c:forEach>
				</article>
				<article>
					<c:import url="menu.jsp"/>
					<br>
					<c:forEach begin="1" end="10" var="row" varStatus="s">
						${s.begin } / ${s.end } 
					</c:forEach>
					
				</article>
			</div>
		</div>
		<footer>
		<c:import url="footer.jsp"/>
		</footer>
	</div>
</body>
</html>