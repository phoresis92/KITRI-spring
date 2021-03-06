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

function calcTotal(){
var price = ${ p.price };
var quan = $('#quantity').val();

var result = price*quan;
	if(isNaN(result)){
		$('#totalPay').text("숫자를 입력해주세요!");
		
	}else{
		$('#totalPay').text(result);
		
	}
}//calcTotal end

var param = "num="+${ p.cate };
$.ajax({
	type: 'GET',
	url: '${pageContext.request.contextPath}/cate/getName',
	data: param,
	success: function(result){
		var data = JSON.parse(result);
		
		$('#ca').text(data.grand+" - "+data.pa+" - "+data.my);
		
	}
})


$(document).ready(function(){
	var originSrc = $('#mainImage').attr('src');
	
	$('.image').on('mouseover',function(){
		
		var imgSrc = $(this).attr('src');
		
		$('#mainImage').attr('src',imgSrc);
		
	})
	
	$('.image').on('mouseout', function(){
		
		$('#mainImage').attr('src',originSrc);
		
	})
});


</script>

<style>

.container{
	margin: 20px;
}

</style>

</head>
<body>


<div class="container">

	<div class="row">
	<h1>제품명 : ${ p.title }</h1>
	</div>
	<div class="float-right">제품번호 : ${ p.num }</div>
	<hr>
	<div class="row clearfix">
		<div class="float-left">
			<div class="row">
				<img id="mainImage" src="${ p.img1 }" height="300" width="300"/>
			</div>
			<c:if test="${ not empty p.img2 }">
				<img class="image" src="${ p.img2 }" height="100" width="100"/>
			</c:if>
			<c:if test="${ not empty p.img3 }">
				<img class="image" src="${ p.img3 }" height="100" width="100"/>
			</c:if>
			<c:if test="${ not empty p.img4 }">
				<img class="image" src="${ p.img4 }" height="100" width="100"/>
			</c:if>
		</div>

		<div class="float-right" style="border-left:1px solid gray; margin:20px; padding: 10px;">
			<p>판매자 : ${ p.seller }</p>
			<p>재고 수량 : ${ p.quantity }</p>
			<p>종류 : <span id="ca"></span></p>
			<hr>
			<p>판매가격 : <span id="price">${ p.price }</span></p>
			<p>주문수량 : <input type="text" id="quantity" onkeyup="calcTotal()"></p>
			<p>결제금액 : <span id="totalPay"></span></p>
			<hr>
			<span><button>장바구니 추가</button><button>바로구매</button></span>
			<hr>
		</div>	
	
	</div>
	
	<hr>
	
	<div>
	
	<h2>제품 상세 내용</h2>
	<p>${ p.content }</p>
	
	</div>

</div>



</body>
</html>