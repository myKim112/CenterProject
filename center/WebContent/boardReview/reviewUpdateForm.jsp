<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Review 수정게시판</title>
</head>

<body>  
<center><b>Review 글수정</b>
<br>
<form method="post" name="writeform" action="reviewUpdatePro.kiki?pageNum=${pageNum}" onsubmit="return writeSave()" enctype="multipart/form-data">
<input type="hidden" name="pageNum" value="${pageNum}"></td>
<table width="450" border="1" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td  width="70" align="center">이 름</td>
    <td align="left" width="330">
       <input type="text" size="10" maxlength="50" name="writer" value="${article.writer}">
	   <input type="hidden" name="num" value="${article.num}"></td>
  </tr>
  <tr>
    <td  width="70" align="center" >제 목</td>
    <td align="left" width="330">
       <input type="text" size="40" maxlength="50" name="title" value="${article.title}"></td>
  </tr>
  <tr>
    <td  width="70" align="center" >센터명</td>
    <td align="left" width="330">
       <input type="text" size="40" maxlength="50" name="center" value="${article.center}"></td>
  </tr>  
  <tr>
    <td  width="70" align="center" >내 용</td>
    <td align="left" width="330">
     <textarea name="content" rows="13" cols="40">${article.content}</textarea></td>
  </tr>
  <tr>
  	<td>파일 올리기</td>
  	<td>
  		<input type="file" name="save" value="${article.sysName}"/>${article.sysName}
  	</td>
  </tr>
  <tr>
    <td  width="70" align="center" >비밀번호</td>
    <td align="left" width="330" >
     <input type="password" size="8" maxlength="50" name="pw">
	 </td>
  </tr>
  <tr>      
   <td colspan=2 align="center"> 
     <input type="submit" value="글수정" >  
     <input type="reset" value="다시작성">
     <input type="button" value="목록보기" 
       onclick="document.location.href='reviewList.kiki?pageNum=${pageNum}&num=${num }'">
   </td>
 </tr>
 </table>
</form>
</body>
</html>      
