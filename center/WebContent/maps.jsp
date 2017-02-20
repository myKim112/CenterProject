<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="false" />  
  		<h1 id="company"><div>maps</div></h1>
  <head>
  <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <style type="text/css">
    <center>
      html, body { width:500px; height: 500px; margin-left:500px; padding-top: 500px; }
      #map { height: 500px; width:500px; }
    </style>
  </head>
  <body>
    <jsp:include page="sidebar_company.jsp" flush="false" />
    <article>
  <h2>오시는길</h2>
 
  
  <link href="style.css" rel="stylesheet" type="text/css">
  <div><hr>
  주소	서울특별시 강남구 테헤란로 14길 6 남도빌딩 2F, 3F, 4F(T: 1544-9970 / F: 070-8290-2889)<br><hr>
버스	역삼역.포스코P&S타워 정류장<br><hr>
지선 146 / 740 / 341 / 360         간선 1100 / 1700 / 2000 / 7007 / 8001<br><hr>
지하철	지하철 2호선 역삼역 3번출구 100m</div><hr>
    <div id="map"></div>
    

     
     
    <script type="text/javascript">
  
    
    

var map;
function initMap() {
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat:37.4993694 , lng:127.032836},
    
    zoom: 17
    
  });
  
  

               }




    </script>
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAz_RAZ9cYwJhc6HrXPzgRk-Lzkp963AqA&callback=initMap">
    </script>
<jsp:include page="footer.jsp" flush="false" />
  </body>
  </article>
</html>