<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A 게시글 내용보기</title>
</head>
<body>
<center>
	<table border="1">
		<tr>
			<td align="center">글번호</td>
			<td align="center">${article.num}</td>
			<input type="hidden" name="num" value="${num }">
			<td align="center">조회수</td>
			<td align="center">${article.readCount }</td>
		</tr>
		<tr>
			<td align="center">작성자</td>
			<td align="center">${article.writer }</td>
			<td align="center">작성일</td>
			<td align="center">${article.regDate }</td>
		</tr>
		<tr>
			<td align="center">글제목</td>
			<td align="center"  colspan="3">${article.title}</td>
		</tr>
		<tr>
			<td align="center">글내용</td>
			<td align="center"  colspan="3">
				<textarea name="content" name="content">${article.content}</textarea>			
			</td>
		</tr>	
		<tr>
			<td align="center" colspan="4">
				<input type="button" value="글수정" onclick="document.location.href='/center/qnaUpdateForm.kiki?num=${article.num}&pageNum=${pageNum}'">
				<input type="button" value="글삭제" onclick="document.location.href='/center/qnaDeleteForm.kiki?num=${article.num}&pageNum=${pageNum}'">
				<input type="button" value="답글쓰기" onclick="document.location.href='/center/qnaWriteForm.kiki?num=${num}&ref=${article.ref}&reStep=${article.reStep}&reLevel=${article.reLevel}'">
				<input type="button" value="글목록" onclick="document.location.href='/center/qnaList.kiki?pageNum=${pageNum}'">
			</td>
		</tr>					
	</table>
</center>
</body>
</html>