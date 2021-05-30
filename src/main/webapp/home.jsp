<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
</head>
<fmt:setBundle basename="text"/>
<body>
<h2><fmt:message key = "home.header"/></h2>
<p>
    <a href="${pageContext.request.contextPath}/home/rooms/table" style="color: bisque">Rooms</a>
    <br>
    <a href="${pageContext.request.contextPath}/home/book" style="color: bisque">Leave order</a>
</p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
