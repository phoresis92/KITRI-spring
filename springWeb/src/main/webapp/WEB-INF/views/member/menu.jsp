<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${ sessionScope.id }님 페이지</h1>

	<a href="${ pageContext.request.contextPath }/member/myInfo">내정보확인</a><br>
	<a href="${ pageContext.request.contextPath }/member/logout">로그아웃</a><br>
	<a href="${ pageContext.request.contextPath }/board?pnum=1">게시판</a><br>
	<a href="${ pageContext.request.contextPath }/imgBoard/list">자료실</a><br>
	<a href="${ pageContext.request.contextPath }/imgBoard/list">내 이미지 게시판</a><br>
	
	<form action="${ pageContext.request.contextPath }/imgBoard/list" method="post">
	<input type="text" name="frId"><input type="submit" value="친구 이미지 게시판">
	</form>
</body>
</html>