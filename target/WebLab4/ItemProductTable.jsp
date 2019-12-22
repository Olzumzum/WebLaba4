
<%--
  Created by IntelliJ IDEA.
  User: palm
  Date: 19.11.2019
  Time: 15:05
  Loading and displaying products in the form of blocks
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- connect JQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!-- connect JQuery ui -->
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
          type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/page_style.css">
    <title>Title</title>
</head>
<body>

<!-- Вывод таблицы продукции -->
<table id="productTable">
    <colgroup>
        <col id="product_name"/>
        <col id="product_description"/>
        <col id="weight"/>
        <col id="price"/>
    </colgroup>

    <thread>
        <tr>
            <th scope="col"> Название продукта</th>
            <th scope="col"> Описание продукта</th>
            <th scope="col"> Вес</th>
            <th scope="col"> Цена</th>
        </tr>
    </thread>

    <tbody>

    </tbody>
</table>
</body>
</html>
