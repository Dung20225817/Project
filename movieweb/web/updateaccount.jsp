<%-- 
    Document   : updateaccount
    Created on : Feb 5, 2025, 1:46:59 PM
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
    <link rel="stylesheet" type="text/css" href="css/accountstyle.css"><!-- link lấy css -->
    <style>
    #header .logo {
    width: 80px;  /* Điều chỉnh kích thước chiều rộng */
    height: auto;  /* Giữ tỷ lệ khung hình */
    border-radius: 50%;
    object-fit: cover;
    }
    
    </style>
    </style>
    </head>
    <body>
    <section id="header">
    <a href="#"><img src="img/newlogo.png" class="logo"></a>
    <div><!-- Không có ý nghĩa về mặt nội dung, chỉ giúp bố cục trang -->
        <ul id="navbar">     <!-- Dùng để tạo danh sách các mục có dấu đầu dòng (bullet points). -->
            <li><a class="active" href="homepage.jsp">Home</a></li> <!-- tạo list danh sách -->
            <li><a href="addaccountservlet">Add account</a></li>
            <li><a href="deletaccountservlet">Delete account</a></li>
            <li><a href="resetpasswordservlet">Reset password</a></li>
        </ul>
    </div>
    </section>
        <div class="form-container">
        <h2>Cập nhật tài khoản</h2>

        <form action="updateaccountservlet" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${curaccount.username}" required>

            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" value="${curaccount.name}" required>

            <label for="age">Age:</label>
            <input type="number" id="age" name="age" value="${curaccount.age}" required>

            <label for="mail">Email:</label>
            <input type="email" id="mail" name="mail" value="${curaccount.mail}" required>

            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" value="${curaccount.phone}" required>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="${curaccount.address}" required>

            <label for="image">Profile Image URL:</label>
            <input type="text" id="image" name="image" value="${curaccount.image}" required>

            <input type="hidden" name="aid" value="${curaccount.aid}">

            <button type="submit">Cập nhật</button>
        </form>
    </div>
    </body>
</html>
