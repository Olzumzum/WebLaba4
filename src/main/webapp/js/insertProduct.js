/**
 * проверка вводимых данных при добавлении продукции
 * @param form
 */
function verificationEnteredData(form) {

    var weightProduct = parseFloat(form.productWeight.value);
    var priceProduct = parseFloat(form.productPrice.value);

    /** проверка на тип вводимых данных
     * если у полей стоимость и цена тип - не числовой, бд будет плакать (наверное)
     */
    if (typeof weightProduct == "number" && !isNaN(weightProduct))
        console.log("Тип поля 'вес' - цифра - все верно");
    else {
        console.log("Ошибка ввода поля 'вес' ");
        $("#succsess_dialog").dialog("open");
    }

    if (typeof priceProduct == "number" && !isNaN(priceProduct))
        console.log("Тип поля 'цена' - цифра - все верно");
    else {
        console.log("Ошибка ввода поля 'цена'");
        $("#succsess_dialog").dialog("open");
    }

    var succsessStatus = request.getAttribute("succsessStatusConservation");
  //  if (succsessStatus)
       // $("#succsess_save_dialog").dialog("open");
}