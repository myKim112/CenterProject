<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>수강 회원</title>
</head>

<body>
<table align="center" width="700">
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>

<c:if test="${count == 0}">
<table align="center" width="700">
	<tr>
		<td>수강 회원이 없습니다.</td>
	</tr>		
</table>
</c:if>

<c:if test="${count > 0">
<table align="center" width="700">
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
</table>
</c:if>
</body>