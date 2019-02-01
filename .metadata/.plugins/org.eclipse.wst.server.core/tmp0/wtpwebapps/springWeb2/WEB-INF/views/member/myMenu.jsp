<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="${pageContext.request.contextPath }/member/update" method="post">
	id : <input type="text" name="id" value="${ m.id }" readonly="readonly"><br>
	pwd : <input type="text" name="pwd" value="${m.pwd }"><br>
	name : <input type="text" name="name" value="${m.name }" readonly="readonly"><br>
	email : <input type="text" name="email" value="${m.email }"><br>
	
	<button type="submit" >수정하기</button> <br>
</form>

<form action="${pageContext.request.contextPath }/member/del" method="POST">
	<button>탈퇴하기</button>
</form>
</body>
</html>