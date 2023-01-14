<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<div class="row mx-0 py-xl-5" style="height: 90%;margin-top: 0px">
    <div class="col-md-3 col-lg-2 min-vh-100 p-0 m-0">
        <%@ include file="../side-bar.jsp" %>
    </div>
    <div class="col-md-9 col-lg-10 min-vh-100 vh-100 navbar-nav-scroll" style="margin-top: 10px">
        <h3>
            Trang danh sách sinh viên
        </h3>
        <form class="row g-3 d-fex justify-content-end" action="/student" method="get">
            <input type="text" name="action" value="search" hidden>
            <div class="col-auto">
                <input type="text" name="searchName" class="form-control" placeholder="Name">
            </div>
            <div class="col-auto">
                <input type="text" name="searchAccount" class="form-control" placeholder="Account">
            </div>
            <div class="col-auto">
                <select class="form-select" name="searchClassName">
                    <option selected value="">Chọn lớp...</option>
                    <c:forEach var="cls" items="${classList}">
                        <option value="${cls.name}">${cls.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-outline-primary mb-3">Search</button>
            </div>
        </form>
        <a class="btn btn-outline-primary btn-sm my-1 " href="/student?action=add">Thêm mới</a>
        <table class="table table-sm" style="width: 100%">
            <tr class="bg-warning">
                <th>STT</th>
                <th>Id</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Birthday</th>
                <th>Point</th>
                <th>Rank</th>
                <th>Account</th>
                <th>ClassID</th>
                <th>Email</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="student" items="${studentList}" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${student.getId()}</td>
                    <td>${student.getName()}</td>
                    <c:if test="${student.isGender()}">
                        <td>Nam</td>
                    </c:if>
                    <c:if test="${!student.isGender()}">
                        <td>Nữ</td>
                    </c:if>
                    <td>${student.getBirthday()}</td>
                    <td>${student.getPoint()}</td>
                    <c:choose>
                        <c:when test="${student.getPoint()>=8}">
                            <td>Giỏi</td>
                        </c:when>
                        <c:when test="${student.getPoint()>=7}">
                            <td>Khá</td>
                        </c:when>
                        <c:when test="${student.getPoint()>=5}">
                            <td>Trung Bình</td>
                        </c:when>
                        <c:otherwise>
                            <td>Yêu sắc yếu</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${student.getAccount()}</td>
                    <td>${student.getClassName()}</td>
                    <td>${student.getEmail()}</td>
                    <td>
                        <button class="btn btn-sm btn-outline-primary">Edit</button>
                    </td>
                    <td>
                        <button type="button" onclick="showInfo('${student.getId()}','${student.getName()}')"
                                class="btn btn-outline-warning btn-sm" data-bs-toggle="modal"
                                data-bs-target="#exampleModal">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <form action="/student">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Xác nhận xoá?</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="text" id="deleteId" name="deleteId" hidden>
                            <input type="text" value="delete" name="action" hidden>
                            <span>Bạn có muốn xoá sinh viên </span><span id="deleteName"></span>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-primary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-outline-warning">Delete</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
        <script>
            function showInfo(id, name) {
                document.getElementById("deleteName").innerText = name;
                document.getElementById("deleteId").value = id;
            }
        </script>
    </div>
</div>
<%@ include file="../footer.jsp" %>
