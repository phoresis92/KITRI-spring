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
$.ajax({
	type: 'get',
	url: '${pageContext.request.contextPath}/cate/cate1',
	success: function(data){
		//console.log(data);
		$('#medium').empty();
		$('#small').empty();
		var list = JSON.parse(data);
		//console.log(list);
		$('<option disabled selected >대분류</option>').appendTo('#large');
		for(var i in list){
			$('<option></option>').val(list[i].num).text(list[i].name).appendTo('#large');
		};
	}
})

function getM(){
var param = "parent="+$('#large').val();
//console.log(param);
	$.ajax({
		type: 'get',
		url: '${pageContext.request.contextPath}/cate/cate2',
		data: param,
		success: function(data){
			$('#medium').empty();
			$('#small').empty();
			var list = JSON.parse(data);
			//console.log(list);
			$('<select id="medi"></select>').attr('onchange','getS()').appendTo('#medium');
			$('<option disabled selected >중분류</option>').appendTo('#medi');
			for(var i in list){
				$('<option></option>').val(list[i].num).text(list[i].name).appendTo('#medi');
			};
		}
	})//ajax end
}//getM end

function getS(){
	var param = "parent="+$('#medi').val();
	//console.log(param);
	$.ajax({
		type: 'get',
		url: '${pageContext.request.contextPath}/cate/cate2',
		data: param,
		success: function(data){
			$('#small').empty();
			var list = eval(data);
			//console.log(list);
			$('<select id="sm"></select>').appendTo('#small');
			$('<option disabled selected >소분류</option>').appendTo('#sm');
			for(var i in list){
				$('<option></option>').val(list[i].num).text(list[i].name).appendTo('#sm');
			};
		}
	})//ajax end
}//getS end 

$(document).ready(function(){
	$('#large').click(function(){
		getM();
	})
})

function go(){
	
	var cate = $('#sm').val();
	console.log(Number(cate))
	$('#cateInput').val(cate);
	
	$('#go').submit();
	
}



</script>

</head>
<body>

<form action="${pageContext.request.contextPath }/product/add" method="post" id="go" enctype="multipart/form-data">
	title: <input type="text" name="title"> <br>
	seller: <input type="text" name="seller" value="${ sessionScope.id }" readonly> <br>
	category: 
		<select class="cate" id="large" name="type" ></select>
		<span  id="medium"></span>
		<span  id="small"></span> <br>
	quantity: <input type="text" name="quantity"> <br>
	content: <input type="text" name="content"> <br>
	price: <input type="text" name="price"> <br>
	
	img1: <input type="file" name="file1"> <br>
	img2: <input type="file" name="file2"> <br>
	img3: <input type="file" name="file3"> <br>
	img4: <input type="file" name="file4"> <br>
	
	<input type="hidden" name="cate" id="cateInput">
</form>
	<button onclick="go()">등록</button>

</body>
</html>