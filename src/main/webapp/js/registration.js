/**
 * Регистрация
 * @param form
 */
function registration(form) {
    /**адрес для перехода по ссылке в случае успешного завершения действия */
    const url = "authorization.html";

    /** Объявление полей */
    var userEmail = form.email.value;
    var userPassword = form.password.value;
    var userRepeatPassword = form.repeat_password.value;

    console.log("email: " + userEmail + ", password: " + userPassword + ", repeat_password: " + userRepeatPassword);

    /** Получаем введенную сумму и вычисленую */
    var checkSummAB = document.getElementById('md5').value;
    var userSummAB = document.getElementById('userSummAB').value;


    if (userEmail.length != 0 && userPassword.length != 0 && userRepeatPassword.length != 0 && userSummAB.length != 0) {

        /** проверка совпадения паролей */
        if (userPassword != userRepeatPassword) {
            $('#dialog').dialog("open");
        } else {

            /** Проверить введенную капчу */

            /** Проверяем на равенство */
            if (!checkCaptcha(checkSummAB, userSummAB)) {
                /** Если сумма не совпала */
                $('#capcha_dialog').dialog("open");
            }

            /** Если сумма введена правильно */
            else {
                /** Отправляем данные пользователя на сервер */
                var dataUser = JSON.stringify([userEmail, userPassword]);
                sendData(dataUser);

                /** Выводим сообщение о успешной регистрации и переходим к странице авторизации */
                $('#succsess_dialog').dialog({
                    beforeClose: function () {
                        document.location.href = url;
                    }
                });
                $('#succsess_dialog').dialog("open");
            }
        }
    }
}

/**
 * Отправка данных на сервер
 */
function sendData(user) {
}
