<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" flush="false" /> 

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>노곰문화센터</title>
	
	<script type="text/javascript">
		function delCart(index){
			
			document.cartForm.action="cartDel.kiki";
			document.cartForm.submit();
		}
		
		function testPay(){
			document.cartForm.action="appList.kiki";
			document.cartForm.submit();
		}
		
	</script>
</head>

<body>
<h1 id="customer"><div>lecture center</div></h1>
<jsp:include page="sidebar_mypage.jsp" flush="false" />
<article>
<h2>장바구니</h2>
	<table border="0" width="650" cellpadding="0" cellspacing="0" align="center"style="table-layout:fixed">
		<tr>
			<td>
				<hr align="center" style="border: solid 1px black;" WIDTH="650">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">선택</td>
			<td colspan="3" align="center">지점</td>
			<td colspan="4" align="center" >강좌코드</td>
			<td colspan="15" align="center">강좌명</td>
			<td colspan="4" align="center">강좌기간</td>
			<td colspan="4" align="center">강좌시간</td>
			<td colspan="3" align="center">수강료</td>
			<td colspan="2" align="center">인원</td>
			<td colspan="4" align="center">접수상태</td>
		</tr>
	</table>
	<hr align="center" style="border: solid 0.5px lightgray;"WIDTH="650">
	<c:if test="${count == 0}">
		<table border="0" width="650" cellpadding="0" cellspacing="0" align="center"style="table-layout:fixed">
 			<tr>
    			<td align="center">
      				장바구니가 비었습니다.
   				</td>
   			</tr>
		</table>
	</c:if>
	<form method="post" name="cartForm">
		<c:if test="${count > 0}">
			<c:forEach var="dto" items="${articleList }" >
				<table border="0" width="650" cellpadding="0" cellspacing="0" align="center"style="table-layout:fixed">
					<tr>
						<td colspan="2" align="center"><input type="checkbox" name="classCode" value="${dto.classCode }"></td>
						<td colspan="3" align="center" >${dto.center }</td>
						<td colspan="4" align="center" >${dto.classCode}</td>
						<td colspan="15" align="center">
							<a href="classContent.kiki?num=${dto.cnum}&pageNum=${currentPage}">${dto.className }</a>
						</td>
						<td colspan="4" align="center">${dto.classDate }</td>
						<td colspan="4" align="center">${dto.classTime }</td>
						<td colspan="3" align="center">${dto.classPay }</td>
						<td colspan="2" align="center">${dto.person }</td>
						<td colspan="4" align="center">${dto.state}
							<input type="button" value="수강신청"onclick="javascript:window.location='appList.kiki?classCode=${dto.classCode}'">
						</td>
					</tr>
					<tr>
						<td>
							<hr align="center" style="border: solid 0.5px lightgray;"WIDTH="650">
						</td>
					</tr>
				</table>
			</c:forEach>
		</c:if>
		
		<form id="searchbbs" method="">
		<table id="cbbs_f">
			<tr>
				<td>
					<br><br>
					<input type="button"  value="결제" onclick="testPay();" /> 
					<input type="button" value="삭제" onclick="delCart();" /> 
				</td>
			</tr>
		</table>
		</form>

		<table border="0" width="650" cellpadding="0" cellspacing="0" align="center" style="table-layout: fixed">
			<td>
				<input type="hidden" name="classCode" value="${dto.classCode}" />
			</td>
		</table>
	</form>
</body>
</article>
<jsp:include page="footer.jsp" flush="false" />
</html>


