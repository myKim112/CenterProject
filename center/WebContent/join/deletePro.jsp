<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import = "center.join.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" />

<html>
<head>
<title>ȸ��Ż��</title>
</head>

<%--
    String id = (String)session.getAttribute("centerId"); 
    String pw  = request.getParameter("pw"); //

	JoinDAO manager = JoinDAO.getInstance();
    int check = manager.deleteMem(id,pw);
	//������ �׼ǿ� ���� �Ʒ� ���� �׼ǿ� ���� �־��ֶ� 
	if(check==1){
--%>

<body >
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>ȸ��Ż��</h2>
<form id="searchbbs" method="post" action="index.jsp" name="userinput" >
<table id="cbbs_f">
<c:if test="${check==1}"> 
<%		session.invalidate(); %>
  <tr > 
    <td>
	  <font size="+1" ><b>ȸ�������� �Ϻ��� �����Ǿ����ϴ�.</b></font></td>
  </tr>
  <tr >
    <td> 
      <p>������ �����Ǿ����� �츰 ����� ����ϰ�, ��ٸ��ڽ��ϴ�<p>
      <meta http-equiv="Refresh" content="5;url=loginPage.kiki" >
    </td>
  </tr>
  <tr>
    <td> 
      <input type="submit" value="Ȯ��" onclick="javascript:window.location='loginPage.kiki'">
    </td>
  </tr>
  </c:if>
</table>

<c:if test="${check==0}"> 
	<script> 
	  alert("��й�ȣ�� ���� �ʽ��ϴ�.");
      history.go(-1);
	</script>
</c:if>

</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html>