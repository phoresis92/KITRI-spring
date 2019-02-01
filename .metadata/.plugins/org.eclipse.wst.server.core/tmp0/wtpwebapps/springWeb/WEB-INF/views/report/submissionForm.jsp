<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>파일 업로드</h2>

	<form action="${ pageContext.request.contextPath }/report/submitReport3" method="post" enctype="multipart/form-data">
	
	<label for="studentNumber">학번 : </label>
	<input type="text" name="studentNumber" > <br>
	<label for="report">파일 : </label>
	<input type="file" name="report"> <br>
	
	<input type="submit" value="제출">
	</form>

</body>
</html>