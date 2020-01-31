<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hello</title>
</head>
<body>
<h1>
	헬로우 페이지에 오신것을 환영합니다. <br />
	아이디 : ${id}
	패스워드 : ${pw} 
</h1>
<a href="/springlegacy/goodbye">goodbye 페이지로 이동</a>
</body>
</html>
