<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>랜덤값 6개 출력</h1>
	<% 
		ArrayList<String> values = (ArrayList)request.getAttribute("values");
	%>
	<ul>
		<% for(String s: values) {%> 
		<li><%=s %></li>
		<% } %>
	</ul>
</body>
</html>