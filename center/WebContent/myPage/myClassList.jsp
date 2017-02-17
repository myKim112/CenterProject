<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" flush="false" /> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>노곰문화센터</title>
</head>
<link href="style.css" rel="stylesheet" type="text/css">
<body>
<h1 id="customer">
<div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
 <h2>내 강좌보기</h2>

<table id="cbbs_f" align="center" border="1" width="700" cellpadding="0" cellspacing="0" align="center">
	<tr>
	<td align="center"  width="50" >번호</td>
    <td align="center"  width="50" >지점</td>
    <td align="center"  width="50" >강좌코드</td>
    <td align="center"  width="50" >강좌명</td>
    <td align="center"  width="50" >강사</td>
    <td align="center"  width="50" >강좌기간</td>
    <td align="center"  width="50" >강좌시간</td>
    <td align="center"  width="50" >결제금액</td>
    <td align="center"  width="50" >인원</td>
    <td align="center"  width="50" >수강취소</td>
    
    </tr>
    </table>
    <c:if test="${count == 0}">
	<table id="cbbs_f" align="center" width="700" border="1" cellpadding="0" cellspacing="0">
	<tr>
	<td align="center"> 신청하신 강좌가 없습니다.</td></tr>
</table>
</c:if>
    <c:if test="${count > 0 }">
    <c:forEach var="dto" items="${articleList }">
    <table id="cbbs_f" align="center" border="1" width="700" cellpadding="0" cellspacing="0" align="center">
    
    <tr>
	  <td colspan="2" align="center"><c:out value="${dto.num}"/>
      <c:set var="num" value="${number - 1}"/></td>
      <td align="center"  width="50" >${dto.center} </td>
	  <td align="center"  width="50" >${dto.classCode } </td>
      <td align="center"  width="50" ><a href="classContent.kiki?classCode=${dto.classCode}&pageNum=${pageNum}">${dto.className }</a></td>
      <td align="center"  width="50" >${dto.teacher}</td>
      <td align="center"  width="50" >${dto.classDate} </td>
   	  <td align="center"  width="50" >${dto.classTime}</td>
   	  <td align="center"  width="50" >${dto.sum}</td>
      <td align="center"  width="50" >${dto.memberCount}</td>
      <td align="center"  width="50" ><input type="button" value="수강취소"onclick="javascript:window.location='myAppListDel.kiki?classCode=${dto.classCode}'"></td>
	</tr>
</table>

</c:forEach>
</c:if> 
</article>
</body>
<%--
<center>
<c:if test="${count > 0}">
<c:set var="pageCount" value="${count/pageSize + ( count % pageSize == 0 ? 0 : 1)}"/> 
<c:set var="pageBlock" value="${10}"/>

<fmt:parseNumber var="result" value="${currentPage /10 }" integerOnly="true"/>

<c:set var="startPage" value="${result*10+1}"/>
<c:set var="endPage" value="${startPage*pageBlock-1}"/>
</c:if>

<c:if test="${endPage > pageCount}">
<c:set var="endPage" value="${pageCount }"/>
</c:if>

<c:if test="${startPage > 10}">
<a href="myClassList.kiki?pageNum=${startPage - 10 }">[이전]</a>
</c:if>

<c:forEach var="i" begin="${startPage}" end="${endPage}">
<a href="myClassList.kiki?pageNum=${i}">[${i}]</a>
</c:forEach>

<c:if test="${endPage < pageCount}">
<a href="myClassList.kiki?pageNum=${startPage + 10}">[다음]</a>
</c:if>
</center>
 --%>
</article>
<jsp:include page="footer.jsp" flush="false" />