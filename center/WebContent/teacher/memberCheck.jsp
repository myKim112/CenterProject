<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>수강 회원</title>
</head>

<body>
<table align="center" width="700">
	<tr>
		<td>번호</td>
		<td>회원 ID</td>
		<td>강좌코드</td>
		<td>신청일자</td>
		<td>상태</td>
	</tr>
</table>

<c:if test="${count == 0}">
<table align="center" width="700">
	<tr>
		<td>수강 회원이 없습니다.</td>
	</tr>		
</table>
</c:if>

<c:if test="${count > 0}">
<table align="center" width="700">
<c:forEach var="member" items="${memberList}" varStatus="i">
	<tr>
		<td>${i.count}</td>
		<td>${member.id}</td>
		<td>${member.classCode}</td>
		<td>${member.reg_date}</td>
		<td>${member.position}</td>
	</tr>
</c:forEach>
</table>
</c:if>

<table align="center" width="700">
	<tr>
		<td align="right">
			<input type="button" value="목록" onclick="window.location='teacherClassList.kiki?id=${id}'" />
		</td>
	</tr>
</table>
</body>