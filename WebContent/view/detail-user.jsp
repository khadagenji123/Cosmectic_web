<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style-detail-user.css" type="text/css">
<script type="text/javascript" src="js/script-detail.js"></script>
<title>detail-user</title>
</head>
<body>
	<div>
	    <ul id="header" class="show">
	        <li class="font-li">Hotline: 1900 636 510 - 0973 104 105
	        &nbsp;&nbsp; Email: rogerles@gmail.com</li>
	        <li><a href="MainPageServlet">Trang chủ</a></li>
	    </ul>
	</div>
	
	<div>
	    <div id="left1">
	        <p class="item">RogerLes</p>
	    </div>
	    <div id="right1">
	    	<form action="MainPageServlet" method="post">
    		  	<input type="hidden" name="command" value="SEARCH">
        		<input type="search" name="name-product"
                    placeholder ="Tìm kiếm trên RogerLes" size="60px" class="search">
    		</form>
	    </div>
	</div>
	 
	<br><br/>
	<c:forEach var="tempImage" items="${list_image}">
        		
		<div id="product">
	        <div>
	            <img src="${tempImage.link }" alt="image" class="index-image">
	        </div>
	        <div id="right">
	            ${tempImage.title }
	            <p style="color:red">${tempImage.cost }đ</p>
	            <p><del>${tempImage.old_prime }đ</del>&nbsp; -${tempImage.sale }%<p>
	            <form class="number-product">
	               <input type="button" onclick="down();" value="-" class="button4"/>
	                &nbsp;&nbsp;
	                <div id="up">1</div>
	                &nbsp;&nbsp;
	               <input type="button" onclick="up();" value="+" class="button4" />
	            </form>
				<%String cate = (String)request.getAttribute("cate"); %>
				<br><br><br>
				<form id="myForm" action="buyProduct_Servlet" method="post">
					<input type="hidden" name="category" id="category" value="${cate }">
					<input type="hidden" name="id" id="id" value="${tempImage.id }">
					<input type="button" class="button" onclick="myFunction()" value="Mua ngay">
				</form>
				<br>
	            <form id="myForm" action="buyProduct_Servlet" method="post">
					<input type="hidden" name="category" id="category" value="${cate }">
					<input type="hidden" name="id" id="id" value="${tempImage.id }">
					<input type="button" class="button" onclick="myFunction()" value="Thêm vào giỏ hàng">
				</form>
			</div> 
		</div>
        <div id="describe">
        	<h3>Mô tả sản phẩm:</h3>
        	${tempImage.description }
		</div>
	</c:forEach>
<script>
function myFunction() {
	localStorage.setItem("figure",count);
	  document.getElementById("myForm").submit();
	  
}
</script>

</body>
</html>