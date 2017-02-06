<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>노곰문화센터</title>
</head>


<body >
	<center>
		<b>강좌소개</b>
	</center>
	<br>
	<form method="post" name="classFile" >
		<input type="hidden" name="num" value="${num}"> </br> </br>

		<table width="800" border="0" cellspacing="0" cellpadding="0"align="center" >

			<tr>
				<td align="center" rowspan="10" width="300" style="table-layout:fixed" >
				<img src="/center/classSave/${dto.sysName}" width="200" ></td>

				<td width="70" align="right">강좌명</td>
				<td width="330">&nbsp;${dto.className }</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<hr style="border: solid 0.5px lightgray;">
				</td>
			</tr>


			<tr>
				<td width="70" align="right">지점</td>
				<td width="330">&nbsp;&nbsp;&nbsp;${dto.center }</td>
			</tr>

			<tr>
				<td width="70" align="right">강좌코드</td>
				<td width="330">&nbsp;&nbsp;&nbsp;${dto.classCode }</td>
			</tr>

			<tr>
				<td width="70" align="right">강사명</td>
				<td width="330">&nbsp;&nbsp;&nbsp;${dto.teacher }<br /></td>
			</tr>

			<tr>
				<td width="70" align="right">강좌 기간</td>
				<td width="330">&nbsp;&nbsp;&nbsp;${dto.classDate }</td>
			</tr>

			<tr>
				<td width="70" align="right">강좌 시간</td>
				<td width="330">&nbsp;&nbsp;&nbsp;${dto.classTime }</td>
			</tr>

			<tr>
				<td width="70" align="right">수강료</td>
				<td width="330">&nbsp;&nbsp;&nbsp;${dto.classPay }</td>
			</tr>
			
			<tr>
				<td width="70" align="right">인원</td>
				<td width="330">&nbsp;&nbsp;&nbsp;${dto.person}</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<hr style="border: solid 0.5px lightgray;">
				</td>
			</tr>
			
			<tr>
			<input type="hidden" name="num" value="${num}">
				<td colspan="4" align="right"><input type="button" value="즉시결제"
					onclick="javascript:window.location='classState.kiki'" /> <input
					type="button" value="강좌바구니"
					onclick="javascript:window.location='classCartListPro.kiki?classCode=${dto.classCode}&pageNum=${pageNum}'" /></td>
			</tr>
		</table>
		<br /> <br />
		
		 <center><b>소개상세</b> <br><center> <input type="hidden" name="num"
			value="${num}"> </br>

		<table align="center">
			<tr>
				<td colspan="4" align="center">
					<hr align="center" style="border: solid 0.3px lightgray;">
			</tr>
			<tr>
				<td width="80" align="center">대상</td>
				<td width="330">&nbsp;&nbsp;&nbsp;${dto.lev}</td>

				<td width="80" align="center">접수기간</td>
				<td width="330">&nbsp;&nbsp;&nbsp;강좌시작일 3일전 마감</td>
			</tr>

			<tr>
				<td colspan="4" align="center">
					<hr align="center" size="1" color="#EAEAEA">
			</tr>
			<tr>

				<td width="80" align="center">강의실</td>
				<td width="330">&nbsp;&nbsp;&nbsp;문자발송</td>

				<td width="80" align="center">재료비</td>
				<td width="330">&nbsp;&nbsp;&nbsp;문자발송</td>
			</tr>

			<tr>
				<td colspan="4" align="center">
					<hr align="center" size="1" color="#EAEAEA">
			</tr>

			<tr>
				<td width="80" align="center">개요</td>
				<td width="330" colspan="3"><pre>${dto.classSummary}</pre></td>
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
					onclick="document.location.href='classList.kiki'">
					
					<c:if test="${power.lev>=20 }">
					<input type="button" value="글수정"
					onclick="document.location.href='classUpdate.kiki?num=${dto.num}&pageNum=${pageNum}'">
					
					
					<input type="button" value="글삭제"
					onclick="document.location.href='classDelete.kiki?num=${dto.num}&pageNum=${pageNum}'">
					</c:if>

				</td>
			</tr>
		</table>

	</form>
</body>