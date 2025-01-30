<%-- 
    Document   : newmovie
    Created on : Nov 11, 2024, 5:57:43 PM
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
        <form action="addmovieservlet" method="post">
           movie name : <input type="text" name="movie" placeholder="name movie" value="" required="">
           script : <input type="text" name="script" placeholder="script for movie" >
           time : <input type="datetime-local" name="time" placeholder="time start" value="" required>
           price : <input type="number" step="0.01" name="price"  value="" required="">
           <input type="submit" value="add">
        </form>
        ${error}
    </body>
</html>
