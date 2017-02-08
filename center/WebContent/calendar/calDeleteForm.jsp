<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>캘린더</title>
</head>

<script>
	function deleteCheck() {
		if(document.deleteForm.calPw.value='') {
			alert("비밀번호를 입력하시오.");
			document.deleteForm.calPw.focus();
			return false;
		}
	}
</script>

<form action="calDeletePro.kiki?calNum=${calNum}" method="post" name="deleteForm" onsubmit="return deleteCheck()">
<table align="center">
	<tr>
		<td>비밀번호 :
			<input type="password" name="calPw" />
		</td>
	</tr>
	<tr>
		<td align="center">
			<input type="submit" value="삭제" />
		</td>
	</tr>
</table>
</form>