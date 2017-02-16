<%@ page language="java" contentType="text/html; charset=euc-kr"%>
<jsp:include page="header.jsp" flush="false" />

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
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>회원탈퇴</h2>  
<form id="searchbbs" name="myform" action="deletePro.kiki" method="post" onSubmit="return checkIt()">
<TABLE id="cbbs_f">
  <TR>
    <TD>비밀번호 <br><br><br></TD>
    <TD>
      <INPUT type=password name="pw">
    </TD>
  </TR>
</TABLE>
<br>
<TABLE>
	<TR>  
    <TD>
      <INPUT type=submit value="회원탈퇴"> 
    </TD>
</TABLE>
</form>
</BODY>
</article>
<jsp:include page="footer.jsp" flush="false" />   
</html>

<%-- input 창이 있는 경우에는 거의 스크립트가 있다고 보면 된다. --%>