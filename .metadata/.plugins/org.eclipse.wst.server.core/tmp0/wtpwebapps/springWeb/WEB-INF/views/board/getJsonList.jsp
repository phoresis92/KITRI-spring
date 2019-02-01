<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	[
	<c:forEach var="i" items="${ list }" varStatus="stat" >
		<c:if test="${ not stat.first }">,</c:if>
	
    { 
    "num": ${ i.num},
    "w_date": '${ i.w_date }',
    "title":'${ i.title }',
    "writer":'${ i.writer }',
    "content": '${ i.content }'
    }
    </c:forEach>
    ]