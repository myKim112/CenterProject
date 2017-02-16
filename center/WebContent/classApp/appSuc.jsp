<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="header.jsp" flush="false" />    

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_lecture.jsp" flush="false" />
<article>
<h2>고객상담</h2>

<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
  <tr > 
    <td height="39"  align="center">
	  <font size="+1" ><b>결제가 완료되었습니다.<br>
	  5초후에 메인으로 이동합니다.<meta http-equiv="Refresh" content="5;url=index.jsp" ></b></font></td>
      
  </tr>
  <tr>
    <td  align="center"> 
      <form>
	    <input type="button" value="메인으로" onclick="window.location='index.jsp'">
      </form>
    </td>
  </tr>
</table>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>
