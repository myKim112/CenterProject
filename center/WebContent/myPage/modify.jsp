<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="center.join.*" %>




 <% request.setCharacterEncoding("UTF-8"); %>

<head>
<title>회원정보수정</title>
</head>

<link href="style.css" rel="stylesheet" type="text/css">

<script>
	function checkIt() {
		var userinput = evl("document.userinput");
		
		if(!userinput.pw.value){
			alert("비밀번호를 입력하세요");
			return false;
		}
		
		if(userinput.pw.value != userinput.pwcheck.value) {
			alert("비밀번호를 동일하게 입력하세요");
			return false;
		}
		url = "confirmId.kiki?id=" + userinput.id.value ;
	}
</script>


<%
    String id = (String)session.getAttribute("centerId");
    JoinDAO manager = JoinDAO.getInstance();
    JoinDTO c = manager.getMember(id);
 %>


<center>
<font face ="Impact" color="lightgray" size = "20" >
Membership Modify</font>
</center>
<hr align="center" style="border: solid 1px lightgray; width: 55%;">

<body>
<form action="modifyPro.kiki" method="post" name="userinput" onSubmit="return checkIt()">
<table  border="0" align="center">
	<tr>
	<td width="150">ID</td>
	<td align="left">${dto.id}<br><br>
	</td></tr>
	<tr>
	<td width="150">비밀번호</td>
	<td align="left">
		<input type="password" name="pw" value="${dto.pw}">
		<br><br>
	</td></tr>

	<tr>
	<td width="150" >이름</td>
	<td align="left">
		<input type="text" name="name" value="${dto.name}">
		<br><br>
	</td></tr>
	<tr>
	<td width="150">생년월일</td>
	<td align="left">
		<input type="text" name="birth" value="${dto.birth}">
		<br><br>
	</td></tr>
	<tr>
	<td width="150">전화번호</td>
	<td align="left">
		<input type="text" name="phone" value="${dto.phone}">
		<br><br>
	</td></tr>
		<tr>
	<td width="150">E-mail</td>
	<td align="left">
		<input type=text name="email" value="${dto.email}">
	    <br><br>
	</td></tr>
	<tr>
	<tr>
	<td width="150">주소</td>
	<td align="left">
		<input type="text" name="address" value="${dto.address}">
		<br><br>
	</td></tr>

	<tr>
	<td align="right" colspan="2">
	<br><br>
		<input type="submit" value="회원수정" />
		<input type="button" value="회원탈퇴" onclick="javascript:window.location='memDelete.kiki'"/>
		<input type="button" value="메인으로" onclick="javascript:window.location='main.kiki'"/>
	</td></tr>
</table>
</form>
</body>
