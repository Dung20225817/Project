<%-- 
    Document   : DeleteMovie
    Created on : Jan 27, 2025, 10:19:52 PM
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
        <form action="deletemovieservlet" method="Post">
          chose movie to delete:  
          <select name="curmvname">
              <c:forEach var="movie" items="${ListMovie}">                
                  <c:if test="${movie.mvstatus}"> 
                      <option value="${movie.mvname}"> ${movie.mvname}</option>
                  </c:if>                     
              </c:forEach>
          </select>
          <input type="submit" name="Delete">
        </form>
       ${msg0}
    </body>
</html>
