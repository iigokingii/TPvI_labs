<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.04.2023
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="Header.jsp"/>
        <h1>Greetings!</h1>
        <p>Name: ${Login}</p>
        <p>Role: ${Role}</p>
        <p>Date: ${Date}</p>





    <jsp:include page="Footer.jsp"/>
</body>
</html>
