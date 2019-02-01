<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<h1>자료실</h1>

<ul>
<c:forEach var="item" items="${ list }">

<li><a href="${pageContext.request.contextPath }/download/down?name=${ item }">${ item }</a></li>

</c:forEach>
</ul>


</body>
</html>