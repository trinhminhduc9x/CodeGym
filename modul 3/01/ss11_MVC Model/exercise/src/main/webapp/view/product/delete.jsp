<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/29/2022
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table border="1px">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Producer</th>
        </tr>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.producer}</td>
        </tr>
    </table>
    <button type="submit">Xóa sản phẩm</button>
</form>
<a href="/product">Quay lại danh sách sản phẩm</a>
</body>
</html>
