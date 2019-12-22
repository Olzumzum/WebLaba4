/**
 *  Валидация
 **/
function valid(form) {

    /**адрес для перехода по ссылке в случае успешного завершения действия */
    const url = "../sheets/shopping_basket.html";

    /** Объявление переменных, присвоение значений,
     * полученных из формы*/
    var email = "";
    var password = "";
    email = form.email.value;
    password = form.password.value;

    if (email.length != 0 && password.length != 0) {
        /**Получение данных с сервера */
        /* const json = getData();
         const object = JSON.parse(json);
         var userEmail = object["email"];
         var userPassword = object["password"];

         /* Здесь проверяем полученные данные */
        // if (email != userEmail || password != userPassword) {
        //console.log("negative");
        //$("#dialog").dialog("open");
        // }
    }
};

