<%@ page language="java" contentType="text/html; charset=euc-kr"%>

<html>
<head><title>회원탈퇴</title>
<link href="style.css" rel="stylesheet" type="text/css">

   <script language="javascript">
     
       function begin(){
         document.myform.pw.focus();
       }

       function checkIt(){
		  if(!document.myform.pw.value){
           alert("비밀번호를 입력하지 않으셨습니다.");
           document.myform.pw.focus();
           return false;
         }
	   }   
     
   </script>
</head>
<BODY onload="begin()">
<form name="myform" action="deletePro.kiki" method="post" onSubmit="return checkIt()">
<TABLE cellSpacing=1 cellPadding=1 width="260" border=0 align="center" >
 <%-- 패스워드만 전달된다. --%>
  <TR height="30">
    <TD colspan="2" align="middle" >
	  <font size="+1" ><b>회원 탈퇴</b></font> <br><br><br></TD></TR>
	  <br> <br><br><br><br> <br><br><br>
	 
  
  <TR height="30">
    <TD width="110" align=center>비밀번호 <br><br><br></TD>
    <TD width="150" align=center>
      <INPUT type=password name="pw"  size="15" maxlength="12"> <br><br><br></TD></TR>
  <TR height="30">
    <TD colspan="2" align="middle" >
  
      <INPUT type=submit value="회원탈퇴"> 
      <input type="button" value="취  소" onclick="javascript:window.location='loginPage.kiki'">
      <input type="button" value="돌아가기" onclick="javascript:window.location='loginPage.kiki'"></TD></TR>
</TABLE>
</form>
</BODY>
</HTML>

<%-- input 창이 있는 경우에는 거의 스크립트가 있다고 보면 된다. --%>