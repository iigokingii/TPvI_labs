<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.05.2023
  Time: 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post">
        <label>Name</label><br>
        <input value="${student.getName()}" name="name"/><br><br>
        <label>Surname</label><br>
        <input value="${student.getSurname()}" name="surname"/><br><br>
        <label>Server</label><br>
        <input value="${student.getServer()}" name="server"/><br><br>
        <input type="submit" value="Save" />
    </form>



</body>
</html>
