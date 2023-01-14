<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light mx-0 fixed-top" style="background-color:#7952b3;height: 8%">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <svg xmlns="http://www.w3.org/2000/svg"  viewBox="0 0 48 48" width="48px" height="48px"><path fill="#0883d9" d="M36.232,23.985c0-5.865,4.766-8.51,4.966-8.636c-2.596-3.993-6.79-4.467-8.362-4.468	c-3.643,0-6.863,2.022-8.585,2.022c-1.797,0-4.418-2.121-7.363-2.022c-3.843,0.075-7.363,2.346-9.334,5.691	c-1.397,2.396-1.947,5.217-1.896,8.087c0.002,0.113,0.017,0.228,0.02,0.341H36.32C36.279,24.671,36.243,24.337,36.232,23.985z"/><path fill="#0883d9" d="M30.565,7.063C32.261,5.191,33.21,2.621,33.06,0c-2.346,0-5.066,1.372-6.788,3.394	c-1.348,1.672-2.795,4.293-2.271,6.913C26.422,10.607,29.043,9.085,30.565,7.063z"/><path fill="#0370c8" d="M17.511,45c2.771,0,3.794-1.848,7.413-1.848c3.37,0,4.418,1.848,7.338,1.848	c3.07,0,5.092-2.795,6.913-5.567c2.295-3.218,3.07-6.288,3.169-6.414c-0.094,0-5.287-2.112-6.026-8.019H5.678	c0.157,5.311,2.228,10.79,4.671,14.309C12.27,42.055,14.441,45,17.511,45z"/></svg>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active text-white" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item text-white" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item text-white" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled text-white">Disabled</a>
                </li>
            </ul>
            <div class="d-flex align-items-center">
                <span class="text-white"><%=(session.getAttribute("user"))==null?"":((User)session.getAttribute("user")).getUsername() %></span>
                <span><%=(session.getAttribute("user"))==null?"<a href=\"/login\">Login</a>":"<a href=\"/logout\">Logout</a>"%></span>
            </div>

        </div>
    </div>
</nav>
