<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.04.2023
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="Header.jsp"/>
        <h1>Greetings!</h1>
    <div style="border:10px ridge blueviolet;padding: 15px;width: 300px">
        <p>Name: ${Login}</p>
        <p>Role: ${Role}</p>
        <p>Date: ${Date}</p>
    </div>
    <p>
        <a href='<c:url value="/Servlet-Create" />'>Create new</a>
    </p>
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Server</th>
        </tr>
        <c:forEach var ="user" items ="${usersFromDb}">
            <tr>
                <td>${user.getName()}</td>
                <td>${user.getSurname()}</td>
                <td>${user.getServer()}</td>
                <td>
                    <a href='<c:url value="/Servlet-Edit?id=${(user.getID()-1)}" />'>Edit</a>
                    <form method="post" action='<c:url value="/Delete-Servlet" />'>
                        <input type="hidden" name="id" value="${user.getID()-1}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
    <jsp:include page="Footer.jsp"/>
</body>
</html>
