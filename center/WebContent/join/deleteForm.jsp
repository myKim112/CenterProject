<%@ page language="java" contentType="text/html; charset=euc-kr"%>

<html>
<head><title>ȸ��Ż��</title>
<link href="style.css" rel="stylesheet" type="text/css">

   <script language="javascript">
     
       function begin(){
         document.myform.pw.focus();
       }

       function checkIt(){
		  if(!document.myform.pw.value){
           alert("��й�ȣ�� �Է����� �����̽��ϴ�.");
           document.myform.pw.focus();
           return false;
         }
	   }   
     
   </script>
</head>
<BODY onload="begin()">
<form name="myform" action="deletePro.kiki" method="post" onSubmit="return checkIt()">
<TABLE cellSpacing=1 cellPadding=1 width="260" border=0 align="center" >
 <%-- �н����常 ���޵ȴ�. --%>
  <TR height="30">
    <TD colspan="2" align="middle" >
	  <font size="+1" ><b>ȸ�� Ż��</b></font> <br><br><br></TD></TR>
	  <br> <br><br><br><br> <br><br><br>
	 
  
  <TR height="30">
    <TD width="110" align=center>��й�ȣ <br><br><br></TD>
    <TD width="150" align=center>
      <INPUT type=password name="pw"  size="15" maxlength="12"> <br><br><br></TD></TR>
  <TR height="30">
    <TD colspan="2" align="middle" >
  
      <INPUT type=submit value="ȸ��Ż��"> 
      <input type="button" value="��  ��" onclick="javascript:window.location='loginPage.kiki'">
      <input type="button" value="���ư���" onclick="javascript:window.location='loginPage.kiki'"></TD></TR>
</TABLE>
</form>
</BODY>
</HTML>

<%-- input â�� �ִ� ��쿡�� ���� ��ũ��Ʈ�� �ִٰ� ���� �ȴ�. --%>