<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
</style>
<head>
    <title>Edit Rooms</title>
</head>
<body>
<table>
    <c:forEach items="${table}" var="row">
        <tr>
            <c:forEach items="${row}" var="element">
                <td>${element}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
<p><a href = "${pageContext.request.contextPath}/home/rooms">Back to rooms</a></p>
</body>
<%@ include file="logout.jsp" %>
</html>
