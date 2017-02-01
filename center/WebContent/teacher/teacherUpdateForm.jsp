<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>직원관리</title>
</head>

<script>
	function checkIt() {
		var userinput = evl("document.userinput");
		
		if(!userinput.pw.value){
			alert("비밀번호를 입력하세요");
			return false;
		}
		
		if(userinput.pw.value != userinput.pwcheck.value) {
			alert("비밀번호를 동일하게 입력하세요");
			return false;
		}
	}
</script>

<center>
<font face ="Impact" color="lightgray" size = "20" >
Teacher Modify</font>
</center>

<body>
<form action="teacherUpdatePro.kiki" method="post" name="userinput">
<table  border="0" align="center">
	<tr>
	<td width="150">ID</td>
	<td align="left">${staff.id}<br><br>
	</td></tr>
	<tr>
	<td width="150">비밀번호</td>
	<td align="left">
		<input type="password" name="pw" value="${staff.pw}">
		<br><br>
	</td></tr>
	<tr>
	<td width="150">비밀번호 재입력</td>
	<td align="left">
		<input type="password" name="pwcheck" placeholder="비밀번호재입력"> 
		<br><br>
	</td></tr>
	<tr>
	<td width="150" >이름</td>
	<td align="left">
		<input type="text" name="name" value="${staff.name}">
		<br><br>
	</td></tr>
	<tr>
	<td width="150">생년월일</td>
	<td align="left">
		<input type="text" name="birth" value="${staff.birth}">
		<br><br>
	</td></tr>
	<tr>
	<td width="150">전화번호</td>
	<td align="left">
		<input type="text" name="phone" value="${staff.phone}">
		<br><br>
	</td></tr>
	<tr>
	<td width="150">주소</td>
	<td align="left">
		<input type="text" name="address" value="${staff.address}">
		<br><br>
	</td></tr>
	<tr>
	<td width="150">E-mail</td>
	<td align="left">
		<input type=text name="email" value="${staff.email}">
	    <br><br>
	</td></tr>
	<tr>
	<td width="150">은행명</td>
	<td align="left">
		<select name="bankName">
			<option value="신한">신한</option>
			<option value="우리">우리</option>
			<option value="농협">농협</option>
			<option value="국민">국민</option>
			<option value="SC제일">SC제일</option>
			<option value="기업">기업</option>
			<option value="KEB하나">KEB하나</option>
		</select>
		<br><br>
	</td></tr>
	<tr>
	<td width="150">계좌번호</td>
	<td align="left">
		<input type="text" name="bankAccount" placeholder="'-'를 제외하고 입력하시오." value="${staff.bankAccount}" />
		<br><br>
	</td></tr>
	<tr>
	<td align="right" colspan="2">
	<br><br>
		<input type="submit" value="정보수정" />
		<input type="button" value="메인으로" onclick="javascript:window.location='main.kiki'"/>
	</td></tr>
</table>
</form>
</body>