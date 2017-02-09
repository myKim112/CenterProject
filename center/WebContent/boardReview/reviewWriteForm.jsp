<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Review 게시판 글쓰기</title>
</head>

   
<body bgcolor="${bodyback_c}">  
<center><b>Review 글쓰기</b>
<br>
<form method="post" name="writeform" action="reviewWritePro.kiki" onsubmit="return writeSave()" enctype="multipart/form-data">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="reStep" value="${reStep}">
<input type="hidden" name="reLevel" value="${reLevel}">

<table width="450" border="1" cellspacing="0" cellpadding="0"  align="center">
   <tr>
    <td  width="250" align="center">센터명</td>
    <td  width="330">
       <input type="text" size="10" maxlength="10" name="center"></td>
  </tr>   
   <tr>
    <td  width="250" align="center">작성자</td>
    <td  width="330">
       <input type="text" size="10" maxlength="10" name="writer"></td>
  </tr>
  <tr>
    <td  width="250" align="center" >제 목</td>
    <td  width="330">
	<c:if test="${num == 0}">
       <input type="text" size="40" maxlength="50" name="title"></td>
	</c:if>
	<c:if test="${num != 0}">
	   <input type="text" size="40" maxlength="50" name="title" value="[답변]"></td>
	</c:if>
  </tr>
  <tr>
    <td  width="250" align="center" >내 용</td>
    <td  width="330" >
     <textarea name="content"></textarea> </td>
  </tr>
  <tr>
  	<td>파일 올리기</td>
  	<td>
  		<input type="file" name="save">
  	</td>
  </tr>
  <tr>
    <td  width="250" align="center" >비밀번호</td>
    <td  width="330" >
     <input type="password" size="8" maxlength="12" name="pw"> 
	 </td>
  </tr>
<tr>      
 <td colspan=2 align="center"> 
  <input type="submit" value="글쓰기" >  
  <input type="reset" value="다시작성">
  <input type="button" value="목록보기" OnClick="window.location='reviewList.kiki'">
</td></tr></table>    
</form>      
</body>
</html>      
