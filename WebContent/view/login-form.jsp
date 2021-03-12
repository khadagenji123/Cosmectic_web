<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="../js/login-ajax.js"></script>
<link rel="stylesheet" href="../css/style-index.css" type="text/css">
<link rel="stylesheet" href="../css/style-sign-up.css" type="text/css">
<title>Log In</title>
</head>
<body>
<div>
    <ul id="header" class="show">
        <li class="font-li">Hotline: 1900 636 510 - 0973 104 105
        &nbsp;&nbsp; Email: rogerles@gmail.com</li>
        <li><a href="login-form.jsp"><input class="button" type="button" value="Đăng nhập"></a>
        &nbsp;&nbsp;
        <a href="sign-up-form.jsp"><input class="button" type="button" value="Đăng kí"></a></li>
    </ul>
</div>

<div>
    <div id="left1">
        <p class="item">RogerLes</p>
    </div>
    <div id="right1">
        <form action="../MainPageServlet" method="post">
    		  	<input type="hidden" name="command" value="SEARCH">
        		<input type="search" name="name-product"
                    placeholder ="Tìm kiếm trên RogerLes" size="60px" class="search">
    	</form>
    </div>
</div> 

<div id="create1">
    <p>Chào mừng đến với RogerLes. Đăng nhập ngay!</p>
</div>

	<div>
        <div id="login">
        	<form>
        		<input type="hidden" id="command" value="LOGIN" />
	            <input class="button6" type="text" id="username" placeholder="Nhập tài khoản hoặc Email">
	            <br></br>
	               
	            <input class="button6" type="password" id="password" placeholder="Vui lòng nhập mật khẩu">
	            <br></br>
	            <input class="button4" type="button" id="myBtn" value="ĐĂNG NHẬP"> 

	            <div id="myModal" class="modal">
					<!-- Modal content -->
					<div class="modal-content">
						<span class="close">&times;</span>
						<p id="message"></p>
					</div>
				</div>
				
        	</form> 
        </div>
       
	</div>
<script>
$(document).ready(function() {
	
	// Get the modal
	var modal = document.getElementById("myModal"); 

	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];
	
	btn.onclick=(function() {
		$.ajax({
			type: 'POST',
			url : 'http://localhost:8081/Cosmetic-web/MainPageServlet',
			data : {
				command : $('#command').val(),
				username : $('#username').val(),
				password : $('#password').val()
			},
			success : function(data) {
				if(data.checkuser==1){
					 window.location = 'admin.jsp';
				}
				else if(data.checkuser==2){
					window.location = 'http://localhost:8081/Cosmetic-web/login_Successfully__Servlet';
				}
				else{
					modal.style.display = "block";
					 document.getElementById("message").innerHTML = `Tài khoản hoặc mật khẩu 
					 không chính xác, xin vui lòng nhập lại!`;
				}
			},
			error: function (error) {
				console.log(error)
			}
		});
	});
	span.onclick = function() {
		 modal.style.display = "none";
	 }
	 window.onclick = function(event) {
		 if (event.target == modal) {
		 modal.style.display = "none";
		 }
	 }
});
</script>
</body>
</html>