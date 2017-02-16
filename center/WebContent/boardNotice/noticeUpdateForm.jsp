<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:include page="header.jsp" flush="false" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 글수정</title>
</head>
<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_customer.jsp" flush="false" />
<article>
<h2>공지사항</h2>
<center>
	<form id="searchbbs" method="post" action="/center/noticeUpdatePro.kiki" onsubmit="return writeSave()">
	<input type="hidden" name="pageNum" value="${pageNum }">
	<input type="hidden" name="num" value="${num }">
	<table id="cbbs_f">
		<tr>
			<th>센터명</th>
			<td>
				<input type="text" name="center" value="${article.center}">
       			<input type="hidden" name="center" value="${article.center}">	
			</td>
		</tr>
		<tr>			
			<th>제목</th>
			<td>
				<input type="text" name="title" value="${article.title}">
       			<input type="hidden" name="title" value="${article.title}">				
			</td>	
		</tr>
		<tr>		
			<th>내용</th>
			<td>
				<textarea name="content">${article.content}</textarea>
       			<input type="hidden" name="content" value="${article.content}">	
       		</td>				
		</tr>
	</table>
	<br>
	<table>
		<tr>
			<td colspan="3" align="center">
     			<input type="submit" value="글수정" > 
     			<input type="button" value="목록보기"
      			 onclick="document.location.href='/center/noticeList.kiki?pageNum=${pageNum}'">
			</td>
		</tr>
	</table>
	</form>
</center>
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html>