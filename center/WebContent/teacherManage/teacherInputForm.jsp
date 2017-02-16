<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" /> 

<head>
<title>직원관리</title>
</head>

<center>
<font face="impact">
Teacher Application</font>
</center>

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
		url = "teacherConfirmId.kiki?id="+userinput.id.value;
		
		open(url,"confirmId", "toolbar=no, location=no, status=no, menubar=no, scroollbar=no, resizable=no, width=300, height=200");
	}
</script>

<body>
<form action="teacherInputPro.kiki" method="post" name="userinput" onSubmit="return checkIt()">
<table align="center" border="0">
	<tr>
	<td width="150">ID</td>
	<td align="left">
		<input type="text" name="id" placeholder="사원번호" />
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
	</td></tr>
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
		<input type="text" name="email" />
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
		<input type="text" name="bankAccount" placeholder="'-'를 제외하고 입력하시오." />
		<br><br>
	</td></tr>
	<tr>
	<td align="center" colspan="2">
		<br><br><br><br>
		<input type="submit" value="직원 등록" />
		<input type="reset" value="다시작성" />
		<input type="button" value="메인으로" onclick="window.location='main.kiki'" />
	</td></tr>
</table>
</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>