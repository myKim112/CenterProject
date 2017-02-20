<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" flush="false" /> 
<head>
<title>회원관리</title>
</head>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_master.jsp" flush="false" />
<article>
<h2>회원 목록</h2>
<table id="cbbs_f">
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
<table id="cbbs_f">
	<tr>
	<td align="center">
		등록된 회원이 없습니다.
	</td>
</table>
</c:if>

<c:if test="${count > 0}">
<table id="cbbs_f">
<c:forEach var="article" items="${articleList}" varStatus="i">
	<tr>
	<td>${i.count}
<%--	<c:set var="num" value="${num-1}" />
		<input type="hidden" name="num" value="${num}"/> --%>
	</td>	
	<td><a href="memInf.kiki?id=${article.id}&pageNum=${pageNum}">${article.id}</a></td>
	<td>${article.name}</td>
	</tr>
</c:forEach>
</table>
</c:if>
</body>
<center>

<div id="page">
<ul class="paging">
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
		<li><a href="/memList.kiki?pageNum=${startPage-10}">[이전]</a></li>
	</c:if>
	
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<li><a href="/memList.kiki?pageNum=${i}">${i}</a></li>
	</c:forEach>
	
	<c:if test="${endPage < pageCount}">
		<li><a href="/memList.kiki?pageNum=${startPage+10}">[다음]</a></li>
	</c:if>
</c:if>
</ul>
</div>
</center>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>
