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
<style type="text/css">
body {
	background-color: #1BBC9B;
}

h1 {
	text-align: center;
	font-size: 100px;
	color: white;
}

.login {
	margin: 0 auto;
	width: 300px;
	min-height: 100px;
	
	padding: 10px;
	box-sizing: border-box;
	text-align: center;
}

.login input {
	width: 100%;
	height: 50px;
	text-align: center;
	color: #eeeef1;
	margin-bottom: 10px;
	box-sizing: border-box;
	background-color: #9b9b9b;
	border-radius: 5px;
}

.login button {
	width: 45%;
	height: 30px;
	color: #eeeef1;
	font-size: large;
	background-color: #9b9b9b;
}
</style>
<script type="text/javascript">
function err() {
	let errBox = document.querySelector("#errorMSG");
	errBox.innerHTML = "<marquee>올바른 id와 pw를 입력하세요.</marquee>";
	errBox.style.color = 'white';
	
}
</script>
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
					<h1>login</h1>
					<c:if test="${param.error ne null }">
						<script type="text/javascript">
							alert("올바른 암호와 아이디를 입력하세요.");
							
						</script>
					</c:if>
					
					<div class="login">
						<form action="./login" method="post">
							<input type="text" name="id"  placeholder="아이디를 입력하세요">
							<input type="password" name="pw" placeholder="암호를 입력하세요">
							<button type="reset">지우기</button>
							<button type="submit">로그인</button>
							<div id="errorMSG"></div>
						</form>
						<a href="./join">회원가입</a>
					</div>

				</article>
			</div>
		</div>
		<footer>
		<c:import url="footer.jsp"/>
		</footer>
	</div>
	
	<c:if test="${param.error ne null }">
		<script type="text/javascript">
			err();
		</script>
	</c:if>
	
</body>
</html>