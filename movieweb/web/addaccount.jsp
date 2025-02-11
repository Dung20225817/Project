<%-- 
    Document   : addaccount
    Created on : Feb 1, 2025, 5:07:12 PM
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
     button {
    width: 100%;
    background-color: #007bff;
    color: white;
    border: none;
    padding: 10px;
    font-size: 16px;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 15px;
    }

    button:hover {
    background-color: #0056b3;
    }
    </style>
    </head>
    <body>
    <section id="header">
    <a href="#"><img src="img/newlogo.png" class="logo"></a>
    <div><!-- Không có ý nghĩa về mặt nội dung, chỉ giúp bố cục trang -->
        <ul id="navbar">     <!-- Dùng để tạo danh sách các mục có dấu đầu dòng (bullet points). -->
            <li><a class="active" href="homepage.jsp">Home</a></li> <!-- tạo list danh sách -->
            <li><a href="resetpasswordservlet">Reset password</a></li>
        </ul>
    </div>
    </section>
        
    <div class="form-container">
        <h2>New Account</h2>
        <form action="addaccountservlet" method="post">
           User name: <input type="text" name="username" placeholder="user name" required=""><!-- thêm user -->
           Pass word: <input type="text" name="pass" placeholder="pass word" required=""><!-- thêm pass -->
           Full name: <input type="text" name="fullname" placeholder="full name" required=""><!-- thêm user -->
           Age: <input type="number" name="age" placeholder="age" required=""><!-- thêm pass -->
           Address: <input type="text" name="address" placeholder="address" required=""><!-- thêm user -->
           Mail: <input type="text" name="mail" placeholder="mail" required=""><!-- thêm pass -->
           Phone: <input type="text" name="phone" placeholder="address" required=""><!-- thêm user -->
           Image: <input type="text" name=image placeholder="mail" required=""><!-- thêm pass -->
           Role: <select name="role">
                <option value="admin">admin</option>
                <option value="user">user</option>
            </select>
           <button type="submit">Add account </button>
        </form>
    </div>
    </body>
</html>
