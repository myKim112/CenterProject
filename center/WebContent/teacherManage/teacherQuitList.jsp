<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<head>
<title>퇴사자 목록</title>
</head>

<center>
<font face="impact">퇴사자 목록</font>
</center>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_master.jsp" flush="false" />
<article>
<h2>퇴사자 목록</h2>
<table id="cbbs_f">
	<tr>
	<td align="center">퇴사자 수(${count})</td>
	</tr>
</table>

<table id="cbbs_f">
	<tr>
	<td>번호</td>
	<td>ID</td>
	<td>강사 이름</td>
	<td>&nbsp;&nbsp;&nbsp;</td>
</table>

<c:if test="${count == 0}">
<table id="cbbs_f">
	<tr>
	<td align="center">확인되는 퇴사자가 없습니다.</td>
</table>
</c:if>

<c:if test="${count > 0}">
<table id="cbbs_f">
<c:forEach var="staff" items="${staffList}" varStatus="i">
	<tr>
	<td>${i.count}</td>
	<td><a href="teacherInf.kiki?id=${staff.id}&pageNum=${pageNum}">${staff.id}</a></td>
	<td>${staff.name}</td>
	<td>
		<input type="button" value="삭제" onclick="window.location='teacherDeletePro.kiki?id=${staff.id}'" />
	</td>
</c:forEach>
</table>
</c:if>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>