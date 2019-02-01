<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

[
<c:forEach var="p" items="${ list }" varStatus="stat">
<c:if test="${not stat.first }">,</c:if>

{
	"num":${ p.num },
	"title":"${ p.title }",
	"seller": "${ p.seller }",
	"cate": ${ p.cate },
	"quantity": ${ p.quantity },
	"content": "${ p.content }",
	"price": ${ p.price },
	"img1": "${ p.img1 }",
	"img2": "${ p.img2 }",
	"img3": "${ p.img3 }",
	"img4": "${ p.img4 }"
}


</c:forEach>
]