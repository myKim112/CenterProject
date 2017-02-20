<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="header.jsp" flush="false" />   

<%--    
<?php include "./header.php";
echo $_SERVER['HTTP_X_FILE_NAME'];
echo $HTTP_X_FILE_NAME;
echo $act;
echo $act1;
?> 
--%> 

  		<h1 id="community"><div>community</div></h1>
  		<article>
  			<h2>포토갤러리 업로드 </h2>
  			<form id="upphoto" method="post" enctype='multipart/form-data' action="<?=$PHP_SELF?>">
				<input type="hidden" name="act" value="1">
				<input type="hidden" id="act1" name="act1" value="">
				<div id="photoframe"> 
					<img id="imgBG" src="imgs/upphoto.gif" class="photoplace"> 
				</div> 
				<p><label>제목</label><input type="text"></p>
				<p><label>사진 설명 </label><textarea></textarea></p>
                <input name="" type="submit" value="전송 하기 ">
			</form>	
  		</article>
<jsp:include page="sidebar_community.jsp" flush="false" />      		
<script>
var dropbox = document.getElementById('imgBG'); 
// Setup drag and drop handlers. 
dropbox.addEventListener('dragenter', stopDefault, false); 
dropbox.addEventListener('dragover', stopDefault, false); 
dropbox.addEventListener('dragleave', stopDefault, false); 
dropbox.addEventListener('drop', onDrop, false); 

function stopDefault(e)  
{ 
  e.stopPropagation(); 
  e.preventDefault(); 
} 

var readFileSize = 0; 
function onDrop(e)  
{ 
	e.stopPropagation(); 
	e.preventDefault(); 

	
	var files = e.dataTransfer.files; 	
	file = files[0]; 
	readFileSize += file.fileSize; 
	fileName = file.fileName;
	


// Only process image files. 
	var imageType = /image.*/; 
	if (!file.type.match(imageType))  
	{ 
		return; 
	} 

	var a = document.getElementById('act1'); 
	var reader = new FileReader(); 
	var fileNames="TEST";
	fileNames = file.fileName;
	reader.onerror = function(e)  
	{ 
	alert('Error code: ' + e.target.error); 
	}; 


	// Create a closure to capture the file information. 
	reader.onload = (function(aFile)  
	{	 
		return function(evt)  
		{ 
			dropbox.src = evt.target.result; 
			a.value=dropbox.src;
		} 
	})(file); 
	
	reader.readAsDataURL(file); 
	
		
} 
</script>
		
<jsp:include page="footer.jsp" flush="false" />    