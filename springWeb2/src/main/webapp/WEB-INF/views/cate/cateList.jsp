<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="item" items="${ list }" varStatus="stat">
<c:if test="${ not stat.first }">,</c:if>

{
	"num": ${ item.num },
	"name": "${ item.name }"
}

</c:forEach>
]