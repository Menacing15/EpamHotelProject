<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rooms</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"/>
</head>
<body>
<c:choose>
    <c:when test='<%=(request.getSession().getAttribute("role").equals("admin"))%>'>
        <a href = "${pageContext.request.contextPath}/form.jsp" >Add room</a>
        <br>
        <a href = "${pageContext.request.contextPath}/form.jsp" >Delete room</a>
        <br>
        <a href = "${pageContext.request.contextPath}/form.jsp" >Change room</a>
    </c:when>
    <c:otherwise>
        user rooms
    </c:otherwise>
</c:choose>
</body>
</html>
