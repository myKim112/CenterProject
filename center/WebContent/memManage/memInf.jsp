<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>회원 관리</title>
</head>

<center>
<font size="6" face="impact">
MEMBER INFORMATION</font>
</center>

<body>
<table align="center" width="700">
	<tr>
	<td>ID</td><td>${article.id}</td>
	<td>PASSWORD</td><td>${article.pw}</td>
	</tr>
	<tr>
	<td>이름</td><td>${article.name}</td>
	<td>생년월일</td><td>${article.birth}</td>
	</tr>
	<tr>
	<td>전화번호</td><td>${article.phone}</td>
	<td>E-Mail</td><td>${article.email}</td>
	</tr>
	<tr>
	<td>주소</td><td colspan="3">${article.address}</td>
	</tr>
	<tr>
	<td>은행명</td><td>${article.bankName}</td>
	<td>계죄번호</td><td>${article.bankAccount}</td>
	</tr>
	<tr>
	<td>가입일</td><td>${article.regDate}</td>
	<td>level</td><td>${article.lev}</td>
	</tr>
	<tr>
	<td colspan="4" align="right">
		<input type="button" value="회원 글보기" onclick="document.location.href='/memWriteList.kiki?writer=${article.id}'" />
		<input type="button" value="회원 수강내역" onclick="document.loaction.href='/memClassList.kiki?writer=${article.id}'" />
	</td></tr>
	<tr>
	<td colspan="4" align="right">
		<input type="button" value="탈퇴" onclick="document.location.href=''" />
		<input type="button" value="정보수정" onclick="document.location.href=''"/>
	</td></tr>
	<tr>
	<td colspan="4" align="right">
		<input type="button" value="목록" onclick="document.location.href='/memList.kiki?pageNum=${pageNum}'" />
	</td></tr>
</table>
</body>