<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A 글쓰기</title>
</head>
<body>
<center><b>글쓰기</b>
	<form method="post" action="/center/qnaWritePro.kiki" onsubmit="return wrtieSave()">
	<input type="hidden" name="num" value="${num}">
	<input type="hidden" name="ref" value="${ref}">
	<input type="hidden" name="reStep" value="${reStep}">
	<input type="hidden" name="reLevel" value="${reLevel}">
		<table width="400" border="1" cellspacing="0" cellpadding="0"  align="center">
			<tr>
				<td>센터명</td>
				<td><input type="text" name="center"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<c:if test="${num == 0}">
      					 <input type="text" size="40" maxlength="50" name="title">
					</c:if>
					<c:if test="${num != 0}">
   						<input type="text" size="40" maxlength="50" name="title" value="[답변]">
					</c:if>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onclick="window.location='/center/qnaList.kiki'">
				</td>
			</tr>
		</table>
	</form>
</center>

</body>
</html>