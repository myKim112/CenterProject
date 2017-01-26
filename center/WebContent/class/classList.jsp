<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>노곰문화센터</title></head>


<body>
<table border="0" width="900" cellpadding="0" cellspacing="0" align="center"style="table-layout:fixed">
<tr>
<td align="right" >
<c:if test="${sessionScope.centerId == admin }">
<a href="classWriteForm.kiki">글쓰기</a>
</c:if>
</td></tr></table>



<table border="0" width="900" cellpadding="0" cellspacing="0" align="center"style="table-layout:fixed">
<hr align="center" style="border: solid 1px red;" WIDTH="900">
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
<hr align="center" style="border: solid 0.5px lightgray;"WIDTH="900">
<c:if test="${count == 0}">
<table border="0" width="900" cellpadding="0" cellspacing="0" align="center"style="table-layout:fixed">
 	<tr>
    <td align="center">
      	개설된 강좌가 없습니다.
   </td></tr>
</table>
</c:if>
<c:if test="${count > 0}">
<c:forEach var="dto" items="${articleList }">
<table border="0" width="850" cellpadding="0" cellspacing="0" align="center"style="table-layout:fixed">
<tr>
<td colspan="2" align="center">${dto.num }</td>
<td colspan="3" align="center">${dtocenter }</td>
<td colspan="4" align="center">${dto.classNum}</td>
<td colspan="15" align="center">${dto.className }</td>
<td colspan="4" align="center">${dto.teacher }</td>
<td colspan="4" align="center">${dto.classDate }</td>
<td colspan="4" align="center">${dto.classTime }</td>
<td colspan="3" align="center">${dto.classPay }</td>
<td colspan="2" align="center">${dto.person }</td>
<td colspan="2" align="center">${dto.lev }</td>
<td colspan="4" align="center">${dto.ask }
<input type="button" value="수강신청"onclick="javascript:window.location='classAsk.kiki'"></td>
</tr></table>
<hr align="center" style="border: solid 0.5px lightgray;"WIDTH="850">
</c:forEach>
</c:if>

<c:if test="${count > 0}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if> 
          
   <c:if test="${startPage > 10}">
        <a href="classList.kiki?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="classList.kiki?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="classList.kiki?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>




</body>
</html>