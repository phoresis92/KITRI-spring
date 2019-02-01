<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${ article.parent != 0 }">
<c:set var="val">-->${ article.title }</c:set>
</c:if>
	<form action="${pageContext.request.contextPath }/board/write" method="POST">
	writer: <input type="text" name="writer" value="${sessionScope.id }" readonly="readonly"><br>
	title: <input type="text" name="title" value="${ val }"><br>
	content: <input type="text" name="content"><br>
	<input type="hidden" value="${ article.parent }" name="parent">
	<input type="submit" value="작성">
	</form>

</body>
</html>