<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<c:choose>
    <c:when test='<%=request.getSession().getAttribute("bundle").equals("text")%>'>
        <a href=${pageContext.request.contextPath}/switchlang style="color: bisque;
        text-shadow: black;
        position: absolute;
        top: 1px;
        left: 1px;
        font-size: 20px;">RU</a>
    </c:when>
    <c:otherwise>
        <a href=${pageContext.request.contextPath}/switchlang style="color: bisque;
        text-shadow: black;
        position: absolute;
        top: 1px;
        left: 1px;
        font-size: 20px;">EN</a>
    </c:otherwise>
</c:choose>
</html>
