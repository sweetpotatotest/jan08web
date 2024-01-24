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
					<h1>info</h1>
					<h2>2024-01-22</h2>
					<ul>
						<li>댓글달기</li>
						<li>동적생성하기</li>
						<li>관리자모드</li>
					</ul>
					<h2>2024-01-19</h2>
					<ul>
						<li>postman</li>
						<li>database development</li>
						<li>dbeaver</li>
						<li>댓글달기 관계도 그리기</li>
						<li>댓글 테이블 만들기</li>
						<li>댓글달기</li>
						<li>관리자모드 - 회원관리</li>
						<li>관리자모드 - 글관리</li>
					</ul>
					
					<h2>2024-01-17</h2>
					<ul>
						<li>페이징</li>
						<li>bootstrap</li>
						<li>jquery</li>
						<li>회원가입</li>
						<li>AJAX</li>
						<li>관리자모드 - 회원관리</li>
						<li>관리자모드 - 글관리</li>
					</ul>
					<h2>2024-01-10/ 웹 서버프로그램 구현</h2>
					<ul>
						<li>톺아보기</li>
						<li>각각 게시판 서블릿, jsp</li>
						<li>글쓰기</li>					
						<li>삭제하기</li>					
						<li>수정하기</li>					
					</ul>
					<h2>java - servlet - jsp(jsp/jstl/el) - thymelea</h2>
					<h2>2024-01-15</h2>
					<ul>
						<li>세션으로 로그인 만들기</li>
						<li>board테이블 변경</li>
						<li>내 정보 보기</li>
					</ul>									
				</article>
			</div>
		</div>
		<footer>
		<c:import url="footer.jsp"/>
		</footer>
	</div>
</body>
</html>