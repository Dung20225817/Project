<%-- 
    Document   : showcinemainformation
    Created on : Feb 10, 2025, 6:41:39 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"><!-- lấy kí hiệu đặc biệt -->
    <title>Trang Web Rạp Chiếu Phim</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"><!-- link lấy css -->
    <style>
    #hero{
    background-image: url("img/natra.png") ; 
    }
    #hero button{
    background-image: url("img/button.png");
    }
    #header .logo {
    width: 80px;  /* Điều chỉnh kích thước chiều rộng */
    height: auto;  /* Giữ tỷ lệ khung hình */
    border-radius: 50%;
    object-fit: cover;
    }
    h2 {
    font-size: 16px; /* Kích thước chữ */
    font-weight: bold; /* Độ đậm */
    color: #000; 
    text-transform: uppercase; /* Viết hoa toàn bộ */
    text-align: center; /* Căn giữa */
    margin-bottom: 5px; /* Khoảng cách dưới */
    /*border-bottom: 3px solid #ff6600;  Gạch chân */
    display: inline-block; /* Giữ nguyên kích thước theo nội dung */
    padding-bottom: 5px; /* Khoảng cách dưới gạch chân */
}
p {
    font-size: 14px; /* Kích thước chữ dễ đọc */
    color: #333; /* Màu chữ xám đậm */
    line-height: 1.6; /* Giãn dòng để dễ đọc */
    text-align: justify; /* Căn đều 2 bên */
    margin-bottom: 10px; /* Khoảng cách giữa các đoạn */
}
.container {
    width: 70%; /* Hoặc dùng max-width để giới hạn chiều rộng */
    max-width: 800px; /* Giới hạn tối đa chiều rộng */
    margin: 0 auto; /* Căn giữa nội dung */
    padding: 20px; /* Tạo khoảng cách bên trong */
    background: #fff; /* Nền trắng để nổi bật */
}
    </style>
</head>
<body>
   <section id="header">
       <a href="#"><img src="img/newlogo.png" class="logo"></a>


    <div><!-- Không có ý nghĩa về mặt nội dung, chỉ giúp bố cục trang -->
        <ul id="navbar">     <!-- Dùng để tạo danh sách các mục có dấu đầu dòng (bullet points). -->
            <li><a class="active" href="homepage.jsp">Home</a></li> <!-- tạo list danh sách -->
            <li><a href="showmoviepageservlet">Movie</a></li>
            <li><a href="showorderpageservlet">Order</a></li>
            <li><a href="showaccountpageservlet">Account</a></li>
            
        </ul>
    </div>
  </section>
    <div class="container"> 
     <h2>TRẢI NGHIỆM ĐIỆN ẢNH HIỆN ĐẠI VÀ KHÁC BIỆT</h2>
    <p>DxMovie không chỉ đơn thuần là một rạp chiếu phim mà còn là không gian giải trí sáng tạo, kết hợp công nghệ chiếu phim tiên tiến với thiết kế trẻ trung, hiện đại. Các phòng chiếu của DxMovie được trang bị hệ thống âm thanh vòm Dolby Atmos, màn hình LED độ phân giải cao, mang đến những khung hình sắc nét và sống động.</p>

    <h2>CHIẾN LƯỢC GIÁ CẢ PHÙ HỢP VỚI MỌI KHÁN GIẢ</h2>
    <p>DxMovie cam kết mang lại mức giá vé hợp lý nhưng vẫn đảm bảo chất lượng dịch vụ cao cấp. Với giá vé trung bình từ 60,000 VNĐ, DxMovie hướng đến việc mở rộng thị trường và phục vụ đa dạng đối tượng khách hàng.</p>

    <h2>PHÁT TRIỂN NHANH CHÓNG & KHẢ NĂNG SINH LỜI CAO</h2>
    <p>Kể từ khi thành lập, DxMovie đã ghi nhận sự tăng trưởng mạnh mẽ với hơn 25 cụm rạp trên cả nước, đón tiếp hơn 8 triệu lượt khách mỗi năm. Năm 2023, DxMovie đạt mức tăng trưởng doanh thu 170% so với giai đoạn trước đại dịch.</p>

    <h2>CƠ HỘI ĐẦU TƯ NHƯỢNG QUYỀN HẤP DẪN</h2>
    <p>DxMovie triển khai chương trình nhượng quyền rạp chiếu phim với mô hình linh hoạt, tối ưu hóa chi phí đầu tư và đảm bảo lợi nhuận hấp dẫn. Các nhà đầu tư có thể dễ dàng vận hành rạp chiếu phim với sự hỗ trợ toàn diện từ DxMovie.</p>

    <div class="contact">
        <h2>LIÊN HỆ ĐỂ NẮM BẮT CƠ HỘI ĐẦU TƯ NGAY HOM NAY!</h2>
        <p><strong>Hotline:</strong> 1900 888 999</p>
        <p><strong>Email:</strong> franchise@dxmovie.vn</p>
        <p><strong>Website:</strong> <a href="https://www.dxmovie.vn" target="_blank">www.dxmovie.vn</a></p>
    </div>
    </div>
    </body>
</html>
