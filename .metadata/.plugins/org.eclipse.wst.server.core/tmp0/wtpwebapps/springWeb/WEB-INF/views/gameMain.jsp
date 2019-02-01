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
	
	<h3>인기 키워드:</h3>
	<c:forEach var="QueryList" items="${ PopularQueryList }">
	${ QueryList }
	</c:forEach>
	
	<br>
	
	<select name="type">
	<c:forEach var="SearchType" items="${ SearchTypeList }">
	
	<option value="${ SearchType.code }">${ SearchType.text }</option>
	
	</c:forEach>
	</select>

</body>
</html>