<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

메인입니다. [${sessionScope.centerId }]
<br/>
앞으로 이 공간을 꾸며야합니다.
<br/>
어떻게 꾸미면 좋을까요?

<br/><br/>

<c:if test="${sessionScope.centerId ne null}">

<input type="button" value="정보수정" onclick="window.location='modify.kiki'"/>

</c:if>
<br/>

<input type="button" value="로그인" onclick="window.location='loginPage.kiki'"/>

<c:if test="${null eq id}">
===== 관리자 모드로 넣을거 ========
<br/>
<input type="button" value="직원 등록" onclick="window.location='teacherInputForm.kiki'" />

<br/>
<input type="button" value="직원 목록" onclick="window.location='teacherList.kiki'" />
<br/>

===== 강사에게 줄 것들 =====

<br/>
<input type="button" value="정보 수정" onclick="window.location='teacherUpdateForm.kiki'" />
<br/>
<input type="button" value="강의 신청" onclick="window.location='classList.kiki'" />
<br/>
<input type="button" value="강의 목록" onclick="window.location='classList.kiki'" />

</c:if>

