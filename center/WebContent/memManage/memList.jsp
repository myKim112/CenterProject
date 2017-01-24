<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<title>회원관리</title>
</head>

<center>
<font size="20" face="impact">
MEMBER LIST</font>
</center>

<body>
<table align="center" width="500" border="1">
	<tr>
	<td align="center" colspan="3">전체 회원 수(${count})</td>
	</tr>
	<tr>
	<td>번호</td>
	<td>ID</td>
	<td>이름</td>
	</tr>
</table>
<c:if test="${count == 0}">
<table align="center" width="500" border="1">
	<tr>
	<td align="center">
		등록된 회원이 없습니다.
	</td>
</table>
</c:if>

<c:if test="${count > 0}">
<table align="center" width="500" border="1">
<c:forEach var="article" items="${articleList}">
	<tr>
	<td><c:out value="${num}"/>
		<c:set var="num" value="${num-1}" />
	<input type="hidden" name="num" value="${num}"/>
	</td>	
	<td><a href="memInf.kiki?id=${article.id}&num=${num}&pageNum=${pageNum}">${article.id}</a></td>
	<td>${article.name}</td>
	</tr>
</c:forEach>
</table>
</c:if>
</body>

<center>
<c:if test="${count>0}">
	<c:set var="pageCount" value="${count/pageSize+(count%pageSize == 0 ? 0 : 1)}" />
	<c:set var="pageBlock" value="${10 }"/>
	<fmt:parseNumber var="result" value="${currentPage/10}" integerOnly="true"/>
	<c:set var="startPage" value="${result*10+1}"/>
	<c:set var="endPage" value="${startPage+pageBlock-1}" />
	<c:if test="${endPage > pageCount}">
		<c:set var="endPage" value="${pageCount}"/>
	</c:if>
	
	<c:if test="${startPage > 10}">
		<a href="/memList.kiki?pageNum=${startPage-10}">[이전]</a>
	</c:if>
	
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="/memList.kiki?pageNum=${i}">[${i}]</a>
	</c:forEach>
	
	<c:if test="${endPage < pageCount}">
		<a href="/memList.kiki?pageNum=${startPage+10}">[다음]</a>
	</c:if>
</c:if>
</center>