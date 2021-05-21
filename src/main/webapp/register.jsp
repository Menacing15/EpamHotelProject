<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href= "${pageContext.request.contextPath}/css/form.css" />
</head>
<body>
<h1>Hotel Registration</h1>
<form action="<%=request.getContextPath()%>/register" method="post">
    <table>
        <tr>
            <td>Email</td>
            <td><label>
                <input type="email" name="email" required/>
            </label></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><label>
                <input type="password" name="password" required/>
            </label></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Register" />
    <br>
    <span><%=(request.getSession().getAttribute("regError") == null) ? "" : request.getSession().getAttribute("regError")%></span>
</form>
<p><a href = "${pageContext.request.contextPath}/login">I already have an account</a></p>
</body>
</html>
