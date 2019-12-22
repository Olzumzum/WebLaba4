$(document).ready(function () {
    /** Диалог о несовпадении паролей */
    $('#dialog').dialog({
        autoOpen: false
    });
    /** Диалог об успехе по жизни */
    $('#succsess_dialog').dialog({
        autoOpen: false
    });
    /** Диалог о непройденной капче */
    $('#capcha_dialog').dialog({
        autoOpen: false
    });

    /* успешное внесение изменений в запись */
    $('#succsess_save_dialog').dialog({
        autoOpen: false
    });
});