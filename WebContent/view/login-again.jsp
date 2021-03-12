<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style-login-again.css" type="text/css">
<title>Wrong login</title>
</head>
<body>
	<%String cate = (String)request.getAttribute("cate"); %>
	<%int id = (int)request.getAttribute("id"); %>
	<a href="MainPageServlet">Trang chủ</a>
	<form action="buyProduct_Servlet" method="post">
		<input type="hidden" name="id" value="${id}">
		<input type="hidden" name="category" value="${cate }" >
	    <h2>Đăng nhập sai! Vui lòng đăng nhập lại để tiếp tục</h2>
	    <div>
	      <input type="text" name="username" placeholder="Số điện thoại hoặc email">
	      <br>
	      <input type="password" name="password" placeholder="Mật khẩu">
	    </div>
	    <button type="submit" class="submit">Submit</button>
	</form>
</body>
</html>