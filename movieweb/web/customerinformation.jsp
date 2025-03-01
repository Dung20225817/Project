<%-- 
    Document   : customerinformation
    Created on : Feb 7, 2025, 8:40:29 PM
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
            <li><a class="active" href="showhomepageservlet">Home</a></li> <!-- tạo list danh sách -->
            <li><a href="showaccountpageservlet">Account</a></li>
            <li><a href="resetpasswordservlet">Reset password</a></li>
        </ul>
    </div>
       </section>
           <table border="1">
    <thead>
        <tr>
            <th>Customer_id</th>
            <th>Username</th>
            <th>Pass</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Gender</th>
            <th>Date of birth</th>
            <th>Register_date</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="customer" items="${ListCustomer}">
            <tr>
                <td>${customer.customer_id}</td>
                <td>${customer.username}</td>
                <td>${customer.pass}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
                <td>${customer.address}</td>
                <td>${customer.gender}</td>
                <td>${customer.dob}</td>
                <td>${customer.register_date}</td>
                <td>${customer.status}</td>
            </tr>
        </c:forEach>
    </tbody>
    </table>

    </body>
</html>
