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
    <div id="content1">
        <table border="1" cellpadding="5">
        	<caption>List Accounts</caption>
        	<tr>
        		<th>user name</th>
        		<th>password</th>
        		<th>name</th>
        		<th>birthday</th>
        		<th>gender</th>
        		<th>address</th>
        		<th>check user</th>
        		<th>number phone</th>
        	</tr>
        	
        	<c:forEach var="tempAccount" items="${list_account }">
        		
        		<tr>
        			<td>${tempAccount.username }</td>
        			<td>${tempAccount.password }</td>
        			<td>${tempAccount.name }</td>
        			<td>${tempAccount.birthday }</td>
        			<td>${tempAccount.gender }</td>
        			<td>${tempAccount.address }</td>
        			<td>${tempAccount.checkuser }</td>
        			<td>${tempAccount.number_phone }</td>
        		</tr>
        	</c:forEach>
        	
        </table>
        <br><br>
        
        <table border="1" cellpadding="5">
        	<caption>List Email Accounts</caption>
        	<tr>
        		<th>user name</th>
        		<th>password</th>
        		<th>name</th>
        		<th>birthday</th>
        		<th>gender</th>
        		<th>address</th>
        		<th>number phone</th>
        	</tr>
        	
        	<c:forEach var="tempEaccount" items="${list_eaccount }">
        		
        		<tr>
        			<td>${tempEaccount.email }</td>
        			<td>${tempEaccount.password }</td>
        			<td>${tempEaccount.name }</td>
        			<td>${tempEaccount.birthday }</td>
        			<td>${tempEaccount.gender }</td>
        			<td>${tempEaccount.address }</td>
        			<td>${tempEaccount.number_phone }</td>
        		</tr>
        	</c:forEach>
        	
        </table>
    </div>
    
</body>
</html>