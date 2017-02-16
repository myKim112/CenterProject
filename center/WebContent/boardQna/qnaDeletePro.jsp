<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객상담게시판 글수정</title>
</head>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_customer.jsp" flush="false" />
<article>
<h2>고객상담 글수정</h2>
<c:if test="${check==1}"> 
	<meta http-equiv="Refresh" content="0;url=qnaList.kiki?pageNum=${pageNum}" >
</c:if>
<c:if test="${check==0}"> 
비밀번호가 다릅니다.
<br>
<a href="javascript:history.go(-1)">[이전으로 돌아가기]</a>
</c:if>
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html>