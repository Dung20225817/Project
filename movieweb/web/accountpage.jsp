<%-- 
    Document   : accountpage
    Created on : Feb 3, 2025, 10:59:30 PM
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
            <li><a href="deletaccountservlet">Delete account</a></li>
            <li><a href="resetpasswordservlet">Reset password</a></li>
        </ul>
    </div>
    </section>
    <section id="account" >
   <div class="account-container">
        <!-- Hình ảnh avatar bên trái -->
        <div class="account-avatar">
            <img src="${account.image}" alt="User Avatar">
        </div>

        <!-- Thông tin phim bên phải -->
        <div class="account-info">
            <h2>${account.name}</h2>
            <p><strong>User-name:</strong> ${account.username}</p>
            <p><strong>ID:</strong> ${account.aid}</p>
            <p><strong>Age:</strong> ${account.age}</p>
            <p><strong>Phone:</strong> ${account.phone}</p>
            <p><strong>Mail:</strong> ${account.mail}</p>
            <p><strong>Address:</strong> ${account.address}</p>
            <p><strong>Role:</strong> ${account.role}</p>
            
            
             <!-- Nút Chỉnh Sửa và Xóa -->
        <!-- Nút Chỉnh Sửa -->
        <form action="updateaccountservlet" method="get">
            <input type="hidden" name="aid" value="${account.aid}">
            <button type="submit" class="edit-btn">Update</button>
        </form>

        <!-- Nút Xóa -->
        <form action="deleteaccountservlet" method="post" onsubmit="return confirm('Bạn có chắc chắn muốn xóa phim này không?');">
            <input type="hidden" name="aid" value="${account.aid}">
            <button type="submit" class="delete-btn">Delete</button>
        </form>

        </div>
    </div>    
    </section>
    </body>
</html>
