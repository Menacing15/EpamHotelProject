<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
</head>
<body>
<h2>ADMIN PAGE</h2>
<p>
    <a href="${pageContext.request.contextPath}/home/rooms" style="color: bisque">Rooms</a>
    <br>
    <a href="${pageContext.request.contextPath}/home/orders" style="color: bisque">Orders</a>
</p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
