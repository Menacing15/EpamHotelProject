<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
</head>
<%@ include file="switchlang.jsp" %>
<fmt:setBundle basename='<%=(String)request.getSession().getAttribute("bundle")%>'/>
<body>
<h2><fmt:message key = "home.header"/></h2>
<p>
    <a href="${pageContext.request.contextPath}/home/rooms/table" style="color: bisque; text-shadow: black 3px 3px 3px"><fmt:message key = "home.rooms"/></a>
    <br>
    <a href="${pageContext.request.contextPath}/home/book" style="color: bisque; text-shadow: black 2px 2px 2px"><fmt:message key = "home.order"/></a>
</p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
