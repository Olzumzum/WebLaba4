<!--
Часть html-страницы, отвечающая за поиск:
отображает поле ввода и кнопку
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/list_search.css">
    <title>Title</title>
</head>
<body>

<input id="searchfield"  name="searchfield" placeholder="Поиск"/>
<input id="search_button" type="submit" value="Поиск" onclick="getSearchResults(
    document.getElementById('searchfield').value)" />


<script type="text/javascript" src="js/searchList.js"></script>
</body>
</html>
