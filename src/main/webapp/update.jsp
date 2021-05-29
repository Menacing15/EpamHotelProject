<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>
<h2>Update room <%=request.getSession().getAttribute("edited")%>
</h2>
<form action="<%=request.getContextPath()%>/home/rooms/table/update" method="post">
    <table>
        <tr>
            <td>Type</td>
            <td><label>
                <select name="type" required>
                    <option selected="selected"><%=request.getAttribute("type")%>
                    </option>
                    <option>Budget</option>
                    <option>Decent</option>
                    <option>Premium</option>
                </select>
            </label></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><label>
                <input type="number" name="price" value="<%=request.getAttribute("price")%>" required/>
            </label></td>
        </tr>
        <tr>
            <td>Status</td>
            <td><label>
                <select name="status" required>
                    <option selected="selected"><%=request.getAttribute("status")%>
                    </option>
                    <option>Available</option>
                    <option>Taken</option>
                </select>
            </label></td>
        </tr>
    </table>
    <br>
    <input type="hidden" name="number" value="<%=request.getAttribute("number")%>"/>
    <input type="submit" name="UPDATE" value="Update"/>
    <br>
    <p><a href="${pageContext.request.contextPath}/home/rooms/table">Back to table</a></p>
</form>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
