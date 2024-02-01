<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 뷰포트메타태그 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>미디어쿼리</title>
<style>
/* 모든기기공통 CSS */
body {
	background-color: orange;
}

/* desktop 규격 */
@media screen and (min-width: 1024px) {
	body {
		background-color: lightblue;
	}
}

/* tablet 규격 */
@media screen and (max-width: 1023px) {
	body {
		background-color: pink;
	}
}

/* mobile 규격 */
@media screen and (max-width: 540px) {
	body {
		background-color: navy;
	}
}
</style>

<script type="text/javascript">
	//console.log(window.innerWidth)
	//console.log(window.innerHeight)
let size = document.getElementById("size");
</script>
</head>
<body>
	<h1 id="size"></h1>
</body>
</html>