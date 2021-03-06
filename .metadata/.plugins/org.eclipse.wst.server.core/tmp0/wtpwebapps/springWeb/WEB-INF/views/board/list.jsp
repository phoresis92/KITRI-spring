<%@page import="com.kitri.app1.board.Article"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:set var="list" value="${ list }" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>


function search(){
	
	if($('#key').val() == ''){
		alert('검색어를 입력하세요!');
		return;
	}

	var what = $('#what').val();
	var ur = '';
	if(what== 'writer'){
		ur = 'http://localhost/app1/board/search/writer';
	}else if(what == 'title'){
		ur = 'http://localhost/app1/board/search/title';
	}
	
	$.ajax({
		'type': 'post',
		'url': ur,
		data:{
			key: $('#key').val()
		},
		success: function(data){
			
			var list = JSON.parse(data);
			//console.log(list);
			$('#list').empty();
			$('#paging').empty();
			for(var a in list){
				//console.log(list[a]);
				$('<tr class="pre_view" num="'+list[a].num+'"></tr>').attr('id',list[a].num).appendTo($('#list'));
				$('<td></td>').text(list[a].num).appendTo($('#'+list[a].num+''))
				$('<td></td>').text(list[a].writer).appendTo($('#'+list[a].num+''))
				$('<td></td>').attr('id',list[a].num+'aa').appendTo($('#'+list[a].num+''))
				$('<a></a>').attr('href','http://localhost/app1/board/detail?bnum='+list[a].num).text(list[a].title).appendTo($('#'+list[a].num+'aa'))
				$('<td></td>').text(list[a].w_date).appendTo($('#'+list[a].num+''))
				
			}
			
			
		}
	})//ajax end
}//search end


function btnX(){
	
	window.location.reload();
	
}

var cursorX;
var cursorY;
document.onmousemove = function(e){
    cursorX = e.pageX;
    cursorY = e.pageY;
}

    
/* setInterval(checkCursor, 1000);
function checkCursor(){
    console.log("Cursor at: " + cursorX + ", " + cursorY);
} */


$(document).ready(function(){

	$('.pre_view').mouseover(function(){
		var num = $(this).attr('num');
		var param = "num="+num;
		$.ajax({
			type: 'POST',
			url: '${ pageContext.request.contextPath}/board/getArticle',
			data: param,
			success: function(data){
				console.log(data);
				var obj = eval('('+data+')');
				var str = "";
				str += "num: "+obj.num;
				str += "<br/>writer: "+obj.writer;
				str += "<br/>w_data: "+obj.w_date;
				str += "<br/>title: "+obj.title;
				str += "<br/>content: "+obj.content;
				str += "<button onclick='close()' >닫기</button>"
				$('#pre_view_result').html(str);
				$('#pre_view_result').css("left",cursorX);
				$('#pre_view_result').css("top",cursorY);
				$('#pre_view_result').css("display","block");
				
				
			}
		});
		
	})//mouseover
	$('.pre_view').mouseout(function(){
		$('#pre_view_result').html('');
		$('#pre_view_result').css('display',"none");
	})
	

	
	
	//==============================================================================
		
		$('#search').click(function(){
		var w = $('#word').val();
		var type = $('input:radio[name="ra"]:checked').val();
		var param = "type="+type+"&word="+w;
		console.log(param)
		$.ajax({
			type: 'POST',
			url: '${ pageContext.request.contextPath}/board/getJsonList',
			data: param,
			success: function(data){
				console.log(data);
				var arr = eval('('+data+')');
				var x = "<a href='${pageContext.request.contextPath}/board/detail?bnum=";
				var str = "<table border= '1'";
				str += "<tr><td>num</td><td>title</td><td>writer</td></tr>"
				for(i=0; i< arr.length; i++){
					str+= "<tr>";
					str+= "<td>"+arr[i].num+"</td>";
					str+= "<td>"+x+arr[i].num+"'>"+arr[i].title+"</a></td>";
					str+= "<td>"+arr[i].writer+"</td>";
					str+= "</tr>";
					
					$('#resultList').html(str);
					
				}
				
				
			}
		});//ajax end
		
		})//click end
		
		$('#clear').click(function(){
			$('#resultList').html('');
		});
	
	//==============================================================================

	
	
})



</script>

<style>

#pre_view_result{
	position: absolute;
	display: none;
	width: 300px;
	height: 200px;
	background-color: white;
	border: 1px solid black;
}

</style>

</head>
<body >


<button onclick="location.href='http://localhost/app1/member/lobby'">back</button>

<button onclick="location.href='http://localhost/app1/board/write'" >write</button> <br>

<input id="key" type="text"  >

<select id="what" >
<option value="writer">writer</option>
<option value="title">title</option>
</select>
<button onclick="search()">search</button>
<button onclick="btnX()">X</button>

<div id="pre_view_result"></div>

<table style="border:1px solid gray">
<tr >
<th>글번호</th>
<th>작성자</th>
<th>글제목</th>
<th>작성일</th>
</tr>
<tbody id="list">
<c:choose>
<c:when test="${fn:length(list) == 0 }"></c:when>
<c:otherwise>
<c:forEach var="item" begin="${ pInfo.startNum }" end="${pInfo.endNum }" items="${ list }" >


<tr class="pre_view" num="${ item.num }">
<td>
	${item.num }
</td>
<td>
	${item.writer }
</td>
<td >
	<a href="${ pageContext.request.contextPath }/board/detail?bnum=${item.num }">${item.title }</a>
</td>
<td>
	${item.w_date }
</td>
</tr>
</c:forEach>
</c:otherwise>
</c:choose>
</tbody>
</table>


<input type="text" id="word">
<input type="button" id="search" value="검색">
<form>
<input type="radio" name="ra" value="2">타이틀
<input type="radio" name="ra" value="1">writer
</form>
<input type="button" id="clear" value="검색결과지우기">
<div id="resultList"></div>

<div id="paging">

				
				<c:choose>
				<c:when test="${ pInfo.page <= 1 }">
									
				<button disabled="disabled">이전</button>
				</c:when>
				
				<c:otherwise>
				
				<button onclick="location='board?pnum=${pInfo.page -1 }'">이전</button>
				
				</c:otherwise>
				
				</c:choose>
				
				<!-- ============================================================= -->
		
				<c:forEach var="i" begin="${pInfo.startPage}" end="${pInfo.endPage}">
				
					<c:choose>
					<c:when test="${i eq pInfo.page }">
					
					<button disabled="disabled">${ i }</button>
					</c:when>
					
					<c:otherwise>
					
					<button onclick="location='board?pnum=${ i }'">${ i }</button>
					
					</c:otherwise>
					
					</c:choose>
				</c:forEach>
				
				<!-- ========================== -->
				
				
				
				<c:choose>
				
				<c:when test="${ pInfo.page >= pInfo.totalPage }">
				
				<button disabled="disabled">다음</button>
				
				</c:when>
				
				<c:otherwise>
				
				<button onclick="location='board?pnum=${pInfo.page +1}'">다음</button>

				</c:otherwise>
				
				</c:choose>
				
				<!-- =========================== -->
				<c:choose>
					<c:when test="${ pInfo.page eq 1 }">
				<div>
					<button disabled="disabled">처음페이지</button>
					<button onclick="location='./board?pnum=${pInfo.totalPage}'">마지막페이지</button>
				</div>
					</c:when>
				
					<c:when test="${ pInfo.page eq pInfo.totalPage }">
				<div>
					<button onclick="location='./board?pnum=1'">처음페이지</button>
					<button disabled="disabled" >마지막페이지</button>
				</div>
					</c:when>
					<c:otherwise>
				<div>
					<button onclick="location='./board?pnum=1'">처음페이지</button>
					<button onclick="location='./board?pnum=${pInfo.totalPage}'">마지막페이지</button>
				</div>
					</c:otherwise>
				</c:choose>

</div>



</body>
</html>