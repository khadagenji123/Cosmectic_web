<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style-detail.css" type="text/css">
<script type="text/javascript" src="js/script-detail.js"></script>
<title>detail</title>
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
	           <p>
      				<button class="button" data-modal="modalOne">Mua ngay</button>
    		   </p>
			    <p>
			      <button class="button" data-modal="modalTwo">Thêm vào giỏ hàng</button>
			    </p>
			    <div id="modalOne" class="modal">
			      <div class="modal-content">
			        <div class="contact-form">
			          <a class="close">&times;</a>
			          <form action="buyProduct_Servlet" method="post">
			          	<input type="hidden" name="category" value="${cate }" >
			          	<input type="hidden" name="id" value="${tempImage.id }">
			            <h2>Chào mừng bạn! Hãy đăng nhập để tiếp tục</h2>
			            <div>
			              <input type="text" name="username" placeholder="Số điện thoại hoặc email">
			              <input type="password" name="password" placeholder="Mật khẩu">
			            </div>
			            <button type="submit">Submit</button>
			          </form>
			        </div>
			      </div>
			    </div>
			    <div id="modalTwo" class="modal">
			      <div class="modal-content">
			        <div class="contact-form">
			          <span class="close">&times;</span>
			          <form action="buyProduct_Servlet" method="post">
			          	<input type="hidden" name="command" value="LOGIN">
			          	<input type="hidden" name="category" value="${cate }" >
			          	<input type="hidden" name="id" value="${tempImage.id }">
			            <h2>Chào mừng bạn! Hãy đăng nhập để tiếp tục</h2>
			            <div>
			              <input type="text" name="username" placeholder="Số điện thoại hoặc email">
			              <input type="password" name="password" placeholder="Mật khẩu">
			            </div>
			            <button type="submit">Submit</button>
			          </form>
			        </div>
			      </div>
			    </div>
			</div> 
		</div>
        <div id="describe">
        	<h3>Mô tả sản phẩm:</h3>
        	${tempImage.description }
		</div>
	</c:forEach>
	
	<script>
      let modalBtns = [...document.querySelectorAll(".button")];
      modalBtns.forEach(function(btn) {
        btn.onclick = function() {
          	localStorage.setItem("figure",count);
          let modal = btn.getAttribute('data-modal');
          document.getElementById(modal)
            .style.display = "block";
        }
      });
      
      let closeBtns = [...document.querySelectorAll(".close")];
      closeBtns.forEach(function(btn) {
        btn.onclick = function() {
        	localStorage.setItem("figure",count);
          let modal = btn.closest('.modal');
          modal.style.display = "none";
        }
      });
      window.onclick = function(event) {
        if(event.target.className === "modal") {
          event.target.style.display = "none";
        }
      }
    </script>

</body>
</html>