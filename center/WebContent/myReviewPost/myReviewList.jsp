<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.sql.*,java.text.SimpleDateFormat,java.util.Date"%>
<jsp:include page="header.jsp" flush="false" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 수강후기</title>
</head>
<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>나의 수강후기 목록</h2>
	<c:if test="${count == 0 }">
	<table id="cbbs_f">
		<tr>
			<td align="center">
				나의 수강후기에 저장된 글이 없습니다.
			</td>
			</tr>
		
	</table>
	</c:if>
	<c:if test="${count > 0 }">
	<table id="cbbs_f">	
		<tr height="30">
			<td align="center" width="50">번호</td>
			<td align="center" width="100">센터명</td>
			<td align="center" width="250">제목</td>
			<td align="center" width="150">작성일</td>
		</tr>
		
		<c:forEach var="article" items="${articleList }">
			<c:if test="${article.writer == sessionScope.centerId}">
			<tr height="30">
				<td align="center" width="50">
					<c:out value="${number }"/>
					<c:set var="number" value="${number-1}"/>
				</td>
				<td align="center" width="100">
					${article.center}					
				</td>		
				<td align="center" width="250">
  					<a href="myReviewContent.kiki?num=${article.num}&pageNum=${pageNum}">${article.title}</a>
				</td>
				<td align="center" width="150">${article.regDate}</td>
			</tr>
			</c:if>
		</c:forEach>
	</table>
	</c:if>
<div id="page">
<ul class="paging">
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
        <li><a href="myReviewList.kiki?pageNum=${startPage - 10 }">[이전]</a></li>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <li><a href="myReviewList.kiki?pageNum=${i}">${i}</a></li>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <li><a href="myReviewList.kiki?pageNum=${startPage + 10}">[다음]</a></li>
   </c:if>
</c:if>
</ul>
</div>
<%-- 
<div class="clear"></div>
<form id="searchbbs"  method="post">
<select id="s" name="searchn">
	<option value="0">제목</option>
	<option value="1">내용</option>
	<option value="2">센터</option>
</select>

<input type="text" name="search" size="15" maxlength="50" /> 
<input type="hidden" value="${search}">
<input type="submit" value="검색" />
<input type="button" value="목록보기" OnClick="window.location='myReviewList.kiki'">
</form>
--%>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>