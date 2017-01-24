<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
<title>회원탈퇴</title>
</head>

<link href="style.css" rel="stylesheet" type="text/css">

<script>
	function begin() {
		 document.myform.pw.focus();
	}
	
	function checkIt() {
		if(!document.myform.pw.value) {
			alert("비밀번호를 입력하지 않으셨습니다.");
	        document.myform.pw.focus();
	        return false;
		}
	}
</script>

<body onload="begin()">
<form name="myform" action="memDeletePro.kiki" method="post" onSubmit="return checkIt()">
<table align="center" border="0" width="260" cellSpacing="1" cellPadding="1">
	<tr height="30">
	<td colspan="2" align="center">
		<b>회원탈퇴</b>
	</td></tr>
	<tr height="30">
 	<td align="center">비밀번호</td>
 	<td>
 		<input type="password" name="pw" size="15" mexlength="12" />
 	</td></tr>
 	<tr height="30">
 	<td colspan="2" align="middle">
		<input type=submit value="회원탈퇴" />
		<input type="button" value="취  소" onclick="window.location='main.kiki'" />
	</td></tr>
</table>
</form>
</body>