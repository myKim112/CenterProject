<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<form action="calUpdatePro.kiki?calNum=${cal.calNum}" method="post">
<table align="center" width="300" border="1">
	<tr>
		<td align="center" colspan="2"><b>일정 추가</b></td>
	</tr>
	<tr>
		<td>제목 : </td>
		<td>
			<input type="text" name="calTitle" value="${cal.calTitle}" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="text" name="memoYear" size="4" maxlength="4" value="${cal.memoYear}"/>년
			<input type="text" name="memoMonth" size="2" maxlength="2" value="${cal.memoMonth}"/>월
			<input type="text" name="memoDate" size="2" maxlength="2" value="${sdf.format(cal.calDate)}"/>일
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea cols="40" rows="10" name="calContent" >${cal.calContent}</textarea>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="calPw" size="6" />
		</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="submit" value="일정 수정" />
			<input type="reset" value="다시 등록" />
		</td>
	</tr>
	<tr>
		<td align="right" colspan="2">
			<input type="button" value="달력으로" onclick="calendar.kiki" />
		</td>
	</tr>	
</table>
</form>
</body>