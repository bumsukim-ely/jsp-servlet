<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
	<h1>구구단 출력</h1>
	<form action="./gugudan" method="post">
		<input type="number" min="1" max="9" value="1" name="dan_num">
		<button type="submit">출력</button>
	</form>

</body>
</html>