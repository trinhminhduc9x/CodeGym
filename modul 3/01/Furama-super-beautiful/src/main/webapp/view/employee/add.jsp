<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/7/2022
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/view/include/navbar.jsp" %>
<html>
<head>
    <title>Add Facility</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist/css/bootstrap.min.css">
    <style>
        body {
            background: url("https://wallpaperaccess.com/full/187163.jpg") 100%;
        }
    </style>
</head>
<body>

<h1 class="p-3 bg-success text-white text-center">ADD FACILITY</h1>

<%--Hiện thị kết quả thêm được không--%>


<c:if test="${check!=null}">

    <button type="button" class="btn btn-primary" id="modalBtn" data-bs-toggle="modal" data-bs-target="#resultMess">
        Open modal
    </button>
    <div class="modal" id="resultMess">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">Kết quả thêm mới</div>
                <!-- Modal body -->
                <div class="modal-body">
                    <div class="d-flex justify-content-center">
                        <c:if test="${check=true}">
                            <p class="fw-bold text-success">Thêm mới thành công</p>
                        </c:if>
                        <c:if test="${check=false}">
                            <p class="fw-bold text-danger">Thêm mới thất bại</p>
                        </c:if>
                    </div>
                </div>
                <!-- Modal footer -->
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
    </div>
</c:if>
<%--Form add--%>


<div class="d-flex justify-content-center">
    <form action="/Facility?action=addFacility" method="post"
          class="bg-light text-success fw-bold w-50 shadow-lg p-5 mt-5">
        <div class="d-flex justify-content-center">
            <div>
                <div id="" class="form-text">Select facility to add</div>
                <select name="facilityTypeId" id="FacilityType"
                        class="border-success border-5 rounded-pill form-select-lg" onchange="displayInput()">
                    <option value="none">Select facility type</option>
                    <option value="1">Villa</option>
                    <option value="2">House</option>
                    <option value="3">Room</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" requiredplaceholder="Enter facility name" name="name" id="name"
                    value="${facility.facilityName}">
                    <p class="text-danger">${errorMap.get("name")}</p>
                </div>
                <div class="mb-3">
                    <label for="area" class="form-label">Area</label>
                    <input type="text" class="form-control" required id="area" placeholder="Enter Area" name="area" value="${facility.area}">
                    <p class="text-danger">${errorMap.get("area")}</p>
                </div>
                <div class="mb-3">
                    <label for="cost" class="form-label">Cost</label>
                    <input type="text" class="form-control" required id="cost" placeholder="Enter Cost" name="cost" value="${facility.cost}">
                    <p class="text-danger">${errorMap.get("cost")}</p>
                </div>
                <div class="mb-3">
                    <label for="maxPeople" class="form-label">Max people</label>
                    <input type="text" class="form-control" required id="maxPeople" placeholder="Enter Max people" value="${facility.maxPeople}"
                           name="maxPeople">
                    <p class="text-danger">${errorMap.get("maxPeople")}</p>
                </div>

                <p>Select Rent Type id</p>
                <select name="rentTypeId" id="rentTypeId" class="form-control border-success">
                    <c:forEach var="rentType" items="${rentTypeList}">
                        <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                    </c:forEach>
                </select>

            </div>
            <div class="col-md-6">
                <div style="display: none" id="divStandardRoom">
                    <div class="mb-3">
                        <label for="standardRoom" class="form-label">Standard room</label>
                        <input type="text" class="form-control" id="standardRoom" placeholder="Enter standard room" value="${facility.standardRoom}"
                               name="standardRoom">
                    </div>
                </div>

                <div style="display: none" id="divDescriptionOtherConvenience">
                    <div class="mb-3">
                        <label for="descriptionOtherConvenience" class="form-label">Description other
                            convenience</label>
                        <input type="text" class="form-control" id="descriptionOtherConvenience" value="${facility.descriptionOtherConvenience}"
                               placeholder="Enter description other convenience" name="descriptionOtherConvenience">
                    </div>
                </div>

                <div style="display: none" id="divPoolArea">
                    <div class="mb-3">
                        <label for="poolArea" class="form-label">Pool area</label>
                        <input type="text" class="form-control" required id="poolArea" placeholder="Enter pool area" value="${facility.poolArea}"
                               name="poolArea">
                        <p class="text-danger">${errorMap.get("poolArea")}</p>
                    </div>
                </div>

                <div style="display: none" id="divNumberOfFloor">
                    <div class="mb-3">
                        <label for="numberOfFloor" class="form-label">Number of floor</label>
                        <input type="text" class="form-control" required id="numberOfFloor" placeholder="Enter number of floor"
                               value="${facility.numberOfFloor}" name="numberOfFloor">
                        <p class="text-danger">${errorMap.get("numberOfFloor")}</p>
                    </div>
                </div>

                <div style="display: none" id="divFacilityFree">
                    <div class="mb-3">
                        <label for="facilityFree" class="form-label">facility free</label>
                        <input type="text" class="form-control" id="facilityFree" placeholder="Enter facility free"
                               value="${facility.facilityName}" name="facilityFree">
                    </div>
                </div>
            </div>
        </div>
        <div class="mt-5 d-flex justify-content-evenly">
            <button class="btn btn-success btn-lg" id="addBtn">ADD</button>
            <a class="btn btn-primary" href="/Facility">Return Facility List</a>
        </div>
    </form>
</div>
</div>
<script>
    window.onload = setStatusBtn(false);
    document.getElementById("resultMess").click();

    // function setStatusBtn(check) {
    //     // false => tắt ~ disable
    //     // true => bật ~ enable
    //     if (check) {
    //         document.getElementById("addBtn").disabled = false;
    //     } else {
    //         document.getElementById("addBtn").disabled = true;
    //     }
    // }

    function displayInput() {
        let facilityChoice = document.getElementById("FacilityType").value;
        console.log(facilityChoice);
        let divStandardRoom = document.getElementById("divStandardRoom");
        let divDescriptionOtherConvenience = document.getElementById("divDescriptionOtherConvenience");
        let divPoolArea = document.getElementById("divPoolArea");
        let divNumberOfFloor = document.getElementById("divNumberOfFloor");
        let divFacilityFree = document.getElementById("divFacilityFree");
        switch (facilityChoice) {
            case "none":
                divStandardRoom.style.display = "none";
                divDescriptionOtherConvenience.style.display = "none";
                divPoolArea.style.display = "none";
                divNumberOfFloor.style.display = "none";
                divFacilityFree.style.display = "none";
                // setStatusBtn(false)
                break
            case "1":
                //villa
                divStandardRoom.style.display = "block";
                divDescriptionOtherConvenience.style.display = "block";
                divPoolArea.style.display = "block";
                divNumberOfFloor.style.display = "block";
                divFacilityFree.style.display = "none";
                document.getElementById("FacilityFree").value="";
                // setStatusBtn(true);
                break
            case "2":
                //house
                divStandardRoom.style.display = "block";
                divDescriptionOtherConvenience.style.display = "block";
                divPoolArea.style.display = "none";
                document.getElementById("poolArea").value=0;
                divNumberOfFloor.style.display = "block";
                divNumberOfFloor.style.display = "block";
                divFacilityFree.style.display = "none";
                document.getElementById("facilityFree").value="";
                // setStatusBtn(true);
                break
            case "3":
                //room
                divStandardRoom.style.display = "none";
                document.getElementById("standardRoom").value="";
                divDescriptionOtherConvenience.style.display = "none";
                document.getElementById("descriptionOtherConvenience").value="";
                divPoolArea.style.display = "none";
                document.getElementById("poolArea").value=0;
                divNumberOfFloor.style.display = "none";
                document.getElementById("numberOfFloor").value=0;
                divFacilityFree.style.display = "block";
                // setStatusBtn(true);
                break
        }
    }
</script>

<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
