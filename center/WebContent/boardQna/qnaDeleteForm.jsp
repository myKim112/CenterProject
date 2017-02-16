<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객상담게시판 삭제</title>
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
<jsp:include page="sidebar_customer.jsp" flush="false" />
<article>
<h2>고객상담 글삭제</h2>
<form id="searchbbs" method="POST" name="delForm"  action="qnaDeletePro.kiki?pageNum=${pageNum}" 
   onsubmit="return deleteSave()"> 
 <table id="cbbs_f">
  	<tr>
     	<td align="center">
      	 <b>비밀번호를 입력해 주세요.</b>
      	</td>
  	</tr>
  <tr>
     <td>비밀번호 :   
       <input type="password" name="pw" size="8" maxlength="12">
	   <input type="hidden" name="num" value="${num}"></td>
 </tr>
 </table>
 <br><br>

 <table>
 <tr>
    <td>
      <input type="submit" value="글삭제" >
      <input type="button" value="글목록" 
       onclick="document.location.href='qnaList.kiki?pageNum=${pageNum}'">     
   </td>
 </tr>  
</table> 
</form>
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html> 