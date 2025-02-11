<%-- 
    Document   : moviepage
    Created on : Feb 3, 2025, 10:41:37 PM
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
            <li><a href="addmovie.jsp">Add movie</a></li>
        </ul>
    </div>
</section>

 <section id="product1" class="section-p1">
    <h2>Phim trong tháng</h2>
    <p>Cập nhật theo ngày</p>
    <div class="pro-container">
             <c:forEach var="movie" items="${ListMovie}">
                 <div class="pro">
                 <img src="${movie.mvposter}" alt="">
                  <div class="des">
                 <span>${movie.mvname}</span>
                <h5>${movie.mvtime}</h5>
                 <div class="star">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
                  </div>
                <h4>${movie.mvprice} $</h4>
                <form action="searchmovieservlet" method="get" id="search">
                    <button type="submit" name="mvid" value="${movie.mvid}"><i class="fa fa-search"></i></button>
                </form>
                 
                </div>
              </c:forEach>   
                
    </div>
 </section>        
    </body>
</html>
