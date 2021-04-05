<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%@ include file="/WEB-INF/module/css_js.jsp" %>
</head>
<body>
	<% 
		String username = "";
		if(request.getAttribute("username") != null){
			username = (String)request.getAttribute("username");
		}
	%>
	<form action="./login" method="post">
		<div>
			<label for="id_username">아이디</label>
			<input type="text" id="id_username" name="username" value="<%=username %>"required>
		</div>
		<div>
			<label for="id_password">비밀번호</label>
			<input type="password" id="id_password" name="password" required>
		</div>
		<div>
			<% 
				if(username.equals("")) {
			%>
					<input type="checkbox" id="id_remember" name="remember">
			<% 
				} else {
			%>
					<input type="checkbox" id="id_remember" name="remeeber" checked>
			<%
				}
			%>		
			<label for="id_remember">기억하기</label>
		</div>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>
</body>
</html>