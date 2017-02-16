<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" />

<head>
<title>캘린더</title>
</head> 

<script>
	function checkIt() {
		var userinput = eval("document.userinput");
	
		if(!userinput.memoYear.value) {
			alert("년도를 입력하시요.");
			return false;
		}
		
		if(!userinput.memoMonth.value) {
			alert("월을 입력하시요.");
			return false;
		}
		
		if(!userinput.memoDate.value) {
			alert("일을 입력하시요.");
			return false;
		}
		
		if(!userinput.calPw.value) {
			alert("비밀번호를 입력하시요.");
			return false;
		}
	}
</script>
	
<body>
<h1 id="customer"><div>master center</div></h1>
<jsp:include page="sidebar_master.jsp" flush="false" />
<article>
<h2>일정표 일정추가</h2>
<form id="searchbbs" action="calInputPro.kiki" method="post" name="userinput" onSubmit="return checkIt()">
<table id="cbbs_f" align="center" width="300" border="1">
	<tr>
		<th>제목</th>
		<td>
			<input type="text" name="calTitle" />
			<input type="hidden" name="calNum" value="${calNum}"/>
		</td>
	</tr>
	<tr>
		<th>일정</th>
		<td colspan="2">
			<input type="text" name="memoYear" size="4" maxlength="4" />년
			<input type="text" name="memoMonth" size="2" maxlength="2" />월
			<input type="text" name="memoDate" size="2" maxlength="2" />일
		</td>
	</tr>
	<tr>
		<th>내용</th>	
		<td colspan="2">
			<textarea cols="40" rows="10" name="calContent" ></textarea>
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="calPw" size="6" />
		</td>
	</tr>
	<tr>
		<td>
			<input type="button" value="달력으로" onclick="window.location='calendar.kiki'" />
		</td>
		<td>
			<input type="submit" value="일정 등록" />
		</td>
	</tr>
</table>
</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
