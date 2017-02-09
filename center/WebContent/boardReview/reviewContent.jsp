<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review 게시판 내용보기</title>
</head>

<body>  
<center><b>Review 글내용 보기</b>
<br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">  
  <tr height="30">
    <td align="center" width="125">번호</td>
    <td align="center" width="125" align="center">${article.num}</td>
    <td align="center" width="125" >조회수</td>
    <td align="center" width="125" align="center">${article.readCount}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125">작성자</td>
    <td align="center" width="125" align="center">${article.writer}</td>
    <td align="center" width="125">작성일</td>
    <td align="center" width="125" align="center">${article.regDate}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125">글제목</td>
    <td align="center" width="375" align="center" colspan="3">${article.title}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125">센터명</td>
    <td align="center" width="375" align="center" colspan="3">${article.center}</td>
  </tr>  
  <tr>
    <td align="center" width="125">글내용</td>
    <td align="left" width="375" colspan="3">
    	<pre>${article.content}</pre>
    	<img src="/center/save/${article.sysName}" width="200"/>
    	<input type="hidden" value="${article.sysName}" name="sysName"/>
    </td>
  </tr>
  <tr height="30">      
    <td colspan="4" align="center" > 
	  <input type="button" value="글수정" 
       onclick="document.location.href='reviewUpdateForm.kiki?num=${article.num}&pageNum=${pageNum}&num=${num}'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
	  <input type="button" value="글삭제" 
       onclick="document.location.href='reviewDeleteForm.kiki?num=${article.num}&pageNum=${pageNum}'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" value="답글쓰기" 
       onclick="document.location.href='reviewWriteForm.kiki?num=${article.num}&ref=${article.ref}&reStep=${article.reStep}&reLevel=${article.reLevel}'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="button" value="글목록" 
       onclick="document.location.href='reviewList.kiki?pageNum=${pageNum}'">
    </td>
  </tr>
</table>    
</form>      
</body>
</html>  