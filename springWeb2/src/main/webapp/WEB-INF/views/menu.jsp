<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>메뉴</h3>

	<c:choose>
	<c:when test="${ sessionScope.type == 1 }">
	
	<%@ include file="m1.jsp" %>
	
	</c:when>
	<c:otherwise>
	
	<%@ include file="m2.jsp" %>
	
	</c:otherwise>
	
	</c:choose>

</body>
</html>	