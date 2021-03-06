<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test='<%=request.getSession().getAttribute("role").equals("guest")%>'>
        <a href=${pageContext.request.contextPath}/login style="color: bisque;
        text-shadow: black;
        position: absolute;
        top: 1px;
        right: 1px;
        font-size: 20px;"><fmt:message key = "login"/></a>
    </c:when>
    <c:otherwise>
        <a href=${pageContext.request.contextPath}/logout style="color: bisque;
        text-shadow: black;
        position: absolute;
        top: 1px;
        right: 1px;
        font-size: 20px;"><fmt:message key = "logout"/></a>
    </c:otherwise>
</c:choose>
</body>
</html>
