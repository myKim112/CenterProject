<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.sql.*" %>
<%@ page import="center.join.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" />

<html>
<% request.setCharacterEncoding("utf-8");%>

 <%
 		String name = request.getParameter("name");
 		String phone = request.getParameter("phone");

		 JoinDAO manager = JoinDAO.getInstance();
		 String check = manager.idFind(name,phone);
 
		 if(name != null) {
 %>
 <body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>아이디 찾기</h2>  
 <form id="searchbbs" method="post" action="loginPage.kiki">
		${name} 님의 아이디는 <b>${name}</b>입니다<p> 
		<br>
		 <input type="submit" value="이전">
<%}else{%>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>아이디 찾기</h2>
<form id="searchbbs" >
		이름 또는 핸드폰번호가 틀렸습니다 <p>
		<br>
		<input type="button" value="다시입력" onclick="window.location='findIdForm.kiki'">
</form>
<%}%>

</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />   
</html>