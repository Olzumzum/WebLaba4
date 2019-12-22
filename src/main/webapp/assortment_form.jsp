<%@ page import="java.util.ArrayList" %>
<%@ page import="com.olzumzum.weblab4.server.model.DAO.AssortmentList" %>
<%@ page import="com.olzumzum.weblab4.server.model.entities.ItemAssortment" %>
<%--
  Created by IntelliJ IDEA.
  User: palm
  Date: 19.11.2019
  Time: 18:30
    Создан для отображения списка ассортимента продукции
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/assortment.css">

    <title>Title</title>
</head>
<body>

<!--Подменю -->
<div>
    <label id="title_assort" class="title_submenu" onclick="getSearchResults(
        document.getElementById('title_assort').innerHTML)">Ассортимент</label>

    <ul><%
        AssortmentList assortmentList = new AssortmentList("AssortmentCake");
        String[] assortmentName = new String[assortmentList.getList().size()];
        int i = 0;
        for (ItemAssortment item : (ArrayList<ItemAssortment>) assortmentList.getList()) {
            assortmentName[i] = item.getNameAssortment();
    %>

        <li id="submenu" class="subparagraph_submenu">
            <label id="assName" onclick="getSearchResults('<%= item.getNameAssortment() %>')" class="submenu_item">
                <%= item.getNameAssortment() %>
            </label>
        </li>
        <%
            }
        %>
    </ul>
</div>

<script type="text/javascript" src="js/searchList.js"></script>
</body>
</html>
