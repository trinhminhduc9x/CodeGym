<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convert">
    <label>Rate: </label><br/>
    <input type="number" name="rate" value="${rate}"/><br/>
    <label>USD: </label><br/>
    <input type="number" name="usd" value="${usd}"/><br/>
    <label>convert </label><br/>
    <input type="submit" value="convert"/><br/>
</form>

<label>VND:</label>
<input type="number" value="${vnd}">
</body>
</html>