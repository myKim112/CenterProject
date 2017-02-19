<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<html>
<head>
<title>고객상담 게시판 글수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>  
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_customer.jsp" flush="false" />
<article>
<h2>고객상담 글수정</h2>
<form id="searchbbs" method="post" name="writeform" action="qnaUpdatePro.kiki?pageNum=${pageNum}" onsubmit="return writeSave()">
<input type="hidden" name="pageNum" value="${pageNum}">
<table id="cbbs_f">
  <tr>
    <td>이 름</td>
    <td>
    	${article.writer}
       <input type="hidden" size="10" maxlength="50" name="writer" value="${article.writer}">
	   <input type="hidden" name="num" value="${article.num}"></td>
  </tr>
  <tr>
    <td>제 목</td>
    <td>
       <input type="text" size="40" maxlength="50" name="title" value="${article.title}"></td>
  </tr>
  <tr>
    <td>센터명</td>
    <td>
       <input type="text" size="40" maxlength="50" name="center" value="${article.center}"></td>
  </tr>  
  <tr>
    <td>내 용</td>
    <td>
     <textarea name="content" rows="13" cols="40">${article.content}</textarea></td>
  </tr>
  <%-- 
  <tr>
  	<td>파일 올리기</td>
  	<td>
  		<input type="file" name="save" value="${article.sysName}"/>${article.sysName}
  	</td>
  </tr>
  --%>
  <tr>
    <td>비밀번호</td>
    <td >
     <input type="password" size="8" maxlength="50" name="pw">
	 </td>
  </tr>
  </table>
  <br><br>
  
  <table>
  <tr>      
   <td>
     <input type="button" value="목록보기" 
       onclick="document.location.href='qnaList.kiki?pageNum=${pageNum}&num=${num }'">
   </td>
   <td>&nbsp;&nbsp;&nbsp;</td>
   <td> 
     <input type="submit" value="글수정" >  
   </td>
 </tr>
 </table>
</form>
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html>      
