<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/1/2022
  Time: 4:40 PM
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
<div class="container">
<h1 class="bg-warning text-center text-white">UPDATE USER</h1>

<c:if test="${message != null}">
    <p>${message}</p>
</c:if>

<c:if test="${user != null}">
    <form method="post">
        <div class="mb-3 mt-3">
            <label for="id" class="form-label">Name:</label>
            <input disabled type="text" class="form-control" id="id"  name="id" value="${user.id}">
        </div>
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Name:</label>
            <input type="text" class="form-control" id="name"  name="name" value="${user.name}">
        </div>
        <div class="mb-3 mt-3">
        <label for="email" class="form-label">Email:</label>
        <input type="text" class="form-control" id="email"  name="email" value="${user.email}">
        </div>
        <div class="mb-3">
            <label for="country" class="form-label">Country</label>
            <input type="text" class="form-control" id="country" name="country" value="${user.country}">
        </div>

        <button type="submit" class="btn btn-success">Update</button>
    </form>

</c:if>
<a class="btn btn-outline-primary" href="/User">Return User List</a>
</div>
<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
