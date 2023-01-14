<%--
  Created by IntelliJ IDEA.
  User: Gia Nguyen Store
  Date: 8/5/2022
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../style/bootstrap/normalize.css">
    <link rel="stylesheet" href="../style/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../style/datatables/css/dataTables.bootstrap4.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../style/style.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0"/>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <h1 class="text-center text-primary m-5">List Customer</h1>
    <div class="row">
        <div class="col-lg-4"><a href="/customer?action=create" class="btn btn-success">Create Customer</a></div>
        <div class="col-lg-8 align-items-lg-end">
                    <form action="/customer" class="d-flex justify-content-lg-end">
                        <input class="form-control me-2 w-50" type="text" placeholder="SearchName"
                               name="keyName" value="${keyName}" aria-label="Search">
                        <input class="form-control me-2 w-50" type="text" placeholder="SearchAddress"
                               name="keyAddress" value="${keyAddress}" aria-label="Search">
                        <button class="btn btn-success" name="action" value="search" type="submit">Search</button>
                    </form>
        </div>
    </div>
    <table class="table table-hover" id="myTable">
        <thead>
        <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>IdCard</th>
            <th>Phone</th>
            <th>CustomerType</th>
            <th>Email</th>
            <th>Address</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.dateOfBirth}</td>
                <c:if test="${customer.gender == 1}">
                    <td>Male</td>
                </c:if>
                <c:if test="${customer.gender == 0}">
                    <td>FeMale</td>
                </c:if>
                <td>${customer.idCard}</td>
                <td>${customer.phoneNumber}</td>
                <c:forEach items="${customerTypeList}" var="customerType">
                    <c:if test="${customerType.id == customer.customerTypeId}">
                        <td>${customerType.nameCustomerType}</td>
                    </c:if>
                </c:forEach>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>
                    <a href="/customer?action=update&id=${customer.id}" class="btn btn-warning">Update</a>
                </td>
                <td>
                    <button onclick="infoToModal('${customer.id}','${customer.name}')" class="btn btn-danger"
                            type="button" data-bs-toggle="modal" data-bs-target="#deleteModal">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <form action="/customer?action=delete" method="get">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 class="modal-title text-danger" id="exampleModalLabel">Customer</h2>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body ">
                            <b>ID Customer :</b>
                            <input type="text" readonly name="id" id="deleteId" class="form-control"><br>
                            <b>Customer Name :</b>
                            <input type="text" readonly name="name" id="deleteName" class="form-control"><br>
                            <h3 class="text-danger">Are you sure want delete </h3>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" name="action" value="delete" >Yes</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        </tbody>
    </table>
</div>
<%@include file="../include/footer.jsp"%>
<script>
   function infoToModal(id,name) {
       document.getElementById("deleteId").value = id;
       document.getElementById("deleteName").value = name;
   }
</script>
<script>
    $(document).ready(function () {
        $('#myTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 4
        });
    });
</script>
<script src="../style/jquery/jquery-3.5.1.min.js"></script>
<script src="../style/datatables/js/jquery.dataTables.min.js"></script>
<script src="../style/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../style/bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>
