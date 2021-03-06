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

$.mkRepList = function(img_num){
	var param = "img_num="+img_num;
	$.ajax({
		type: "POST",
		url: "${pageContext.request.contextPath}/imgRep/list",
		data: param,
		success:function(data){
			var arr = eval('('+data+')');
			var str = "";
			for(i = 0 ; i < arr.length ; i++){
				str += arr[i].content + "(writer:"+arr[i].writer+")<br />"
			}
			$('#repList_'+img_num).html(str);
		}
		
	});//ajax end
}

$(document).ready(function(){
	
	$('.rep_btn').click(function(){
		
		var img_num = $(this).attr('num');
		var writer = '${ sessionScope.id }';
		var content = $('#content_'+img_num).val();
		if(content == ''){
			return;
		}
		//console.log(content);
		var param = "img_num="+img_num;
		param +="&writer="+writer;
		param +="&content="+content;
		$.ajax({
			type: "POST",
			url: "${pageContext.request.contextPath}/imgRep/add",
			data: param,
			success:function(data){
 				var arr = eval('('+data+')');
				var str = "";
				for(i = 0 ; i < arr.length ; i++){
					str += arr[i].content + "(writer:"+arr[i].writer+")<br />"
				}
				$('#repList_'+img_num).html(str);
				$('#content_'+img_num).val('');
			}
			
		});//ajax end
	})
	
	
	
})//ready end

</script>

</head>
<body>
<h3>글목록</h3>
<c:if test="${empty frId }">
<a href="${pageContext.request.contextPath}/imgBoard/writeForm">글작성</a>
</c:if>
<table border="1">
<c:forEach var="ib" items="${ list }">
<tr><td>
<table border="1">
<tr><th>num</th><td><input type="text" value="${ib.num }" name="num" readonly></td></tr>
<tr><th>writer</th><td><input type="text" value="${ib.writer }" name="writer" readonly></td></tr>
<tr><th>w_date</th><td><input type="text" value="${ib.w_date }" name="w_date" readonly></td></tr>
<tr><th>title</th><td><input type="text" value="${ib.title }" name="title"></td></tr>
<tr><th>img</th><td><img src="${ib.img_path }" width="200" height="200"></td></tr>
<tr><th>content</th><td><input type="text" value="${ib.content }" name="content"></td></tr>
<tr><th>댓글작성</th><td><input type="text" id="content_${ib.num }">
<input type="button" class="rep_btn" value="작성" num="${ib.num }"></td></tr>
<tr><th>댓글목록</th><td><div id="repList_${ib.num }"></div></td></tr>
</table>
</td></tr>
<script>$.mkRepList('${ib.num }');</script>
</c:forEach>
</table>
</body>
</html>