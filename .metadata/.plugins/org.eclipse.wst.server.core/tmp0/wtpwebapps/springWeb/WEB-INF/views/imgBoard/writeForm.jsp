<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>작성폼</h3>
<form action="${pageContext.request.contextPath}/imgBoard/write" 
method="post" enctype="multipart/form-data">
<table border="1">
<tr><th>작성자</th><td><input type="text" name="writer" value="${sessionScope.id }"
readonly></td><tr>
<tr><th>제목</th><td><input type="text" name="title"></td><tr>
<tr><th>내용</th><td><input type="text" name="content"></td><tr>
<tr><th>이미지</th><td><input type="file" name="file"></td><tr>
<tr><td colspan="2"><input type="submit" value="등록"></td></tr>
</table>
</form>
</body>
</html>