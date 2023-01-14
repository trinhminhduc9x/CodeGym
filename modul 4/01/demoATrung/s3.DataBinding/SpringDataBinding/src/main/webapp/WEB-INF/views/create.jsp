<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admint
  Date: 17/10/2022
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="student" action="/student/create" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td>
                <form:input path="id"/>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <form:radiobutton path="gender" value="1" label="Male"></form:radiobutton>
                <form:radiobutton path="gender" value="0" label="Femal"></form:radiobutton>
                <form:radiobutton path="gender" value="3" label="LGBT"></form:radiobutton>
            </td>
        </tr>
        <tr>
            <td>
                Languages
            </td>
            <td>
                <form:checkboxes path="languages" items="${languageList}"></form:checkboxes>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Create</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
