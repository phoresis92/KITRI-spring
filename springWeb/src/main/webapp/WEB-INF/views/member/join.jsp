<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
var idChk = 0;
function idKey(){

$.ajax({
	type: 'GET',
	url: './idCheck',
	data:{
		"inputId": $('#id').val()
	},
	success: function(data){
		console.log(data)
		if(data == 'yes'){
			$('#idResult').html('아이디사용가능');
			idChk = 1;
		}else{
			$('#idResult').html('기존의 아이디가 있습니다');
			idChk =0;
		}
	}
});

};

function regi(){
	
	if($('#id').val()==''||$('#pwd').val()==''||$('#name').val()==''||$('#email').val()==''){
		alert("공백을 입력해 주세요");
		return;
			
	}
	
	
	
	if(idChk == 1){
		$('#go').submit();
	}else{
		alert('아이디 중복체크를 확인하세요');
		return;
	}
}

function login(){
	location.href="./login";
}

</script>

</head>
<body>

	<form action="${ pageContext.request.contextPath }/member/join" method="post" id="go">
	id : <input type="text" name="id" id="id" onkeyup="idKey()" onkeydown="idKey()"><span id="idResult"></span> <br>
	pwd : <input type="password" id="pwd" name="pwd"><br>
	name : <input type="text" id="name" name="name"><br>
	email : <input type="text" id="email" name="email"><br>
	</form>
	<button type="submit" onclick="regi()">Sign up</button>
	<button onclick="login()">Sign in</button>

</body>
</html>