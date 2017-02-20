<?php include "./header.php"; ?> 
  		<h1 id="community"><div>community</div></h1>
		<article>
			<h2>포토갤러리 업로드 </h2>
			<form id="upphoto">
			<div id="photoframe"> 
				<img id="imgBG" src="imgs/upphoto.gif" class="photoplace"> 
			</div> 
			<p><label>제목</label><input type="text"></p>
			<p><label>사진 설명 </label><textarea></textarea></p>
		    <input name="" type="submit" value="전송 하기 ">
		</form>	
  		</article>
<?php include "./sidebar_community.php"; ?>

<script type="text/javascript"> 
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
	function onDrop(e)  
	{ 
	e.stopPropagation(); 
	e.preventDefault(); 

	var readFileSize = 0; 
	var files = e.dataTransfer.files; 

	file = files[0]; 
	readFileSize += file.fileSize; 


	// Only process image files. 
	var imageType = /image.*/; 

	if (!file.type.match(imageType))  
	{ 
	return; 
	} 
	var reader = new FileReader(); 


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
	} 
	})(file); 

	// Read in the image file as a data url. 
	reader.readAsDataURL(file); 
} 
</script> 
		
<?php include "./footer.php"; ?>