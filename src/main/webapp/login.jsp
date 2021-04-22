<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<style>
  body {
    text-align: center;
    color: bisque;
    background-image: url(image/bg.jpg);
    font-family: HelveticaNeueCyr, cursive;
  }
  h1 {
    text-shadow: 4px 4px 2px black;
    font-size: 84px;
  }
  form {
    display: inline-block;
  }

  table {
    font-size: 24px;
    text-shadow: 2px 2px 1px black;
  }
  input {
    font-size: 24px;
  }
</style>

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
</body>
</html>