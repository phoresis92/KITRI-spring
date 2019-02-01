<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

[
<c:forEach var="r" items="${ reps }" varStatus="stat">
<c:if test="${not stat.first }">,</c:if>

{
	"num":${ r.num },
	"img_num":${ r.img_num },
	"writer": "${ r.writer }",
	"content": "${ r.content }"
}

</c:forEach>
]