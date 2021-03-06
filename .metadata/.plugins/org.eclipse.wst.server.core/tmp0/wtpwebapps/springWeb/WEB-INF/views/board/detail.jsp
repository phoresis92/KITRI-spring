<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

function back(){
	history.back();
}

function del(){
	
	location.href="./delete?bnum=${ requestScope.Article.num}"
	
}

function modi(){
	
	
	
	$('#modi').submit();
}

</script>

</head>
<body>
<a href="${ pageContext.request.contextPath }/board/writeForm?parent=${ Article.num }&title=${ Article.title }">댓글작성</a>

<button onclick="back()">back</button> 

<c:if test="${ sessionScope.id == requestScope.Article.writer }">

<button onclick="modi()">modify</button>
<button onclick="del()">delete</button>

</c:if>

<br>
	${Article.num } <br>
	${Article.title }<br>
	${Article.writer }<br>
	${Article.content }<br>
	${Article.w_date }<br>

<form id="modi" action="./modify" method="POST">

<input type="hidden" name="num" value="${Article.num }" >
<input type="hidden" name="title" value="${Article.title }" >
<input type="hidden" name="writer" value="${Article.writer }" >
<input type="hidden" name="content" value="${Article.content }" >
<input type="hidden" name="w_date" value="${Article.w_date }" >

</form>

<h3>댓글 목록</h3>
<table>
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>내용</th>
<th>작성일</th>
</tr>
<c:forEach var="a" items="${ Article.reps }">
<tr>
<td>${ a.num }</td>
<td><a href="${ pageContext.request.contextPath }/board/detail?bnum=${a.num}">${ a.title }</a></td>
<td>${ a.writer }</td>
<td>${ a.content }</td>
<td>${ a.w_date }</td>
</tr>
</c:forEach>
</table>

</body>
</html>