<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 글쓰기</title>
</head>
<body>
<center><b>공지사항 글쓰기</b>
	<form method="post" action="/center/noticeWritePro.kiki" onsubmit="return wrtieSave()">
	<input type="hidden" name="num" value="${num}">
		<table width="400" border="1" cellspacing="0" cellpadding="0"  align="center">
			<tr>
				<td>센터명</td>
				<td><input type="text" name="center"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
      				<input type="text" size="40" maxlength="50" name="title">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onclick="window.location='/center/noticeList.kiki'">
				</td>
			</tr>
		</table>
	</form>
</center>

</body>
</html>