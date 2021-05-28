<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
</head>
<body>
<h2>ADMIN PAGE</h2>
<p>
    <a href="${pageContext.request.contextPath}/home/rooms" style="color: bisque">Go to room's menu</a>
    <br>
    <a href="${pageContext.request.contextPath}/home/book" style="color: bisque">Go to customer's orders</a>
</p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
