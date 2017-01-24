<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<title>노곰문화센터</title>
</head>

<link href="style.css" rel="stylesheet" type="text/css">

<center>
<b>나의 게시글 목록(전체 글:${count})</b>
</center>

<body>
<c:if test="${sessiontScopeId !=null }">
<table width="700" align="center">
	<tr>
	<td align="right">
		<a href="classwriteForm.kiki">글쓰기</a>
	</td></tr>
</table>
</c:if>

<c:if test="${count == 0}">
<table width="700" align="center" border="1" cellpadding="0" cellspacing="0">
	<tr>
	<td align="center">
 		신청하신 강좌가 없습니다.
	</td></tr>
</table></c:if>

<c:if test="${count > 0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
	<tr> 
	<td align="center"  width="50" >번호</td> 
    <td align="center"  width="50" >지점</td> 
    <td align="center"  width="50" >제목</td> 
    <td align="center"  width="50" >글쓴이</td> 
    <td align="center"  width="50" >Date</td> 
    <td align="center"  width="50" >조회수</td>
    </tr> 
    
<c:forEach var="article" items="${aticleList}">
	<tr height="30">
	<td align="center"  width="50" >
		<c:out value="${num}"/>
		<c:set var="num" value="{num -1}"/>
	</td>
	<td  width="250" >
<c:if test ="${article.re_level > 0}">
	<img src="images/level.gif" width="${5 * article.re_level}" height="16">
	<img src="images/re.gif">
</c:if>
<c:if test="${article.re_level == 0}">
	<img src="images/level.gif" width="${5 * article.re_level}" height="16">
</c:if>
	<a href="content.do?num=${article.num}&pageNum=${currentPage}">${article.title}</a> 
<c:if test="${article.readcount >= 20}">
	<img src="images/hot.gif" border="0"  height="16">
</c:if>
	</td>
	<td align="center"  width="100">
	<td align="center"  width="150">${article.writer}</td>
	<td align="center"  width="150">${article.regDate}</td>
	<td align="center"  width="50">${article.readCount}</td>
	</tr>
</c:forEach>
</table>
</c:if>							
</body>

<center>
<c:set var="pageCount" value="${count/pageSize + ( count % pageSize == 0 ? 0 : 1)}"/> 
<c:set var="pageBlock" value="${10}"/>

<fmt:parseNumber var="result" value="${currentPage /10 }" intergerOnly="true"/>

<c:set var="startPage" value="${result*10+1}"/>
<c:set var="endPage" value="${startPage*pageBlock-1}"/>

<c:if test="${endPage > pageCount}"/>
<c:set var="endPage" value="${pageCount }"/>
	<input type="button" value="강좌취소" onclick="document.location.href='classDelete.kiki?num=${dto.Num}&pageNum=${pageNum}>'">

<c:if test="${startPage > 10}">
<a href="myBoardList.kiki?pageNum=${startPage - 10 }">[이전]</a>
</c:if>

<c:forEach var="i" begin="${startPage}" end="${endPage}">
<a href="myBoardList.kiki?pageNum=${i}">[${i}]</a>
</c:forEach>

<c:if test="${endPage < pageCount}">
<a href="myBoardList.kiki?pageNum=${startPage + 10}">[다음]</a>
</c:if>
</center>
