<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" flush="false" />  

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_lecture.jsp" flush="false"/>
<article>
	<h2>강좌소개</h2>
<c:if test="${check==1}"> 
<meta http-equiv="Refresh" content="0;url=classList.kiki" >
</c:if>
<c:if test="${check==0}"> 
비밀번호가 다릅니다.
<br>
<a href="javascript:history.go(-1)">[글수정 폼으로 돌아가기]</a>
</c:if>
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>