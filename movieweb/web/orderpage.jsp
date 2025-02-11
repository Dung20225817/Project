<%-- 
    Document   : orderpage
    Created on : Feb 3, 2025, 10:57:57 PM
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
        
        <table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Tên Người Đặt</th>
            <th>Điện Thoại</th>
            <th>Trạng Thái</th>
            <th>Thời Gian</th>
            <th>Tên Phim</th>
            <th>Hành Động</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="order" items="${ListOrder}">
            <tr>
                <td>${order.oid}</td>
                <td>${order.oname}</td>
                <td>${order.phone}</td>
                <td>
                    <c:choose>
                        <c:when test="${order.status}">
                             Đã Thanh Toán
                        </c:when>
                        <c:otherwise>
                             Chưa Thanh Toán
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${order.otime}</td>
                <td>${order.movie.mvname}</td>
                <td>
<!--                     Nút Chỉnh Sửa -->
                    <form action="updateorderservlet" method="get" style="display: inline-block;">
                        <button type="submit">Chỉnh Sửa</button>
                    </form>

<!--                     Nút Xóa (Có xác nhận) -->
                    <form action="deleteorderservlet" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa đơn hàng này không?');" style="display: inline-block;">
                        <input type="hidden" name="oid" value="${order.oid}">
                        <button type="submit" style="background-color: red; color: white;">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

    </body>
</html>
