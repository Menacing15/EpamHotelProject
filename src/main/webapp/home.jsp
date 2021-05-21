<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
</head>
<body>
<h2>Please choose most convenient option for booking the room.</h2>
<p>
    <a href="${pageContext.request.contextPath}/home/rooms/choose" style="color: bisque">Choose room independently</a>
    <br>
    <a href="${pageContext.request.contextPath}/home/orders" style="color: bisque">Leave order</a>
</p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
