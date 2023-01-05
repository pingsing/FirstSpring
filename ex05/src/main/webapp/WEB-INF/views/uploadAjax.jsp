<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Ajax</title>
</head>
<body>
	<h1>Upload With Ajax</h1>
	
	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple />
	</div>
	
	<button id='uploadBtn'>Upload</button>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script>
		$(function(){
			$("#uploadBtn").on("click", function(e){
				var formData = new FormData();
				var inputFile = $("input[name='uploadFile']");
				var files = inputFile[0].files;
				
				console.log(files);
				
				// add f iledate to formdata
				for(var 1=0; i<files.length; i++) {
					formData.append("uploadFile", files[i]);
				}
				
				$.ajax({
					url: '/uploadAjaxAction',
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					success: function(result){
						alert("Uploaded");
					}
				});	//$.ajax
			});
		});
	</script>
</body>
</html>