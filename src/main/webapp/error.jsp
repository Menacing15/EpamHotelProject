<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Error :(</title>
    <link rel="stylesheet" href= "${pageContext.request.contextPath}/css/error.css"/>
</head>
<body>
<p>Something went wrong...</p>
<p><%=(request.getAttribute("error") == null) ? "" : request.getAttribute("error")%></p>
<p><a href = "${pageContext.request.contextPath}/home">Back</a></p>
</body>
<%@ include file="logout.jsp" %>
</html>
