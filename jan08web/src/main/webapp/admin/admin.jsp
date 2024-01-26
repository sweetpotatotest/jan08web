<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${sessionScope.mname }님</title>
<link href="../css/admin.css" rel="stylesheet"/> <!-- .. 2개 생각해야됨 -->
<script type="text/javascript" src="../js/menu.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
	<!-- <h1>관리자 페이지</h1>
	admin.jsp열기를 위해 서블릿을 만들어야함 -->
	<!-- 2024-01-26 관리자 페이지 만들기 -->
	<!-- 틀 -->
	<div class="wrap">
		<!-- menu -->
		<div class="menu">
			<nav>
				<ul>
					<li onclick="url('./members')"><i class="xi-users"></i>회원 관리</li>
					<li onclick="url('./board')"><i class="xi-document"></i>게시글 관리</li>
					<li onclick="url('./comments')"><i class="xi-forum-o"></i>댓글 관리</li>
					<li onclick="url('./info')"><i class="xi-github-alt"></i>${sessionScope.mname } 님</li>
					<li></li>
					<li></li>
				</ul>			
			</nav>
		</div>
		<!-- content -->
		<div class="main">
			<!-- 이 페이지에 오는 모든 사람은 관리자 검사를 합니다.
			관리자 경우 보여주고, 로그인 하지 않았거나 일반 사용자는 로그인 페이지로 이동시킵니다. -->
			<article>
				<div class="info">
					왼쪽 메뉴를 선택하세요.
				</div>		
			</article>
		</div>
	</div>
</body>
</html>