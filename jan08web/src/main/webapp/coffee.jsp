<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${sessionScope.mname }님의 커피를 골라주세요</h1>
		<div class="coffeeFORM">
			<form action="./coffee" method="post">
				<input type="radio" name="coffee" value="아아" > 아아 <br>
	        	<input type="radio" name="coffee" value="뜨아" > 뜨아<br>
	        	<input type="radio" name="coffee" value="아차" > 아차 <br>
	        	<input type="radio" name="coffee" value="뜨차"> 뜨차 <br>
				<button type="submit">주문하기</button>
			</form>
		</div>
</body>

</html>