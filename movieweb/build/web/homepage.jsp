<%-- 
    Document   : homepage
    Created on : Nov 11, 2024, 3:40:52 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="addmovie.jsp">
            <button type="submit">Add movie</button>
        </form>
        <form action="deletemovieservlet" method="Get">
            <button type="submit">Delete movie</button>
        </form>
        <form action="updatemovieservlet" method="get">
            <button type="submit">Update movie</button>
        </form>
        <form action="addorderservlet" method="get">
            <button type="submit">Add Order</button>
        </form>
        <form action="deleteorderservlet" method="get">
            <button type="submit">Delete Order</button>
        </form>
    </body>
</html>
