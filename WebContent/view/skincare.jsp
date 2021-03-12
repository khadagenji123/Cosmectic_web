<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style-best_selling.css" type="text/css">
<title>skincare</title>
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

	<div id="show-image">
		<c:forEach var="tempImage" items="${list_image}">
			<c:url var="tempLink" value="detail_Servlet">
		 		<c:param name="command" value="skincare"/>
		 		<c:param name="id" value="${tempImage.id }"/>
	    	 </c:url>
			<div id="image-list">
				<a href = "${tempLink }"><img src="${tempImage.link }" alt="image" class="index-image"></a>
				<div id="show-infor">
					<a href = "${tempLink }" style="color:blue">${tempImage.title }</a>
					<p style="color:red">${tempImage.cost }đ<p>
					<p><del>${tempImage.old_prime }</del>&nbsp; -${tempImage.sale }%</p>
				</div>
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;
		</c:forEach>
	</div>
	<br><br/>
	
<div id="footer">
    <div class="footer-information">
        <p>
            ROGERLES - MUA SẮM VÀ BÁN HÀNG ONLINE ĐƠN GIẢN, NHANH CHÓNG VÀ AN TOÀN
            <br><br/>
            Nếu bạn đang tìm kiếm một trang web để mua và bán hàng trực tuyến thì 
            RogerLes.vn là một sự lựa chọn hiệu quả dành cho bạn. Bản chất của RogerLes
            là một social ecommerce platform - nền tảng trang web thương mại điện 
            tử tích hợp mạng xã hội.. Điều này cho phép người mua và người bán hàng 
            dễ dàng tương tác, trao đổi thông tin về sản phẩm và chương trình khuyến 
            mãi của shop. Nhờ nền tảng đó, việc mua bán trên RogerLes trở nên nhanh 
            chóng và đơn giản hơn.Bạn có thể trò chuyện trực tiếp với nhà bán hàng để 
            hỏi trực tiếp về mặt hàng cần mua.Còn nếu bạn muốn tìm mua những 
        </p> 

    </div>
    <div class="footer-information">
        <p>
            dòng sản phẩm chính hãng, uy tín, RogerLes Mall chính là sự lựa chọn lí 
            tưởng dành cho bạn. Đến với RogerLes, cơ hội để trở thành một nhà bán hàng 
            dễ dàng hơn bao giờ hết. Chỉ với vài thao tác trên ứng dụng, bạn đã 
            có thể đăng bán ngay những sản phẩm của mình. Không những thế, các nhà 
            bán hàng có thể tùy chọn các tính năng “Shop tạm nghỉ” hoặc tự tạo riêng 
            cho mình một chương trình khuyến mãi để thu hút người mua với những 
            sản phẩm có mức giá hấp dẫn. Khi đăng nhập tại RogerLes Kênh người bán, 
            bạn có thể dễ dàng phân loại sản phẩm, theo dõi đơn hàng, chăm sóc 
            khách hàng và cập nhập ngay các hoạt động của shop.
        </p>
    </div>
    <div class="footer-information">
        <p>
            MUA HÀNG CHÍNH HÃNG TỪ CÁC THƯƠNG HIỆU LỚN VỚI ROGERLES
            <br><br/>
            Mua hàng trên RogerLes luôn là một trải nghiệm ấn tượng. Dù bạn đang 
            có nhu cầu mua bất kỳ mặt hàng thời trang nam, thời trang nữ, 
            chăm sóc da, dụng cụ làm đẹp RogerLes cũng sẽ 
            đảm bảo cung cấp cho bạn những sản phẩm ưng ý. Bên cạnh đó, RogerLes
            cũng có sự tham gia của các thương hiệu hàng đầu thế giới ở đa 
            dạng nhiều lĩnh vực khác nhau. Trong đó có thể kể đến Nivea, 
            Romno, Loreal, Innisfree, Clinique,...Các thương 
            hiệu này hiện cũng đã có cửa hàng chính thức trên RogerLes Mall 
            với hàng trăm mặt hàng chính hãng, được cập nhập liên tục.
        </p>
    </div>
    <div class="footer-information">
        <p> 
            Là một kênh bán hàng uy tín, RogerLes luôn cam kết mang lại cho khách 
            hàng những trải nghiệm mua sắm online giá rẻ, an toàn và tin cậy.
            Mọi thông tin về người bán và người mua đều được bảo mật tuyệt đối. Các 
            hoạt động giao dịch thanh toán tại RogerLes luôn được đảm bảo diễn ra 
            nhanh chóng, an toàn. 
            Ngoài ra, khách hàng có thể sử dụng RogerLes Xu để đổi lấy mã giảm giá có giá 
            trị cao và voucher dịch vụ hấp dẫn. Tiếp đến là RogerLes Mum's Club với 
            các ưu đãi độc quyền từ các thương hiệu lớn như Enfa; Friso; Pampers...
            cho các mẹ bỉm sữa đăng ký làm thành viên. Hãy truy cập ngay RogerLes.vn 
            hoặc tải ngay ứng dụng RogerLes về điện thoại ngay hôm nay!
        </p>
    </div>
</div>
</body>
</html>