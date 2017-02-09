<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 1. c와 fmt가 필요할 때, 표현식? -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A 게시판</title>
</head>
<body>
<center><b>Q&A 글목록(전체 글:${count})</b>
	<table width="700">
		<tr>
			<td align="right">
				<!-- 2. kiki를 사용할 땐, 앞에 아무것도 필요없다? -->
				<a href="qnaWriteForm.kiki">글쓰기</a>
			</td>
		</tr>
	</table>
	
	<c:if test="${count == 0 }">
	<table width="700" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center">
				Q&A 게시판에 저장된 글이 없습니다.
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
			<td align="center" width="100">작성자</td>
			<td align="center" width="150">작성일</td>
		</tr>
		
		<!-- 3. 표현식 forEach문에 대한 이해 필요 -->
		<c:forEach var="article" items="${articleList }">
			<tr height="30">
				<td align="center" width="50">
					<%-- 4. number는 컴퓨터에서 자동생성되는 것? --%>
					<%-- 5. out과 set의 역할 --%>
					<%-- 6. 1은 왜 빼는거지? --%>
					<c:out value="${number }"/>
					<c:set var="number" value="${number-1}"/>
				</td>
				<td align="center" width="100">
					${article.center}					
				</td>				
				<td align="center" width="250">
					<c:if test="${article.reLevel > 0 }">
					<!-- 7. img 경로와 reLevel 이 댓글의 번호? -->
						<img src="images/level.gif" width="${5*article.reLevel}" height="16">
						<img src="images/re.gif">
					</c:if>
					<c:if test="${article.reLevel == 0 }">
						<img src="images/level.gif" width="${5*article.reLevel }" height="16">
					</c:if>
					 <c:if test="${article.reLevel >= 20}">
   					 	<img src="images/hot.gif" border="0" height="16">
  					</c:if>
  					<a href="qnaContent.kiki?num=${article.num}&pageNum=${pageNum}">${article.title}</a>
				</td>
				<td align="center" width="100">${article.writer}</td>
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
        <a href="qnaList.kiki?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="qnaList.kiki?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="qnaList.kiki?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>
</center>
</body>
</html>





