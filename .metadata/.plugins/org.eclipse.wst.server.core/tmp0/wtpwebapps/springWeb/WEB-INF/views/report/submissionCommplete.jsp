<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리포트 제출 완료</title>
</head>
<body>

	<h1>리포트 제출 완료</h1>
	
	<c:forEach var="list" items="${ imgList }">
	
	<img src="/img/${ list }" width="150" height="150";><br>
	
	</c:forEach>

</body>
</html>