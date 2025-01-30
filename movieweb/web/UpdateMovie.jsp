<%-- 
    Document   : UpdateMovie
    Created on : Jan 29, 2025, 11:46:50 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="updatemovieservlet" method="Post">
            <select name="id">
                <c:forEach var="movie" items="${MovieList}">
                    <option value="${movie.mvid}">${movie.mvname}</option><!-- chọn tên movie để sửa đổi -->
                </c:forEach>
            </select>
            <input type="text" name="script" placeholder="new script" required=""><!-- nhập văn bản mới -->
            <input type="number" name="price" step="0.01" placeholder="new price" required=""><!-- nhập giá mới -->
            <input type="datetime-local" name="time" placeholder="newtime" required=""><!-- nhập thời gian mới -->
            <input type="submit" value="update"><!-- comment -->     
           
          
        </form>
    </body>
</html>
