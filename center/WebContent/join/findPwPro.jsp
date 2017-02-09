<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="center.join.*" %>

<%


	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String pw = request.getParameter("pw");
	String id = request.getParameter("id");
%>



<body >
<c:if test="${null ne pw}">
<form method="post" action="loginPage.kiki" name="findIdRs" >
<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
  <tr > 
    <td height="39" align="center">
	  <font size="+1" ><b>${id}님의 비밀번호는
${pw}입니다</b></font></td>
  </tr>
 
  <tr>
    <td align="center"> 
      <input type="submit" value="확인">
    <input type="button" value="아이디찾기" onclick="window.location='/center/findIdForm.kiki'" />
    <input type="button" value="회원가입" onclick="window.location='/center/agreeForm.kiki'" />
    </td>
  </tr>
</table>
</form>
</c:if>



<c:if test="${null eq pw}">

	<script> 
	  alert("일치하는 회원정보가 없습니다");
      history.go(-1);
	</script>

</c:if>
</body>
</html>