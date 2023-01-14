<%--
  Created by IntelliJ IDEA.
  User: Admint
  Date: 26/09/2022
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Product Discount Calculator App$</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<form action="/display-discount" method="post">
  <input type="text" name="mo_ta_san_pham" placeholder="nhap mo ta san pham">
  <input type="text" name="gia_niem_yet" placeholder="nhap gia niem yet">
  <input type="text" name="ti_le_chiet_khau" placeholder="nhap ti le chiet khau">
  <button  id="submid">Calculator</button>
</form>
</body>
</html>