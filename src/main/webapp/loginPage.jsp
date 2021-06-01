<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Epam Hotel</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<fmt:setBundle basename='<%=(String)request.getSession().getAttribute("bundle")%>'/>
<%@ include file="switchlang.jsp" %>
<body>
<h1><fmt:message key = "welcome"/></h1>
<form action="<%=request.getContextPath()%>/login" method="post">
    <table>
        <tr>
            <td><fmt:message key = "login.input"/></td>
            <td><label>
                <input type="email" name="email" required/>
            </label></td>
        </tr>
        <tr>
            <td><fmt:message key = "password.input"/></td>
            <td><label>
                <input type="password" name="password" required/>
            </label></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Login"/>
    <br>
    <span><%=(request.getSession().getAttribute("logError") == null) ? "" : request.getSession().getAttribute("logError")%></span>
</form>
<br>
<p><a href="${pageContext.request.contextPath}/register"><fmt:message key = "new.customer"/></a></p>
<p><a href="${pageContext.request.contextPath}/home"><fmt:message key = "be.guest"/></a></p>
</body>
</html>