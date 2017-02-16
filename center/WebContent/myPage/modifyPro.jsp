<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="false" />

<h1 id="customer"><div>customer center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>회원정보 수정</h2>
<form id="searchbbs" method="post">
<table id="cbbs_f" >
	<tr>
	<td>
		<p>입력하신 내용대로 수정이 완료되었습니다.</p>
		5초후에 메인으로 이동합니다.
		<meta http-equiv="Refresh" content="5;url=index.kiki" >
		<br><br>
		<input type="button" value="메인으로" onclick="window.location='index.kiki'">
	</td>
	</tr>
</table>
</form>
</article>
<jsp:include page="footer.jsp" flush="false" />