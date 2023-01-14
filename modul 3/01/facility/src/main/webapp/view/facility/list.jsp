<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/7/2022
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/view/include/navbar.jsp" %>


<html>
<head>
    <title>Facility</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
    <style>
        body{
            background: url("https://media.istockphoto.com/photos/grunge-background-picture-id637350420?k=20&m=637350420&s=612x612&w=0&h=JyGkD_lC9eAiswveaJqtIZtYTZvLazrIAXCgHoxrzHA=");
        }
    </style>
</head>
<body>


<h1 class="p-3 text-white text-center bg-secondary">FACILITY LIST</h1>

    <div class="container mt-5 mb-5 justify-content-center">
        <div class="d-flex justify-content-start">
            <div class="w-50">
                <a class="btn btn-success" href="/Facility?action=addFacility">Add Facility</a>
            </div>
        </div>
        <div class="d-flex justify-content-center table-responsive ">
            <table id="facilityList" class="table-bordered table-hover table-striped table fw-bold">
                <thead class="bg-secondary text-center fw-bold text-white">
                <tr>
                    <th>STT</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Area</th>
                    <th>Cost</th>
                    <th>Max people</th>
                    <th>Rent Type id</th>
                    <th>facility type id</th>
                    <th>standard room</th>
                    <th>description other convenience</th>
                    <th>pool area</th>
                    <th>number of floor</th>
                    <th>facility free</th>
                    <th>Update</th>
                    <th>Delet</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="facility" items="${facilityList}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${facility.facilityId}</td>
                        <td>${facility.facilityName}</td>
                        <td>${facility.area}</td>
                        <td>${facility.cost}</td>
                        <td>${facility.maxPeople}</td>

                        <td>
                            <c:forEach items="${rentTypeList}" var="rentType">
                                <c:if test="${facility.rentTypeId == rentType.rentTypeId}">
                                    ${rentType.rentTypeName}
                                </c:if>
                            </c:forEach>
                        </td>

                        <td>
                            <c:forEach items="${facilityTypeList}" var="facilityType">
                                <c:if test="${facility.facilityTypeId == facilityType.facilityTypeId}">
                                    ${facilityType.facilityTypeName}
                                </c:if>
                            </c:forEach>
                        </td>

                        <td>${facility.standardRoom}</td>
                        <td>${facility.descriptionOtherConvenience}</td>
                        <td>${facility.poolArea}</td>
                        <td>${facility.numberOfFloor}</td>
                        <td>${facility.facilityFree}</td>
                        <td><a class="btn btn-warning" href="/Facility?action=updateFacility&idUpdate=${facility.facilityId}">UPDATE</a></td>
                        <td>
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal" onclick="getInfoToDelete('${facility.facilityId}','${facility.facilityName}')">
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
                <h4 class="modal-title">DELETE FACILITY</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <form action="/Facility?action=deleteFacility" method="post">
                <!-- Modal body -->
                <div class="modal-body">
                    Do you want to delete Facility:
                    <div>
                        <div class="input-group flex-nowrap">
                            <span class="input-group-text" id="addon-wrapping1">Id</span>
                            <input type="text" readonly  class="form-control" id="idDelete" name="idDeLete">
                        </div>
                        <div class="input-group flex-nowrap mt-3">
                            <span class="input-group-text" id="addon-wrapping2">Name</span>
                            <input type="text" readonly class="form-control" id="nameDeLete">
                        </div>
                    </div>
                </div>
                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">Close</button>
                    <button class="btn btn-danger">DELETE</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
<script>
    function getInfoToDelete(id,name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDeLete").value = name;
    }
</script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#facilityList').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</body>
</html>
