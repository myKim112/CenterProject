<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>Review 게시판</title>
</head>

<body>
<center><b>Review 글목록(전체 글:${count})</b>
<table width="700">
  <tr>
    <td align="right">
       <a href="reviewWriteForm.kiki">글쓰기</a>
    </td>
  </tr>
</table>

<c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      Review 게시판에 저장된 글이 없습니다.
    </td>
  </tr>
</table>
</c:if>

<c:if test="${count > 0}">
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30">
      <td align="center"  width="50"  >번호</td> 
      <td align="center"  width="100" >제목</td>    
      <td align="center"  width="250" >센터명</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td> 
      <td align="center"  width="50" >조회</td> 
    </tr>

   <c:forEach var="article" items="${articleList}">
   <tr height="30">
    <td align="center"  width="50" >
	  <c:out value="${number}"/>
	  <c:set var="number" value="${number - 1}"/>
	</td>
    <td  width="250"  align="center">
	  <c:if test="${article.reLevel > 0}">
	  	<img src="images/level.gif" width="${5 * article.reLevel}" height="16">
	    <img src="images/re.gif">
	  </c:if>
	  <c:if test="${article.reLevel == 0}">
	    <img src="images/level.gif" width="${5 * article.reLevel}" height="16">
	  </c:if>
           
      <a href="reviewContent.kiki?num=${article.num}&pageNum=${currentPage}">
          ${article.title}</a> 
          <c:if test="${article.readCount >= 20}">
            <img src="images/hot.gif" border="0"  height="16">
		  </c:if>
	</td>
    <td align="center"  width="100">${article.center}</td>
    <td align="center"  width="100">${article.writer}</td>
    <td align="center"  width="150">${article.regDate}</td>
    <td align="center"  width="50">${article.readCount}</td>
  </tr>
  </c:forEach>
</table>
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
        <a href="reviewList.kiki?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="reviewList.kiki?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="reviewList.kiki?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>

<form method="post">
	<select name="searchn">
		<option value="0">제목</option>
		<option value="1">내용</option>
		<option value="2">센터명</option>
		<option value="3">작성자</option>
	</select>

	<input type="text" name="search" size="15" maxlength="50" /> 
	<input type="hidden" value="${search}">
	<input type="submit" value="검색" />&nbsp;
	<input type="button" value="목록보기" OnClick="window.location='reviewList.kiki'">
</form>
</body>
</center>
</html>