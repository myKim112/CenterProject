<%@ page language="java" contentType="text/html; charset=euc-kr"%>
<jsp:include page="header.jsp" flush="false" />

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
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>ȸ��Ż��</h2>  
<form id="searchbbs" name="myform" action="deletePro.kiki" method="post" onSubmit="return checkIt()">
<TABLE id="cbbs_f">
  <TR>
    <TD>��й�ȣ <br><br><br></TD>
    <TD>
      <INPUT type=password name="pw">
    </TD>
  </TR>
</TABLE>
<br>
<TABLE>
	<TR>  
    <TD>
      <INPUT type=submit value="ȸ��Ż��"> 
    </TD>
</TABLE>
</form>
</BODY>
</article>
<jsp:include page="footer.jsp" flush="false" />   
</html>

<%-- input â�� �ִ� ��쿡�� ���� ��ũ��Ʈ�� �ִٰ� ���� �ȴ�. --%>