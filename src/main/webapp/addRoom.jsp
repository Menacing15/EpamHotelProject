<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<fmt:setBundle basename='<%=(String)request.getSession().getAttribute("bundle")%>'/>
<body>
<h1>Add room</h1>
<form action="<%=request.getContextPath()%>/home/rooms/add" method="post">
    <table>
        <tr>
            <td><fmt:message key = "number"/></td>
            <td><label>
                <input type="number" name="number" required/>
            </label></td>
        </tr>
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
            <td><fmt:message key = "price"/></td>
            <td><label>
                <input type="number" name="price" required/>
            </label></td>
        </tr>
        <tr>
            <td><fmt:message key = "status"/></td>
            <td><label>
                <select name="status" required>
                    <option>Available</option>
                    <option>Taken</option>
                </select>
            </label></td>
        </tr>
    </table>
    <br>
    <input type="submit" name="CREATE" value="Create room"/>
    <br>
    <span><%=(request.getSession().getAttribute("newRoom") == null) ? "" : request.getSession().getAttribute("newRoom")%></span>
    <br>
    <p><a href="${pageContext.request.contextPath}/home/rooms"><fmt:message key = "back.to.rooms.menu"/></a></p>
</form>
<%@ include file="loginlogout.jsp" %>
</body>
</html>
