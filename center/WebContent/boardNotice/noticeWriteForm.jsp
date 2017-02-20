<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 글작성</title>
</head>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_customer.jsp" flush="false" />
<article>
<h2>공지사항 글작성</h2>
<center>
	<form id="searchbbs" method="post" action="/center/noticeWritePro.kiki" onsubmit="return wrtieSave()">
	<input type="hidden" name="num" value="${num}">
		<table id="cbbs_f">
			<tr>
				<td>센터명</td>
				<td><input type="text" name="center"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
      				<input type="text" name="title">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content"></textarea></td>
			</tr>
		</table>
		<br><br>
		<table>
			<tr>
				<c:if test="${sessionScope.centerId !=null && sessionScope.centerId == 'MY00001'}">
				<td>
					<input type="submit" value="글쓰기">
				</td>
				</c:if>
				<td>&nbsp;&nbsp;&nbsp;</td>
				<td>
					<input type="button" value="목록보기" onclick="window.location='/center/noticeList.kiki'">
				</td>
			</tr>
		</table>
	</form>
</center>
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html>