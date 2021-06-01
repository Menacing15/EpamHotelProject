<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Book room</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<fmt:setBundle basename='<%=(String)request.getSession().getAttribute("bundle")%>'/>
<body>
<h2><fmt:message key = "inf.request"/></h2>
<form action="<%=request.getContextPath()%>/home/book" method="post">
    <label for="arrival">Arrival date</label>
    <input type="date" id="arrival" name="arrival" required>
    <input type="submit" value="Submit">
</form>
<br>
<form action="<%=request.getContextPath()%>/home/book" method="post">
    <label for="departure">Departure day</label>
    <input type="date" id="departure" name="departure" required>
    <input type="submit" value="Submit">
</form>
<p><a href="${pageContext.request.contextPath}/home"><fmt:message key = "back.to.menu"/></a></p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
