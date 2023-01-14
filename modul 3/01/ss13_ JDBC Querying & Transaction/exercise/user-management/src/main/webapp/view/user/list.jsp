<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/1/2022
  Time: 3:24 PM
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
<h1 class="p-3 bg-primary text-center"><a class="text-white text-decoration-none" href="/User">LIST USER</a></h1>

<div class="container d-flex align-content-center justify-content-around">
    <div>
        <form action="/User?action=search" method="post">
            <input type="text" placeholder="Enter country" name="country">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
    <div>
        <a class="btn btn-outline-info" href="/User?action=add">Add user</a>
    </div>

    <c:if test="${message!=null}">
        <p>${message}</p>
    </c:if>

</div>

<a href="/User?action=test-with-tran1">Test Transaction</a>
<table class="table table-hover table-striped table-light">
    <thead>
    <tr>
        <th>Id</th>
        <th>
            Name
            <a href="/User?action=sort" class="btn btn-success" >
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-sort-alpha-down" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M10.082 5.629 9.664 7H8.598l1.789-5.332h1.234L13.402 7h-1.12l-.419-1.371h-1.781zm1.57-.785L11 2.687h-.047l-.652 2.157h1.351z"/>
                <path d="M12.96 14H9.028v-.691l2.579-3.72v-.054H9.098v-.867h3.785v.691l-2.567 3.72v.054h2.645V14zM4.5 2.5a.5.5 0 0 0-1 0v9.793l-1.146-1.147a.5.5 0 0 0-.708.708l2 1.999.007.007a.497.497 0 0 0 .7-.006l2-2a.5.5 0 0 0-.707-.708L4.5 12.293V2.5z"/>
            </svg>
            </a>

        </th>
        <th>Email</th>
        <th>Country</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <th><a class="btn btn-outline-warning" href="/User?action=update&id=${user.id}">Update</a></th>
            <th>
                <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#deleteModal${user.id}">
                    DELETE
                </button>
                <div class="modal" id="deleteModal${user.id}">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Delete User</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <div class="modal-body">
                                Delete User?
                            </div>
                            <div class="modal-footer">
                                <a class="btn btn-outline-danger" href="/User?action=delete&id=${user.id}">Delete</a>
                                <button type="button" class="btn btn-success" data-bs-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </th>
        </tr>
    </c:forEach>
</table>

<script src="bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
