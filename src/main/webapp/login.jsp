<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
  <title>Login Account</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>

<body>
  <h1>Welcome to our hotel!</h1>
  <form action="<%=request.getContextPath()%>/login" method="post">
    <table>
      <tr>
        <td>Login</td>
        <td><label>
          <input type="text" name="login"/>
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
    <input type="submit" value="Login" />
  </form>
  <br>
  <p><a href = "${pageContext.request.contextPath}/register">I am new customer</a></p>
</body>
</html>