<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 9/29/2022
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<div class="row mx-0 py-xl-5" style="height: 90%;margin-top: 0px">
    <div class="col-md-3 col-lg-2 min-vh-100 p-0 m-0">
        <%@ include file="side-bar.jsp" %>
    </div>
    <div class="col-md-9 col-lg-10 min-vh-100 vh-100 navbar-nav-scroll" style="margin-top: 10px">
        <a href="/student">Quản lý sinh viên</a>
    </div>

</div>
<%@ include file="footer.jsp" %>