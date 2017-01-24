<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<title>회원 관리</title>
</head>

<center>
<font size="20" face="impact">
MEMBER CLASS
</font>
</center>

<body>
<table align="center" width="700">
	<tr>
	<td>번호</td>
	<td>지점</td>
	<td>강좌 코드</td>
	<td>강좌명</td>
	<td>강사</td>
	<td>강좌 기간</td>
	<td>강좌 시간</td>
	<td>인원</td>
	<td>구분</td>
	</tr>
</table>

<c:if test="${count == 0}">
<table align="center" width="700">
	수강한 강좌가 없습니다.
</table>
</c:if>

<c:if test="${count > 0}">
<table align="center" width="700">
<c:forEach var="article" items="${articleList}">
	<tr>
	<td><c:out value="${number}" />
		<c:set var="number" value="${number-1}"/></td>
	<td>${article.center}</td>
	<td>${article.classCode}</td>
	<td>${article.className}</td>
	<td>${article.teacher}</td>
	<td>${article.classDate}</td>
	<td>${article.classTime}</td>
	<td>${article.person}</td>
	<td>${article.lev}</td>
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