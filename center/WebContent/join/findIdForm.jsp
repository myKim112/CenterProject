<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>���̵�ã��</title>


</head>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	try {
		if(session.getAttribute("centerId") == null) { %>
		
		
<script>



function focusIt() {
	document.findForm.id.focus();
}

function ResearchId() {
	inputForm = eval("document.findForm");
	
	if(!inputForm.name.value) {
		alert("�̸��� �Է��ϼ���.");
		inputForm.id.focus();
		return false;
	}
	
	if(!inputForm.phone.value) {
		alert("-���� ��ȭ��ȣ��  �Է��ϼ���.");
		inputForm.pw.focus();
		return false;
	}
}
</script>



<body onLoad="focusIt()">
<center>
<br><br><br><br><br><br><br><br>
<form name="findForm" method=post action="findIdPro.kiki" onSubmit="ResearchId()"/>
<table>
  <tr><td  align="center"><p><h1><b>���̵� ã��</b></h1></td></tr>
  <tr><td>
            <p><strong>Name :</strong></td>
            <td><input name="name" type=text size="31"></td></tr> </p>
            </p>
            <tr><td><strong>Phone Number:</strong></td>
            <td><input type=text name=phone size="31" placeholder="-�������ϰ� ���ڸ��Է¼���" />
            </td></tr>
         
           
  <tr><td><p><input type=submit value="Ȯ     ��" >
     <input type=reset value="��    ��"></p></td></tr>
</form>











<%	} else { %>

<form action="finIdPro.kiki" method="post">
<table align="center">
	<tr>
	<td align="center">
		<h3>���ϰ� �Է��Ͻ� Id�� <br>
		<%= session.getAttribute("centerId") %>�Դϴ�</h3>
	</td></tr>
	<tr>
	<td align="center">
		<input type="button" value="�α���" onclick="javascript:window.location='logPage.kiki'"/>
		<input type="button" value=" ��������" onclick="javascript:window.location='/form/noticeboard/noticeList.jsp'"/>
	</td></tr>
	<tr>
	<td algin="center">
		<input type="submit" value="�α׾ƿ�" onclick="window.location='logOut.kiki'" /></td>
	</tr>
	<tr>
	<td align="center">
		<%
			String id = (String)session.getAttribute("centerId");
		
			if(id.equals("admin")) {	%>
			<input type="button" value="������" onclick="window.location=''" />
		<%	} %>
	</td></tr>
	<tr>
	<td align="center">
		<font size="2">
			<a href="">��������</a> |
			<a href="">ȸ��Ż��</a>
	</font>
</table>
</form>
<%		} 
	} catch(Exception e) { }	%>
</body>
</body>
</html>