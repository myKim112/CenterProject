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
<h2>���̵� ã��</h2>  
 <form id="searchbbs" method="post" action="loginPage.kiki">
		${name} ���� ���̵�� <b>${name}</b>�Դϴ�<p> 
		<br>
		 <input type="submit" value="����">
<%}else{%>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>���̵� ã��</h2>
<form id="searchbbs" >
		�̸� �Ǵ� �ڵ�����ȣ�� Ʋ�Ƚ��ϴ� <p>
		<br>
		<input type="button" value="�ٽ��Է�" onclick="window.location='findIdForm.kiki'">
</form>
<%}%>

</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />   
</html>