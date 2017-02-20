<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head><title>노곰 문화센터</title>
<link href="style.css" rel="stylesheet" type="text/css">

   <script language="javascript">
     
       function begin(){
         document.classFile.pw.focus();
       }

       function checkIt(){
		  if(!document.classFile.pw.value){
           alert("비밀번호를 입력하지 않으셨습니다.");
           document.classFile.pw.focus();
           return false;
         }
	   }   
     
   </script>
   </head>
   
   <BODY onload="begin()" >
<form  method="post" name="classFile" action="classDeletePro.kiki?num=${num}&pageNum=${pageNum}"onSubmit="deleteSave()">
<TABLE cellSpacing=1 cellPadding=1 width="260" border=1 align="center" >

  <TR height="30">
    <TD colspan="2" align="middle" >
	  <font size="+1" ><b>게시글삭제</b></font></TD></TR>
  
  <TR height="30">
    <TD width="110" align=center>비밀번호</TD>
    <TD width="150" align=center>
      <INPUT type=password name="pw"  size="15" maxlength="12"></TD></TR>
  <TR height="30">
    <TD colspan="2" align="middle" >
      <INPUT type="submit" value="게시글삭제"> 
      <input type="button" value="취  소" onclick="document.location.href=classList.kiki?pageNum=${pageNum}'"></TD></TR>
</TABLE>
</form>
</BODY>
</HTML>