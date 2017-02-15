<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<jsp:include page="header.jsp" flush="false" />  
  
<h1 id="community"><div>community</div></h1>
<jsp:include page="sidebar_community.jsp" flush="false" />    
<article>
	<h2>포토갤러리</h2>
  	<article id="gallery">
  	
 		<c:if test="${count == 0}"> 			
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic1.jpg" title="벗꽃과 직박구리"><img src="imgs/photos/pic1.jpg"> <figcaption>벗꽃과 직박구리 </figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic2.jpg" title="아름다움이란"><img src="imgs/photos/pic2.jpg"> <figcaption>아름다움이란 </figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic3.jpg"><img src="imgs/photos/pic3.jpg"> <figcaption>민들레</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic4.jpg"><img src="imgs/photos/pic4.jpg"> <figcaption>민들레 2</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic5.jpg"><img src="imgs/photos/pic5.jpg"> <figcaption>비가 내린 후</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic6.jpg"><img src="imgs/photos/pic6.jpg"> <figcaption>노란 잡초</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic7.jpg"><img src="imgs/photos/pic7.jpg"> <figcaption>은은한</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic8.jpg"><img src="imgs/photos/pic8.jpg"> <figcaption>벗꽃의 계절</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic9.jpg"><img src="imgs/photos/pic9.jpg"> <figcaption>아름다움 </figcaption></a></figure>			
	  	</c:if>
	  	
 		<c:if test="${count > 0}"> 	
 			<c:forEach var="article" items="${articlleList}">
 			${article.readCount}		
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic1.jpg" title="벗꽃과 직박구리"><img src="imgs/photos/pic1.jpg"> <figcaption>벗꽃과 직박구리 </figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic2.jpg" title="아름다움이란"><img src="imgs/photos/pic2.jpg"> <figcaption>아름다움이란 </figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic3.jpg"><img src="imgs/photos/pic3.jpg"> <figcaption>민들레</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic4.jpg"><img src="imgs/photos/pic4.jpg"> <figcaption>민들레 2</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic5.jpg"><img src="imgs/photos/pic5.jpg"> <figcaption>비가 내린 후</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic6.jpg"><img src="imgs/photos/pic6.jpg"> <figcaption>노란 잡초</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic7.jpg"><img src="imgs/photos/pic7.jpg"> <figcaption>은은한</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic8.jpg"><img src="imgs/photos/pic8.jpg"> <figcaption>벗꽃의 계절</figcaption></a></figure>
			<figure><a class="fancybox" data-fancybox-group="gallery" href="imgs/photos/pic9.jpg"><img src="imgs/photos/pic9.jpg"> <figcaption>아름다움 </figcaption></a></figure>			
	  		</c:forEach>
	  	</c:if>	  
	</article>
		<div class="btn"><a href="photoWriteForm.kiki?num=${num}&pageNum=${pageNum}">사진 업로드</a></div>
</article>										
<jsp:include page="footer.jsp" flush="false" /> 

<%-- 페이지 번호 생성하는 곳 --%>  		
<div class="clear"></div>	
<div id="page">
<ul class="paging">
<c:if test="${count > 0}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if> 
          
   <c:if test="${startPage > 10}">
       <li><a href="photoList.kiki?pageNum=${startPage - 10 }">이전</a></li>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <li><a href="photoList.kiki?pageNum=${i}">${i}</a></li>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <li><a href="photoList.kiki?pageNum=${startPage + 10}">다음</a></li>
   </c:if>
</c:if>
</ul>
</div>   
