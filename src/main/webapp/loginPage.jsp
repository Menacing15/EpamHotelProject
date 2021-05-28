<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
  <title>Epam Hotel</title>
  <link rel="stylesheet" href= "${pageContext.request.contextPath}/css/form.css"/>
</head>

<body>
  <h1>Welcome to our hotel!</h1>
  <form action="<%=request.getContextPath()%>/login" method="post">
    <table>
      <tr>
        <td>Login</td>
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
    <input type="submit" value="Login" />
    <br>
    <span><%=(request.getSession().getAttribute("logError") == null) ? "" : request.getSession().getAttribute("logError")%></span>
  </form>
  <br>
  <p><a href = "${pageContext.request.contextPath}/register">I am new customer</a></p>
  <p><a href = "${pageContext.request.contextPath}/home">Be a guest for now</a></p>
</body>
</html>