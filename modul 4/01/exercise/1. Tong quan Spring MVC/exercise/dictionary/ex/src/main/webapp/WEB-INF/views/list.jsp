<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Translate</h2>
<form action="/translate">
<label>ENG:</label>
<input type="text" name="eng" value="${eng}">
<label>VIE:</label>
<input type="text" name="vie" value="${vie}">
<input type="submit" value="translate">
</form>

</body>
</html>