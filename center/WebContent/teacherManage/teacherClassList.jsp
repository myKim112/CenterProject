<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" flush="false" /> 
<head>
<title>강사 관리</title>
</head>

<body>
<h1 id="customer"><div>master center</div></h1>
<jsp:include page="sidebar_teacher.jsp" flush="false" />
<article>
<h2>강의목록</h2>
<table id="cbbs_f">
	<tr>
		<td>번호</td>
		<td>지점</td>
		<td>강좌코드</td>
		<td>강좌명</td>
		<td>강사</td>
		<td>강좌기간</td>
		<td>강좌시간</td>
		<td>인원</td>
		<td>구분</td>
		<td>상태</td>
	</tr>
</table>

<c:if test="${count == 0}">
<table id="cbbs_f">
	<tr>
		<td align="center">
			강좌 이력이 없습니다.
		</td>
	</tr>
</table>
</c:if>

<c:if test="${count > 0}">
<table id="cbbs_f">
<c:forEach var="staff" items="${classList}">
	<tr>
		<td>
			<c:out value="${number}" />
			<c:set var="number" value="${number-1}"/>
		</td>
		<td>${staff.center}</td>
		<td>${staff.classCode}</td>
		<td>
			<a href="memberCheck.kiki?classCode=${staff.classCode}&id=${id}">${staff.className}</a>
		</td>
		<td>${staff.teacher}</td>
		<td>${staff.classDate}</td>
		<td>${staff.classTime}</td>
		<td>${staff.person}</td>
		<td>${staff.lev}</td>
		<td>${staff.state}</td>
	</tr>
</c:forEach>
</table>
</c:if>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>


<table align="center" width="1000" border="1">
	<tr>
		<td align="right">
			<input type="button" value="목록보기" onclick="window.location='taecherList.kiki'" />
		</td>
	</tr>
</table>
</body>

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
			<a href="teacherClassList.kiki?pageNum=${startPage-10}">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="teacherClassList.kiki?pageNum=${i}">[${i}]</a>
		</c:forEach>

		<c:if test="${endPage < pageCount}">
			<a href="teacherClassList.kiki?pageNum=${startPage+10}">[다음]</a>
		</c:if>
	</c:if>
</center>