<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 8/25/2022
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang them moi</h1>

<a href="/student">Quay lại trang list</a>

<c:if test="${mess!=null}">
    <p style="color: red">${mess}</p>
</c:if>

<form action="/student?action=add" method="post">
<%--    <pre>ID:       <input type="text" name="id"/></pre>--%>
    <pre>Name:     <input type="text" name="name"> </pre>
    <pre>Gender :  <input type="radio" name="gender" value="true">Nam <input type="radio" value="false" name="gender"> Nữ </pre>
    <pre>Birthday: <input type="date" name="birthday"> </pre>
    <pre>Point:    <input type="number" name="point"> </pre>
    <c:if test="${map.get('point')!=null}">
        <span>${map.get('point')}</span>
    </c:if>
<%--    <pre>Account:  <input type="text" name="account"> </pre>--%>
    <pre>Email:    <input type="text" name="email"> </pre>
    <c:if test="${map.get('email')!=null}">
        <span>${map.get('email')}</span>
    </c:if>
    <pre>ClassId:  <select name="classId">
                   <option value="">Chọn lớp</option>
                   <c:forEach var="cls" items="${classList}">
                       <option value="${cls.id}">${cls.name}</option>
                   </c:forEach>
                    </select></pre>
    <pre>           <button>Save</button></pre>
</form>
</body>
</html>
