<%-- 
    Document   : newmovie
    Created on : Nov 11, 2024, 5:57:43 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
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
            <li><a href="updatemovieservlet">Update movie</a></li>
            <li><a href="deletemovieservlet">Delete movie</a></li>
        </ul>
    </div>
</section>
        <form action="addmovieservlet" method="post">
           movie name : <input type="text" name="movie" placeholder="name movie" value="" required="">
           script : <input type="text" name="script" placeholder="script for movie" >
           time : <input type="datetime-local" name="time" placeholder="time start" value="" required>
           price : <input type="number" step="0.01" name="price"  value="" required="">
           poster :<input type="text" name="mvposter" ><!-- comment -->
           <input type="submit" value="add">
        </form>
        ${error}
    </body>
</html>
