<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/7/2022
  Time: 1:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/include/navbar.jsp" %>


<html>
<head>
    <title>Update Customer</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
<style>
    body{
        background: url("https://media.istockphoto.com/vectors/pop-art-background-in-retro-comics-book-style-with-halftone-texture-vector-id1363447269?b=1&k=20&m=1363447269&s=612x612&w=0&h=awdTuITih4GmkyjQw4pxMx_cuY4LOTSEzGvaCwgZUGQ=");
    }
</style>
</head>
<body>
<div style="height: 150px;"></div>
<h1 class="p-3 text-center text-white bg-warning">UPDATE CUSTOMER</h1>



<%--tin nhắn trả về kết quả cập nhật--%>
<div class="d-flex justify-content-center">
    <c:if test="${check==true}">
        <p class="w-50 bg-success p-1 text-center text-white">SUCCESS!</p>
    </c:if>
    <c:if test="${check==false}">
        <p class="w-50 bg-primary p-1 text-center text-white">FAIL!</p>
    </c:if>
</div>

<%--form update--%>
<div class="d-flex justify-content-center m-5">
    <form class="w-50 text-warning fw-bold shadow-lg p-5 bg-light" action="/Customer?action=updateCustomer" method="post">
        <div class="mb-3">
            <div class="w-100 d-flex justify-content-center">
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="addon-wrapping1">Id</span>
                    <input type="text" readonly class="form-control" name="id" value="${customer.id}">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="mb-3">
                    <p>Select customer type</p>
                    <select class="border-warning border-3 rounded-3 form-select-md" name="customerType"
                            id="customerType">
                        <c:forEach var="customerType" items="${customerTypeList}">
                            <c:if test="${customer.customerTypeId==customerType.customerTypeId}">
                                <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                            </c:if>
                        </c:forEach>

                        <c:forEach items="${customerTypeList}" var="customerType">
                            <c:if test="${customer.customerTypeId!=customerType.customerTypeId}">
                                <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">Enter name</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter customer name"
                           value="${customer.name}" name="name">
                    <p class="text-danger">${errorList.get("name")}</p>

                </div>
                <div class="mb-3">
                    <label for="birthday" class="form-label">Select birthday</label>
                    <input type="date" class="form-control" name="dayOfBirth" value="${customer.dateOfBirth}"
                           id="birthday">
                    <p class="text-danger">${errorList.get("birthday")}</p>

                </div>
                <div class="mb-3">
                    <p>Select gender</p>
                    <select class="border-warning border-3 rounded-3 form-select-md" name="gender" id="gender">
                        <c:if test="${customer.gender == true}">
                            <option value="true">Male</option>
                            <option value="false">Female</option>
                        </c:if>
                        <c:if test="${customer.gender == false}">
                            <option value="false">Female</option>
                            <option value="true">Male</option>
                        </c:if>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="idCard" class="form-label">Enter Customer Id Card</label>
                    <input type="text" class="form-control" placeholder="Enter customer Id Card" id="idCard"
                           value="${customer.idCard}" name="idCard">
                    <p class="text-danger">${errorList.get("idCard")}</p>

                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Enter customer phone</label>
                    <input type="text" class="form-control" placeholder="Enter customer phone" id="phone"
                           value="${customer.phoneNumber}" name="phone">
                    <p class="text-danger">${errorList.get("phone")}</p>

                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Enter customer email</label>
                    <input type="email" class="form-control" placeholder="Enter customer email" id="email"
                           value="${customer.email}" name="email">
                    <p class="text-danger">${errorList.get("email")}</p>

                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Enter customer adress</label>
                    <input type="text" class="form-control" placeholder="Enter customer adress" id="address"
                           value="${customer.address}" name="address">
                </div>
            </div>
        </div>
        <div>
            <button class="btn btn-warning">UPDATE</button>
            <a class="btn btn-success" href="/Customer">RETURN</a>
        </div>

    </form>
</div>
</div>

<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
