<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>캘린더</title>
</head> 

<body>
<form action="calInputPro.kiki" method="post">
<table align="center" width="300" border="1">
	<tr>
		<td align="center" colspan="2"><b>일정 추가</b></td>
	</tr>
	<tr>
		<td>제목 : </td>
		<td>
			<input type="text" name="calTitle" />
			<input type="hidden" name="calNum" value="${calNum}"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="text" name="memoYear" size="4" maxlength="4" />년
			<input type="text" name="memoMonth" size="2" maxlength="2" />월
			<input type="text" name="memoDate" size="2" maxlength="2" />일
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea cols="40" rows="10" name="calContent" ></textarea>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="calPw" size="6" />
		</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="submit" value="일정 등록" />
			<input type="reset" value="다시 등록" />
		</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="button" value="달력으로" onclick="window.location='calendar.kiki'" />
		</td>
	</tr>	
</table>
</form>
</body>