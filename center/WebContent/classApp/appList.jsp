<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>노곰문화센터</title>
<script type="text/javascript">
	function sumCalc(count){
		var pay = parseInt('${cdto.classPay}');
		var sum = pay * count;
		document.getElementById("mc").innerHTML=count;
		document.getElementById("sum").innerHTML=sum;
		document.getElementById("rmc").value=count;
		document.getElementById("rpay").value=sum;
		document.payment.sum.value = sum;
	}
</script>
</head>
<body>
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
		<tr>
			<td colspan="15" align="center">
				[${cdto.center}][${cdto.className}]<br />
				강좌기간 | ${cdto.classDate } <br />
				강좌시간 | ${cdto.classTime } <br />
				강사명 | ${cdto.teacher }
			</td>
			<td colspan="4" align="center">${sessionScope.centerId }</td>
			<td colspan="4" align="center"><input type="number" value="0" name="memberCount" onchange="sumCalc(this.value);"/> </td>
			<td colspan="4" align="center">${cdto.classPay}</td>
			<td colspan="3" align="center"> - </td>
			<td colspan="2" align="center">${cdto.classPay}</td>
		</tr>
	</table>
	<hr align="center" style="border: solid 1px red;" WIDTH="1400">
	<form action="appSucPro.kiki?classCode=${cdto.classCode }" method="post" name = "payment">
	<table border="0" width="1400" cellpadding="0" cellspacing="0" align="center" style="table-layout: fixed">
		<hr align="center" style="border: solid 1px red;" WIDTH="1400">
		<tr>
			<td colspan="15" align="center"><label id="pay">${cdto.classPay}</label> * <label id="mc">0</label> = <label id="sum">${cdto.classPay}</label> 
			<br/>
			</td>
			<td>
				<input type="hidden" name="classCode" value="${cdto.classCode}" />
				<input type="hidden" name="pay" value="" id="rpay"/>
				<input type="hidden" name="memberCount" value="" id="rmc" />
				<input type="hidden" name="sum" value="" id="sum" />
			</td>
				<td align="center"><input type="submit" value="결제" /></td>
		</tr>
	</table>
			</form>

</body>
</html>

