<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import = "center.join.*" %>
>
<html>
<head>
<title>회원탈퇴</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<%
	
    String id = (String)session.getAttribute("centerId"); 
    String pw  = request.getParameter("pw"); //

	
	JoinDAO manager = JoinDAO.getInstance();
    int check = manager.deleteMem(id,pw);
	//요기까지 액션에 들어가고 아래 값도 액션에 같이 넣어주라 
	if(check==1){
		session.invalidate();
%>
<body >
<form method="post" action="main.kiki" name="userinput" >
<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
  <tr > 
    <td height="39" align="center">
	  <font size="+1" ><b>회원정보가 완벽히 삭제되었습니다.</b></font></td>
  </tr>
  <tr >
    <td align="center"> 
      <p>정보는 삭제되었지만 우린 당신을 기억하고, 기다리겠습니다</p>
      <meta http-equiv="Refresh" content="5;url=loginPage.kiki" >
    </td>
  </tr>
  <tr>
    <td align="center"> 
      <input type="submit" value="확인" onclick="javascript:window.location='loginPage.kiki'">
    </td>
  </tr>
</table>
</form>
<%}else {%>
	<script> 
	  alert("비밀번호가 맞지 않습니다.");
      history.go(-1);
	</script>
<%}%>

</body>
</html>
