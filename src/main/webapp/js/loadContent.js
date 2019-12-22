$(document).ready(function () {
    jQuery.ajax({
        type: 'POST',
        url: 'ProductShowServlet',
        respons: 'xml',
        success: function (html) {
            console.log("Успешно");
            $('#content').html(html);
        }
    });
})