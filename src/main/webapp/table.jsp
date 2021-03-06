<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Edit Rooms</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/edit.css"/>
</head>
<body>
<fmt:setBundle basename='<%=(String)request.getSession().getAttribute("bundle")%>'/>
<%@ include file="switchlang.jsp" %>
<br>
<table>
    <tr>
        <c:forEach items="${columns}" var="column">
            <td>
                <form action="<%=request.getContextPath()%>/home/rooms/table" method="post">
                    <input type="hidden" name="ordered" value="${column}"/>
                    <input type="submit" name="ORDER" value="${column}"/>
                </form>
            </td>
        </c:forEach>
    </tr>
    <c:choose>
        <c:when test='<%=(request.getAttribute("table") != null)%>'>
            <c:forEach items="${table}" var="row">
                <tr>
                    <c:forEach items="${row}" var="element">
                        <td>${element}</td>
                    </c:forEach>

                    <td>
                        <form action="<%=request.getContextPath()%>/home/rooms/table" method="post">
                            <input type="hidden" name="chosen" value="${row}"/>
                            <input type="hidden" name="CHOOSE"/>
                            <input type="submit" value="<fmt:message key = "book"/>"/>
                        </form>
                    </td>

                    <c:choose>
                        <c:when test='<%=(request.getSession().getAttribute("role").equals("admin"))%>'>
                            <td>
                                <form action="<%=request.getContextPath()%>/home/rooms/table" method="post">
                                    <input type="hidden" name="deleted" value="${row}"/>
                                    <input type="hidden" name="REMOVE"/>
                                    <input type="image" src="${pageContext.request.contextPath}/images/trash.png"
                                           width="16" height="16" alt="submit"/>
                                </form>
                            </td>
                            <td>
                                <form action="<%=request.getContextPath()%>/home/rooms/table" method="post">
                                    <input type="hidden" name="edited" value="${row}"/>
                                    <input type="hidden" name="EDIT"/>
                                    <input type="submit" value="<fmt:message key = "edit"/>"/>
                                </form>
                            </td>
                        </c:when>
                    </c:choose>
                </tr>
            </c:forEach>
        </c:when>
    </c:choose>
</table>
<span><%=(request.getAttribute("bookError") == null) ? "" : request.getAttribute("bookError")%></span>
<c:choose>
    <c:when test='<%=(request.getSession().getAttribute("role").equals("admin"))%>'>
        <p><a href="${pageContext.request.contextPath}/home/rooms"><fmt:message key = "back.to.rooms.menu"/></a></p>
    </c:when>
    <c:otherwise>
        <p><a href="${pageContext.request.contextPath}/home"><fmt:message key = "back.to.menu"/></a></p>
    </c:otherwise>
</c:choose>
</body>
<%@ include file="loginlogout.jsp" %>
</html>
