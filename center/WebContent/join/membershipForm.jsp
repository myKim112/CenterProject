<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" flush="false" />

<head>
<title>회원가입</title>
</head>

<script language="JavaScript">
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

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>회원가입</h2>  
<form id="searchbbs" action="membershipPro.kiki" method="post" name="userinput" onSubmit="return checkIt()">
<table id="cbbs_f">
	<tr>
		<td>ID</td>
		<td>
			<input type="text" name="id" placeholder="아이디" />
		</td>
		<td>
			<input type="button" value="중복확인" OnClick="openConfirmId(this.form)"/>
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" name="pw" />
		</td>
	</tr>
	<tr>
		<td>비밀번호 재입력</td>
		<td>
			<input type="password" name="pwcheck" ><br> *동일한 비밀번호를 입력하시오.
		</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="name" />
		</td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td>
			<input type="text" name="birth" placeholder="ex>19990909"/>
		</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>
			<input type="text" name="phone" placeholder="숫자만 입력해주세요"/>
		</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>
			<input type="text" name="address" />
		</td>
	</tr>
	<tr>
		<td>E-mail</td>
		<td>
			<input type=text name="email">
		</td>
	</tr>
	<tr>
	<td>
		<input type="submit" value="회원가입" />
	</td>
	<td>&nbsp;&nbsp;&nbsp;</td>
	<td>
		<input type="button" value="메인으로" onclick="window.location='index.jsp'" />
	</td></tr>
</table>
</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />   