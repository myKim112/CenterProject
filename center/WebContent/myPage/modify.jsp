<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="center.join.*" %>
<jsp:include page="header.jsp" flush="false" /> 

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
    JoinDTO dto = new JoinDTO();
 %>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>회원정보 수정</h2>
<form id="searchbbs" action="modifyPro.kiki" method="post" name="userinput" onSubmit="return checkIt()">
<table id="cbbs_f" border="0" align="center">
	<tr>
	<td width="150">ID</td>
	<td align="left">${sessionScope.centerId}<br><br>
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
		<input type="button" value="메인으로" onclick="javascript:window.location='index.jsp'"/>
		<input type="submit" value="회원수정" />
	</td></tr>
</table>
</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
