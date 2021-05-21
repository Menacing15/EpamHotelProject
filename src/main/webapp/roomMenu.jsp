<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rooms</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
</head>
<body>
<a href="${pageContext.request.contextPath}/home/rooms/choose" style="color: bisque">Choose room independently</a>
<br>
<a href="${pageContext.request.contextPath}/home/rooms/add" style="color: bisque">Add room</a>
<br>
<a href="${pageContext.request.contextPath}/home/rooms/edit" style="color: bisque">Update room</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/home" style="color: bisque">Back to menu</a>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
