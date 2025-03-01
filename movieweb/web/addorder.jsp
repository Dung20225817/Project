<%-- 
    Document   : addorder
    Created on : Jan 30, 2025, 11:03:52 PM
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
    }
    
    </style>
    </head>
    <body>
         <section id="header">
    <a href="#"><img src="img/newlogo.png" class="logo"></a>
    <div><!-- Không có ý nghĩa về mặt nội dung, chỉ giúp bố cục trang -->
        <ul id="navbar">     <!-- Dùng để tạo danh sách các mục có dấu đầu dòng (bullet points). -->
            <li><a class="active" href="showhomepageservlet">Home</a></li> <!-- tạo list danh sách -->
            <li><a href="addorderservlet">Add Order</a></li>
            <li><a href="deleteorderservlet">Delete Order</a></li>
            <li><a href="updateorderservlet">Update Order</a></li>
        </ul>
    </div>
</section>
            <div class="form-container">
        <form action="addorderservlet" method="post">
            <label for="Name">Name:</label>
            <input type="text" name="oname" placeholder="input your name" ><!-- comment -->

            <label for="OrderTime:">Order Time::</label>
            <input type="datetime-local" name="otime" placeholder="input time you added movie" required=""><!-- comment -->

            <label for="OrderPhone">Order Phone:</label>
            <input type="text" name="ophone" placeholder="input your phone"><!-- comment -->

            <label for="Movie">Movie:</label>
            <select name="mvid">
                <c:forEach var="movie" items="${ListMovie}">
                    <option value="${movie.mvid}">${movie.mvname}</option>
                </c:forEach>
            </select>

            <button type="submit">Add</button>
        </form>
    </div>
        
        ${msg}
    </body>
</html>
<script>
    function setCurrentTime() {
        let now = new Date();
        let year = now.getFullYear();
        let month = String(now.getMonth() + 1).padStart(2, '0'); // Định dạng thành 2 chữ số (01-12)
        let day = String(now.getDate()).padStart(2, '0');
        let hours = String(now.getHours()).padStart(2, '0');
        let minutes = String(now.getMinutes()).padStart(2, '0');

        // Định dạng chuẩn cho input datetime-local: YYYY-MM-DDTHH:MM
        let currentTime = `${year}-${month}-${day}T${hours}:${minutes}`;

        // Gán giá trị vào input datetime-local
        document.getElementById('otime').value = currentTime;
    }

    // Chạy hàm khi trang tải xong
    window.onload = setCurrentTime;
</script>
