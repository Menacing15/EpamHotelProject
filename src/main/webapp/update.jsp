<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>
<h2>Update room <%=request.getSession().getAttribute("edited")%></h2>
<p><a href = "${pageContext.request.contextPath}/home/rooms">Back to rooms</a></p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
