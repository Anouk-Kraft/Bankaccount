/**
 * view-controller for login.html
 *
 * M133: Bookshelf
 *
 * @author Marcel Suter
 */

/**
 * register listeners
 */

$(document).ready(function (){

    /**
     * listener for submitting the form sends the login dara to the web service
     */
    $("#loginForm").submit(sendLogin);
    /**
     * listender for button [Abmelden]
     */

});


function sendLogin(form){
    form.preventDefault();
    $
        .ajax({
            utl: "./resource/user/login",
            dataType: "text",
            type: "POST",
            data: $("#loginForm").serialize()
        })
        .done(function (){
            window.location.href = "./bookshelf.html";

        })
        .fail(function (xhr, status, errorThrown){
            if(xhr.status == 404){
                $("#message").text("Benutzername/Passwort unbekannt")
            } else {
                $("#message").text("Es ist ein Fehler aufgetreten")
            }
        })
}

/**
 * sends the logoff-request
 */
function sendLogoff(){

}
