<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>아이디찾기</title>

<link href="style.css" rel="stylesheet" type="text/css">

<% request.setCharacterEncoding("UTF-8"); %>
<%
	try {
		if(session.getAttribute("centerId") == null) { %>
		
		
<script language="javascript">

function focusIt() {
	document.findIdForm.id.focus();
}

function findId() {
	inputForm = eval("document.findIdForm");
	
	if(!inputForm.name.value) {
		alert("이름을 입력하세요.");
		inputForm.id.focus();
		return false;
	} 
	
	if(!inputForm.phone.value) {
		alert("-없이 전화번호를  입력하세요.");
		inputForm.phone.focus();
		return false;
	} 
	
}
</script>

</head>

<body onLoad="focusIt()">
		<center>
<br><br><br><br><br><br><br><br>
			
			
			
			
			
			<form name="findIdForm" id="findIdForm" action="findIdPro.kiki" method="post" onSubmit="return findId(this);">
		
	<table>
	

  						<tr>
  								<h1><td  align="center"><p><h1><b>아이디 찾기</b></h1></td>
  						</tr>
  				        <tr>
  				        		<td><p><strong>Name :</strong></p></td>
           					    <td><input type=text name="name" id="name" type=text size="31"></td>
           			   </tr>
           
           				<tr>    <td><strong>Phone Number:</strong></td>
           						 <td><input type=text name="phone" id="phone" size="31" placeholder="-를생략하고 숫자만입력세요" />
          						  </td>
          			  </tr>
         
           
  <tr>

  <td><P><input type="submit" value="확     인" />
     <input type=reset value="취    소" />
     <input type="button" value="회원가입" onclick="window.location='/center/agreeForm.kiki'" />
     </p></td></tr></table>
     
			</form>
			











<%	} else { %>

<form action="" method="post">
<table align="center">
	<tr>
	<td align="center">
		<h3>귀하가 입력하신 Id는 <br>
		<%= session.getAttribute("centerId") %>입니다</h3>
	</td></tr>
	<tr>
	<td align="center">
		<input type="button" value="로그인" onclick="javascript:window.location='logPage.kiki'"/>
		<input type="button" value=" 공지사항" onclick="javascript:window.location='/form/noticeboard/noticeList.jsp'"/>
	</td></tr>
	<tr>
	<td algin="center">
		<input type="submit" value="로그아웃" onclick="window.location='logOut.kiki'" /></td>
	</tr>
	<tr>
	<td align="center">
		<%
			String id = (String)session.getAttribute("centerId");
		
			if(id.equals("admin")) {	%>
			<input type="button" value="관리자" onclick="window.location=''" />
		<%	} %>
	</td></tr>
	<tr>
	<td align="center">
		<font size="2">
			<a href="">정보수정</a> 
			<a href="">회원탈퇴</a>
	</font>
</table>
</form>
<%		} 
	} catch(Exception e) { }	%>
</body>
</body>
</html>
