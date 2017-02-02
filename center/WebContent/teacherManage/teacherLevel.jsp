<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>직원관리</title>
</head>

<center>
<font face="impact">
권한 부여</font>
</center>

<body>
<form action="teacherLevelPro.kiki?id=${staff.id}" method="post" >
<table align="center">
	<tr>
	<td>ID</td>
	<td>변경 전</td>
	<td>변경 후</td>
	</tr>
	<tr>
	<td>${staff.id}</td>
	<td>${power.position}</td>
	<td>
		<select name="lev">
			<option value="20">강사</option>
			<option value="50">팀장</option>
			<option value="500">중간관리자</option>
			<option value="1000">최고관리자</option>
		</select>
		
		<input type="submit" value="수정" />
	</td></tr>
</table>
</form>
</body>