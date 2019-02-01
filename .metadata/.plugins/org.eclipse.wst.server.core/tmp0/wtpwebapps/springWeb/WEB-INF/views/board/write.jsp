<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">

	function modi(){
		
		$('#go').attr('action', './update');
		$('#go').submit();
		
	}
	
	function wri(){
		
		$('#go').attr('action', './write');
		$('#go').submit();
	}

</script>

</head>
<body>


<form method="POST" id="go">


<c:if test="${Article.writer != null }">
	<h2>readonly</h2>
	writer: <input type="text" name="writer" value="${ Article.writer }" readonly="readonly"> <br>
	num: <input type="text" name="num" value="${ Article.num }" readonly="readonly"> <br>
	w_date: <input type="text" name="w_date" value="${ Article.w_date }" readonly="readonly"> <br>
</c:if>

	<h2>write</h2>
	title: <input type="text" name="title" value="${ Article.title }"> <br>
	content: <input type="text" name="content" value="${ Article.content }"> <br>
	file: <input type="file" name="file">
</form>


<c:choose>

<c:when test="${Article.writer != null }">
	<button onclick="modi()" >modify</button>
</c:when>

<c:otherwise>
	<button onclick="wri()">write</button>
</c:otherwise>

</c:choose>



</body>
</html>