<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
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
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_login.jsp" flush="false" />
<article>
<h2>로그인</h2>  
<form id="searchbbs" name="logform" action="loginPro.kiki" method="post" onSubmit="return checkIt()" >
<table id="cbbs_f">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="id">
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="pw">
		</td>
	</tr>
</table>

<table  id="cbbs">
	<tr>
		<td>
			<input type="submit" value="로그인" />
		</td>
		<td>&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;</td>
		<td>
			<input type="button" value="아이디 찾기" onclick="window.location='/center/findIdForm.kiki'">
		</td>
		<td>
			<input type="button" value="비밀번호 찾기" onclick="window.location='/center/findPwForm.kiki'">
		</td>
	</tr>
</table>
<%-- <table id="cbbs">		
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="회원가입" onclick="window.location='agreeForm.kiki'" />
		</td>
	</tr>
</table>
--%>
</form>

<%	} else { %>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<form id="searchbbs"  action="logOut.kiki" method="post">
<table id="cbbs_f">
	<tr>
		<td>
			<h1>반갑습니다.</h1> <br>
			<%= session.getAttribute("centerId") %>님이 방문하셨습니다.</h3>
		</td>
	</tr>
	<tr>
		<td>
			<%
				String id = (String)session.getAttribute("centerId");
				if(id.equals("admin")) {	%>
				<input type="button" value="관리자" onclick="window.location=''" />
			<%	} %>
		</td>
	</tr>
	<tr>
		<td>
			<font size="2">
				<a href="">정보수정</a> |
				<a href="">회원탈퇴</a>
		</font>
	</table>
</form>
<%		} 
	} catch(Exception e) { }	%>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />   
</html>