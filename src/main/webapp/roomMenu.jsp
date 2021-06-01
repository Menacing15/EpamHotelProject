<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Rooms</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
</head>
<fmt:setBundle basename='<%=(String)request.getSession().getAttribute("bundle")%>'/>
<body>
<h2><fmt:message key = "admin.header"/></h2>
<a href="${pageContext.request.contextPath}/home/rooms/table" style="color: bisque"><fmt:message key = "home.rooms"/></a>
<br>
<a href="${pageContext.request.contextPath}/home/rooms/add" style="color: bisque"><fmt:message key = "add.room"/></a>
<br>
<br>
<a href="${pageContext.request.contextPath}/home" style="color: bisque"><fmt:message key = "back.to.menu"/></a>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
