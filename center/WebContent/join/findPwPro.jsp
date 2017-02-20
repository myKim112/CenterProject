<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="center.join.*" %>
<jsp:include page="header.jsp" flush="false" />

<%


	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String pw = request.getParameter("pw");
	String id = request.getParameter("id");
%>



<body >
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>비밀번호 찾기</h2> 
<c:if test="${null ne pw}">
<form id="searchbbs"method="post" name="findIdRs"  action="loginPage.kiki">
	  <font size="+1" ><b>${id}님의 비밀번호는
${pw}입니다</b></font><br><br>
<input type="submit" value="이전">
</form>
</c:if>



<c:if test="${null eq pw}">

	<script> 
	  alert("일치하는 회원정보가 없습니다");
      history.go(-1);
	</script>

</c:if>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />   
</html>