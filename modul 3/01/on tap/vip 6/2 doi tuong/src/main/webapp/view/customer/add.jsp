<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/7/2022
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Add Customer</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <style>
        body {
            background: url("https://img.freepik.com/free-vector/abstract-watercolor-pastel-background_87374-139.jpg?w=2000");
        }
    </style>
</head>
<body>
<!--navbar-->
<div class="fixed-top" style="margin: 0">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class=" navbar-nav me-auto mb-2 mb-lg-0">
                    <div class="container" style="width: 60px;height: 60px">
                        <a class="navbar-brand" href="/Furama">
                            <img class="img-fluid"
                                 src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png" alt="">
                        </a>
                    </div>

                    <li class="nav-item">
                        <a class="nav-link  fw-bold" href="/Furama?action=employee">Employee</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link  fw-bold" href="/Furama?action=customer" tabindex="-1" aria-disabled="true">Customer</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link  fw-bold" href="/Furama?action=service" tabindex="-1" aria-disabled="true">Service</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link  fw-bold" href="/Furama?action=contract" tabindex="-1" aria-disabled="true">Contract</a>
                    </li>
                </ul>
                <form class="d-flex ">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
                <div>
                    <a href="">Nguyễn Trần Thảo Nhiên</a>
                </div>
            </div>
        </div>
    </nav>
</div>

<div style="height: 150px;"></div>

<h1 class="p-3 text-center text-white bg-primary">ADD CUSTOMER</h1>

<%--//message--%>
<div class="d-flex justify-content-center m-5">
    <c:if test="${check==true}">
        <p class="w-50 bg-success p-1 text-center text-white">SUCCESS!</p>
    </c:if>
    <c:if test="${check==false}">
        <p class="w-50 bg-danger p-1 text-center text-white">FAIL!</p>
    </c:if>
</div>

<%--form add--%>
<div class="d-flex justify-content-center m-5">
    <form class="w-75 text-primary fw-bold shadow-lg p-5 bg-light" action="/Customer?action=addCustomer" method="post">
        <div class="row">
            <div class="col-md-6">
                <div class="mb-3 mt-3">
                    <p>Select customer type</p>
                    <select class="form-control" name="customerType" id="customerType">
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                        </c:forEach>
                    </select>
                </div>

                <%--       Tên khách hàng         --%>
                <div class="mb-3 mt-3">
                    <label for="name" class="form-label">Enter name</label>
                    <input type="text" class="form-control" id="name" value="${customer.name}"
                           placeholder="Enter customer name" name="name">
                    <p class="text-danger">${errorList.get("name")}</p>
                </div>

                <%--Ngày sinh--%>
                <div class="mb-3 mt-3">
                    <label for="birthday" class="form-label">Select birthday</label>
                    <input type="date" class="form-control" name="dayOfBirth" id="birthday"
                           value="${customer.dateOfBirth}">
                    <p class="text-danger">${errorList.get("birthday")}</p>
                </div>

                <%--                giới tính--%>
                <div class="mb-3 mt-3">
                    <p>Select gender</p>
                    <select class=" form-control" name="gender" id="gender" value="${customer.gender}">
                        <option value="true">Male</option>
                        <option value="false">Female</option>
                    </select>
                </div>
            </div>

            <div class="col-md-6">
                <%--                Số Cmnd--%>
                <div class="mb-3 mt-3">
                    <label for="idCard" class="form-label">Enter Customer Id Card</label>
                    <input type="text" class="form-control" placeholder="Enter customer Id Card"
                           value="${customer.idCard}" id="idCard" name="idCard">
                    <p class="text-danger">${errorList.get("idCard")}</p>
                </div>


                <%-- Số điện thoại   --%>
                <div class="mb-3 mt-3">
                    <label for="phone" class="form-label">Enter customer phone</label>
                    <input type="text" class="form-control" placeholder="Enter customer phone" id="phone" name="phone"
                           value="${customer.phoneNumber}">
                    <p class="text-danger">${errorList.get("phone")}</p>
                </div>



                <%--    email--%>
                <div class="mb-3 mt-3">
                    <label for="email" class="form-label">Enter customer email</label>
                    <input type="text   " class="form-control" placeholder="Enter customer email" id="email" name="email"
                           value="${customer.email}">
                    <p class="text-danger">${errorList.get("email")}</p>
                </div>


                <%--    Địa chỉ--%>
                <div class="mb-3 mt-3">
                    <label for="address" class="form-label">Enter customer adress</label>
                    <input type="text" class="form-control" placeholder="Enter customer adress" id="address"
                           value="${customer.address}" name="address">
                </div>
            </div>
        </div>
        <div>
            <button class="btn btn-primary">ADD</button>
            <a class="btn btn-success" href="/Customer">RETURN</a>
        </div>

    </form>
</div>
</div>

<%--<!-- Button to Open the Modal -->--%>
<%--<button type="button" class="btn btn-primary" data-bs-toggle="modal" id="messBtn" data-bs-target="#messModal ">--%>
<%--    Open modal--%>
<%--</button>--%>

<%--<!-- The Modal -->--%>
<%--<div class="modal" id="messModal">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>

<%--            <!-- Modal Header -->--%>
<%--            <div class="modal-header">--%>
<%--                <h4 class="modal-title">Modal Heading</h4>--%>
<%--                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>--%>
<%--            </div>--%>

<%--            <!-- Modal body -->--%>
<%--            <div class="modal-body">--%>
<%--                <div class="d-flex justify-content-center m-5">--%>
<%--                    <c:if test="${check==true}">--%>
<%--                        <p class="w-50 bg-success p-1 text-center text-white">SUCCESS!</p>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${check==false}">--%>
<%--                        <p class="w-50 bg-danger p-1 text-center text-white">FAIL!</p>--%>
<%--                    </c:if>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <!-- Modal footer -->--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>--%>
<%--            </div>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<%--<script>--%>
<%--    document.getElementById("messBtn").onclick();--%>
<%--</script>--%>
<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
