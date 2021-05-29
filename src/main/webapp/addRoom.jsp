<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css"/>
</head>
<body>
<h1>Add room</h1>
<form action="<%=request.getContextPath()%>/home/rooms/add" method="post">
    <table>
        <tr>
            <td>Number</td>
            <td><label>
                <input type="number" name="number" required/>
            </label></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><label>
                <select name="type" required>
                    <option>Budget</option>
                    <option>Decent</option>
                    <option>Premium</option>
                </select>
            </label></td>
        </tr>
        <tr>
            <td>Size</td>
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
            <td>Price</td>
            <td><label>
                <input type="number" name="price" required/>
            </label></td>
        </tr>
        <tr>
            <td>Status</td>
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
    <p><a href="${pageContext.request.contextPath}/home/rooms">Back to rooms menu</a></p>
</form>
<%@ include file="loginlogout.jsp" %>
</body>
</html>
