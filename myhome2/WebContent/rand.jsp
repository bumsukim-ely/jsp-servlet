<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>랜덤값 생성</h1>
	<form action="./random/res" method="post">
		<label>최소값<input type="number" min="1" max="100" step="1" value="1" name="min" required></label>
		<label>최대값<input type="number" min="1" max="100" step="1" value="100" name="max" required></label>
		<button type="submit">생성</button>
	</form>
</body>
</html>