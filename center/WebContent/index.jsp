<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>NGC에 오신 여러분을 환영합니다.</title>
    <link href="css/reset5.css" rel="stylesheet" type="text/css">
    <link  href="css/themes/default/default.css" rel="stylesheet" type="text/css">
    <link href="css/nivo-slider.css" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans' rel='stylesheet' type='text/css'>
	<style>	
	body{font-size: 0.75em;font-family: "맑은 고딕", "Malgun Gothic", "돋움", Dotum, AppleGothic, sans-serif;line-height:1.2em;	color:#333;background-color: #e8e8e8;}
	#wrap{margin: 0 auto;width: 944px;background-color: #fff;}
	a { text-decoration:none;color:#333;}
	a:hover { color:#39F; text-decoration:none}
	.clear { clear:both }
	header{height: 137px;}
	#logo{float: left;text-indent: -9999px;background:url(imgs/logo.png) no-repeat left top;margin:42px 0 0 18px;}
	#logo a {display:block;width:167px;height:63px;}	
	#hlink, nav {float:right;}	
	#hlink ul {list-style:none;}	
	#hlink li, nav li {float:left;}
	#hlink { margin:11px 28px 0 0;}	
	#hlink li a { padding:0 10px}
	nav {margin:42px 38px 0 0;font-size:1.4em;clear:right;text-indent:-9999px;width:480px;height:20px;}
	nav li {background:url(imgs/div_line.png) no-repeat center right}
	nav li.n1 a, nav li.n2 a, nav li.n3 a, nav li.n4 a, nav li.n1 a:hover, nav li.n2 a:hover, nav li.n3 a:hover, nav li.n4 a:hover { 
		background-image:url(imgs/main_menu.png); 
		background-repeat:no-repeat;		
	}
	nav li.n1 a, nav li.n2 a, nav li.n3 a, nav li.n4 a{transition:all 0.2s ease-in-out;}
	nav li.n1 a {background-position:27px top;}
	nav li.n2 a {background-position:-96px top;}
	nav li.n3 a {background-position:-217px top;}
	nav li.n4 a {background-position:-338px top;}
	nav li.n1 a:hover {background-position: 27px -23px;}
	nav li.n2 a:hover {background-position: -96px -23px;}
	nav li.n3 a:hover {background-position: -217px -23px;}
	nav li.n4 a:hover {background-position: -338px -23px;}		
	nav li a { padding:0; display:block; width:118px; height:20px;}	
	nav li:last-child { background:none}
	#justar {
		margin:0 0 0 30px;
		float:left;
		width:200px;
	}
	#justar h3 {
		text-transform:capitalize;
		background:url(imgs/h3_under.jpg) no-repeat left bottom;
		padding:0 0 5px 5px;
		font-family: 'Droid Sans', sans-serif;
		font-weight:normal;
		font-size:1.1em;
	}
	#justar figure {
		text-align:center;
		padding-top:10px;
	}

/*.container {width: 500px; margin: 10px auto;}*/
	#notinews {width: 350px; float:left; margin-left:80px;}
	ul.tabs {
		margin: 0;
		padding: 0;
		float: left;
		list-style: none;
		height: 24px;
		border-bottom: 1px solid #999;
		border-left: 1px solid #999;
		width: 100%;
		font-family: 'Droid Sans', sans-serif;			
	}
	ul.tabs li {
		float: left;
		margin: 0;
		padding: 0;
		/*height: 31px;*/
		height:23px;
		/*line-height: 31px;*/
		line-height: 23px;
		border: 1px solid #999; 
		border-left: none;
		margin-bottom: -1px;
		background: #F6F6F6;
		overflow: hidden;
		position: relative;
	}
	ul.tabs li a {
		text-decoration: none;
		color: #000;
		display: block;
		padding: 0 20px;
		border: 1px solid #fff;
		outline: none;
	}
	ul.tabs li a:hover {
		background: #ccc;
	}	
	html ul.tabs li.active, html ul.tabs li.active a:hover  {
		background: #fff;
		border-bottom: 1px solid #fff;
	}
	.tab_container {
		/*border: 1px solid #999; */
		border-top: none;
		clear: both;
		float: left; 
		width: 300px;
		background: #fff;
	/*	-moz-border-radius-bottomright: 5px;
		-khtml-border-radius-bottomright: 5px;
		-webkit-border-bottom-right-radius: 5px;
		-moz-border-radius-bottomleft: 5px;
		-khtml-border-radius-bottomleft: 5px;
		-webkit-border-bottom-left-radius: 5px;*/
	}
	.tab_content {
/*		padding: 20px;
		font-size: 1.2em;*/
		padding: 20px 10px;
		font-size: 1.1em;
	}
/*	.tab_content h2 {
	font-weight: normal;
	padding-bottom: 10px;
	border-bottom: 1px dashed #ddd;
	font-size: 1.8em;
	}
	.tab_content h3 a{
		color: #254588;
	}
	.tab_content img {
		float: left;
		margin: 0 20px 20px 0;
		border: 1px solid #ddd;
		padding: 5px;
	}*/
	.tab_container ul {
		list-style:none;
	}
	.tab_container ul li {
		line-height:1.7em;
		background:url(imgs/bullet.gif) no-repeat left 10px;
		padding-left:10px;
	}
	

	#social {
		float:right;
		margin:0 30px 0 0;
		width: 180px;
	}
	#social h3 {
		padding:0 0 15px 0;
		font-family: 'Droid Sans', sans-serif;
		font-weight:normal;
		font-size:1.1em;
		text-transform:capitalize;
	}
	#social ul {list-style:none;}
	#social ul li {	float:left;	margin:5px;}
	#social ul li img {width:33px; height: 32px; }
	#social ul li a {opacity:0.7;transition:all 0.3s ease-in-out;}
	#social ul li a:hover { opacity:1}
	
	footer {
		padding:20px 0;
		margin:10px 20px;
		border-top:1px solid #CCC;
		
	}
	footer address {
		width:510px;
		height:50px;
		margin:10px auto;
		padding:0 0 0 90px;
		text-align:center;
		font-style:normal;
		line-height:1.8em;
		background:url(imgs/foot_logo.png) no-repeat left center;
	}
	
	</style>	
</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo"><a href="index.jsp">NGC Corp.</a></div>
			<div id="hlink">
				<c:if test="${sessionScope.centerId == null }" >			
					<ul>
						<li><a href="index.jsp">HOME</a></li>
						<li><a href="loginPage.kiki">로그인</a></li>
						<li><a href="agreeForm.kiki">회원가입</a></li>
					</ul>
				</c:if>
				<c:if test="${sessionScope.centerId != null }" >
					<ul>
						<li><a href="logOut.kiki">로그아웃</a></li>
						<li><a href="modify.kiki">정보수정</a></li>
						<li><a href="myQnaList.kiki?writer=${sessionScope.centerId}">마이페이지</a></li>
						<li><a href="deleteForm.kiki">회원탈퇴</a></li>
					</ul>
				</c:if>	
				
				
				<%-- 관리자 로그인 
				<% 
				String power = request.getParameter("power");
				out.println(power);%>				
				<c:if test="${power.lev >= 500 }">
					<li><a href="calendar.kiki">관리자</a></li>					
				</c:if>
				
				<c:if test="${power.lev >= 20 }">
					<li><a href="teacherUpdateForm.kiki">강사</a></li>					
				</c:if>				
				--%>
				
				<c:if test="${sessionScope.centerId !=null && sessionScope.centerId == 'MY00001'}">
					<ul>
						<li><a href="calendar.kiki">관리자</a></li>					
						<li><a href="teacherUpdateForm.kiki">강사</a></li>					
					</ul>
				</c:if>
				
			</div>
           
		  <nav>
				<ul>
					<li class="n1"><a href="company.jsp">회사소개</a></li>
					<li class="n2"><a href="classList.kiki">강좌소개</a></li>
					<li class="n3"><a href="community.jsp">커뮤니티</a></li>
					<li class="n4"><a href="noticeList.kiki">고객지원</a></li>
				</ul>
			</nav>
		</header>
        <div class="slider-wrapper theme-default">
            <div id="slider" class="nivoSlider">
                <img src="imgs/slider1.jpg" width="943" height="401"> 
                <img src="imgs/slider2.jpg" width="943" height="401"> 
                <img src="imgs/slider3.jpg" width="943" height="401"> 
                <img src="imgs/slider4.jpg" width="943" height="401"> 
            </div>
        </div>    
        <div class="clear"></div>
        <%-- 
        <div id="justar">
        	<h3>just arrived</h3>
        	<figure><img src="imgs/goods1.jpg" width="161" height="125"></figure>
        </div>
        --%>
        <div id="notinews">
        	<div class="container">
            <ul class="tabs">
                <li><a href="#tab1">Notice</a></li>
                <li><a href="#tab2">News</a></li>        
            </ul>
            	<div class="tab_container">
                    <div id="tab1" class="tab_content">
                        <ul>
                            <li><a href="http://localhost:8080/center/noticeContent.kiki?num=43&pageNum=1">정규강좌 횟수별 환불 규정</a></li>
                            <li><a href="http://localhost:8080/center/noticeContent.kiki?num=42&pageNum=1">전단 정정 안내 </a></li>
                            <li><a href="http://localhost:8080/center/noticeContent.kiki?num=39&pageNum=1">2017 봄학기 문화센터 회원규정 </a></li>
                            <li><a href="http://localhost:8080/center/noticeContent.kiki?num=40&pageNum=1">쉬즈토크 조조영화 동호회</a></li>
                            <li><a href="http://localhost:8080/center/noticeList.kiki?pageNum=1">수지점 문화센터 봄학기 회원모집 안내 </a></li>                        
                        </ul>
            
                    </div>
                    <div id="tab2" class="tab_content">
                         <ul>
                            <li><a href="#">여기는 뉴스가 들어가는 곳입니다.</a></li>
                            <li><a href="#">여기는 뉴스가 들어가는 곳입니다.</a></li>
                            <li><a href="#">여기는 뉴스가 들어가는 곳입니다.</a></li>
                            <li><a href="#">여기는 뉴스가 들어가는 곳입니다.</a></li>
                            <li><a href="#">여기는 뉴스가 들어가는 곳입니다.</a></li>                        
                        </ul>
                    </div>        
            	</div>
       		</div>
        </div>
        
		<div id="social">
        <h3>social network</h3>
            <ul>
                <li><a href="#"><img src="imgs/icon1.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon2.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon3.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon4.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon5.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon6.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon7.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon8.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon9.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon10.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon11.png" width="33" height="32"></a></li>
                <li><a href="#"><img src="imgs/icon12.png" width="33" height="32"></a></li>
            </ul>
        </div>    
        <div class="clear"></div>
        <footer>
        	<address>All contents copyright YNG Corp, ltd. Contact: webmaster@yngmastergrin.com<br>
					서울특별시 강남구 신사동 123-34 | Tel : +82-2-123-4567  Fax: +82-2123-4568 </address>            
        </footer>
</div>


    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="scripts/jquery.nivo.slider.js"></script>
    <script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
	// 아래는 tab 메뉴 
	$(document).ready(function() {
	//Default Action
		$(".tab_content").hide(); //Hide all content
		$("ul.tabs li:first").addClass("active").show(); //Activate first tab
		$(".tab_content:first").show(); //Show first tab content	
		//On Click Event
		$("ul.tabs li").click(function() {
			$("ul.tabs li").removeClass("active"); //Remove any "active" class
			$(this).addClass("active"); //Add "active" class to selected tab
			$(".tab_content").hide(); //Hide all tab content
			var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
			$(activeTab).fadeIn(); //Fade in the active content
			return false;
		});
	});
    </script>
</body>
</html>