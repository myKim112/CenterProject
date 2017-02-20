<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>로그인</h2>
	<c:if test="${check == 1}"> <!-- check가 1과 같을때 -->
		<c:redirect url="index.jsp"/>	 <!-- main.do로 이동해라 -->
	</c:if>
	<c:if test="${check == 0 }">
		<script> 
	  		alert("비밀번호가 맞지 않습니다.");
      		history.go(-1);
		</script>
	</c:if>
	<c:if test="${check == -1 }">
		<script>
	  	alert("아이디가 맞지 않습니다..");
	  	history.go(-1); 
	 	</script>
	 </c:if>
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html>