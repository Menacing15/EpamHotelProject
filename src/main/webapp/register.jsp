<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<fmt:setBundle basename='<%=(String)request.getSession().getAttribute("bundle")%>'/>
<%@ include file="switchlang.jsp" %>
<body>
<h1><fmt:message key = "reg.header"/></h1>
<form action="<%=request.getContextPath()%>/register" method="post">
    <table>
        <tr>
            <td><fmt:message key = "email"/></td>
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
    <input type="submit" value="Register"/>
    <br>
    <span><%=(request.getSession().getAttribute("regError") == null) ? "" : request.getSession().getAttribute("regError")%></span>
</form>
<p><a href="${pageContext.request.contextPath}/login"><fmt:message key = "alr.have.acc"/></a></p>
</body>
</html>
