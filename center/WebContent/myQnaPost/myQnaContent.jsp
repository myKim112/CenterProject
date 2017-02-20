<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 게시글 내용보기</title>
</head>
<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>나의 질문</h2>
<center>
	<table id="cbbs_f">
		<tr>
			<td align="center">글번호</td>
			<td align="center">${article.num}</td>
			<input type="hidden" name="num" value="${atricle.num }">
			<td align="center">조회수</td>
			<td align="center">${article.readCount }</td>
		</tr>
		<tr>
			<td align="center">작성일</td>
			<td align="center"  colspan="3">${article.regDate }</td>
		</tr>
		<tr>
			<td align="center">글제목</td>
			<td align="center"  colspan="3">${article.title}</td>
		</tr>
		<tr>
			<td align="center">글내용</td>
			<td align="center"  colspan="3">${article.content}</td>
		</tr>	
		<tr>
			<td align="center" colspan="4">
				<input type="button" value="글수정" onclick="document.location.href='/center/myQnaUpdateForm.kiki?num=${article.num}&pageNum=${pageNum}'">
				<input type="button" value="글삭제" onclick="document.location.href='/center/myQnaDeleteForm.kiki?num=${article.num}&pageNum=${pageNum}'">
				<input type="button" value="글목록" onclick="document.location.href='/center/myQnaList.kiki?pageNum=${pageNum}'">
			</td>
		</tr>					
	</table>
</center>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>