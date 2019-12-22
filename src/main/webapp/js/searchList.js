/**
 * Функция получает данные поля ввода критерия поиска
 * и отправляет запрос сервлету на получение списка данных
 */
function getSearchResults(element) {
    var data;

    /** очистить таблицу от старых результатов */
    cleanTable();

    /** получаем строковое значение критерия поиска */
    var criterion = element;
    console.log("Получено значение " + criterion);

    /** получаем значение поисковой строки */
    var searchCriterion = document.getElementById("searchfield").value;

    /** сравниваем полученное значение со значением в поисковой строке
     * и словом "Ассортимент" - ключевым словом для вывода всего списка
     */
    if (!criterion.localeCompare(searchCriterion)) {
        console.log("Ищем по критерию поиска");
        data = "searchCriterion=" + encodeURIComponent(criterion);
    } else {
        if (!criterion.localeCompare("Ассортимент")) {
            console.log("Выводим весь список");
            data = "assort=all";
        } else {
            console.log("Выводим по критерию ассортимента");
            data = "assort=" + encodeURIComponent(criterion);
        }
    }

    sendData(data);


    // xhr.onload = function () {
    //   //  document.getElementById("test_field").value = xhr.responseText;
    //     document.getElementById("searchfield").value = xhr.responseText;
    // };


}

/**
 * Отправка критерия поиска и получение данных о продукции
 * @param data
 */
function sendData(data) {
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "ProductShowServlet");
    //xhr.responseType = "text";

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("Success " + xhr.responseText);
            //document.getElementById("searchfield").value = xhr.responseText;
            getListIntoJson(xhr);
        }

    };

    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(data);

}

/**
 * преобразование полученного json
 * @param xhr
 */
function getListIntoJson(xhr) {
    let listCake = JSON.parse(xhr.responseText);
    console.log(listCake);


    for (let i = 0; i < listCake.length; i++) {
            $("#productTable").append(
                "<tr>"+
                "<td>" + listCake[i]["mProductName"] + "</td>" +
                "<td>" + listCake[i]["mProductDescription"] + "</td>" +
                "<td>" + listCake[i]["mWeight"] + "</td>" +
                "<td>" + listCake[i]["mPrice"] + "</td>" + "</tr>"

            );


    }
}

/**
 * очистка динамической таблицы от старых результатов
 */
function cleanTable() {
    for (; document.getElementById('productTable').getElementsByTagName('tr').length > 1;) {
        document.getElementById('productTable').deleteRow(1);
    }

}

