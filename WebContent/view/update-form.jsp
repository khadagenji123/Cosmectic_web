<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style-admin.css" type="text/css">
<title>Edit page</title>
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
     	<h1>Products Management</h1>
      	<div align="center">
		<h2>Edit Product</h2>
		
		<form action="manage_TradeMark_Action_Servlet" method="post">
			<%String category = (String)request.getAttribute("category"); %>
			<input type="hidden" name="command" value="UPDATE"/>
			<input type="hidden" name="category" value="${category }"/>
			<input type = "hidden" name="imageId" value="${theImage.id }"/>
			
			<table border="1" cellpadding="5">
				<tbody>
					<tr>
						<td><label>Link Image</label></td>
						<td><input type="text" name="link"
									value="${theImage.link }" size="45"/></td>
					</tr>
					<tr>
						<td><label>title</label></td>
						<td><input type="text" name="title"
									value="${theImage.title }" size="45"/></td>
					</tr>
					<tr>
						<td><label>description</label></td>
						<td>
							<input type="text" name="description"
									value="${theImage.description }" size="45"/>
						</td>
					</tr>
					<tr>
						<td><label>cost</label></td>
						<td><input type="text" name="cost"
									value="${theImage.cost }" size="45"/></td>
					</tr>
					<tr>
						<td><label>sale</label></td>
						<td><input type="text" name="sale"
									value="${theImage.sale }" size="45"/></td>
					</tr>
					<tr>
						<td><label>old prime</label></td>
						<td><input type="text" name="old_prime"
									value="${theImage.old_prime }" size="45"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="Save"></td>
					</tr>
				</tbody>
			</table>
		</form>
		<div style="clear:both;"></div>
		
		<p>
			<a href="manage_TradeMark_Servlet?value=${category }">Back to List</a>
		</p>
    </div>
	</div>

</body>
</html>