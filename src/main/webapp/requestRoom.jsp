<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request for room</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>
<h2>Please fill up the request form</h2>
<form action="<%=request.getContextPath()%>/home/book" method="post">
    <table>
        <tr>
            <td>Category</td>
            <td><label>
                <select  name = "type" required>
                    <option>Budget</option>
                    <option>Decent</option>
                    <option>Premium</option>
                </select>
            </label></td>
        </tr>
        <tr>
            <td>Size</td>
            <td><label>
                <select  name = "size" required>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
            </label></td>
        </tr>
        <tr>
            <td>Arrival date</td>
            <td><label>
                <input type="date" name="arrival" required>
            </label>
            </td>
        </tr>
        <tr>
            <td>Departure date</td>
            <td><label>
                <input type="date" name="departure" required>
            </label>
            </td>
        </tr>
    </table>
    <input type="submit" value="Request" />
</form>
<p><a href = "${pageContext.request.contextPath}/home">Back to homepage</a></p>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
