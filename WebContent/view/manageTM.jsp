<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style-admin.css" type="text/css">
<title>Manage TradeMark</title>
</head>
<body>
	<div id="menu">
        <p class="show1">DANH MỤC SẢN PHẨM</p>
        <hr>
        <ul class="distance-line">
           <li><a href="../manage_Category_Servlet?value=skincare">Chăm sóc da</a></li>
	        <li><a href="../manage_Category_Servlet?value=makeup">Trang điểm</a></li>
	        <li><a href="../manage_Category_Servlet?value=bodycare">Chăm sóc cơ thể</a></li>
	        <li><a href="../manage_Category_Servlet?value=forman">Dành cho nam giới</a></li>
        </ul>
        <hr>
        <p class="show1">THƯƠNG HIỆU</p>
        <hr>
        <ul class="distance-line">
            <li><a href="manage_TradeMark_Servlet?value=loreal">Loreal</a></li>
            <li><a href="manage_TradeMark_Servlet?value=nivea">Nivea</a></li>
            <li><a href="manage_TradeMark_Servlet?value=neutrogena">Neutrogena</a></li>
        </ul>
        <hr>
        <a href="manage_BestSelling_Servlet"><p class="show1">BÁN CHẠY</p></a>
        <hr>
        <a href="manage_NewProduct_Servlet"><p class="show1">HÀNG MỚI VỀ</p></a>
        <hr>
        <a href="manage_Contact_Servlet"><p class="show1">LIÊN HỆ</p></a>
        <hr>
        <a href="manage_MemberShip_Servlet"><p class="show1">THÀNH VIÊN</p></a>
    </div>
     <div id="welcome">
        <h1>Hi Admin!</h1>
    </div>
    <div id="content">
        <table border="1" cellpadding="5">
        	<caption>List products</caption>
        	<tr>
        		<th>Id</th>
        		<th>Image link</th>
        		<th>title</th>
        		<th>description</th>
        		<th>cost</th>
        		<th>sale</th>
        		<th>old prime</th>
        		<th>Action</th>
        	</tr>
        	
        	<%String category = (String)request.getAttribute("category"); %>
        	<c:forEach var="tempImage" items="${list_image }">
        		
        		<!--set up a link for each book -->
        		<c:url var="tempLink" value="manage_TradeMark_Action_Servlet">
        			<c:param name="command" value="LOAD"/>
        			<c:param name="id" value="${tempImage.id }"/>
        			<c:param name="category" value="${category }"/>
        		</c:url>
        		
        		
        		<!-- set up a link to delete a product -->
        		<c:url var="deleteProduct" value="manage_TradeMark_Action_Servlet">
        			<c:param name="command" value="DELETE"/>
        			<c:param name="id" value="${tempImage.id }"/>
        			<c:param name="category" value="${category }"/>
        		</c:url>
        		<tr>
        			<td>${tempImage.id }</td>
        			<td>${tempImage.link }</td>
        			<td>${tempImage.title }</td>
        			<td>${tempImage.description }</td>
        			<td>${tempImage.cost }</td>
        			<td>${tempImage.sale }</td>
        			<td>${tempImage.old_prime }</td>
        			<td>
        				<p>
        				<button class="button" data-modal="modalOne">Add</button>
        				</p>
        				<div id="modalOne" class="modal">
					      <div class="modal-content">
					        <div class="contact-form">
					          <a class="close">&times;</a>
					          <form action="manage_TradeMark_Action_Servlet" method="post">
					          	<input type="hidden" name="command" value="ADD">
					          	<input type="hidden" name="category" value="${category }">
					            <h2>Add Product</h2>
					            <div>
					              <input class="fname" type="text" name="link" placeholder="Link Image">
					              <input type="text" name="title" placeholder="Title">
					              <input type="text" name="cost" placeholder="Cost">
					              <input type="text" name="sale" placeholder="Sale">
					              <input type="text" name="old_prime" placeholder="old_prime">
					              <div>
						          		<textarea name="description" placeholder="Description" rows="7"></textarea>
						          </div>
					            </div>
					            <button type="submit">Submit</button>
					          </form>
					        </div>
					      </div>
					    </div>
        				<a href="${tempLink }"><button class="button">Update</button></a>
        				&nbsp;&nbsp;&nbsp;
        				<a href = "${deleteProduct }"
    	 	 			onclick = "if(!(confirm('Are you sure you want to delete this product'))) return false" >
    	 	 			<button class="button" >Delete</button></a>
        			</td>
        		</tr>
        	</c:forEach>
        	
        </table>
    </div>
    
    <script>
	    let modalBtns = [...document.querySelectorAll(".button")];
	    modalBtns.forEach(function(btn) {
	      btn.onclick = function() {
	        let modal = btn.getAttribute('data-modal');
	        document.getElementById(modal)
	          .style.display = "block";
	      }
	    });
	    let closeBtns = [...document.querySelectorAll(".close")];
	    closeBtns.forEach(function(btn) {
	      btn.onclick = function() {
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