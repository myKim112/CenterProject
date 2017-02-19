<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" />

<head>
<title>강좌 관리</title>
</head>

<body>
<h1 id="customer"><div>master center</div></h1>
<jsp:include page="sidebar_master.jsp" flush="false" />
<article>

<h2>강좌 목록</h2>

<table>
	<tr>
		<td>
			<a href="classWrite.kiki">강좌 등록하기</a>
		</td>
	</tr>
</table>

<table id="cbbs_f">
	<tr>
		<td>번호</td>
		<td>지점</td>
		<td>강좌번호</td>
		<td>강좌명</td>
		<td>강사명</td>
		<td>강좌기간</td>
		<td>강좌시간</td>
		<td>수강료</td>
		<td>인원</td>
		<td>등급</td>
		<td>강의삭제</td>
	</tr>
<c:forEach var="article" items="${articleList}">
	<tr>
		<td>
			<c:out value="${number}" />
			<c:set var="number" value="${number -1}"/>
		</td>
		<td>${article.center}</td>
		<td>${article.classCode}</td>
		<td>
			<a href="classManageChoice.kiki?num=${article.num}&pageNum=${currentPage}&classCode=${article.classCode}">${article.className}</a>
		</td>
		<td>${article.teacher}</td>
		<td>${article.classDate}</td>
		<td>${article.classTime}</td>
		<td>${article.classPay}</td>
		<td>${article.person}</td>
		<td>${article.lev}</td>
		<td>
			<input type="button" value="강좌 삭제" onclick="window.location='classManageDelete.kiki?classCode=${article.classCode}&pageNum=${currentPage}'" />
		</td>
	</tr>	
</c:forEach>
</table>

<center>
<c:if test="${count>0}">
		<c:set var="pageCount"
			value="${count/pageSize+(count%pageSize == 0 ? 0 : 1)}" />
		<c:set var="pageBlock" value="${10 }" />
		<fmt:parseNumber var="result" value="${currentPage/10}"
			integerOnly="true" />
		<c:set var="startPage" value="${result*10+1}" />
		<c:set var="endPage" value="${startPage+pageBlock-1}" />
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>

		<c:if test="${startPage > 10}">
			<a href="classList.kiki?pageNum=${startPage-10}">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="classList.kiki?pageNum=${i}">[${i}]</a>
		</c:forEach>

		<c:if test="${endPage < pageCount}">
			<a href="classList.kiki?pageNum=${startPage+10}">[다음]</a>
		</c:if>
</c:if>
<center>

<br>

<form method="post">
<table align="center" width="650">
	<tr>
		<td align="center">
			<select name="search">
				<option value="0">강사</option>
				<option value="1">강좌</option>
				<option value="2">지점</option>
			</select>
			<input type="text" name="searchContent" size="15" maxlength="50" />
			<input type="hidden" value="${searchContent}" />
			<input type="submit" value="검색" />
		</td>
	</tr>
</table>
</form>
	
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>