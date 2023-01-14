<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/29/2022
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Cập nhật sản phẩm</h1>
<a href="/product">Quay lại danh sách sản phẩm</a>
<form method="post">
    <p>Tên Sản phẩm</p>
    <input type="text" name="name" value="${product.name}">
    <p>Giá sản phẩm</p>
    <input type="text" name="price" value="${product.price}">
    <p>Mô tả sản phẩm</p>
    <input type="text" name="description" value="${product.description}">
    <p>Nhà sản xuất</p>
    <input type="text" name="producer" value="${product.producer}">
    <button type="submit">Save</button>
</form>
<c:if test="${message != null}">
    <p>${message}</p>
</c:if>
</body> 
</html>
