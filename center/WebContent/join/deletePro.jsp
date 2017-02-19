<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import = "center.join.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" />

<html>
<head>
<title>회원탈퇴</title>
</head>

<%--
    String id = (String)session.getAttribute("centerId"); 
    String pw  = request.getParameter("pw"); //

	JoinDAO manager = JoinDAO.getInstance();
    int check = manager.deleteMem(id,pw);
	//요기까지 액션에 들어가고 아래 값도 액션에 같이 넣어주라 
	if(check==1){
--%>

<body >
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>회원탈퇴</h2>
<form id="searchbbs" method="post" action="index.jsp" name="userinput" >
<table id="cbbs_f">
<c:if test="${check==1}"> 
<%		session.invalidate(); %>
  <tr > 
    <td>
	  <font size="+1" ><b>회원정보가 완벽히 삭제되었습니다.</b></font></td>
  </tr>
  <tr >
    <td> 
      <p>정보는 삭제되었지만 우린 당신을 기억하고, 기다리겠습니다<p>
      <meta http-equiv="Refresh" content="5;url=loginPage.kiki" >
    </td>
  </tr>
  <tr>
    <td> 
      <input type="submit" value="확인" onclick="javascript:window.location='loginPage.kiki'">
    </td>
  </tr>
  </c:if>
</table>

<c:if test="${check==0}"> 
	<script> 
	  alert("비밀번호가 맞지 않습니다.");
      history.go(-1);
	</script>
</c:if>

</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html>