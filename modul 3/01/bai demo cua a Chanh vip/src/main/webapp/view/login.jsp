<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<div class="row mx-0 py-xl-5" style="height: 90%;margin-top: 0px">
<%--    side bar--%>
    <div class="col-md-3 col-lg-2 min-vh-100 p-0 m-0">
        <%@ include file="side-bar.jsp" %>
    </div>
<%--    content--%>
    <div class="col-md-9 col-lg-10 min-vh-100 vh-100 navbar-nav-scroll" style="margin-top: 10px">
        <div style="width: 300px;height: 400px;margin-left: 200px">
            <h3 style="margin-left: 50px">Đăng nhập</h3>
            <form action="/login" method="post">
                <p>${mess}</p>
                <div class="form-group my-2">
                    <label for="exampleInputEmail1">Tên đăng nhập</label>
                    <input type="text" name="username" value="${username}" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
                </div>
                <div class="form-group my-2">
                    <label for="exampleInputPassword1">Mật khẩu </label>
                    <input type="password" name="password" value="${password}" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="form-group form-check my-3">
                    <input type="checkbox" name="rememberMe" value="1" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Ghi nhớ mật khẩu</label>
                </div>
                <div style="margin-left: 100px;margin-top: 10px">
                    <button type="submit" class="btn btn-outline-primary" style="background-color:#7952b3 ">Đăng nhập</button>
                </div>

            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
