<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
<tiles:insertAttribute name="title" ignore="true"/>
</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

</head>
<body>
	
	<div class="container" style="margin-top: 150px">
	
	<table border="1" align="center" class="table">
	
	<tr  class="thead-dark">
		<td height="30" colspan="2">
		<tiles:insertAttribute name="header"/>
		</td>
	</tr>
	<tr>
		<%-- <c:choose>
		<c:when test="${ sessionScope.type eq 1 }">
		</c:when>
		</c:choose> --%>
		<td ><tiles:insertAttribute name="menu"/></td>
		<td><tiles:insertAttribute name="body"/></td>
	</tr>
	<tr>
		<td height="20" colspan="2" align="center">
		<tiles:insertAttribute name="footer"/>
		</td>
	</tr>
	
	</table>
	
	</div>
	
</body>
</html>