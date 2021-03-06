<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" flush="false" />  

<head>
<title>수강 회원</title>
</head>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_teacher.jsp" flush="false"/>
<article>
	<h2>수강 회원</h2>
<table id="cbbs_f" align="center" width="700">
	<tr>
		<td>번호</td>
		<td>회원 ID</td>
		<td>강좌코드</td>
		<td>신청일자</td>
		<td>상태</td>
	</tr>
</table>

<c:if test="${count == 0}">
<table id="cbbs_f" align="center" width="700">
	<tr>
		<td>수강 회원이 없습니다.</td>
	</tr>		
</table>
</c:if>

<c:if test="${count > 0}">
<table id="cbbs_f" align="center" width="700">
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

</article>
<jsp:include page="footer.jsp" flush="false" />
</body>