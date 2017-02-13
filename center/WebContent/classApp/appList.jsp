<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>노곰문화센터</title>
<script type="text/javascript">	
	function sumCalc(count,pay,i){
		document.getElementById("sumpay"+i).innerHTML=count*pay;
		resultPay();
	}
	
	
	function resultPay(){
		var x = ${classListCount};
		var resultSum=0;
		for(a=1; a <= x ; a++){
			rs = document.getElementById("sumpay"+a).textContent;
			resultSum+=parseInt(rs);
		}
		document.getElementById("resultPay").innerHTML=resultSum; 
		
	}
	
</script>
</head>
<body >
	<table border="0" width="1400" cellpadding="0" cellspacing="0"
		align="center" style="table-layout: fixed">
		<hr align="center" style="border: solid 1px red;" WIDTH="1400">
		<tr>
			<td colspan="15" align="center">강좌명/강좌정보</td>
			<td colspan="4" align="center">수강자ID</td>
			<td colspan="4" align="center">수강인원</td>
			<td colspan="4" align="center">수강료</td>
			<td colspan="3" align="center">할인</td>
			<td colspan="2" align="center">결제액</td>
		</tr>
		</table>
		<hr align="center" style="border: solid 0.5px lightgray;"WIDTH="1400">
	<form action="appSuc.kiki" method="post" name = "payment">
		<table border="0" width="1400" cellpadding="0" cellspacing="0" align="center" style="table-layout: fixed">
		<c:forEach items="${classList}" var="cdto" varStatus="i">
			<tr>
				<td colspan="15" align="center">
					[${cdto.center}][${cdto.className}]<br />
					강좌기간 | ${cdto.classDate } <br />
					강좌시간 | ${cdto.classTime } <br />
					강사명 | ${cdto.teacher } ${cdto.classCode }

				</td>
				<td colspan="4" align="center">${sessionScope.centerId }</td>
				<td colspan="4" align="center"><input type="number" value="0" name="memberCount" onchange="sumCalc(this.value,${cdto.classPay},'${i.count}');"/> </td>
				<td colspan="4" align="center">${cdto.classPay}</td>
				<td colspan="3" align="center"> - </td>
				<td colspan="2" align="center"><label id="sumpay${i.count}">${cdto.classPay}</label></td>
			</tr>
				<input type="hidden" name="classCode" value="${cdto.classCode}">
				<input type="hidden" name="classPay" value="${cdto.classPay}">
		</c:forEach>
	</table>
		<hr align="center" style="border: solid 0.5px lightgray;"WIDTH="1400">

	<table border="0" width="1400" cellpadding="0" cellspacing="0" align="center" style="table-layout: fixed">

		<tr>
				<td colspan="15" align="right">
				총 결제 금액 : <label id="resultPay">0</label>
			</td>
				<td align="center"><input type="submit" value="결제" /></td>
		</tr>
	</table>
			</form>

</body>
</html>

