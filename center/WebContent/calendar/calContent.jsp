<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<head>
<title>캘린더</title>
</head>

<body>
<h1 id="customer"><div>master center</div></h1>
<jsp:include page="sidebar_teacher.jsp" flush="false" />
<article>
<h2>일정확인</h2>
<form id="searchbbs" action="" method="post">
<table id="cbbs_f">
	<tr>
		<th colspan="2" ><b>일정 확인</b></th>
	</tr>
	<tr>
		<th>제목</th>
		<td>${cal.calTitle}</td>
	</tr>
	<tr>
		<th>일정</th>
		<td width="500">
			${cal.memoYear}년 ${cal.memoMonth}월${sdf.format(cal.calDate)}일
		</td>
	</tr>
	<tr>
		<th>내용</th>	
		<td>
			<pre>${cal.calContent}</pre>
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="일정 수정" onclick="window.location='calUpdateForm.kiki?calNum=${cal.calNum}'"/>
		</td>
		<td>
			<input type="button" value="일정 삭제" onclick="window.location='calDeleteForm.kiki?calNum=${cal.calNum}'" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="목록" onclick="window.location='calendar.kiki'" />
		</td>
	</tr>			
</table>
</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />