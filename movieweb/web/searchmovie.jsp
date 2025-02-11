<%-- 
    Document   : searchmovie
    Created on : Feb 4, 2025, 3:37:23 PM
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
    </head>
    <body>       
    <section id="header">
    <a href="#"><img src="img/newlogo.png" class="logo"></a>
    <div><!-- Không có ý nghĩa về mặt nội dung, chỉ giúp bố cục trang -->
        <ul id="navbar">     <!-- Dùng để tạo danh sách các mục có dấu đầu dòng (bullet points). -->
            <li><a class="active" href="homepage.jsp">Home</a></li> <!-- tạo list danh sách -->
            <li><a href="updatemovieservlet">Update movie</a></li>
            <li><a href="deletemovieservlet">Delete movie</a></li>
            <li><a href="addmovie.jsp">Add movie</a></li>
        </ul>
    </div>
    </section>
        
      <section id="hero1" >
    <div class="movie-container">
        <!-- Hình ảnh poster phim bên trái -->
        <div class="movie-poster">
            <img src="${Movie.mvposter}" alt="Movie Poster">
        </div>

        <!-- Thông tin phim bên phải -->
        <div class="movie-info">
            <h4>${Movie.mvname}</h4>
            <h2>Giá vé:  <span>${Movie.mvprice} $</span></h2>
            <h2>Thời gian chiếu: <span>${Movie.mvtime}</span> </h2>
            <h2>Nội dung: <span>${Movie.mvscript}</span> </h2>
            
             <!-- Nút Chỉnh Sửa và Xóa -->
        <!-- Nút Chỉnh Sửa -->
        <form action="updatemovieservlet" method="get">
            <input type="hidden" name="mvid" value="${Movie.mvid}">
            <button type="submit" class="edit-btn">Chỉnh Sửa</button>
        </form>

        <!-- Nút Xóa -->
        <form action="deletemovieservlet" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa phim này không?');">
            <input type="hidden" name="mvid" value="${Movie.mvid}">
            <button type="submit" class="delete-btn">Xóa</button>
        </form>

        </div>
    </div>    
    </section>
        
    </body>
</html>
