<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Account</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>
<h1>Hotel Registration</h1>
<form action="<%=request.getContextPath()%>/register" method="post">
    <table>
        <tr>
            <td>Email</td>
            <td><label>
                <input type="text" name="email"/>
            </label></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><label>
                <input type="password" name="password"/>
            </label></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Register" />
</form>
<p><a href = "${pageContext.request.contextPath}/login">I already have an account</a></p>
</body>
</html>
