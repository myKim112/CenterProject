<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수강후기 글작성</title>
</head>

<body>  
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_customer.jsp" flush="false" />
<article>
<h2>수강후기</h2>
<form id="searchbbs" method="post" name="writeform" action="reviewWritePro.kiki" onsubmit="return writeSave()" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${num}">
	<input type="hidden" name="ref" value="${ref}">
	<input type="hidden" name="reStep" value="${reStep}">
	<input type="hidden" name="reLevel" value="${reLevel}">

<table id="cbbs_f">
   <tr>
    <td>센터명</td>
    <td><input type="text" name="center"></td>
   </tr>   
   <tr>
    <td>작성자</td>
    <td><input type="hidden" name="writer" value="${sessionScope.centerId}">${sessionScope.centerId}</td>
    </tr>
  <tr>
    <td>제 목</td>
    <td>
	<c:if test="${num == 0}">
       <input type="text" name="title"></td>
	</c:if>
	<c:if test="${num != 0}">
	   <input type="text" name="title" value="[답변]${article.title}"></td>
	</c:if>
  </tr>
  <tr>
    <td>내 용</td>
    <td>
     <textarea name="content"></textarea> </td>
  </tr>
  <tr>
  	<td>파일 올리기</td>
  	<td>
  		<input type="file" name="save">
  	</td>
  </tr>
  <tr>
    <td>비밀번호</td>
    <td>
     <input type="password" name="pw"> 
	 </td>
  </tr>
  </table>
  <br><br>
  <table>
	<tr>      
 		<td> 
			<input type="button" value="목록보기" onclick="window.location='reviewList.kiki'">
		</td>
		<td>&nbsp;&nbsp;&nbsp;</td>
		<td>
  			<input type="submit" value="등록" >  
		</td>
	</tr>
	</table>    
  			<%-- <div class="btn"><a href="reviewList.kiki">목록보기</a></div> --%>
</form>   
</article>
<jsp:include page="footer.jsp" flush="false" />
</body>
</html>      
