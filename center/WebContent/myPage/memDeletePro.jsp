<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>노곰문화센터</title>
</head>

<link href="style.css" rel="stylesheet" type="text/css">

<body>
<c:if test="${check == 1}">
<form method="post" action="main.kiki" name="userinput">
<table border="0" align="center">
	<tr>
	<td align="center">
		<b>회원정보가 삭제되었습니다.</b>
	</td></tr>
	<tr>
	<td align="center">갑세<br/>
	<meta http-equiv="Refresh" content="5;url=main.kiki">
	</td></tr>
	<tr>
	<td align="right">
		<input type="submit" value="확인">
	</td></tr>
</table>
</form>
</c:if>

<c:if test="${check == 0}">
	<script> 
	  alert("비밀번호가 맞지 않습니다.");
      history.go(-1);
	</script>
</c:if>

</body>