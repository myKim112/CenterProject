<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
</head>
<body>
<center>
	<table width="400" border="1" cellpading="0" cellsapcint="0" align="center">
		<tr>
			<td>
				<jsp:include page="top.jsp" flush="false"/>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="content.jsp" flush="false"/>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="bottom.jsp" flush="false"/>
			</td>
		</tr>
	</table>
</center>
</body>
</html>