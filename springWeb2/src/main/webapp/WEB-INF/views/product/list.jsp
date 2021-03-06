<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<script>

// Convert category number To category Name
function cateName(id, num){
	var param = "num="+num;
	$.ajax({
		type: 'GET',
		url: '${pageContext.request.contextPath}/cate/getName',
		data: param,
		success: function(result){
			var data = JSON.parse(result);
			
			$('#ca'+id+'').text(data.grand+" - "+data.pa+" - "+data.my);
			
		}
	})
}//cateName end;


//Print Large Category Name
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
})// ajax end


//Get Medium Category Name
function getM(){
var param = "parent="+$('#large').val();
	console.log(param);
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
	
	//Searching Large Category
 	$.ajax({
		type: 'get',
		url: '${pageContext.request.contextPath}/product/searchLarge',
		data: param,
		success: function(data){
			console.log(data);
			var result = eval(data);
			console.log(result)
			
			printSearchResult(result);
			
		}//success
	})//ajax end 
	
}//getM end


//Get Small Category Name
function getS(){
	var param = "parent="+$('#medi').val();
	console.log(param);
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
	
	
	//Searching Medium Category
 	$.ajax({
		type: 'get',
		url: '${pageContext.request.contextPath}/product/searchMedium',
		data: param,
		success: function(data){
			console.log(data);
			var result = eval(data);
			console.log(result)
			
			printSearchResult(result);
			
		}//success
	})//ajax end 
	
	
	//Searching Small Category
	$(document).ready(function(){
		$(document).on('click','#sm',function(){
		
		var cate = $('#sm').val();
		var param = "cate="+cate;
		$.ajax({
			type: 'get',
			url: '${pageContext.request.contextPath}/product/searchCate',
			data: param,
			success: function(data){
				console.log(data);
				var result = eval(data);
				console.log(result)
				
				printSearchResult(result);
				
			}//success
		})//ajax end 
		
	});
	})//ready end
	
	
}//getS end 

//Click Event on large category 
$(document).ready(function(){
	$('#large').click(function(){
		getM();
	})
})


function printSearchResult(result){
	
	$('#tbody').empty();
	for(var i in result){
		
		$('<tr></tr>').attr('id',"row"+i).appendTo('#tbody');
		$('<td></td>').attr('id',"title"+i).appendTo('#row'+i+'');
		$('<a></a>').attr('href','${ pageContext.request.contextPath }/product/detail?num='+result[i].num+'').text(result[i].title).appendTo('#title'+i);
		$('<td></td>').text(result[i].seller).appendTo('#row'+i+'');
		$('<td></td>').attr('id','ca'+i).appendTo('#row'+i+'');
		$('<td></td>').text(result[i].price).appendTo('#row'+i+'');
		$('<td></td>').attr('id','img'+i).appendTo('#row'+i+'');
		$('<img></img>').attr('src',result[i].img1).css('width','100').css('height','100').appendTo('#img'+i+'');
		
		$("<script><//script>").text(cateName(i, result[i].cate));
		
	}
	
}

</script>

</head>
<body>
	
	<label>search : </label>
		<select class="cate" id="large" name="type"></select>
		<span  id="medium"></span>
		<span  id="small"></span> <br>
	
<table>


<thead>
<tr>
<th>TITLE</th>
<th>SELLER</th>
<th>CATE</th>
<th>PRICE</th>
<th>IMG1</th>
</tr>
</thead>

<tbody id="tbody">
<c:forEach var="i" items="${ list }">

<tr>
<td><a href="${ pageContext.request.contextPath }/product/detail?num=${ i.num }">${ i.title }</a></td>
<td>${ i.seller }</td>
<td><span id="ca${ i.num }"></span></td>	
<td>${ i.price }</td>
<td><img src="${ i.img1 }" height="100" width="100"/></td>
</tr>
<script>
cateName(${ i.num },${ i.cate });
</script>

</c:forEach>
</tbody>
 
</table>
	
		
</body>
</html>