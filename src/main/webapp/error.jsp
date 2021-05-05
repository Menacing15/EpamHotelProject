<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%=(request.getAttribute("error") == null) ? "" : request.getAttribute("error")%>
</body>
</html>
