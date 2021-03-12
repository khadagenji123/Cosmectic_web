<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/result.js"></script>
<link rel="stylesheet" href="css/style-buyproduct.css" type="text/css">
<title>Buy product</title>
</head>
<body>

	<h1>Rogerles</h1>
	<br><br>
	<div id="content">
		<c:forEach var="tempImage" items="${list_image }">
			<img src="${tempImage.link }" alt="image" class="image">
			&nbsp;&nbsp;
			<p>${tempImage.title }</p>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<div>
				<p style="color:red">${tempImage.cost }đ</p>
				<p><del>${tempImage.old_prime }đ</del>&nbsp;<p>
				<p>-${tempImage.sale }%</p>
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<p>Số lượng: <span id="result-count"></span> </p>
		</c:forEach>
	</div>
</body>
</html>