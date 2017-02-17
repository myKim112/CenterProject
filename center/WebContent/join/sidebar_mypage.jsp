<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="center.join.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  		<aside>
  			<h3><div>마이페이지</div></h3>
  			<ul>
  				<%
  					String id = (String)session.getAttribute("centerId");
  					JoinDAO manage = JoinDAO.getInstance();
					JoinDTO join = manage.getLev(id);
  				%>
  				
  				<c:set value="<%=join %>" var="join"/>
  				<c:if test="${join.lev == 10}">
  					<li><a href="modify.kiki">정보수정</a></li>
  				</c:if>
  					<li><a href="myClassList.kiki">내 강좌보기</a></li>
  					<li><a href="classCartList.kiki">강좌 바구니</a></li>
  					<li><a href="myQnaList.kiki">나의 질문</a></li>
  					<li><a href="myReviewList.kiki">나의 수강후기</a></li>
  				<c:if test="${join.lev == 10}">
  					<li><a href="deleteForm.kiki">회원탈퇴</a></li>
  				</c:if>
  			</ul>
  		</aside>