<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" />

<html>
<head>
<title>Passwordã��</title>
</head>

<% request.setCharacterEncoding("UTF-8"); %>
<%
	try {
		if(session.getAttribute("centerId") == null) { %>
		
<script language="javascript">

function focusIt() {
	document.findForm.id.focus();
}

function findPw() {
	inputForm = eval("document.findPwForm");
	
	if(!inputForm.name.value) {
		alert("�̸��� �Է��ϼ���.");
		inputForm.id.focus();
		return false;

	}
	
	if(!inputForm.phone.value) {
		alert("-���� ��ȭ��ȣ��  �Է��ϼ���.");
		inputForm.phone.focus();
		return false;

	}
	if(!inputForm.id.value) {
		alert("���̵��Է��ϼ���.");
		inputForm.id.focus();
		return false;
	}
}
</script>


<body onLoad="focusIt()">
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>��й�ȣ ã��</h2> 
<form id="searchbbs" name="findPwForm" action="findPwPro.kiki" method="post" onSubmit="return findPw();">
<table id="cbbs_f">
	<tr>
		<td>Name</td>
        <td><input name="name" type=text></td>
	</tr>
	<tr>
		<td>Phone Number</td>
        <td><input type=text name=phone placeholder="-������. ���ڸ��Է�." /></td>
	</tr>
	<tr>
		<td>ID</td>
		<td><input type=text name=id></td>
	</tr>
</table>
<br>
			<input type=submit value="Ȯ��">
</form>


<%	} else { %>

<form id="searchbbs" action="finPwPro.kiki" method="post">
<table id="cbbs_f">
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
</article>
<jsp:include page="footer.jsp" flush="false" />   
</html>






