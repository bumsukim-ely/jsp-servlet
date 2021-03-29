<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function passwordCheck(){
	
}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="./join" method="post">
		<div>
			<label>아이디<input type="text" name="userid" id="id_userid" required></label>
		</div>
		<div>
			<label>패스워드<input type="password" name="pass1" id="id_pass1" required></label>
		</div>
		<div>
			<label>패스워드확인<input type="password" name="pass2" id="id_pass2" required></label>
		</div>
		<div>
			<label>이메일<input type="email" name="email" id="id_email" required></label><br>
		</div>
		<div>
			<button type="submit">가입</button>
		</div>
	</form>
</body>
</html>