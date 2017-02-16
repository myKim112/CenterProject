<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<head>
<title>직원관리</title>
</head>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_teacher.jsp" flush="false" />
<article>
<h2>권한부여</h2>
<form action="teacherLevelPro.kiki?id=${staff.id}&pageNum=${pageNum}" method="post" >
<table id="cbbs_f">
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
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>
