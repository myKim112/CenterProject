<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp" flush="false" />  

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>공지사항 게시판</title>
</head>

<body>

	<h1 id="customer"><div>customer center</div></h1>
	<jsp:include page="sidebar_customer.jsp" flush="false" />
	
<article>
<h2>공지사항</h2>
	<c:if test="${count == 0 }">
	<table id="cbbs">
		<tr>
			<td>
				공지사항 게시판에 저장된 글이 없습니다.
			</td>
		</tr>
	</table>
	</c:if>
	
	<c:if test="${count > 0 }">
	<table id="cbbs">	
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>게시일</th>
			<th>센터명</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach var="article" items="${articleList }">
			<tr>
				<td>
					<c:out value="${number }"/>
					<c:set var="number" value="${number-1}"/>
				</td>
				<td>
  					<a href="noticeContent.kiki?num=${article.num}&pageNum=${pageNum}">${article.title}</a>
				</td>
				<td>${article.regDate}</td>
				<td>${article.center}</td>
				<td>${article.readCount }</td>		
			</tr>
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
        <li><a href="noticeList.kiki?pageNum=${startPage - 10 }">이전</a></li>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <li> <a href="noticeList.kiki?pageNum=${i}">${i}</a></li>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
         <li><a href="noticeList.kiki?pageNum=${startPage + 10}">다음</a></li>
   </c:if>
</c:if>
</ul>
</div>

<div class="clear"></div>
<form id="searchbbs" method="post">
<select id="s" name="searchn">
	<option value="0" >제목</option>
	<option value="1">내용</option>
	<option value="2">센터</option>
</select>
<input type="search" name="search" size="15" maxlength="50" /> 
<input type="hidden" value="${search}">
<input type="submit" value="검색" />
<%-- <input type="button" value="목록보기" OnClick="window.location='noticeList.kiki'"> --%>
</form>

<c:if test="${sessionScope.centerId !=null && sessionScope.centerId == 'MY00001'}">
	<div class="btn"><a href="noticeWriteForm.kiki">글쓰기</a></div>
</c:if>

</article>
<jsp:include page="footer.jsp" flush="false" />
  
</body>
</html>





