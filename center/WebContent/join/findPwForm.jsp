<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" />

<html>
<head>
<title>Password찾기</title>
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
		alert("이름을 입력하세요.");
		inputForm.id.focus();
		return false;

	}
	
	if(!inputForm.phone.value) {
		alert("-없이 전화번호를  입력하세요.");
		inputForm.phone.focus();
		return false;

	}
	if(!inputForm.id.value) {
		alert("아이디를입력하세요.");
		inputForm.id.focus();
		return false;
	}
}
</script>


<body onLoad="focusIt()">
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>비밀번호 찾기</h2> 
<form id="searchbbs" name="findPwForm" action="findPwPro.kiki" method="post" onSubmit="return findPw();">
<table id="cbbs_f">
	<tr>
		<td>Name</td>
        <td><input name="name" type=text></td>
	</tr>
	<tr>
		<td>Phone Number</td>
        <td><input type=text name=phone placeholder="-를생략. 숫자만입력." /></td>
	</tr>
	<tr>
		<td>ID</td>
		<td><input type=text name=id></td>
	</tr>
</table>
<br>
			<input type=submit value="확인">
</form>


<%	} else { %>

<form id="searchbbs" action="finPwPro.kiki" method="post">
<table id="cbbs_f">
	<tr>
	<td align="center">
		<h3>귀하가 입력하신 Id는 <br>
		<%= session.getAttribute("centerId") %>입니다</h3>
	</td></tr>
	<tr>
	<td align="center">
		<input type="button" value="로그인" onclick="javascript:window.location='logPage.kiki'"/>
		<input type="button" value=" 공지사항" onclick="javascript:window.location='/form/noticeboard/noticeList.jsp'"/>
	</td></tr>
	<tr>
	<td algin="center">
		<input type="submit" value="로그아웃" onclick="window.location='logOut.kiki'" /></td>
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
</article>
<jsp:include page="footer.jsp" flush="false" />   
</html>






