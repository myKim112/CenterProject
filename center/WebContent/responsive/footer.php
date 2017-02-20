       </div>
       <div class="clear"></div>
        <footer>
          <address>All contents copyright YNG Corp, ltd. Contact: webmaster@yngmastergrin.com<br>
          서울특별시 강남구 신사동 123-34 | Tel : +82-2-123-4567  Fax: +82-2123-4568 </address>            
        </footer>
</div>


    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="scripts/jquery.nivo.slider.js"></script>
    <script type="text/javascript" src="scripts/bjqs-1.3.min.js"></script>
    <script type="text/javascript" src="scripts/jquery.fancybox.pack.js"></script>
    <script type="text/javascript" src="scripts/prettify.packed.js"></script>
    <script src="scripts/tinynav.js"></script>
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
  //
    $(document).ready(function() {
          $(".fancybox").fancybox({
            openEffect  : 'none',
            closeEffect : 'none'
          });
        });

          
    jQuery(document).ready(function($) {
    $('#slide').bjqs({
            'width' : 300,
            'height' : 190,
            animtype : 'slide',
            'responsive' : true,
            showcontrols : false,
            showmarkers : false,

        });
    });


// TinyNav.js 1
$('#nav').tinyNav({
  header: 'Navigation',
  // active: 'selected',
  // label: 'Menu'
});
      



    </script>
</body>
</html>