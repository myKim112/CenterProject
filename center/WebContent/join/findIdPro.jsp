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
		${name} �Կ� ���̵�� <b>${name}</b>�Դϴ�<p> 
		 <input type="submit" value="�α���������">}
<%}else{%>
		�̸� �Ǵ� �ڵ�����ȣ�� Ʋ�Ƚ��ϴ� <p>
		<input type="button" value="�ٽ��Է��ϱ�" onclick="findIdForm.kiki">
<%}%>

</p>
</form>

</html>