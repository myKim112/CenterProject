<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:include page="header.jsp" flush="false" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>review글수정</title>
</head>
<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>나의 수강후기</h2>
	<form  id="searchbbs" method="post" action="myReviewUpdatePro.kiki" onsubmit="return writeSave()">
	<input type="hidden" name="pageNum" value="${pageNum }">
	<input type="hidden" name="num" value="${num }">
	<table id="cbbs_f">
		<tr>
			<td align="center">센터명</td>
			<td align="center">
				<input type="text" name="center" value="${article.center}">
       			<input type="hidden" name="center" value="${article.center}">	
			</td>	
		</tr>
		<tr>				
			<td align="center">제목</td>
			<td align="center">
				<input type="text" name="title" value="${article.title}">
       			<input type="hidden" name="title" value="${article.title}">				
			</td>
		</tr>	
		<tr>			
			<td align="center">작성자</td>
			<td align="center">
				<input type="text" name="writer" value="${article.writer}">
       			<input type="hidden" name="writer" value="${article.writer}">				
			</td>	
		</tr>
		<tr>							
			<td align="center">내용</td>
			<td align="center">
				<textarea name="content" name="content">${article.content}</textarea>
       			<input type="hidden" name="content" value="${article.content}">				
			</td>	
		</tr>
		<tr>							
			<td align="center">비밀번호</td>
			<td align="center">
				<input type="password" name="pw">
       			<input type="hidden" name="pw" value="${article.pw}">				
			</td>			
		</tr>
		<tr>
			<td colspan="5" align="center">
     		<input type="button" value="목록보기"
      			 onclick="document.location.href='/center/myReviewList.kiki?pageNum=${pageNum}'">
     		<input type="submit" value="글수정" > 
			</td>
		</tr>
	</table>
	</form>
</center>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>