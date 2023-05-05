<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--    <a href="hello-servlet">Hello Servlet</a>--%>
<%--    <form action="Demo-servlet">--%>
<%--        <input type="submit" value="Execute Task1 lab9">--%>
<%--    </form>--%>
    <jsp:include page="/Header.jsp"/>
        <h1>Lab9-10</h1>
        <a href="Demo-servlet">Task2</a>
        <br/>
        <a href="lab10.jsp">Task3</a>
        <br/>
        <a href="Servlet-Cookie">Task4</a>
        <br/>
        <a href="FFirst-Servlet">Task6</a>
        <br/>
        <a href="PFirstServlet">Task6a</a>
        <br/>
        <a href="FOFirstServlet">Task6b</a>
        <br/>
        <a href="RFirstServlet">Task6c</a>
        <br/>
        <a href="GFirstServlet">Task7</a>
    <jsp:include page="/Footer.jsp"/>
</body>
</html>