<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>게시글 작성</h2>
<form action="insert.do" method="post">
	<input type="hidden" name="ano" value="${ano }">
	<%-- <input type="hidden" name="member_id" value="${member.id }"> --%>
	<table>
		<tr><td>제목</td><td><input type="text" name="title" required="required" autofocus="autofocus"></td></tr>
		<tr><td>본문</td><td><textarea rows="5" cols="40" name="content" required="required"></textarea></td></tr>
		<tr><td colspan="2" align="center"><input type="submit" value="작성"></td></tr>
	</table>
</form>

</body>
</html>