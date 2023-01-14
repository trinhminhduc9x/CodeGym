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
        <a class="btn-success btn" href="/Home?action=addCustomer">Add customer</a>
    </div>
    <%--    form tìm kiếm--%>
    <div class="col-md-6 mt-2">
        <form action="/Home?action=searchCustomer" method="post">
            <div class="row">
                <div class="col-md-4">
                    <input type="text" class="form-control" placeholder="tenPhim" name="tenPhim">
                </div>
            </div>
            <div class="row mt-2">
                <select name="customerTypeId" id="" class="form-control">
                    <option value="">theLoai</option>
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
                <th>Ten Phim</th>
                <th>Ngay Chieu Phim </th>
                <th>The Loai</th>
                <th>Quoc Gia</th>
                <th>Do Tuoi</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${phimList}" var="phim" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${phim.sttPhim}</td>
                    <td>${phim.tenPhim}</td>
                    <td>${phim.ngayChieuPhim}</td>
                    <td>
                        <c:forEach items="${theLoaiList}" var="theLoai">
                            <c:if test="${phim.sttTheLoai==theLoai.sttTheLoai}">
                                ${theLoai.tenTheLoai}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${quocGiaList}" var="quocGia">
                            <c:if test="${phim.sttQuocGia==quocGia.sttQuocGia}">
                                ${quocGia.tenQuocGia}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${doTuoiList}" var="doTuoi">
                            <c:if test="${phim.sttDoTuoi==doTuoi.sttDoTuoi}">
                                ${doTuoi.tenDoTuoi}
                            </c:if>
                        </c:forEach>
                    </td>
                    <td><a class="btn btn-outline-warning"
                           href="/Home?action=updateCustomer&idUpdate=${customer.id}">UPDATE</a>
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
                <form action="/Home?action=deleteCustomer" method="post">
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
