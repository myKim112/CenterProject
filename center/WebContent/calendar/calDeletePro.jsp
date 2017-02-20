<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result == 1}">
	<meta http-equiv="Refresh" content="0;url=calendar.kiki" />
</c:if>

<c:if test="${result == 0}">
	비밀번호가 다릅니다.
	<br>
	<a href="javascript:history.go(-1)" >[글삭제 폼으로 돌아가기]</a>
</c:if>