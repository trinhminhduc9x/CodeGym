<%--
  Created by IntelliJ IDEA.
  User: Admint
  Date: 29/09/2022
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach khach hang</h1>
<table border="1" >
    <tr>
        <th>stt</th>
        <th>ten</th>
        <th>ngay sinh</th>
        <th>gioi tinh</th>
    </tr>
    <c:forEach var = "customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${customer.getId()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getBrithday()}</td>
            <td>${customer.getAddress()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
