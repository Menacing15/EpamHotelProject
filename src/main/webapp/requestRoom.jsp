<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Request for room</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<fmt:setBundle basename='<%=(String)request.getSession().getAttribute("bundle")%>'/>
<%@ include file="switchlang.jsp" %>
<body>
<h2><fmt:message key = "request.header"/></h2>
<form action="<%=request.getContextPath()%>/home/book" method="post">
    <table>
        <tr>
            <td><fmt:message key = "category"/></td>
            <td><label>
                <select name="type" required>
                    <option>Budget</option>
                    <option>Decent</option>
                    <option>Premium</option>
                </select>
            </label></td>
        </tr>
        <tr>
            <td><fmt:message key = "size"/></td>
            <td><label>
                <select name="size" required>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
            </label></td>
        </tr>
        <tr>
            <td><fmt:message key = "arrival.date"/></td>
            <td><label>
                <input type="date" name="arrival" required>
            </label>
            </td>
        </tr>
        <tr>
            <td><fmt:message key = "departure.date"/></td>
            <td><label>
                <input type="date" name="departure" required>
            </label>
            </td>
        </tr>
    </table>
    <input type="submit" value="Request"/>
</form>
<p><a href="${pageContext.request.contextPath}/home"><fmt:message key = "back.to.menu"/></a></p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
