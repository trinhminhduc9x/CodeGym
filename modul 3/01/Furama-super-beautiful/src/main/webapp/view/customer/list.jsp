<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/6/2022
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/include/navbar.jsp" %>


<html>
<head>
    <title>Customer</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <style>
        body {
            background: url("https://img.freepik.com/free-vector/hand-painted-watercolor-pastel-sky-background_23-2148902771.jpg?w=2000");
        }
    </style>
</head>
<body>

<h1 class="p-3 text-center text-white bg-success">DANH SÁCH KHÁCH HÀNG</h1>

<div class="row container d-flex align-items-end">
    <div class="col-md-6 d-flex justify-content-center" style="height:38px;">
        <a class="btn-success btn" href="/Customer?action=addCustomer">Add customer</a>
    </div>
    <%--    form tìm kiếm--%>
    <div class="col-md-6 mt-2">
        <form action="/Customer?action=searchCustomer" method="post">
            <div class="row">
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Name" name="name">
                </div>
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Phone" name="phone">
                </div>
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="Email" name="email">
                </div>
            </div>
            <div class="row mt-2">
                <select name="customerTypeId" id="" class="form-control">
                    <option value="">Select Customer Type</option>
                    <c:forEach var="customerType" items="${customerTypeList}">
                        <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="d-flex justify-content-end">
                <button class="btn btn-outline-success mt-4">SEARCH</button>
            </div>
        </form>
    </div>
</div>

<c:if test="${message!=null}">

    <p>${message}</p>

</c:if>

<%--table customer--%>
<div class="container d-flex justify-content-center mb-5">
    <div class="table-responsive mt-2">
        <table id="tableStudent" class="border table table-striped table-hover table-bordered" border="1">
            <thead class="table-success text-center ju">
            <tr>
                <td>Số TT</td>
                <th>ID</th>
                <th>Customer Type</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Gender</th>
                <th>Id card</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customerList}" var="customer" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${customer.id}</td>
                    <td>
                        <c:forEach items="${customerTypeList}" var="customerType">
                            <c:if test="${customer.customerTypeId==customerType.customerTypeId}">
                                ${customerType.customerTypeName}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>${customer.name}</td>
                    <td>${customer.dateOfBirth}</td>
                    <td>
                        <c:if test="${customer.gender==false}">
                            Female
                        </c:if>
                        <c:if test="${customer.gender==true}">
                            Male
                        </c:if>
                    </td>
                    <td>${customer.idCard}</td>
                    <td>${customer.phoneNumber}</td>
                    <td>${customer.email}</td>
                    <td>${customer.address}</td>
                    <td><a class="btn btn-outline-warning"
                           href="/Customer?action=updateCustomer&idUpdate=${customer.id}">UPDATE</a>
                    </td>
                    <td>
                        <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteModal"
                                onclick="getIdToDelete('${customer.id}','${customer.name}')">
                            DELETE
                        </button>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<!-- The Modal -->
<div class="modal" id="deleteModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header bg-danger text-white text-center">
                <h4 class="modal-title">DELETE CUSTOMER</h4>
                <button type="button" class="btn-close text-white" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form action="/Customer?action=deleteCustomer" method="post">
                    <p>Do you want to delete Customer:</p>
                    <div>
                        <div class="input-group flex-nowrap">
                            <span class="input-group-text" id="addon-wrapping1">Id</span>
                            <input type="text" readonly class="form-control" id="idDelete" name="id">
                        </div>
                        <div class="input-group flex-nowrap mt-5">
                            <span class="input-group-text" id="addon-wrapping2">Name</span>
                            <input type="text" readonly class="form-control" id="nameDelete">
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-bs-dismiss="modal">CLOSE</button>
                        <button class="btn btn-outline-danger">DELETE</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script>
    <%--    thêm value cho thẻ input--%>

    function getIdToDelete(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").value = name;
    }
</script>
<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>
