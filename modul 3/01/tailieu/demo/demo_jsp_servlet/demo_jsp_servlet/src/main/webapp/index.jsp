<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 9/26/2022
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1> Trang index</h1>
  <a href="/sum?n1=5&n2=10">Vào do get</a>
  <form action="/sum" method="post">
    <input type="text" name="n1">
    <input type="text" name="n2">
    <input type="submit"> Sum</input>
  </form>

  </body>
</html>
