<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="java.sql.*" %>
<%@ page import="center.join.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

 <form method="post" action="">
		${name} 님에 아이디는 <b>${name}</b>입니다<p> 
		 <input type="submit" value="로그인폼으로">}
<%}else{%>
		이름 또는 핸드폰번호가 틀렸습니다 <p>
		<input type="button" value="다시입력하기" onclick="findIdForm.kiki">
<%}%>

</p>
</form>

</html>