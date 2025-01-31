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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="addorderservlet" method="Post">
            Name: <input type="text" name="oname" placeholder="input your name" ><!-- comment -->
            Order Time: <input type="datetime-local" name="otime" placeholder="input time you added movie" required=""><!-- comment -->
            Order Phone: <input type="text" name="ophone" placeholder="input your phone"><!-- comment -->
            
            Movie: <select name="mvid">
                <c:forEach var="order" items="${ListOrder}">
                    <option value="${order.movie.mvid}">${order.movie.mvname}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Add">
        </form>
        ${msg}
    </body>
</html>
