<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
    <title>Task2</title>
</head>
<body>
    <%--a)--%>
    <p><c:out value="${Mess}"/></p>
    <c:if test="${isVisible==true}">
        <p>Visible</p>
    </c:if>
    <c:choose>
        <c:when test="${val==1}">
            <p>Equals to 1</p>
        </c:when>
        <c:otherwise>
            <p>Dont equal to 1</p>
        </c:otherwise>
    </c:choose>
    <c:forEach var="user" items="${users}">
        <li><c:out value="${user}"/></li>
    </c:forEach>
    <c:set var="salary" scope="session" value="${100*200}"/>
    <c:out value="${salary}"/><br/>
    <c:remove var="salary" scope="session"/>
    <c:if test="${salary==null}">
        <c:out value="Removed"/>
    </c:if>

    <%--b)--%>

    <jsp:useBean id="now" class="java.util.Date"/>
    <fmt:setLocale value="en-EN"/>
    <p>Вывод даты в формате English<br/>Сегодня: <fmt:formatDate value="${now}"/></p>
    <fmt:setLocale value="ru-RU"/>

    <p>Вывод даты в формате Russian<br/>Сегодня: <fmt:formatDate value="${now}" /><br/></p>
    <p>Стиль времени: <br>
        (short): <fmt:formatDate value="${now}" type="time" timeStyle="short"/><br/>
        (medium): <fmt:formatDate value="${now}" type="time" timeStyle="medium"/><br/>
        (long): <fmt:formatDate value="${now}" type="time" timeStyle="long"/><br/>
    </p>
    <fmt:bundle basename="Task2.BundleTask2" prefix="count.">
        <fmt:message key="one"/><br/>
        <fmt:message key="second"/><br/>
        <fmt:message key="third"/><br/>
    </fmt:bundle>

    <%--c)--%>
    <sql:setDataSource var="db" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                       url="jdbc:sqlserver://GOKING;databaseName=LAB9_10_TPvI;trustServerCertificate=true;encrypt=false;IntegratedSecurity=false"
                       user="sa"
                       password="1111"/>
    <sql:query var="res" dataSource="${db}">
        SELECT * FROM USERS
    </sql:query>
    <c:forEach var="us" items="${res.rows}">
        <li><c:out value="${us.LOGIN}"/> <c:out value="${us.PASSWORD}"/> <c:out value="${us.ROLE}"/> </li>
    </c:forEach>

    <%--d)--%>

    <c:set var="web">
        <web>
            <name>Lab12</name>
            <time>3:40</time>
            <Year>2023</Year>
        </web>
    </c:set>
    <x:parse xml="${web}" var="out"/>
    <b>Web : </b>
    <x:out select="$out/web[1]/name"/><br/>
    <b>Time : </b>
    <x:out select="$out/web[1]/time"/><br/>
    <b>Year : </b>
    <x:out select="$out/web[1]/Year"/><br/>

    <%--e)--%>

    <c:set var="test" value="${fn:length(requestScope.Mess)}"/>
    <c:out value="${test}"/><br>
    <c:set var="testU" value="${fn:toUpperCase(requestScope.Mess)}"/>
    <c:out value="${testU}"/><br>
    <c:set var="testFT" value="${fn:substring(requestScope.Mess,4,10)}"/>
    <c:out value="${testFT}"/><br>
    <c:set var="testT" value="${fn:trim(requestScope.Mess)}"/>
    <c:if test="${fn:startsWith(requestScope.Mess,'<')}">
        <c:out value="${requestScope.Mess}"/><br>
    </c:if>




</body>
</html>
