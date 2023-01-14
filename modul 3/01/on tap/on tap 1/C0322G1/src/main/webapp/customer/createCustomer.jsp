<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gia Nguyen Store
  Date: 8/5/2022
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer</title>
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
<div class="container">
    <%@ include file="../include/header.jsp" %>
    <form action="/customer?action=create" method="post">

        <div class="mb-3">
            <label for="name" class="form-label">Name Customer:</label>
            <input type="text" class="form-control" id="name" name="name" value="${customer.name}">
            <p style="color: red">${errors.get('nameErrors')}</p>
        </div>
        <div class="mb-3">
            <label for="birthday" class="form-label">Birthday :</label>
            <input type="date" class="form-control" id="birthday" name ="dateOfBirth" value="${customer.dateOfBirth}">
            <p style="color: red">${errors.get('dateErrors')}</p>
        </div>
        <div class="mb-3">
            <label for="gender" class="form-label">Gender :</label>
           <div> <select id="gender" name="gender" class="form-control">
                <option>Choose Gender</option>
                <option value="1">Male</option>
                <option value="0">Female</option>
            </select>
           </div>
        </div>
        <div class="mb-3">
            <label for="id_card" class="form-label"> Id_card :</label>
            <input type="text" class="form-control" id="id_card" name="idCard" value="${customer.idCard}">
            <p style="color: red">${errors.get('idCardErrors')}</p>
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Phone :</label>
            <input type="text" class="form-control" id="phone" name = "phoneNumber" value="${customer.phoneNumber}">
            <p style="color: red">${errors.get('phoneErrors')}</p>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">email :</label>
            <input type="text" class="form-control" id="email" name="email" value="${customer.email}">
            <p style="color: red">${errors.get('emailErrors')}</p>
        </div>
        <div class="mb-3">
            <label for="customer_type" class="form-label">Customer_type :</label>
            <div class="mb-3 " >
                <select id="customer_type" class="form-control" name="customerTypeId">
                    <option selected disabled>Choose Customer Type</option>
                    <c:forEach items="${customerTypeList}" var="customerType">
                        <option value="${customerType.id}">${customerType.nameCustomerType}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address :</label>
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
