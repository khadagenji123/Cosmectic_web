<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/style-contact.css" type="text/css">
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="../js/contact-ajax.js" type="text/javascript"></script>
<title>Liên hệ</title>
</head>
<body>
	<div>
		<ul class="show">
			<li class="font-li">Rogerles</li>
			<li><a href="../MainPageServlet">Trang chủ</a></li>
		</ul>
	</div>

	<div>
		<a href="make-up.jsp"><img src="../image/image1.jpg" alt="mypham"
			class="image" /></a>
	</div>

	<div id="left-location">
		<p class="show1">DANH MỤC SẢN PHẨM</p>
		<hr>
		<ul class="distance-line">
			<li><a href="../Category_Servlet?value=skincare">Chăm sóc da</a></li>
	        <li><a href="../Category_Servlet?value=makeup">Trang điểm</a></li>
	        <li><a href="../Category_Servlet?value=bodycare">Chăm sóc cơ thể</a></li>
	        <li><a href="../Category_Servlet?value=forman">Dành cho nam giới</a></li>
		</ul>
		<hr>
		<p class="show1">HỖ TRỢ TRỰC TIẾP</p>
		<hr>
		<ul class="distance-line">
			<li class="show3">Tư vấn bán hàng 1</li>
			<li>0868.123.xxx</li>
			<li class="show3">Tư vấn bán hàng 2</li>
			<li>0868.123.xxx</li>
			<li class="show3">Email liên hệ</li>
			<li>rogerles@gmail.com</li>
		</ul>
	</div>

	<div id="right-location">
		 <form>
			<input type="hidden" id="command" value="CONTACT" />
			<p style="color: red">LIÊN HỆ</p>
			Your Name(required) <br> <input type="text" id="name"
				class="contact-button"> <br>
			<br> Your Email(required) <br> <input type="text"
				id="email" class="contact-button"> <br>
			<br> Subject <br> <input type="text" id="subject"
				class="contact-button"> <br>
			<br> Your Massage <br> <input type="text" id="massage"
				class="button-mess"> <br> <input
				class="button-submit size-button" type="button" id="myBtn"
				value="Submit" />
			
			<div id="myModal" class="modal">
				<!-- Modal content -->
				<div class="modal-content">
					<span class="close">&times;</span>
					<p id="popup_show_email"></p>
				</div>
			</div>
		 </form>
	</div>
</body>
</html>