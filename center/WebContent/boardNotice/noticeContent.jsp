<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 게시글 내용보기</title>
</head>
<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_customer.jsp" flush="false" />
<article>
<h2>공지사항</h2>
<center>
<form id="searchbbs" >
	<table id="cbbs_f">
		<tr>
			<th>
				글번호
				<input type="hidden" name="num" value="${atricle.num }">
			</th>
			<td>${article.num}</td>
			<th>조회수</th>
			<td>${article.readCount }</td>
			<th>작성일</th>
			<td>${article.regDate }</td>			
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="5">${article.title}</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td colspan="5">${article.content}</td>
		</tr>	
	</table>
	<br><br>
	<table align="left">
		<tr>
				<c:if test="${sessionScope.centerId !=null && sessionScope.centerId == 'MY00001'}">
			<td>
				<input type="button" value="글수정" onclick="document.location.href='/center/noticeUpdateForm.kiki?num=${article.num}&pageNum=${pageNum}'">
			</td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>
				<input type="button" value="글삭제" onclick="document.location.href='/center/noticeDeletePro.kiki?num=${article.num}&pageNum=${pageNum}'">
			</td>
			<td>&nbsp;&nbsp;&nbsp;</td>			
				</c:if>
			<td>
				<input type="button" value="글목록" onclick="document.location.href='/center/noticeList.kiki?pageNum=${pageNum}'">
			</td>
		</tr>					
	</table>
				<%-- <div class="btn"><a href="noticeList.kiki?pageNum=${pageNum}">목록</a></div> --%>
</form>	
</center>
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html>