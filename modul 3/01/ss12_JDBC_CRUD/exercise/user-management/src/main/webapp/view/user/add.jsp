<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/1/2022
  Time: 3:35 PM
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
<h1 class="bg-success text-center text-white">Create user</h1>
<c:if test="${message != null}">
    <p class="bg-primary m-2 text-white text-center">${message}</p>
</c:if>

<a href="/User" class="btn btn-outline-primary">Return User List</a>
<form action="/User?action=add" method="post">
    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Name:</label>
        <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    <div class="mb-3 mt-3">
    <label for="email" class="form-label">Email:</label>
    <input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="mb-3">
        <label for="country" class="form-label">Country</label>
        <input type="text" class="form-control" id="country" placeholder="Enter country" name="country">
    </div>

    <button type="submit" class="btn btn-success">ADD</button>
</form>
<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
