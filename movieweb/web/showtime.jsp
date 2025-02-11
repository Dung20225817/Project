<%-- 
    Document   : showtime
    Created on : Feb 5, 2025, 9:36:59 PM
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
    table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

th {
    background-color: #f4f4f4;
}

tr:hover {
    background-color: #f1f1f1;
}

button {
    padding: 5px 10px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    transition: 0.3s;
}

button:hover {
    opacity: 0.7;
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

        <table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Tên phim</th>
            <th>Thời gian</th>
            <th>Trạng Thái</th>
            <th>Thời Gian</th>
            <th>Giá tiền</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="movie" items="${ListMovie}">
            <tr>
                <td>${movie.mvid}</td>
                <td>${movie.mvname}</td>
                <td>
                    <c:choose>
                        <c:when test="${movie.mvstatus}">
                             Có lịch chiếu
                        </c:when>
                        <c:otherwise>
                             Hủy lịch
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${movie.mvtime}</td>
                <td>${movie.mvprice}</td>
                <td>
<!--                     Nút Chỉnh Sửa -->
                    <form action="updatemovieservlet" method="get" style="display: inline-block;">
                        <button type="submit">Chỉnh Sửa</button>
                    </form>

<!--                     Nút Xóa (Có xác nhận) -->
                    <form action="deletmovieservlet" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa đơn hàng này không?');" style="display: inline-block;">
                        <input type="hidden" name="mvid" value="${movie.mvid}">
                        <button type="submit" style="background-color: red; color: white;">Xóa</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
    </table>
    </body>
</html>
