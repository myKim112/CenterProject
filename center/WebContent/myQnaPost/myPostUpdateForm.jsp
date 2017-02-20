<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 글수정</title>
</head>
<body>
<center><b>공지사항 글수정</b>
	<form method="post" action="/center/myPostUpdatePro.kiki" onsubmit="return writeSave()">
	<input type="hidden" name="pageNum" value="${pageNum }">
	<input type="hidden" name="num" value="${num }">
	<table border="1">
		<tr>
			<td align="center">센터명</td>
			<td align="center">제목</td>
			<td align="center">내용</td>
		</tr>
		<tr>
			<td align="center">
				<input type="text" name="center" value="${article.center}">
       			<input type="hidden" name="center" value="${article.center}">	
			</td>
			<td align="center">
				<input type="text" name="title" value="${article.title}">
       			<input type="hidden" name="title" value="${article.title}">				
			</td>
			<td align="center">
				<input type="text" name="content" value="${article.content}">
       			<input type="hidden" name="content" value="${article.content}">				
		</tr>
		<tr>
			<td colspan="3" align="center">
     			<input type="submit" value="글수정" > 
     			<input type="reset" value="다시작성">
     			<input type="button" value="목록보기"
      			 onclick="document.location.href='/center/myPostList.kiki?pageNum=${pageNum}'">
			</td>
		</tr>
	</table>
	</form>
</center>
</body>
</html>