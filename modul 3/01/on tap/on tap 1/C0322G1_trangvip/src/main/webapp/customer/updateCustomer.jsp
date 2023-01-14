<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gia Nguyen Store
  Date: 8/5/2022
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Update</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../style/bootstrap/normalize.css">
    <link rel="stylesheet" href="../style/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../style/datatables/css/dataTables.bootstrap4.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../style/style.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0"/>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <form action="/customer?action=update" method="post">
        <input type="hidden" id="id" name="id" value="${customer.id}">
        <div class="mb-3">
            <label for="name" class="form-label">Customer Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${customer.name}">
            <p style="color: red">${errors.get('nameErrors')}</p>
        </div>
        <div class="mb-3">
            <label class="form-label"> number</label>
            <input type="text" class="form-control" name="number" id="number" value="${customer.number}">

        </div>
        <div class="mb-3">
            <label class="form-label">founding</label>
            <input type="date" class="form-control" id="founding" name="founding" value="${customer.founding}">
            <p style="color: red">${errors.get('dateErrors')}</p>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input type="text" class="form-control" id="address" name="address" value="${customer.address}">
        </div>
        <div>
            <button class="btn btn-success" type="submit">Accept</button>
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
            </button>
        </div>
    </form>
</div>
<%@include file="../include/footer.jsp" %>
<script src="../style/jquery/jquery-3.5.1.min.js"></script>
<script src="../style/datatables/js/jquery.dataTables.min.js"></script>
<script src="../style/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../style/bootstrap/bootstrap.bundle.min.js"></script>

</body>
</html>
