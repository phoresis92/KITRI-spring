<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>

$(document).ready(function(){
$('#toJoin').click(function(){
	location.href="${ pageContext.request.contextPath }/member/join";
});
})
</script>

</head>
<body>

	<form action="${ pageContext.request.contextPath }/member/login" method="post">
id : <input type="text" name="id"> <br>
pwd : <input type="password" name="pwd"><br>
<input type="submit" value="로그인"> <input type="button" value="회원가입" id="toJoin">
 	</form>
 <br>
 

</body>
</html>