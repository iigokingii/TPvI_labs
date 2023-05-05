<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.04.2023
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><%= "Sign up" %></h2>
<form action="Register-Servlet">
    Login <input type="text" name="Login"/> <br/> <br/>
    Password <input type="text" name="Password"/> <br/> <br/>
    <input type="submit" value="Зарегистрироваться"/>
</form>
<%if(request.getParameter("error")!=null && request.getParameter("error").equals("true")){%>
<p style="color:red">Ошибка регистрации.</p>
<%}%>
</body>
</html>
