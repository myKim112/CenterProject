<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>캘린더</title>
</head>

<body>
<form action="" method="post">
<table align="center" width="300" border="1">
	<tr>
		<td align="center" colspan="2"><b>일정 확인</b></td>
	</tr>
	<tr>
		<td>제목 : </td>
		<td>${cal.calTitle}</td>
	</tr>
	<tr>
		<td colspan="2">
			
			${cal.memoYear}년 ${cal.memoMonth}월 ${sdf.format(cal.calDate)}일
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<pre>${cal.calContent}</pre>
		</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="button" value="일정 수정" onclick="window.location='calUpdateForm.kiki?calNum=${cal.calNum}'"/>
		</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="button" value="목록" onclick="window.location='calendar.kiki'" />
		</td>
	</tr>			
</table>
</form>
</body>