<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" flush="false" /> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객상담 게시판</title>
</head>
<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_customer.jsp" flush="false" />
<article>
<h2>고객상담</h2>
<c:if test="${count == 0}">
<table id="cbbs">
  <tr>
    <td>
      고객상담 게시판에 저장된 글이 없습니다.
    </td>
  </tr>
</table>
</c:if>

<c:if test="${count > 0}">
<form>
<table id="cbbs"> 
    <tr>
      <th>번호</th> 
      <th>제목</th>    
      <th>게시일</th> 
      <th>센터명</th>
      <th>작성자</th> 
      <th>조회수</th> 
    </tr>

   <c:forEach var="article" items="${articleList}">
   <tr>
    <td>
	  <c:out value="${number}"/>
	  <c:set var="number" value="${number - 1}"/>
	</td>
    <td>
	  <c:if test="${article.reLevel > 0}">
	  	<img src="/center/boardQna/images/level.gif" width="${5 * article.reLevel}" height="16">
	    <img src="/center/boardQna/images/re.gif">
	  </c:if>
	  <c:if test="${article.reLevel == 0}">
	    <img src="/center/boardQna/images/level.gif" width="${5 * article.reLevel}" height="16">
	  </c:if>
           
      <a href="qnaContent.kiki?num=${article.num}&pageNum=${currentPage}&writer=${sessionScope.centerId}">
          ${article.title}</a>
          <c:if test="${article.readCount >= 20}">
            <img src="/center/boardQna/images/hot.gif" border="0"  height="16">
		  </c:if>
	</td>
    <td>${article.regDate}</td>
    <td>${article.center}</td>
    <td>${article.writer}
    	<input type="hidden" name="writer" value="${article.writer }">
    </td>
    <td>${article.readCount}</td>
  </tr>
  </c:forEach>
</table>
</form>
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
       <li><a href="qnaList.kiki?pageNum=${startPage - 10 }">이전</a></li>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <li><a href="qnaList.kiki?pageNum=${i}">${i}</a></li>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <li><a href="qnaList.kiki?pageNum=${startPage + 10}">다음</a></li>
   </c:if>
</c:if>
</ul>
</div>

<div class="clear"></div>
<form id="searchbbs" method="post">
	<select id="s" name="searchn">
		<option value="0">제목</option>
		<option value="1">내용</option>
		<option value="2">센터명</option>
		<option value="3">작성자</option>
	</select>

	<input type="search" name="search" size="15" maxlength="50" /> 
	<input type="hidden" value="${search}">
	<input type="submit" value="검색" />
	<%-- <input type="button" value="목록보기" OnClick="window.location='qnaList.kiki'"> --%>
</form>
<c:if test="${sessionScope.centerId !=null}">
<div class="btn"><a href="qnaWriteForm.kiki?writer=${sessionScope.centerId}">글쓰기</a></div>
</c:if>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>




