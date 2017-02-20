<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script language="javascript">
	alert("삭제를 완료하였습니다.");
</script>

<c:if test="${result==true}">
	<meta http-equiv="Refresh" content="0;url=/center/myReviewList.kiki?pageNum=${pageNum}" >
</c:if>