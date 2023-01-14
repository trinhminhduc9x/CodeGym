<%--
  Created by IntelliJ IDEA.
  User: Admint
  Date: 29/09/2022
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>calculator</h1>
  <form action="/Calculator" method="post">
    <input type="text" name="first_operand" placeholder="nhập số thứ nhất">
  <div>
    <span>Nhập toán hạng</span>
   <select name="Operator">
     <option value="+">addition</option>
     <option value="-">subtraction</option>
     <option value="*">multiplication</option>
     <option value="/">division</option>
   </select>
  </div>
    <input type="text" name="second_operand" placeholder="nhập số thứ hai">
    <button type="submit" >calculate</button>
  </form>
  </body>
</html>
