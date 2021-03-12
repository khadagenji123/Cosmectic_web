<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style-admin.css" type="text/css">
<title>Manage Accounts</title>
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
    <div id="content2">
        <table border="1" cellpadding="5">
        	<caption>List Concatenation</caption>
        	<tr>
        		<th>email</th>
        		<th>name</th>
        		<th>subject</th>
        		<th>message</th>
        	</tr>
        	
        	<c:forEach var="tempContact" items="${list_contact }">
        		
        		<tr>
        			<td>${tempContact.email }</td>
        			<td>${tempContact.name }</td>
        			<td>${tempContact.subject }</td>
        			<td>${tempContact.message }</td>
        		</tr>
        	</c:forEach>
        	
        </table>
    </div>
    
    <br>
    
    
</body>
</html>