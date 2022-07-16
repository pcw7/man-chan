<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
</head>
<body>

<form action="login.do" method="post">
	<input type="text" name="id" required="required" autofocus="autofocus" placeholder="아이디"><br>
	<input type="password" name="password" required="required" placeholder="비밀번호"><br>
	<input type="submit" value="로그인">
</form>
<a href="joinForm.do">회원가입</a>

</body>
</html>