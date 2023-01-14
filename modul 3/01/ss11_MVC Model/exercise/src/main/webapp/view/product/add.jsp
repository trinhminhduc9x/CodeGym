<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/29/2022
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
</head>
<body>
<h1>Thêm mới sản phẩm</h1>
<a href="/product">Quay lại danh sách sản phẩm</a>

<form action="/product?action=add" method="post">
    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Nhập tên sản phẩm:</label>
        <input type="text" class="form-control" id="name" placeholder="Nhập tên sản phẩm" name="name">
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Nhập giá sản phẩm:</label>
        <input type="text" class="form-control" id="price" placeholder="Nhập giá sản phẩm" name="price">
    </div>
    <div class="mb-3 mt-3">
        <label for="description" class="form-label">Nhập mô tả sản phẩm:</label>
        <input type="text" class="form-control" id="description" placeholder="Nhập mô tả sản phẩm" name="description">
    </div>
    <div class="mb-3 mt-3">
        <label for="producer" class="form-label">Nhập nhà sản xuất:</label>
        <input type="text" class="form-control" id="producer" placeholder="Nhập nhà sản xuất" name="producer">
    </div>
    <button type="submit" class="btn btn-success">Thêm mới</button>
</form>

<c:if test="${message != null}">
    <p>${message}</p>
</c:if>
<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</body>
</html>


