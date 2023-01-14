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
    <title>Update Facility</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <style>
        body {
            background: url("https://img.freepik.com/free-vector/soft-yellow-watercolor-texture-decorative-background-vector_1055-12504.jpg?w=2000");
        }
    </style>
</head>
<body>
<h1 class="p-3 text-white text-center bg-warning">UPDATE FACILITY</h1>
<%--<c:if test="${mess!=null}">--%>
<p>${mess}</p>
<%--</c:if>--%>
<div class="d-flex justify-content-center">
    <form action="/Facility?action=updateFacility" method="post"
          class="bg-light text-warning fw-bold w-50 shadow-lg p-5 mt-5">
        <div class="d-flex justify-content-center">
            <div>
                <div class="form-text">Select facility to add</div>
                <input type="hidden" name="idUpdate" value="${facility.facilityId}">
                <select name="facilityTypeId" id="facilityType" onchange="updateFacilityType()"
                        class="border-warning border-5 rounded-pill form-select-lg">
                    <c:forEach items="${facilityTypeList}" var="facilityType">
                        <option value="${facilityType.facilityTypeId}">${facilityType.facilityTypeName}</option>
                    </c:forEach>
                    <option value="none">Select facility type</option>
                </select>
            </div>

        </div>
        <div class="row mt-3">
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" value="${facility.facilityName}"
                           placeholder="Enter facility name" name="name" id="name">
                </div>
                <div class="mb-3">
                    <label for="area" class="form-label">Area</label>
                    <input type="text" class="form-control" id="area" value="${facility.area}" placeholder="Enter Area"
                           name="area">
                </div>
                <div class="mb-3">
                    <label for="cost" class="form-label">Cost</label>
                    <input type="text" class="form-control" id="cost" value="${facility.cost}" placeholder="Enter Cost"
                           name="cost">
                </div>
                <div class="mb-3">
                    <label for="maxPeople" class="form-label">Max people</label>
                    <input type="text" class="form-control" id="maxPeople" value="${facility.maxPeople}"
                           placeholder="Enter Max people"
                           name="maxPeople">
                </div>

                <p>Select Rent Type id</p>
                <select name="rentTypeId" id="rentTypeId" class="border-warning  form-control">
                    <c:forEach var="rentType" items="${rentTypeList}">
                        <c:if test="${facility.rentTypeId==rentType.rentTypeId}">
                            <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                        </c:if>
                    </c:forEach>

                    <c:forEach var="rentType" items="${rentTypeList}">
                        <c:if test="${facility.rentTypeId!=rentType.rentTypeId}">
                            <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                        </c:if>
                    </c:forEach>
                </select>

            </div>
            <div class="col-md-6">
                <div style="display: none" id="divStandardRoom">
                    <div class="mb-3">
                        <label for="standardRoom" class="form-label">Standard room</label>
                        <input type="text" class="form-control" id="standardRoom" value="${facility.standardRoom}"
                               placeholder="Enter standard room"
                               name="standardRoom">
                    </div>
                </div>

                <div style="display: none" id="divDescriptionOtherConvenience">
                    <div class="mb-3">
                        <label for="descriptionOtherConvenience" class="form-label">Description other
                            convenience</label>
                        <input type="text" class="form-control" id="descriptionOtherConvenience"
                               value="${facility.descriptionOtherConvenience}"
                               placeholder="Enter description other convenience" name="descriptionOtherConvenience">
                    </div>
                </div>

                <div style="display: none" id="divPoolArea">
                    <div class="mb-3">
                        <label for="poolArea" class="form-label">Pool area</label>
                        <input type="text" class="form-control" id="poolArea" placeholder="Enter pool area"
                               value="${facility.poolArea}" name="poolArea">
                    </div>
                </div>

                <div style="display: none" id="divNumberOfFloor">
                    <div class="mb-3">
                        <label for="numberOfFloor" class="form-label">Number of floor</label>
                        <input type="text" class="form-control" id="numberOfFloor" placeholder="Enter number of floor"
                               value="${facility.numberOfFloor}" name="numberOfFloor">
                    </div>
                </div>

                <div style="display: none" id="divFacilityFree">
                    <div class="mb-3">
                        <label for="facilityFree" class="form-label">facility free</label>
                        <input type="text" class="form-control" id="facilityFree" placeholder="Enter facility free"
                               value="${facility.facilityFree}" name="facilityFree">
                    </div>
                </div>
            </div>
        </div>
        <div class="mt-5 d-flex justify-content-evenly">
            <button class="btn btn-warning">UPDATE</button>
            <a class="btn btn-primary" href="/Facility">Return Facility List</a>

        </div>
    </form>
    <form action="">
        <input type="hidden" id="firstFacilityTypeId" value="${facility.facilityTypeId}">
    </form>
</div>
<%--form control > css select-option--%>
<%--Tự động bật modal thông báo thành công--%>
<a href="/Facility">Return Facility List</a>
<script>

    window.onload = function () {
        let firstFacilityTypeId = document.getElementById("firstFacilityTypeId").value;
        document.getElementById("facilityType").value = firstFacilityTypeId;
        displayInput(firstFacilityTypeId);
    }
    function updateFacilityType() {
        let selectedFacilityTypeId = document.getElementById("facilityType").value;
        displayInput(selectedFacilityTypeId);
    }

    function displayInput(firstFacilityTypeId) {
        let divStandardRoom = document.getElementById("divStandardRoom");
        let divDescriptionOtherConvenience = document.getElementById("divDescriptionOtherConvenience");
        let divPoolArea = document.getElementById("divPoolArea");
        let divNumberOfFloor = document.getElementById("divNumberOfFloor");
        let divFacilityFree = document.getElementById("divFacilityFree");
        switch (firstFacilityTypeId) {
            case "none":
                divStandardRoom.style.display = "none";
                divDescriptionOtherConvenience.style.display = "none";
                divPoolArea.style.display = "none";
                divNumberOfFloor.style.display = "none";
                divFacilityFree.style.display = "none";
                break;
            case "1":
                //villa
                divStandardRoom.style.display = "block";
                divDescriptionOtherConvenience.style.display = "block";
                divPoolArea.style.display = "block";
                divNumberOfFloor.style.display = "block";
                divFacilityFree.style.display = "none";
                document.getElementById("FacilityFree").value = "";
                break;
            case "2":
                //house
                divStandardRoom.style.display = "block";
                divDescriptionOtherConvenience.style.display = "block";
                divPoolArea.style.display = "none";
                document.getElementById("poolArea").value = 0;
                divNumberOfFloor.style.display = "block";
                divNumberOfFloor.style.display = "block";
                divFacilityFree.style.display = "none";
                document.getElementById("facilityFree").value = "";
                break;
            case "3":
                //room
                divStandardRoom.style.display = "none";
                document.getElementById("standardRoom").value = "";
                divDescriptionOtherConvenience.style.display = "none";
                document.getElementById("descriptionOtherConvenience").value = "";
                divPoolArea.style.display = "none";
                document.getElementById("poolArea").value = 0;
                divNumberOfFloor.style.display = "none";
                document.getElementById("numberOfFloor").value = 0;
                divFacilityFree.style.display = "block";
                break;
        }
    }
</script>

<button type="button" hidden class="btn btn-primary" id="modalBtn" data-bs-toggle="modal" data-bs-target="#resultMess">
    Open modal
</button>
<div class="modal" id="resultMess">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Modal Heading</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <div class="d-flex justify-content-center">
                    <c:if test="${check=true}">
                        <p class="p-3 bg-success text-center text-white w-50">SUCCESS</p>
                    </c:if>
                    <c:if test="${check=false}">
                        <p class="p-3 bg-danger text-center text-white w-50">SUCCESS</p>
                    </c:if>
                </div>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>
<script>
    document.getElementById("resultMess").click();
</script>

</body>
</html>
