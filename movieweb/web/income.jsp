<%-- 
    Document   : income
    Created on : Feb 5, 2025, 10:43:09 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"><!-- lấy kí hiệu đặc biệt -->
    <title>Trang Web Rạp Chiếu Phim</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"><!-- link lấy css -->
    <style>
    #header .logo {
    width: 80px;  /* Điều chỉnh kích thước chiều rộng */
    height: auto;  /* Giữ tỷ lệ khung hình */
    border-radius: 50%;
    object-fit: cover;
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
            <li><a href="accountpage.jsp">Account</a></li>
            <li id="lg-bag"><a href="cart.html"><i class="fa-solid fa-cart-shopping"></i></a></li>
        </ul>
    </div>
</section>
<strong>Tổng doanh thu:</strong> ${sumincome} VND
<form action="incomeservlet" method="post">
    <label for="year">Chọn năm:</label>
    <input type="number" name="year" required min="2000" max="2050">
    <button type="submit">Xem Doanh Thu</button>
</form>
<table border="1">
    <thead>
        <tr>
            <th>Tháng</th>
            <th>Doanh thu (VND)</th>
        </tr>
    </thead>
    <tbody>
        <tr><td>Tháng 1</td><td>${Income1}</td></tr>
        <tr><td>Tháng 2</td><td>${Income2}</td></tr>
        <tr><td>Tháng 3</td><td>${Income3}</td></tr>
        <tr><td>Tháng 4</td><td>${Income4}</td></tr>
        <tr><td>Tháng 5</td><td>${Income5}</td></tr>
        <tr><td>Tháng 6</td><td>${Income6}</td></tr>
        <tr><td>Tháng 7</td><td>${Income7}</td></tr>
        <tr><td>Tháng 8</td><td>${Income8}</td></tr>
        <tr><td>Tháng 9</td><td>${Income9}</td></tr>
        <tr><td>Tháng 10</td><td>${Income10}</td></tr>
        <tr><td>Tháng 11</td><td>${Income11}</td></tr>
        <tr><td>Tháng 12</td><td>${Income12}</td></tr>
    </tbody>
</table>    
    </body>
</html>
