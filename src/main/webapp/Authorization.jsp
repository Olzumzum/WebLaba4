<%--
  Created by IntelliJ IDEA.
  User: palm
  Date: 12.11.2019
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<jsp:include page="mainMenu.html" flush="true"/>

<section class="information_persan">
    <h1> Добро пожаловать !</h1>
    <!-- Заполнение JSP bean -->
    <jsp:useBean id="user" class="com.olzumzum.weblab4.server.model.entities.User" scope="session"/>
    <%
        String emailUser = request.getParameter("email");
        String passwordUser = request.getParameter("password");
    %>
    <jsp:setProperty name="user" property="emailUser" value="<%= emailUser%>"/>
    <jsp:setProperty name="user" property="passwordUser" value="<%= passwordUser%>"/>

    <!-- Вывод данных пользователя -->
    <h3> Ваш email: </h3>
    <jsp:getProperty name="user" property="emailUser"/>
</section>

<div class="shopping_list">

</div>

</body>
</html>
