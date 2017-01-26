<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<title>회원가입</title>
</head>

<link href="style.css" rel="stylesheet" type="text/css">

<script>
	function checkIt()
	{
		var userinput = eval("document.userinput");
		
		if(!userinput.id.value) {
			alert("아이디를 입력하세요.");
			return false;
		}
		
		if(!userinput.pw.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
		if(userinput.pw.value != userinput.pwcheck.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}
		
		if(!userinput.name.value) {
			alert("이름을 입력하세요.");
			return false;
		}
		
		if(!userinput.phone.value) {
			alert("연락처를 입력하세요.");
			return false;
		}
	}
	
	function openConfirmId(userinput)
	{
		if(userinput.id.value == "") {
			alert("아이디를 입력하세요.");
			return;
		}
		url = "confirmId.kiki?id="+userinput.id.value;
		
		open(url,"confirmId", "toolbar=no, location=no, status=no, menubar=no, scroollbar=no, resizable=no, width=300, height=200");
	}
</script>

<center>
<font face="impact" color="gray" size="20">
Membership Application</font>
</center>

<body>
<form action="membershipPro.kiki" method="post" name="userinput" onSubmit="return checkIt()">
<table align="center" border="0">
	<tr>
	<td width="150">ID</td>
	<td align="left">
		<input type="text" name="id" placeholder="아이디" />
		&nbsp;&nbsp;
		<input type="button" value="중복확인" OnClick="openConfirmId(this.form)"/>
		<br><br>
	</td></tr>
	<tr>
	<td width="150">비밀번호</td>
	<td align="left">
		<input type="password" name="pw" />
		<br><br>
	</td></tr>
	<tr>
	<td width="150">비밀번호 재입력</td>
	<td align="left">
		<input type="password" name="pwcheck" /> *동일한 비밀번호를 입력하시오.
		<br><br>
	</td>></tr>
	<tr>
	<td width="150">이름</td>
	<td align="left">
		<input type="text" name="name" />
		<br><br>
	</td></tr>
	<tr>
	<td width="150">생년월일</td>
	<td align="left">
		<input type="text" name="birth" placeholder="ex>19990909"/>
		<br><br>
	</td></tr>
	<tr>
	<td width="150">전화번호</td>
	<td align="left">
		<input type="text" name="phone" placeholder="숫자만 입력해주세요"/>
		<br><br>
	</td></tr>
	<tr>
	<td width="150">주소</td>
	<td align="left">
		<input type="text" name="address" />
		<br><br/>
	</td></tr>
	<tr>
	<td width="150">E-mail</td>
	<td align="left">
		<input type=text name="email">
		<br><br>
	</td></tr>
	<tr>
	<td width="150">등급</td>
	<td align="left">
		<select name="lev">
			<option value="주니어">주니어</option>
			<option value="어덜트">어덜트</option>
			<option value="실버">실버</option>
			<option value="선택안함">선택안함</option>
		</select>
		<br><br>
	</td></tr>
	<tr>
	<td align="center" colspan="2">
		<br><br><br><br>
		<input type="submit" value="회원가입" />
		<input type="reset" value="다시작성" />
		<input type="button" value="메인으로" onclick="window.location='main.kiki'" />
	</td></tr>
</table>
</form>
</body>