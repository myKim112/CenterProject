<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>노곰문화센터</title>
</head>

<c:if test="${lev == 1}">

	<script>
		function writeSave() {
			alert('로그인 후 글쓰기 가능');
			window.location = "/jsp/main.kiki";
		}
	</script>
</c:if>


<body bgcolor="${bodyback_c}">
	<center>
		<b>강좌소개</b>
	</center>
	<br>
	<form method="post" name="writeform" action="classWritePro.kiki"
		onsubmit="return writeSave()">
		<input type="hidden" name="num" value="${num}"> </br> </br>

		<table width="700" border="0" cellspacing="0" cellpadding="0"
			align="center">

			<tr>
				<td align="center" rowspan="9"><input type="file" name="save" /></td>

				<td width="70" align="right">강좌명</td>
				<td width="330">${dto.className }</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<hr style="border: solid 0.5px lightgray;">
				</td>
			</tr>


			<tr>
				<td width="70" align="right">지점</td>
				<td width="330">${dto.center }</td>
			</tr>

			<tr>
				<td width="70" align="right">강좌코드</td>
				<td width="330">${cto.classCord }</td>
			</tr>

			<tr>
				<td width="70" align="right">강사명</td>
				<td width="330">${dto.teacher }<br /></td>
			</tr>

			<tr>
				<td width="70" align="right">강좌 기간</td>
				<td width="330">${dto.classDate }</td>
			</tr>

			<tr>
				<td width="70" align="right">강좌 시간</td>
				<td width="330">${dto.classTime }</td>
			</tr>

			<tr>
				<td width="70" align="right">수강료</td>
				<td width="330">${dto.classPay}</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<hr style="border: solid 0.5px lightgray;">
				</td>
			</tr>
			<tr>
				<td colspan="4" align="right"><input type="button" value="즉시결제"
					onclick="javascript:window.location='classState.kiki'" /> <input
					type="button" value="강좌바구니"
					onclick="javascript:window.location='classbasket.kiki'" /></td>
			</tr>
		</table>
		<br /> <br />
		
		 <b>소개상세</b> <br> <input type="hidden" name="num"
			value="${num}"> </br>

		<table align="center">
			<tr>
				<td colspan="4" align="center">
					<hr align="center" style="border: solid 0.3px lightgray;">
			</tr>
			<tr>
				<td width="80" align="center">대상</td>
				<td width="330">${dto.lev}</td>

				<td width="80" align="center">접수기간</td>
				<td width="330">강좌시작일 3일전 마감</td>
			</tr>

			<tr>
				<td colspan="4" align="center">
					<hr align="center" size="1" color="#EAEAEA">
			</tr>
			<tr>

				<td width="80" align="center">강의실</td>
				<td width="330">문자발송</td>

				<td width="80" align="center">재료비</td>
				<td width="330">문자발송</td>
			</tr>

			<tr>
				<td colspan="4" align="center">
					<hr align="center" size="1" color="#EAEAEA">
			</tr>

			<tr>
				<td width="80" align="center">개요</td>
				<td width="330" colspan="3">${dto.classSummary}</td>
			<tr>
				<td colspan="4" align="center">
					<hr align="center" size="1" color="#EAEAEA">
			</tr>

			<tr>
				<td width="80" height="100" align="center">강의계획서</td>
				<td width="330" colspan="3">${dto.classPlan}</td>
			<tr>
				<td colspan="4" align="center">
					<hr align="center" style="border: solid 0.3px lightgray;">
			</tr>

			<tr>
				<td colspan="4" align="right"><input type="button" value="목록보기"
					onclick="document.location.href='classList.kiki?pageNum=${pageNum}'">
					
					<c:if test="${staff.lev >= 20 }">
					<input type="button" value="글수정"
					onclick="document.location.href='classUpdate.kiki?num=${dto.num}&pageNum=${pageNum}'">
					</c:if>
					<c:if test="${staff.lev >= 500 }">
					<input type="button" value="글삭제"
					onclick="document.location.href='classDelete.kiki?num=${dto.num}&pageNum=${pageNum}'">
					</c:if>

				</td>
			</tr>
		</table>

	</form>
</body>