<%-- 
    Document   : deleteorder
    Created on : Jan 31, 2025, 9:55:59 PM
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
        <form action="deleteorderservlet" method="Post">
        select order to delete: <select name="curorder">
            <c:forEach var="order" items="${ListOrder}">
                <option value="${order.oid}">${order.oid} ${order.oname} ${order.otime} </option>
            </c:forEach>
        </select>
        <input type="submit" value="delete"><!-- comment -->
        </form>
        ${msg}
    </body>
</html>
