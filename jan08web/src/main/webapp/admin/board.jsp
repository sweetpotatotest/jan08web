<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${sessionScope.mname }님</title>
<link href="../css/admin.css?ver=0.12" rel="stylesheet"/>
<link href="../css/board.css" rel="stylesheet" />
<!-- .. 2개 생각해야됨 -->
<script type="text/javascript" src="../js/menu.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
	<div class="wrap">
	<%@include file="menu.jsp" %>
		<div class="main">
			<article>
				<h2>게시글관리</h2>
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>날짜</th>
							<th>댓글</th>
							<th>방문자</th>
							<th>아이피</th>
							<th>삭제여부</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="row">
							<tr>
								<td class="d1">${row.no }</td>
								<td class="d2">${row.title }</td>
								<td class="d1">${row.write }</td>
								<td class="d2">${row.date }</td>
								<td class="d1">${row.count }</td>
								<td class="d1">${row.comment }</td>
								<td class="d1">${row.ip }</td>
								<td class="d1"><select name="del">
										<optgroup label="삭제">
											<option
												<c:if test="${row.mgrade eq 0}">selected="selected"</c:if>
												value="0">0 게시글 삭제</option>
										</optgroup>
										<optgroup label="일반">
										<option
												<c:if test="${row.mgrade eq 1}">selected="selected"</c:if>
												value="1">1 게시글</option>
										</select></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</article>
		</div>
	</div>
</body>
</html>