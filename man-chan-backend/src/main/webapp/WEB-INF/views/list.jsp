<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
</head><body>

${id } 님 로그인 성공<br>

<table>
	<tr><th>번호</th><th>제목</th><th>내용</th><th>작성자</th><th>조회수</th><th>작성일</th><th>수정일</th><th>썸네일</th></tr>
	<c:if test="${empty list }">
		<tr><td colspan="5">게시글이 없습니다</td>
	</c:if>
	<c:if test="${not empty list }">
		<c:forEach var="article" items="${list }">
			<tr><td>${article.ano }</td>
				<td>${article.title }</td>
				<td>${article.content }</td>
				<td>${article.member_id }</td>
				<td>${article.readcount }</td>
				<td>${article.created_at }</td>
				<td>${article.updated_at }</td>
				<td><img alt="${article.thumbnail }" src="${article.thumbnail}" width="130" height="130"></td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<a href="insertForm.do?ano=0">게시글 입력</a>

</body>
</html>
