<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="./css/menu.css" rel="stylesheet" />
<link href="./css/index.css" rel="stylesheet" />
<script type="text/javascript" src="./js/menu.js"></script>
<style type="text/css">
table {
	width: 700px;
	height: 400px;
	border-collapse: collapse;
}

tr:hover {
	background-color: gray;
}

th {
	background-color: red;
	border-bottom: 2px solid blue;
}

td {
	border-bottom: 1px solid gray;
	text-align: center;
}

.title {
	text-align: left;
	width: 40%;
}

.w1 {
	width: 10%;
}

.w2 {
	width: 20%;
}

.title a{
	text-decoration: none;
}
.title a:visited {
	color: orange;
}
.title a:link {
	color: black;
}
.title a:hover {
	color: white;
}
.paging{
	margin: 0 auto;
	width: 500px;
	height: 30px;
	margin-top: 10px;
	line-height: 30px;
}
.currentBtn{
	background-color: black;
	color: white;
}
span{
	font-size:small;
	color: blue;
	font-weight: bolder;
}
</style>
</head>
<body>

	<div class="container">
		<header>
			<%@ include file="menu.jsp"%>
			<!-- 컴파일 전에 불러오고 실행됩니다. -->
		</header>
		<div class="main">
			<div class="mainStyle">
				<article>
					<%-- 	for문 연습해보기
					<c:forEach items="${list }" var="e" varStatus="s">
						${e.no } / ${s.first } / ${s.last } / ${s.index } / ${s.count } / ${s.step }<br>
						
					</c:forEach> --%>
				</article>
				<article>
					<c:choose>
						<c:when test="${fn:length(list) gt 0 }">
							<table>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>날짜</th>
									<th>읽음</th>
								</tr>
								<c:forEach items="${list }" var="row">
									<tr>
										<td class="w1">${row.no }</td>
										<td class="title">
											<a href="./detail?page=${page }&no=${row.no }">${row.title }
											&nbsp;<c:if test="${row.comment ne 0 }"><span>[${row.comment}]</span></c:if> </a>  
										</td>
										<td class="w2">${row.write }</td>
										<td class="w2">${row.date }</td>
										<td class="w2">${row.count }</td>
									</tr>
								</c:forEach>
							</table>
							${totalCount }개 글이 있습니다.
							totalPage : <c:set var="totalPage" value="${totalCount / 10 }"/>
							<fmt:parseNumber integerOnly="true" value="${totalPage }" var="totalPage"/>
							<c:if test="${totalCount % 10 gt 0 }">
								<c:set var="totalPage" value="${totalPage + 1 }"/>
							</c:if>
							<c:out value="${totalPage }"/>
							/ startPage: <c:set var="startPage" value="1"/>
							<c:if test="${page gt 5 }">
								<c:set var="startPage" value="${page - 5}"/>
							</c:if>
							${startPage }
							/ endPage: <c:set var="endPage" value="${startPage + 9 }"/>${endPage }
							<c:if test="${endPage gt totalPage }">
                         		<c:set var="endPage" value="${totalPage}"/>
                      		</c:if>
							
							/ Page : ${page }
							
							<div class="paging">
								<button onclick="paging(1)">⏮</button>
								<button <c:if test="${page - 10 lt 1 }">disabled="disabled"</c:if>onclick="paging(${page - 10 })">◀️</button>
								<%-- <c:choose>
									<c:when test="${page - 10 lt 1 }">
		                        		<button disabled="disabled" onclick="paging(${page -10})">⏪</button>
									</c:when>
									<c:otherwise>
		                        		<button  onclick="paging(${page -10})">⏪</button>
									</c:otherwise>
								</c:choose> --%>
								<c:forEach begin="${startPage }" end="${endPage }" var="p">
									<button 
									<c:if test="${page eq p }">class="currentBtn"</c:if>
									onclick="paging(${p})">${p }</button> 
								</c:forEach>
								<button <c:if test="${page + 10 gt totalPage }">disabled="disabled"</c:if> onclick="paging(${page + 10 })">▶️</button>
                        		<button onclick="paging(${totalPage})">⏭</button>
							</div>
						</c:when>
						<c:otherwise>
							<h1>출력할 값이 없습니다.</h1>
						</c:otherwise>
					</c:choose>
					<c:if test="${sessionScope.mname ne null}">
						<button onclick="url('./write')">글쓰기</button>
						${sessionScope.mname }님 반갑습니다.
					</c:if>
				</article>
				<article></article>
				<!--위에서 사용  -->
				<%-- 	<article>
					fn이용해서 자료형 길이 뽑아내기
					${fn:length(list) }<br>
					<c:choose>
						<c:when test="${fn:length(list) gt 0}">
							참일때
						</c:when>
						<c:otherwise>
							<h1>출력할 값이 없습니다.</h1>
						</c:otherwise>
					</c:choose>
					
				</article> --%>

			</div>
		</div>
		<footer>
			<%-- <fmt:requestEncoding value="UTF-8" />
			<fmt:setLocale value="ko_kr" />
			<fmt:formatNumber value="3.14" type="percent" />
			<fmt:parseNumber value="3.14" integerOnly="true" /> --%>

			<c:set var="nowDate" value="<%=new Date()%>"></c:set>
			<%-- ${nowDate } <br> --%>
			<%-- <fmt:formatDate type="time" value="${nowDate }" />
			<br>
			<fmt:formatDate type="date" value="${nowDate }" />
			<br>
			<fmt:formatDate type="both" value="${nowDate }" />
			<br>
			<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
				value="${nowDate }" />
			<br> --%>
			<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"
				value="${nowDate }" />
			<br>
		<%-- 	<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
				value="${nowDate }" />
			<br>
			<fmt:formatDate pattern="yyyy-MM-dd" value="${nowDate }" />
			<br>
 --%>

		<c:import url="footer.jsp"/>
		
		</footer>
	</div>
	<script type="text/javascript">
		function paging(no) {
			location.href="./board?page="+no;
		}
	</script>
</body>
</html>