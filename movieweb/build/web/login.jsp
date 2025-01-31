<%-- 
    Document   : login
    Created on : Nov 11, 2024, 2:36:31 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="form-container sign-in">
      <form action="adminlogin" method="Post">
        <h1>Sign In</h1>
       
        <span>or use your email password</span>
        <input type="text" name="Username" placeholder="Username" required />
        <input type="text" name="Password" placeholder="Password" required />
        <select name="role">
            <<option value="admin">admin</option>
            <<option value="user">user</option>
        </select>
        <a href="#">Forgot Your Password?</a>
        <button type="submit">Sign In</button>
      </form>
           ${msg0}
    </div>
    </body>
</html>
