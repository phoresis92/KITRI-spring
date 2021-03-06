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
	
	$(document).ready(function(){
		
	$('#main').click(function(){
		location.href="${pageContext.request.contextPath}/";
	})

	})//ready end
	
	</script>
	
</head>
<body>

	<h1 id="main" style="cursor: pointer; margin: 20px">Young#</h1>
	
	<div align="right">
	
	<span id="time">${ serverTime }</span>
	
		<c:choose>
		<c:when test="${ empty sessionScope.id }">
	<button onclick="location.href='${ pageContext.request.contextPath }/member/login'">Sign In</button>
	<button onclick="location.href='${ pageContext.request.contextPath }/member/join'">Sign Up</button>
		</c:when>
		<c:otherwise>
	<button onclick="location.href='${ pageContext.request.contextPath }/member/myMenu'">My Menu</button>
	<button onclick="location.href='${ pageContext.request.contextPath }/member/logout'">Log Out</button>		
		</c:otherwise>
		</c:choose>
	</div>

</body>
</html>