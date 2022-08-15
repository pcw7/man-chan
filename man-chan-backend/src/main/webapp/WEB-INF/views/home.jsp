<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
</head><body>

${id } 님 게시글 작성이 성공하였습니다.<br>
파일이름 : ${fileName } <br>
파일크기 : ${fileSize } <br>
썸네일 : 
<%-- <img alt="${article.thumbnail }" src="${pageContext.request.contextPath }/resources/upload/${article.thumbnail }" width="130" height="130"> --%>
<img alt="${fileName }" src="${pageContext.request.contextPath }/resources/upload/${fileName }" width="130" height="130"> <br>

<a href="insertForm.do?ano=0">게시글 입력</a>

</body>
</html>
