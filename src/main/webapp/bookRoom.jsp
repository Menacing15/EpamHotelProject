<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book room</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>
<h2>Please give us a little bit more information</h2>
<form action="<%=request.getContextPath()%>/home/book" method="post">
    <label for="arrival">Arrival date</label>
    <input type="date" id="arrival" name="arrival" required>
    <input type="submit" value = "Submit">
</form>
<br>
<form action="<%=request.getContextPath()%>/home/book" method="post">
    <label for="departure">Departure day</label>
    <input type="date" id="departure" name="departure" required>
    <input type="submit" value = "Submit">
</form>
<p><a href = "${pageContext.request.contextPath}/home">Back to homepage</a></p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
