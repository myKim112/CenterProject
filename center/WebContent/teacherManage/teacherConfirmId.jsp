<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>중복확인</title>
</head>

<body>
<c:if test="${check == 1}">
<form name="checkForm" method="post" action="teacherConfirmId.kiki">
<table align="center" width="270">
	<tr>
	<td align="center">
		${id} : 이미 사용 중인 사원번호입니다.
	</td></tr>
	<tr>
	<td align="center">
		다른 사원번호를 선택하시요.<br><br>
		<input type="text" size="10" maxlength="12" name="id" /> &nbsp;
		<input type="submit" value="중복확인" />
	</td></tr>
</table>
</form>
</c:if>

<c:if test="${check < 0}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
	<tr>
	<td align="center">
		입력하신 ${id}는<br>
		 사용하실 수 있습니다.<br/><br/>
		<input type="button" value="닫기" onclick="setId()" />
	</td></tr>
</table>
</c:if>
</body>

<script>
function setId() {
	opener.document.userinput.id.value="${id}";
	
	self.close();
}
</script>