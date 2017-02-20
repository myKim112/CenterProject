<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" flush="false" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객상담게시판 게시판 내용보기</title>
</head>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_customer.jsp" flush="false" />
<article>
<h2>고객상담게시판</h2>  
<form id="searchbbs">
<table id="cbbs_f">  
  <tr>
    <th>번호</th>
    <td>${article.num}</td>
    <th>조회수</th>
    <td>${article.readCount}</td>
  </tr>
  <tr>
    <th>작성자</th>
    <td>${article.writer}</td>
    <th>작성일</th>
    <td>${article.regDate}</td>
  </tr>
  <tr>
    <th>글제목</th>
    <td colspan="5">${article.title}</td>
  </tr>
  <tr>
    <th>센터명</th>
    <td colspan="5">${article.center}</td>
  </tr>  
  <tr>
    <th>글내용</th>
    <td colspan="5">
    	<pre>${article.content}</pre>
    	<%-- 
    	<img src="/center/save/${article.sysName}" width="200"/>
    	<input type="hidden" value="${article.sysName}" name="sysName"/>
    	--%>
    </td>
  </tr>
  </table>
  <br><br>
 
   <table> 
  <tr>      
    <td>
       <input type="button" value="글목록" 
       onclick="document.location.href='qnaList.kiki?pageNum=${pageNum}'">
	</td>
	<td>&nbsp;&nbsp;</td>
	<c:if test="${sessionScope.centerId !=null}">
	<td>
		<input type="button" value="글수정" 
       	onclick="document.location.href='qnaUpdateForm.kiki?num=${article.num}&pageNum=${pageNum}&num=${num}'">
	</td>
	<td>&nbsp;&nbsp;</td>	
	<td>	
		<input type="button" value="글삭제" 
       onclick="document.location.href='qnaDeleteForm.kiki?num=${article.num}&pageNum=${pageNum}'">
    </td>
    <td>
      <c:if test="${staff.lev >= 20}">
      <input type="button" value="답글쓰기" 
       onclick="document.location.href='qnaWriteForm.kiki?num=${article.num}&ref=${article.ref}&reStep=${article.reStep}&reLevel=${article.reLevel}'">
    	</c:if>
    </td>
    </c:if>
  </tr>
</table>    
</form>   
</article>
<jsp:include page="footer.jsp" flush="false" />   
</body>
</html> 