<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="center.staff.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NGC에 오신 여러분을 환영합니다.</title>
    <link href="css/reset5.css" rel="stylesheet" type="text/css">
    <link href="css/jquery.fancybox.css" rel="stylesheet" type="text/css"> 
    <link href="css/style.css" rel="stylesheet" type="text/css">
   	<link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>

	<%--
	<script type="text/javascript">
		function changeView(value)
		{
			if(value == "0"){location.href = "index.jsp";} 				//HOME 
			else if(value == "1"){location.href = "loginPage.kiki"}		//로그인 
			else if(value == "2"){location.href = "agreeForm.kiki"}		//회원가입
			else if(value == "3"){location.href = "logOut.kiki"}		//로그아웃
			else if(value == "4"){location.href = "#"}					//마이페이지
			else if(value == "5"){location.href = "#"}					//강사목록
			else if(value == "6"){location.href = "#"}					//회원목록
			else if(value == "7"){location.href = "deleteForm.kiki"}	//회원탈퇴
		}
	</script>
	--%>

</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo"><a href="index.jsp">NGC Corp.</a></div>
			<div id="hlink">
				<ul>
					<li><a href="index.jsp">HOME</a></li>
				
				<%-- 로그인이 안되었을 경우, 로그인, 회원가입 버튼을 보여준다. --%>
				
				<c:if test="${sessionScope.centerId == null }" >
					<li><a href="loginPage.kiki">로그인</a></li>					
					<li><a href="agreeForm.kiki">회원가입</a></li>					
				</c:if>
				
				<%-- 로그인이 되었을 경우, 로그아웃, 마이페이지 버튼을 보여준다. --%>				
				<c:if test="${sessionScope.centerId != null }" >
					<li><a href="logOut.kiki">로그아웃</a></li>	
					<li><a href="modify.kiki">정보수정</a></li>
					<li><a href="deleteForm.kiki">회원탈퇴</a></li>				
					<li><a href="myQnaList.kiki">마이페이지</a></li>				
				</c:if>	
				
				
				<%-- 관리자 로그인 --%>
				<% 
					String id = (String)session.getAttribute("centerId");
					StaffDAO manage = StaffDAO.getInstance();
					StaffDTO staff = manage.getLev(id);
				%>
				<c:set value="<%=staff %>" var="staff"/>			
				<c:if test="${staff.lev >= 20 }">
					<li><a href="teacherUpdateForm.kiki">강사</a></li>					
				</c:if>
				<c:if test="${staff.lev >= 20 }">
					<li><a href="calendar.kiki">일정</a></li>
				</c:if>
				
								
				<c:if test="${staff.lev >= 500 }">
					<li><a href="teacherList.kiki">관리자</a></li>					
				</c:if>
				
				<%--<c:if test="${power.lev >= 500 }"> --%>
<%-- 				<c:if test="${sessionScope.centerId !=null && sessionScope.centerId == 'MY00001'}">
					<li><a href="calendar.kiki">관리자</a></li>					
					<li><a href="teacherUpdateForm.kiki">강사</a></li>					
				</c:if>
--%>
				
				<%-- <c:if test="${power.lev >= 20 }"> --%>
				<%--</c:if>  --%>
				
				<%-- 강사 로그인  
				<c:if test="${sessionScope.centerId !=null && sessionScope.centerId == 'MY00001'}">
					<li><a href="#">강사</a></li>					
				</c:if>
				--%>
				
				</ul>
			</div>
           
			<nav>
				<ul>
					<li class="n1"><a href="company.jsp">회사소개</a></li>
					<li class="n2"><a href="classList.kiki">강좌정보</a></li>
					<li class="n3"><a href="community.jsp">커뮤니티</a></li>
					<li class="n4"><a href="noticeList.kiki">고객지원</a></li>
				</ul>
			</nav>
		</header>
   