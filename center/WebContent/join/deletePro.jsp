<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import = "center.join.*" %>
>
<html>
<head>
<title>ȸ��Ż��</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<%
	
    String id = (String)session.getAttribute("centerId"); 
    String pw  = request.getParameter("pw"); //

	
	JoinDAO manager = JoinDAO.getInstance();
    int check = manager.deleteMem(id,pw);
	//������ �׼ǿ� ���� �Ʒ� ���� �׼ǿ� ���� �־��ֶ� 
	if(check==1){
		session.invalidate();
%>
<body >
<form method="post" action="main.kiki" name="userinput" >
<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
  <tr > 
    <td height="39" align="center">
	  <font size="+1" ><b>ȸ�������� �Ϻ��� �����Ǿ����ϴ�.</b></font></td>
  </tr>
  <tr >
    <td align="center"> 
      <p>������ �����Ǿ����� �츰 ����� ����ϰ�, ��ٸ��ڽ��ϴ�</p>
      <meta http-equiv="Refresh" content="5;url=loginPage.kiki" >
    </td>
  </tr>
  <tr>
    <td align="center"> 
      <input type="submit" value="Ȯ��" onclick="javascript:window.location='loginPage.kiki'">
    </td>
  </tr>
</table>
</form>
<%}else {%>
	<script> 
	  alert("��й�ȣ�� ���� �ʽ��ϴ�.");
      history.go(-1);
	</script>
<%}%>

</body>
</html>
