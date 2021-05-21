<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
    form {
        display: inline-block;
    }
</style>
<head>
    <title>Edit Rooms</title>
</head>
<body>
<table>
    <tr>
        <c:forEach items="${columns}" var="column">
            <td>${column}</td>
        </c:forEach>
    </tr>
    <c:choose>
        <c:when test='<%=(request.getAttribute("table") != null)%>'>
            <c:forEach items="${table}" var="row">
                <tr>
                    <c:forEach items="${row}" var="element">
                        <td>${element}</td>
                    </c:forEach>
                    <td><form action="<%=request.getContextPath()%>/home/rooms/edit" method="post">
                        <input type="hidden" name="deleted" value="${row}"/>
                        <input type="hidden" name="REMOVE"/>
                        <input type="image" src="${pageContext.request.contextPath}/images/trash.jpg"
                               width="16" height="16" alt="submit"/>
                    </form></td>
                </tr>
            </c:forEach>
        </c:when>
    </c:choose>
</table>
<p><a href = "${pageContext.request.contextPath}/home/rooms">Back to rooms</a></p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
