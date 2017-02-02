<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<title>회원 관리</title>
</head>

<body>
<table align="center" width="700">
	<tr>
	<td>번호</td>
	<td>지점</td>
	<td>작성자</td>
	<td>제 목</td>
	<td>작성일</td>
	<td>조회수</td>
	</tr>
</table>

<c:if test="${count == 0}">
<table align="center" width="700">
	작성된 글이 없습니다.
</table>
</c:if>

<c:if test="${count > 0 }">
<table align="center" width="700">
<c:forEach var="article" items="${articleList}">
	<tr>
	<td>
		<c:out value="${number}"/>
		<c:set var="number" value="${number-1}" />
	</td>
	<td>${article.center}</td>
	<td>${article.writer}</td>
	<td>${article.title}</td>
	<td>${article.regDate}</td>
	<td>${article.readCount}</td>
	</tr>
</c:forEach>
</table>
</c:if>
</body>

<center>
<c:if test="${count > 0}">
	<c:set var="pageCount" value="${count/pageSize+(count%pageSize == 0 ? 0 : 1)}"/>
	<c:set var="pageBlock" value="${10}"/>
	<fmt:parseNumber var="result" value="${currentPage/10}" integerOnly="true" />
	<c:set var="startPage" value="${result*10+1}" />
	<c:set var="endPage" value="${startPage+pageBlock-1}" />
	<c:if test="${endPage > pageCount}">
		<c:set var="endPage" value="${pageCount}"/>
	</c:if>
	
	<c:if test="${startPage > 10}">
		<a href="/memWriteList.kiki?pageNum=${startPage-1}">[이전]</a>
	</c:if>
	
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="/memWriteList.kiki?pageNum=${i}">[${i}]</a>
	</c:forEach>
	
	<c:if test="${endPage > pageCount}">
		<a href="/memWriteList.kiki?pageNum=${startPage+10}">[다음]</a>
	</c:if>
</c:if>
</center>
