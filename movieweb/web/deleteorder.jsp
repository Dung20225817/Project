<%-- 
    Document   : deleteorder
    Created on : Jan 31, 2025, 9:55:59 PM
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
        <form action="deleteorderservlet" method="Post">
        select order to delete: <select name="curorder">
            <c:forEach var="order" items="${ListOrder}">
                <option value="${order.oid}">${order.oid} ${order.oname} ${order.otime} </option>
            </c:forEach>
        </select>
        <input type="submit" value="delete"><!-- comment -->
        </form>
        ${msg}
    </body>
</html>
