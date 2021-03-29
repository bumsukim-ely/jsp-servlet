<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 확인</h1>
	<h3><%=request.getParameter("userid") %></h3>
	<h3><%=request.getParameter("email") %></h3>
</body>
</html>