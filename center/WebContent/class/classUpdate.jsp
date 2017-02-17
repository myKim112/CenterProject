<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" flush="false" /> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>노곰문화센터</title>


<body bgcolor="${bodyback_c}">
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_lecture.jsp" flush="false" />
<article>
<h2>강좌소개</h2>
		<br>
		
		<form method="post" name="Updateform"
			action="classUpdatePro.kiki?num=${dto.num}&pageNum=${pageNum}"
			onsubmit="return updateSave(${pw}, ${dto.pw })" enctype="multipart/form-data">

			<input type="hidden" name="num" value="${dto.num}"> </br> </br>

			<table width="700" border="0" cellspacing="0" cellpadding="0"
				align="center">

				<tr>
					<td align="center" rowspan="11"><input type="file" name="save" value="${dto.sysName }"/>${dto.sysName}</td>
					<td width="70" align="right">강좌명</td>
					<td width="330"><input type="text" size="40" maxlength="50"
						name="className" value="${dto.className}"></td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<hr style="border: solid 0.5px lightgray;">
					</td>
				</tr>

				<tr>
					<td width="70" align="right">지점</td>
					<td width="330">
						<input type="text" size="10" maxlength="10"	name="center" value="${dto.center}"></td>
				</tr>

				<tr>
					<td width="70" align="right">강좌코드</td>
					<td width="330">
						<input type="text" size="10" maxlength="10"	name="classCode" value="${dto.classCode}"></td>
				</tr>

				<tr>
					<td width="70" align="right">강사명</td>
					<td width="330">
						<input type="text" size="40" maxlength="30"	name="teacher" value="${dto.teacher}"><br /></td>
				</tr>

				<tr>
					<td width="70" align="right">강좌 기간</td>
					<td width="330">
						<input type="text" size="40" maxlength="30"	name="classDate" value="${dto.classDate}"></td>
				</tr>

				<tr>
					<td width="70" align="right">강좌 시간</td>
					<td width="330">
						<input type="text" size="40" maxlength="30"	name="classTime" value="${dto.classTime}"></td>
				</tr>

				<tr>
					<td width="70" align="right">수강료</td>
					<td width="330">
						<input type="text" size="10" maxlength="10"	name="classPay" value="${dto.classPay}"></td>
				</tr>

			<tr>
				<td width="70" align="right">인원</td>
				<td width="330">
					<input type="text" size="40" maxlength="30"	name="person" value="${dto.person}"></td>
			</tr>
			
			<tr>
				<td width="70" align="right">강사ID</td>
				<td width="330">
					<input type="text" size="40" maxlength="30"	name="teacherId" value="${dto.teacherId}" />
				</td>
			</tr>
			
				<tr>
					<td colspan="2" align="center">
						<hr style="border: solid 0.5px lightgray;">
					</td>
				</tr>
				<%-- 
				<tr>
					<td colspan="4" align="right"><input type="button"
						value="즉시결제"
						onclick="javascript:window.location='classState.kiki'" /> <input
						type="button" value="강좌바구니"
						onclick="javascript:window.location='classCart.kiki'" /></td>
				</tr>
				--%>
			</table>
			<br /> <br />
		<h2>소개상세</h2>

			<table align="center">
				<tr>
					<td colspan="3" align="center">
						<hr align="center" style="border: solid 0.4px lightgray;">
				</tr>

				<tr>
					<td>대상&nbsp;<input type="text" name="lev" value="${dto.lev}"></td>
					<td>접수기간</td>
					<td>강좌시작일 3일전 마감</td>
				</tr>

				<tr>
					<td colspan="3" align="center">
						<hr align="center" size="1" color="#EAEAEA">
				</tr>

				<tr>
					<td>강의실</td>
					<td>문자발송</td>
					<td>재료비</td>
				</tr>

				<tr>
					<td colspan="3" align="center">
						<hr align="center" size="1" color="#EAEAEA">
				</tr>

				<tr>
					<td colspan="4">개요</td>
				</tr>
				<tr>
					<td width="250" colspan="3">
						<textarea rows="50" cols="100" name="classSummary" style="margin: 0px; width: 650px; height: 300px; resize: none;">${dto.classSummary}</textarea></td>
				<tr>
					<td colspan="3" align="center">
						<hr align="center" size="1" color="#EAEAEA">
				</tr>

				<tr>
					<td colspan="4">강의계획서</td>
				</tr>
				<tr>
					<td width="330" colspan="3">
						<textarea rows="50" cols="100" name="classPlan"	style="margin: 0px; width: 650px; height: 300px; resize: none;">${dto.classPlan }</textarea>
					</td>
				</tr>	
				<tr>
					<td colspan="4">비밀번호&nbsp;
					<input type="password" size="8"
						maxlength="12" name="pw" value="${dto.pw }"></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<hr align="center" style="border: solid 0.3px lightgray;">
				</tr>

				<tr>
					<td colspan="4" align="right"><input type="submit" value="수정">
						<input type="reset" value="다시작성"> <input type="button"
						value="목록보기" OnClick="window.location='classList.kiki'"></td>
				</tr>
			</table>
</form>			

</html>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>