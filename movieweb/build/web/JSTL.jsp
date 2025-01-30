<%-- 
    Document   : JSTL
    Created on : Oct 27, 2024, 5:41:45 PM
    Author     : User
--%>
<!-- HTML CSS Bootrap JS nen hoc -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table{
                border: 1px solid;
            }
            tr{
                 border: 1px solid;
            }
            th{
                 border: 1px solid;
            }
            td{
                 border: 1px solid;
            }
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>
        <!-- JSTL
        thư viện thẻ tiêu chuẩn giúp xử lí các chức năng
        phổ biến trong jsp mà k cần viết code java
        
        -JSTL bao gồm nhiều nhóm thẻ 
       <%-- Nhóm thẻ Core taglib(nhóm mình đang dùng)
        - một số thẻ core phổ biến
        1. if được dùng để kiểm tra một số điều kiện
        logic cơ bản
        <c:if test="${not emty listPerson}">
        
        </c:if>
        2. choose, when, ortherWise
        <c:choose>
            <c:when test="${person.getname()>18}">nguoi nay du 18</c:when>
            <c:otherwise>nguoi nay chu du 18</c:otherwise>
        </c:choose>
        3.Foereach: duyệt tất cả phẩn tử
       
            <c:forEach var="p" items="${listPerson}">
        ${p.getname()}
            </c:forEach>
        4.Fortoken ít được sử dụng vì có thể thay bằng split của string
            <c:forTokens var="l" items="DUC,VU,vuDuv" delims=",">
        ${1}
            </c:forTokens>
        --%>
        -->
        
        <!-- tạo bảng -->
          <c:if test="${not empty list}">
              <table>
            <tr>
                <th>Name</th>
                <th>age</th>
                <th>Phone</th>
            </tr>
           
                <c:forEach var="p" items="${list}">      
            <tr>
             
                <td>${p.getName()}</td>
                <td> ${p.age}</td>
                <td>${p.phone}</td>
            </tr>
             </c:forEach>
            
        </table>
        </c:if>
        
        
        <%--     <c:if test="${empty list}">
            danh sách rỗng
        </c:if>
            <c:if test="${not empty list}">
                <c:forEach var="p" items="${list}">
                    Tên: ${p.getName()}<br>
                   SĐT: ${p.getPhone()}<br>
                    Tuổi:  ${p.getAge()}<br>
                </c:forEach>
            </c:if>
        --%>             
                    
        <!--
        -JSP -> Servlet : sử dụng action thẻ form
        Servlet -> JSP: sử dụng response.sendRedirect(newjsp.jsp)
        - đây là cách di chuyển không kèm dữ liệu
        -Servlet->JSP: sử dụng request.getRequestDipatcher(newjso.jsp).foward(req,res)
        đây là cách di chuyển kèm dữ liệu đống gói
        -JSP->JSP2 tuy nhiên phải đi qua Servlet của JSP2 mà không cần form
        -sử dụng thẻ a(link)
        Servlet1->servlet 2: su dung du lieu chung qua secssion
        
        
        -->
        <a href="${pageContext.request.contextPath}/J2_Servlets"}>Go to context</a> cach 1
        <c:redirect url="${pageContext.request.contextPath}/J2_Servlets">Go to context</c:redirect> cach 2
        <!--
            object:
            + account
            acount_id int identity(1,1) primary key
        user_name str
        passworf str
        +product:
        -Product \_id int identity(1,1) primarykey
        product_name str
        price double
        quantity int
        +Brand
        brand_id int identity(1,1) primary key
        product Product
        brand Brand
        
        + Cacs screen
        account
        login
        register
        
        product:
        show ra tat ca product trong kho hang
        o trong home page se co
        add product,va trong add product co add brand cho chon brand co trong danh sach
        add brand:check xem brand co hay chua
        sau khi click vao button add product -> di chuyen den home page
        yeu cau verify tat ca screen
            -->
    </body>
</html>
