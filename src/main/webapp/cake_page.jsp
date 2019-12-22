<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!--
Страница продукции пирожных и тортов
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <!-- connect JQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!-- connect JQuery ui -->
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
          type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/main_menu.css">

    <script type="text/javascript" src="js/loaderMenu.js"></script>
    <title> Tasty House </title>
</head>
<body>
<!-- Контейнер для главного меню -->
<div id="mainMenu"></div>

<%--
<!-- Загрузка данных о продукции из БД -->
<c:if test="${searchCriterion == null}">
<jsp:include page="/ProductShowServlet"/>
</c:if>
--%>

<!-- Поиск -->
<div class="search">
    <jsp:include page="search_form.jsp"/>
</div>


<div class="container">
    <!--Подменю -->
    <div class="submenu">
        <jsp:include page="assortment_form.jsp"/>
    </div>

    <!-- Ассортимент -->
    <div id="content" class="content">
        <h2 class="title_content">Торты и пирожные</h2>
        <c:set var="i" value="${0}"/>

        <%
            List list = (List) request.getAttribute("listCake");
            session.setAttribute("listProduct", list);
        %>
        <input id="list" type="hidden" value="${listProduct}">
        <jsp:include page="ItemProductTable.jsp"/>

    </div>
</div>


<!-- Контейнер для нижнего меню -->
<div id="footerMenu"></div>
<script type="text/javascript" src="js/searchList.js"></script>
</body>
</html>