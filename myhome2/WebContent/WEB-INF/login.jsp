<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="./login" method="post">
		<div>
			<label for="login_id">아이디 : </label>
			<input type="text" name="id" id="login_id" required>
		</div>
		<div>
			<label for="login_password">패스워드 : </label>
			<input type="password" name="password" id="login_password" required>
		</div>
		<button type="submit">로그인</button>
	</form>
</body>
</html>