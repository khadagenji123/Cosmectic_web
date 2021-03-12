<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/style-index.css" type="text/css">
<link rel="stylesheet" href="../css/style-sign-up.css" type="text/css">
<script src="../js/script-signup.js"></script>
<title>Sign Up by Email</title>
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

    <div id="create">
        <p>Tạo tài khoản RogerLes</p>
    </div>

    <div>
        <form action="../MainPageServlet" method="POST">
         <input type="hidden" name="command" value="SIGNUP_BY_EMAIL">
            <div id="left">
                <input class="button2" type="text" name="email" placeholder="Địa chỉ Email">
                <br></br>
                
                <input class="button2" type="password" name="password"
                id="password" placeholder="Tạo mật khẩu">
                <br></br>
                
                <input class="button2" type="password" name="confirm_pass"
                id="confirm_pass" onchange="checkPass()"  placeholder="Nhập lại mật khẩu">
                <br></br>
                <p id="missmatch" style="color: red;"></p>
                
                <input class="button2" type="text" name="number-phone" placeholder="Nhập số điện thoại">
                <br></br>
               
                <input class="button3" type="date" name="birthday" placeholder="yy/mm/dd">
            </div>
            
            <div id=right>
                <input class="button2" type="text" name="name" placeholder="Họ tên">
                <br></br>
                 GIỚI TÍNH:
                <input type="checkbox" name="gender" value="boy">NAM
                <input type="checkbox" name="gender" value="girl">NỮ
                <input type="checkbox" name="gender" value="other">KHÁC
                <br></br>
                <input class="button2" type="text" name="address" placeholder="Địa chỉ">
                <br></br>
                <input class="button4" type="submit" value="ĐĂNG KÍ" id ="submit">
                <br>
                <p>Bằng cách ấn vào nút <em>"ĐĂNG KÍ"</em> tôi đồng ý với <a>Điều<br> Khoảng Sử Dụng</a>
                và <a>Chính Sách Bảo Mật của RogerLes</a></p>
                <br>
                Hoặc đăng kí với<br></br>
                <a href="sign-up-form.jsp"><input class="button5" type="button" value="Đăng kí với Mobile"></a>
            </div>
        </form>
        
    </div>
</body>
</html>