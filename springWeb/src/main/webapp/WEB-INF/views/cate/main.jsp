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

/* function getM(){
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
}//getS end */

/* $(document).ready(function(){
	$('option').first().on('click', getM());
}) */

$.makeSelect=function(arr, id){
	var new_id = "";
	var s_name = "";
	var title = "";
	if(id == "large"){
		new_id = "medium";
		s_name = "#s2";
		//$(s_name).html('')
		$('#small').html('');
		title = '중분류';
	}else if(id == "medium"){
		new_id = "small";
		s_name = "#s3";
		title = '소분류';
	}
	var str = "<select class='cate' id='"+new_id+"'>";
	str += "<option selected disabled>"+title+"</option>"
	for(i=0; i< arr.length; i++){
		str += "<option value="+arr[i].num+">"+arr[i].name+"</option>";
	}
	str += "</select>";
	console.log(new_id)
	console.log(str)
	//$(s_name).html(str)
	$('#'+new_id+'').html(str);
}

$(document).ready(function(){
	$(document).on('change','.cate',function(){
		var id = $(this).attr('id');
		var parent = $(this).val();
		console.log(id, parent)
		if(id != "small"){
			var param = "parent="+parent;
			$.ajax({
				type: 'post',
				url: '${pageContext.request.contextPath}/cate/cate2',
				data: param,
				success: function(data){
					var arr = eval('('+data+')');
					console.log(arr)
					$.makeSelect(arr, id);
					
				}
			})//ajax end
		}
	})// on end
})//ready end

</script>


</head>
<body>

<div class="categoryDiv">
		<select class="cate" id="large" name="type" >
		<option selected disabled >대분류</option>
	<c:forEach var="SearchType" items="${ LargeTypeList }">
	
	<option value="${ SearchType.code }" >${ SearchType.text }</option>
	
	</c:forEach>
	</select>

<div  id="medium"></div>
<div  id="small"></div>
</div>
</body>
</html>