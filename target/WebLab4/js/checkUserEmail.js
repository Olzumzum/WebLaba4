function checkUserEmail() {
    const emailUser = document.getElementById("email").value;
    console.log("Полученный эмайл" + emailUser);

    var data = "emailU=" + encodeURIComponent(emailUser);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "CheckUserEmailServlet");

    xhr.onreadystatechange = function () {
        if(xhr.readyState === 4 && xhr.status === 200){
            var answerServer = xhr.responseText;
            if(!answerServer.localeCompare("Пользователь существует")){
                document.getElementById("message_of_email_valid").style.visibility = "visible";
            } else
                document.getElementById("message_of_email_valid").style.visibility = "hidden";
        }
    };
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(data);

}