<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="false" />

<head>
<title>회원가입</title>
</head>

<body>
<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>회원가입</h2>
<form id="searchbbs" name="loginPro" action="" method="post" onSubmit="return checkIt()">
<table id="cbbs_f">
	<tr>
	<td colspan="2" align="center" id="checkbox01">
		<i>이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택),<br/> 
			프로모션 안내 메일 수신(선택)에 모두 동의합니다.</i>
		<input type="radio" name="checkbox01" /> <br><br><br><br>
	</td></tr>
	<tr>
	<td colspan="2" align="center" id="checkbox02">
		<i> 노곰 이용약관 동의(필수) </i>
		<input type="radio" name="checkbox02" /> <br><br><br><br>
	</td></tr>
	<tr>
	<td align="center">
		<i>개인정보 수집 및 이용에 대한 안내(필수)</i>
		<input type="radio" name="checkbox03" size="15" maxlength="12" /> <br><br><br><br>
	</td></tr>
	<tr>
	<td align="center">
		<i>위치정보 이용약관 동의(선택)</i>
		<input type="radio" name="checkbox04" size="15" maxlength="12" /> <br><br><br><br>
	</td></tr>
	<tr>
	<td align="center">
		<i>이벤트 등 프로모션 알림 메일 수신(선택)</i>
		<input type="radio" name="checkbox05" size="15" maxlength="12" /> <br><br><br><br>
	</td></tr>
	<tr>
	<td>
		<input type="button" value="비동의" onclick="window.location='loginPage.kiki'">
		<input type="button" value="동의" onclick="window.location='membershipForm.kiki'">
	</td>	
</tr>
</table>
</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" /> 