<%-- 
    Document   : Updateorder
    Created on : Feb 1, 2025, 2:08:59 PM
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
    <link rel="stylesheet" type="text/css" href="css/orderstyle.css"><!-- link lấy css -->
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
            <li><a href="addorderservlet">Add Order</a></li>
            <li><a href="deleteorderservlet">Delete Order</a></li>
            <li><a href="updateorderservlet">Update Order</a></li>
        </ul>
    </div>
</section>
        <form action="updateorderservlet" method="Post">
            <input type="number" name="oid" placeholder="order id" required=""><!-- comment -->
            <input type="text" name="oname" placeholder="order name" required=""><!-- comment -->
            <input type="datetime-local" name="otime" placeholder="time order" required="">
            <input type="text" name="ophone" placeholder="order phone" required=""><!-- comment -->
            <select name="mvid">
                <c:forEach var="movie" items="${ListMovie}">
                    <option value="${movie.mvid}">${movie.mvname}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Update"><!-- comment -->
        </form>
    </body>
</html>
