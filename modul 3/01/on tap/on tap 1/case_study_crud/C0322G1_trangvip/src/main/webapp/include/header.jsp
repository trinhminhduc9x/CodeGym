
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../style/bootstrap/normalize.css">
    <link rel="stylesheet" href="../style/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../style/datatables/css/dataTables.bootstrap4.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../style/style.css">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0"/>
</head>
<body>
<div class="row w-100">
    <div class="col-lg-3">
        <img style="width: 120px"
             src="https://cdn.nhanlucnganhluat.vn/uploads/images/051D288B/logo/2018-12/Logo-FURAMA-RESORT.jpg">
    </div>
    <div class="col-lg-5"></div>
    <div class="col-lg-4 d-flex text-center justify-content-center align-items-center">
        <div>
            <div class="row"><b>Nguyễn Thanh Thanh Trang</b></div>
            <div class="row"><b>C0422G1</b></div>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="navbar-brand dropdown-toggle" href="#" id="navbarEmployee" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Employee
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/employee">List Employee</a></li>
                    </ul>
                </li>  <li class="nav-item dropdown">
                    <a class="navbar-brand dropdown-toggle" href="#" id="navbarCustomer" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Customer
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/customer">List Customer</a></li>
                        <li><a class="dropdown-item" href="/customer?action=create"> Create Customer</a></li>

                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="navbar-brand dropdown-toggle" href="#" id="navbarService" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Facility
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/facility">List Facility</a></li>
                        <li><a class="dropdown-item" href="/facility?action=create"> Create Facility</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="navbar-brand dropdown-toggle" href="#" id="navbarContract" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Contract
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/contract">List Contract</a></li>
                        <li><a class="dropdown-item" href="/contract?action=create"> Create Contract</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-success"type="button" >Search</button>
            </form>
        </div>
    </div>
</nav>
</body>
</html>
