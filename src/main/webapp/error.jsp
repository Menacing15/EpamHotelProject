<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>Error :(</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css"/>
</head>
<fmt:setBundle basename='<%=(String)request.getSession().getAttribute("bundle")%>'/>
<body>
<p><fmt:message key = "error"/></p>
<p><%=(request.getAttribute("javax.servlet.error.exception") == null) ? "" : request.getAttribute("javax.servlet.error.exception")%>
</p>
<p><%=(request.getAttribute("javax.servlet.error.status_code") == null) ? "" : request.getAttribute("javax.servlet.error.status_code")%>
</p>
<p><%=(request.getAttribute("error") == null) ? "" : request.getAttribute("error")%>
</p>
<p><a href="${pageContext.request.contextPath}/home"><fmt:message key = "back.to.menu"/></a></p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
