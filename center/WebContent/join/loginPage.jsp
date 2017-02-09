<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>로그인</title>
</head>

<link href="style.css" rel="stylesheet" type="text/css">

<%
	try {
		if(session.getAttribute("centerId") == null) { %>
		
<script>
	function focusIt() {
		document.logform.id.focus();
	}
	
	function checkIt() {
		inputForm = eval("document.logform");
		
		if(!inputForm.id.value) {
			alert("아이디를 입력하세요.");
			inputForm.id.focus();
			return false;
		}
		
		if(!inputForm.pw.value) {
			alert("비밀번호를 입력하세요.");
			inputForm.pw.focus();
			return false;
		}
	}
</script>

<body onload="focusIt()">

<br><br><br><br><br><br><br><br><br><br><br><center><h2>healthy  Upgrade </h2> 
 <br />
      <br />
<h3>노곰의 세계로</h3>
<br />

<form name="logform" action="loginPro.kiki" method="post" onSubmit="return checkIt()" >
<table width="300" height="150" border="0" align="center">
	<tr height="30">
	<td colspan="2" align="middle">
		<strong>Log-in</strong>
	<br/><br/><br/>
	</td></tr>
	<tr height="30">
	<td width="110" align="center">아이디</td>
	<td align="center">
		<input type="text" name="id" size="15" maxlength="12" /></td>
	</tr>
	<tr height="30">
	<td width="110" align="center">비밀번호</td>
	<td align="center">
		<input type="password" name="pw" size="15" maxlength="12" /></td>
	</tr>
	<tr height="30">
	<td colspan="2" align="center">
	<br/><br/>
		<a href="/center/findIdForm.kiki">아이디 찾기</a>&nbsp;
		<a href="/center/findPwForm.kiki">비밀번호 찾기</a>
	</td><tr>
	<tr height="30">
	<td colspan="2" align="center">
	<br/><br/>
		<input type="submit" value="로그인" />
		<input type="button" value="회원가입" onclick="window.location='agreeForm.kiki'" />
	</td></tr>
</table>
</form>

<%	} else { %>

<form action="logOut.kiki" method="post">
<table align="center">
	<tr>
	<td align="center">
		<h3>반갑습니다. <br>
		<%= session.getAttribute("centerId") %>님이 방문하셨습니다.</h3>
	</td></tr>
	<tr>
	<td align="center">
		<input type="button" value="게시판" onclick="javascript:window.location='/form/boardtest/list.jsp'"/>
		<input type="button" value=" 공지사항" onclick="javascript:window.location='/form/noticeboard/noticeList.jsp'"/>
		<input type="button" value="내가쓴글보기" onclick="window.location='memListMenu.kiki'"/>
	</td></tr>
	<tr>
	<td algin="center">
		<input type="submit" value="로그아웃" /></td>
	</tr>
	<tr>
	<td align="center">
		<%
			String id = (String)session.getAttribute("centerId");
		
			if(id.equals("admin")) {	%>
			<input type="button" value="관리자" onclick="window.location=''" />
		<%	} %>
	</td></tr>
	<tr>
	<td align="center">
		<font size="2">
			<a href="">정보수정</a> |
			<a href="">회원탈퇴</a>
	</font>
</table>
</form>
<%		} 
	} catch(Exception e) { }	%>
</body>