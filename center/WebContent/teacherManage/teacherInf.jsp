<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>강사 관리</title>
</head>

<center>
<font size="6" face="impact">
TEACHER INFORMATION</font>
</center>

<body>
<table align="center" width="700">
	<tr>
	<td>ID</td><td>${staff.id}</td>
	<td>PASSWORD</td><td>${staff.pw}</td>
	</tr>
	<tr>
	<td>이름</td><td>${staff.name}</td>
	<td>생년월일</td><td>${staff.birth}</td>
	</tr>
	<tr>
	<td>전화번호</td><td>${staff.phone}</td>
	<td>E-Mail</td><td>${staff.email}</td>
	</tr>
	<tr>
	<td>주소</td><td colspan="3">${staff.address}</td>
	</tr>
	<tr>
	<td>은행명</td><td>${staff.bankName}</td>
	<td>계죄번호</td><td>${staff.bankAccount}</td>
	</tr>
	<tr>
	<td>가입일</td><td>${staff.regDate}</td>
	<td>직급</td><td>${power.position}</td>
	</tr>
	<tr>
	<td colspan="4" align="right">
		<input type="button" value="강의목록" onclick="document.location.href=''" />
	</td></tr>
	<tr>
	<td colspan="4" align="right">
		<input type="button" value="권한부여" onclick="document.location.href='teacherLevel.kiki?id=${staff.id}'" />
		<input type="button" value="정보수정" onclick="document.location.href='teacherUpdateForm.kiki?id=${staff.id}'"/>
	</td></tr>
	<tr>
	<td colspan="4" align="right">		
		<input type="button" value="퇴사처리" onclick="document.location.href='teacherQuitPro.kiki?id=${staff.id}'" />
	</td></tr>
	<tr>
	<td colspan="4" align="right">
		<input type="button" value="목록" onclick="document.location.href='teacherList.kiki?pageNum=${pageNum}'" />
	</td></tr>
</table>
</body>