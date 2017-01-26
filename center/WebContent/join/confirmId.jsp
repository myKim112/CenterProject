<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import= "center.join.JoinDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head><title>ID 중복확인</title>
<link href="style.css" rel="stylesheet" type="text/css">

<% request.setCharacterEncoding("UTF-8");%>

<%
    String id = request.getParameter("id"); 
	JoinDAO manager = JoinDAO.getInstance();
    int check= manager.confirmId(id);

 %>



<body>
<%
    if(check == 1) {
%>
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr> 
   <td height="39">"${id}" 이미 사용중인 아이디입니다.</td>
  </tr>
</table>
<form name="checkForm" method="post" action="confirmId.kiki">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center"> 
       다른 아이디를 선택하세요.<p>
       <input type="text" size="10" maxlength="12" name="id"> 
       <input type="submit" value="ID중복확인">
    </td>
  </tr>
</table>
</form>
<%
    } else {
%>
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr> 
    <td align="center"> 
      <p>입력하신 "${id}" 는 사용하실 수 있는 ID입니다. </p>
      <input type="button" value="닫기" onclick="setid()">
    </td>
  </tr>
</table>
<%
    }
%>
</body>
</html>
<script language="javascript">

  function setid() // 창을 총료 시키는 메소드
    {		
    	opener.document.userinput.id.value="${id}";
    	/* document만 붙어있으면 전체 페이지를 의미하는데,
    		opener가 붙으면 중복 확인을 하였을떄 name="id"에 값이 들어가진다.
    		즉, 현재 창을 띄운 부모창을 의미한다. */
		self.close(); // close() : 해당 창을 총료시키는 명령어
		}

</script>