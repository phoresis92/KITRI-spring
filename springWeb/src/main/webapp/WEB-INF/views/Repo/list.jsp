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


<button >글쓰기</button>

<table>
<tr>
<th>title</th>
<th>writer</th>
<th>W_date</th>
</tr>

<c:forEach var="i" items="${ list }">

<tr>
<td><a>${ i.title }</a></td> 
<td>${i.writer }</td>
<td>${i.w_date }</td>
</tr>

</c:forEach>
</table>
</body>
</html>