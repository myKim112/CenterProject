<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<head>
<title>관리 페이지</title>
</head>

<body>
<h1 id="customer"><div>master center</div></h1>
<jsp:include page="sidebar_master.jsp" flush="false" />
<article>

<h2>관리 페이지</h2>

<table id="cbbs_f">
	<tr>
		<td>
			<a href="classContent.kiki?num=${num}&pageNum=${pageNum}">강좌 내용</a>
		</td>
	</tr>
	<tr>
		<td>
			<a href="memberCheck.kiki?classCode=${classCode}">수강 회원 목록</a>
		</td>
	</tr>	
</table>

</article>
<jsp:include page="footer.jsp" flush="false" />
</body>