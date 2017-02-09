<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 게시판</title>
</head>
<body>
<center><b>공지사항 글목록(전체 글:${count})</b>
	<table width="700">
		<tr>
			<td align="right">
				<a href="noticeWriteForm.kiki">글쓰기</a>
			</td>
		</tr>
	</table>
	
	<c:if test="${count == 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center">
				공지사항 게시판에 저장된 글이 없습니다.
			</td>
		</tr>
	</table>
	</c:if>
	
	<c:if test="${count > 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0">	
		<tr height="30">
			<td align="center" width="50">번호</td>
			<td align="center" width="100">센터명</td>
			<td align="center" width="250">제목</td>
			<td align="center" width="150">작성일</td>
		</tr>
		
		<c:forEach var="article" items="${articleList }">
			<tr height="30">
				<td align="center" width="50">
					<c:out value="${number }"/>
					<c:set var="number" value="${number-1}"/>
				</td>
				<td align="center" width="100">
					${article.center}					
				</td>		
				<td align="center" width="250">
  					<a href="noticeContent.kiki?num=${article.num}&pageNum=${pageNum}">${article.title}</a>
				</td>
				<td align="center" width="150">${article.regDate}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>

<!-- 8. 페이지번호에 대한 이해 필요 -->
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
        <a href="noticeList.kiki?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="noticeList.kiki?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="noticeList.kiki?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>

<form method="post">
<select name="searchn">
	<option value="0">제목</option>
	<option value="1">내용</option>
	<option value="2">센터</option>
</select>

<input type="text" name="search" size="15" maxlength="50" /> 
<input type="hidden" value="${search}">
<input type="submit" value="검색" />&nbsp;
<input type="button" value="목록보기" OnClick="window.location='noticeList.kiki'">
</form>

</center>
</body>
</html>





