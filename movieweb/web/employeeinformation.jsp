<%-- 
    Document   : employeeinformation
    Created on : Feb 6, 2025, 10:37:12 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"><!-- link lấy css -->
        <title>Employee Information</title>
         <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
        }
        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .account-avatar img {
            width: 50px;
            height: 50px;
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
            <li><a href="updateaccountservlet">Update account</a></li>
            <li><a href="resetpasswordservlet">Reset password</a></li>
        </ul>
    </div>
       </section>

           <table border="1">
    <thead>
        <tr>
            <th> </th>
            <th>ID</th>
            <th>Tên</th>
            <th>Vai trò</th>
            <th>Tuổi</th>
            <th>Mail</th>
            <th>Địa chỉ</th>
            <th>Phone</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="account" items="${ListAccount}">
            <tr>
                <td><div class="account-avatar"><img src="${account.image}" alt="User Avatar"></div></td>
                <td>${account.aid}</td>
                <td>${account.name}</td>
                <td>${account.role}</td>
                <td>${account.age}</td>
                <td>${account.mail}</td>
                <td>${account.address}</td>
                <td>${account.phone}</td>
            </tr>
        </c:forEach>
    </tbody>
    </table>

    </body>
</html>
