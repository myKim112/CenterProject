<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A 게시판 삭제</title>
</head>
<script language="JavaScript">         
  function deleteSave(){
	if(document.delForm.pw.value==''){
		alert("비밀번호를 입력하십시요.");
		document.delForm.pw.focus();
	return false;
	}
}   
</script>
</head>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>나의 수강후기</h2>
<form id="searchbbs" method="POST" name="delForm"  action="/center/myReviewDeletePro.kiki?pageNum=${pageNum}&num=${num}"
   onsubmit="return deleteSave()">
<table id="cbbs_f">
  <tr height="30">
     <td align="center">
       <b>비밀번호를 입력해 주세요.</b></td>
  </tr>
  <tr height="30">
     <td align=center >비밀번호 :  
       <input type="password" name="pw" size="8" maxlength="12">
   <input type="hidden" name="num" value="${num}"></td>
</tr>
<tr height="30">
    <td align=center>
      <input type="button" value="글목록"
       onclick="document.location.href='/center/myQnaList.kiki?pageNum=${pageNum}'">    
      <input type="submit" value="글삭제" >
   </td>
</tr> 
</table>
</form>
</center>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>