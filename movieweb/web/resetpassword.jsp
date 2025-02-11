<%-- 
    Document   : resetpassword
    Created on : Feb 1, 2025, 10:46:15 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    .form-container {
    position: absolute;
    transform: translate(-50%, -50%);
    top: 50%;
    left: 50%;
    background: white;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px; /* Giới hạn form để đẹp hơn trên màn hình rộng */
    
    }
    }
    
    </style>
    </head>
    <body>
    <section id="header">
    <a href="#"><img src="img/newlogo.png" class="logo"></a>
    <div><!-- Không có ý nghĩa về mặt nội dung, chỉ giúp bố cục trang -->
        <ul id="navbar">     <!-- Dùng để tạo danh sách các mục có dấu đầu dòng (bullet points). -->
            <li><a class="active" href="homepage.jsp">Home</a></li> <!-- tạo list danh sách -->
            <li><a href="accountpage.jsp">Account</a></li>
        </ul>
    </div>
    </section>
         <div class="form-container">
             <h2>Reset Password</h2>
        <form action="resetpasswordservlet" method="Post">
            User-name: <input type="text" name="username" placeholder="username" required="">
            Old pass: <input type="text" name="oldpass" placeholder="oldpass" required=""><!-- comment -->
            New pass: <input type="text" name="newpass" placeholder="newpass" required=""><!-- comment -->
            <input type="submit" value="Reset"><!-- comment -->
        </form>
         </div>
        ${msg5}
    </body>
</html>
