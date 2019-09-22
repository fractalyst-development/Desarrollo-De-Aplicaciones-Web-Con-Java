<%-- 
    Document   : login
    Created on : Jul 28, 2017, 11:16:07 AM
    Author     : cazuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
    <form action="j_security_check" method="POST">
      Usuario: <input type="text" name="j_username">
      Contraseña: <input type="password" name="j_password">
      <input type="submit" value="Autenticar">
    </form>
  </body>
</html>
