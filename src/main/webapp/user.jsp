<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
</head>
<body>
<h2>Please choose most convenient option for booking the room.</h2>
<p><a href="${pageContext.request.contextPath}/rooms">Choose room independently</a>
    <br>
    <a href="${pageContext.request.contextPath}/order">Leave order</a>
</p>
</body>
<%@ include file="logout.jsp" %>
</html>
