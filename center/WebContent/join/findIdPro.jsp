<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="center.join.*" %>
<html>
<head><title>ID 찾기</title>
<link href="style.css" rel="stylesheet" type="text/css">
<%


	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
%>

<body ><br><br><br><br><br><br><br><br>
<c:if test="${null ne id}">
<form method="post">
<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
  <tr > 
    <td height="39" align="center">
	  <font size="+1" ><b>${name}님의 ID는
${id}입니다</b></font></td>
  </tr>
 
  <tr>
    <td align="center"> 
      <input type="submit" value="확인" onclick="window.location='/center/loginPage.kiki'" />
    <input type="button" value="비밀번호찾기" onclick="window.location='/center/findPwForm.kiki'" />
    <input type="button" value="회원가입" onclick="window.location='/center/agreeForm.kiki'" />
    </td>
  </tr>
</table>
</form>
</c:if>


<c:if test="${null eq id}">

	<script> 
	  alert("일치하는 회원정보가 없습니다");
      history.go(-1);
	</script>

</c:if>
</body>
</html>