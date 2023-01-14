<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/29/2022
  Time: 1:04 PM
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
<h1>Danh sách sản phẩm</h1>
<a href="/product?action=add">Thêm mới sản phẩm</a>

<form action="/product?action=search" method="post">
    <input type="text" placeholder="Tìm kiếm sản phẩm theo tên" name="name">
    <%--    modal button--%>
    <button type="submit" class="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#searchModal">
        Tìm kiếm
    </button>

    <!-- Modal -->
    <div class="modal fade" id="searchModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Search Customer</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div>
                        <c:if test="productList != null">
                            <table class="table table-dark table-hover">
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Description</th>
                                    <th>Producer</th>
                                </tr>
                                <c:forEach var="product" items="${productList}">
                                    <tr>
                                        <td>${product.id}</td>
                                        <td>${product.name}</td>
                                        <td>${product.price}</td>
                                        <td>${product.description}</td>
                                        <td>${product.producer}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                        <c:if test="message != null">
                            <p>${message}</p>
                        </c:if>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Quay trở lại</button>
                </div>
            </div>
        </div>
    </div>
</form>

<div>
    <c:if test="productList != null">
        <div>

        </div>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Producer</th>
            </tr>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td>${product.producer}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="/product">Quay lại danh sách sản phẩm</a>
    </c:if>
    <c:if test="productList == null">
        <p>${message}</p>
        <a href="/product">Quay lại danh sách sản phẩm</a>
    </c:if>

</div>

<table class="table table-striped table-hover">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Producer</td>
        <td colspan="2"></td>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.id}</td>
            <td>
                <button type="button" class="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#detailProduct${product.id}">
                        ${product.name}
                </button>
                <div class="modal" id="detailProduct${product.id}">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Chi tiết sản phẩm</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <form action="/products?action=delete&id=${product.id}" method="post">
                                <!-- Modal body -->
                                <div class="modal-body">
                                    <table  class="table table-dark table-hover">
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Price</th>
                                            <th>Description</th>
                                            <th>Producer</th>
                                        </tr>
                                        <tr>
                                            <td>${product.id}</td>
                                            <td>${product.name}</td>
                                            <td>${product.price}</td>
                                            <td>${product.description}</td>
                                            <td>${product.producer}</td>
                                        </tr>
                                    </table>
                                </div>
                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                                </div>
                            </form>


                        </div>
                    </div>
                </div>

            </td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.producer}</td>
            <td><a href="/product?action=update&id=${product.id}">Update</a></td>
            <td>
                <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#deleteModal${product.id}">
                    Delete
                </button>
                <!-- The Modal -->
                <div class="modal" id="deleteModal${product.id}">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Delet Product</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <form action="/product&action=delete" method="post">
                                <!-- Modal body -->
                                <div class="modal-body">
                                    <table class="table-hover table table-dark">
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Price</th>
                                            <th>Description</th>
                                            <th>Producer</th>
                                        </tr>
                                        <tr>
                                            <td>${product.id}</td>
                                            <td>${product.name}</td>
                                            <td>${product.price}</td>
                                            <td>${product.description}</td>
                                            <td>${product.producer}</td>
                                        </tr>
                                    </table>
                                </div>
                                <!-- Modal footer -->
                                <div class="modal-footer">

                                    <a type="button"  class="btn btn-outline-danger" href="/product?action=delete&id=${product.id}" methods="post">
                                        delte</a>
                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                                </div>
                            </form>


                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>


<%--<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal1">--%>
<%--    Xóa sản phẩm--%>
<%--</button>--%>

<%--&lt;%&ndash;Modal delete&ndash;%&gt;--%>
<%--<div class="modal fade" id="deleteModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title" id="exampleModalLabel">Delete Product</h5>--%>
<%--                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--            </div>--%>

<%--            <form action="">--%>
<%--                <div class="modal-body">--%>
<%--                    <form method="post">--%>
<%--                        <div class="row g-2 align-items-center">--%>
<%--                            <div class="col-auto">--%>
<%--                                <label for="idDelete" class="col-form-label">Nhập id sản phẩm cần xóa</label>--%>
<%--                            </div>--%>
<%--                            <div class="col-auto">--%>
<%--                                <input type="text" id="idDelete" class="form-control" aria-describedby="Nhập id">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                        <a class="btn btn-danger" href="/product?action=delete">Xóa sản phẩm</a>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--            <div class="modal-body">--%>
<%--                <form method="post">--%>
<%--                    <div class="row g-2 align-items-center">--%>
<%--                        <div class="col-auto">--%>
<%--                            <label for="idDelete" class="col-form-label">Nhập id sản phẩm cần xóa</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-auto">--%>
<%--                            <input type="text" id="idDelete" class="form-control" aria-describedby="Nhập id">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                        <a class="btn btn-danger" href="/product?action=delete">Xóa sản phẩm</a>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
