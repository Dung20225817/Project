<%-- 
    Document   : UpdateMovie
    Created on : Jan 29, 2025, 11:46:50 PM
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
            <li><a href="deletemovieservlet">Delete movie</a></li>
            <li><a href="addmovie.jsp">Add movie</a></li>
        </ul>
    </div>
</section>
        <form action="updatemovieservlet" method="Post">
            Movie_id:<select name="id">
                <c:forEach var="movie" items="${MovieList}">
                    <option value="${movie.mvid}">${movie.mvid}</option><!-- chọn tên movie để sửa đổi -->
                </c:forEach>
            </select>
            Movie name:<input type="text" name="mvname" placeholder="new name" required="">
            Movie script:<input type="text" name="script" placeholder="new script" required=""><!-- nhập văn bản mới -->
            Movie price:<input type="number" name="price" step="0.01" placeholder="new price" required=""><!-- nhập giá mới -->
            Movie time:<input type="datetime-local" name="time" placeholder="newtime" required=""><!-- nhập thời gian mới -->
            <input type="submit" value="update"><!-- comment -->              
        </form>
    </body>
</html>
