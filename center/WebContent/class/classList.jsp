<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" flush="false" /> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>노곰문화센터</title></head>


<body>
<h1 id="customer"><div>lecture center</div></h1>
<jsp:include page="sidebar_lecture.jsp" flush="false" />
<article>
<h2>강좌목록</h2>

<c:if test="${staff.lev >= 500}">
<table align="center" width="650">
	<tr>
		<td align="right">
			<a href="classWrite.kiki">글쓰기</a>
		</td>
	</tr>
</table>
</c:if>

<table border="0" width="650" cellpadding="0" cellspacing="0" align="center"style="table-layout:fixed">
<hr align="center" style="border: solid 1px red;" WIDTH="650">
<tr>
<td colspan="2" align="center">번호</td>
<td colspan="3" align="center">지점</td>
<td colspan="4" align="center">강좌번호</td>
<td colspan="15" align="center">강좌명</td>
<td colspan="4" align="center">강사명</td>
<td colspan="4" align="center">강좌기간</td>
<td colspan="4" align="center">강좌시간</td>
<td colspan="3" align="center">수강료</td>
<td colspan="2" align="center">인원</td>
<td colspan="2" align="center">등급</td>
<td colspan="4" align="center">접수상태</td>
</tr>
</table>
<hr align="center" style="border: solid 0.5px lightgray;"WIDTH="650">
<c:if test="${count == 0}">
<table border="0" width="650" cellpadding="0" cellspacing="0" align="center"style="table-layout:fixed">
 	<tr>
    <td align="center">
      	개설된 강좌가 없습니다.
   </td></tr>
</table>
</c:if>
<c:if test="${count > 0}">
<c:forEach var="dto" items="${articleList }">
<table border="0" width="650" cellpadding="0" cellspacing="0" align="center"style="table-layout:fixed">
<tr>
<td colspan="2" align="center"><c:out value="${number}"/>
<c:set var="number" value="${number - 1}"/></td>
<td colspan="3" align="center">${dto.center }</td>
<td colspan="4" align="center">${dto.classCode}</td>
<td colspan="15" align="center">
<a href="classContent.kiki?num=${dto.num}&pageNum=${currentPage}">${dto.className }</a></td>
<td colspan="4" align="center">${dto.teacher }</td>
<td colspan="4" align="center">${dto.classDate }</td>
<td colspan="4" align="center">${dto.classTime }</td>
<td colspan="3" align="center">${dto.classPay }</td>
<td colspan="2" align="center">${dto.person }</td>
<td colspan="2" align="center">${dto.lev }</td>
<td colspan="4" align="center">${dto.reference }

<input type="button" value="수강신청"onclick="javascript:window.location='appList.kiki?classCode=${dto.classCode}'"></td>
</tr></table>
<hr align="center" style="border: solid 0.5px lightgray;"WIDTH="650">
</c:forEach>
</c:if>

<form method="post">
<table align="center" width="650">
	<tr>
		<td align="center">
			<select name="search">
				<option value="0">강사</option>
				<option value="1">제목</option>
				<option value="2">지점</option>
			</select>
			<input type="text" name="searchContent" size="15" maxlength="50" />
			<input type="hidden" value="${searchContent}" />
			<input type="submit" value="검색" />
		</td>
	</tr>
</table>
</form>

</body>
</html>


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
</center>

</article>
<jsp:include page="footer.jsp" flush="false" />
</html>
