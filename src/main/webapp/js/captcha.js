/** Генерация случайных чисел в диапазоне от m до n */
function randomNumber(m, n) {
    m = parseInt(m);
    n = parseInt(n);
    return Math.floor(Math.random() * (n - m + 1)) + m;
};

/**
 * Отображение контрольной суммы,
 * ее вычисление и занесение в элемент с индексом 'md5'
 */
function showExpression() {
    var aspmA = randomNumber(1, 23);
    var aspmB = randomNumber(1, 23);
    var sumAB = aspmA + aspmB;

    /**Отображение пользователю чисел */
    document.getElementById('aspm').innerHTML = aspmA + ' + ' + aspmB + ' = ';
    console.log(document.getElementById('aspm'));
    /**Присвоение скрытому полю контрольной суммы */
    document.getElementById('md5').value = MD5(sumAB);
    var checkSummAB = document.getElementById('md5').value = MD5(sumAB);
    console.log(document.getElementById('md5').value);
};

/** Функция проверки введенного пользователем значения
 * и контрольного (вычисленого в showExpression
 * @param checkSummAB
 * @param userSummAB
 * @returns {boolean}
 */
function checkCaptcha(checkSummAB, userSummAB) {
    userSummAB = MD5(userSummAB);

    if(checkSummAB == userSummAB)
        return true;
    else false;
}
