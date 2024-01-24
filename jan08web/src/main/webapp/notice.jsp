<%@page import="com.kgb4232.dbcon.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>l</title>
<link href="./css/menu.css" rel="stylesheet" />
<link href="./css/index.css" rel="stylesheet" />
<script type="text/javascript" src="./js/menu.js"></script>
<style type="text/css">
body {
	background-color: #1BBC9B;
}

</style>
</head>
<body>
	<div class="container">
		<header>
			<%-- <%@ include file="menu.jsp"%>  아래와 동일한 방법--%>
			<%@ include file="menu.jsp"%>
			<!-- jsp":은 출력 결과만 화면에 나옵니다. -->
		</header>
		<div class="main">
			<div class="mainStyle">
				<article>
					<h1>notice</h1>
					<h2>2024-01-10/ 웹 서버프로그램 구현</h2>
					<ul>
						<li>톺아보기</li>
						<li>각각 게시판 서블릿, jsp</li>
						<li>글쓰기</li>					
						<li>삭제하기</li>					
						<li>수정하기</li>					
					</ul>									
				</article>
			</div>
		</div>
	</div>
</body>
</html>