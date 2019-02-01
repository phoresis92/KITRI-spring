<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	
	function time(){
		$.ajax({
			type:'POST',
			url: '${ pageContext.request.contextPath }/time',
			success: function(data){
				//console.log(data);
				$('#time').text(data);
			}
		})
	}
	
	setInterval(function(){
		time();
	}, 1000); 	
	
	</script>
	
</head>
<body>

<c:choose>
<c:when test="${not empty data }">
<h1 id="time">${ data } 님 환영합니다!!!</h1>
</c:when>
<c:otherwise>
<h1>안녕</h1>
</c:otherwise>
</c:choose>
</body>
</html>
