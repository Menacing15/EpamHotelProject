<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
</head>
<fmt:setBundle basename='<%=(String)request.getSession().getAttribute("bundle")%>'/>
<body>
<h2><fmt:message key = "admin.page"/></h2>
<p>
    <a href="${pageContext.request.contextPath}/home/rooms" style="color: bisque"><fmt:message key = "goto.rooms.menu"/></a>
    <br>
    <a href="${pageContext.request.contextPath}/home/book" style="color: bisque"><fmt:message key = "goto.customer.orders"/></a>
</p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
