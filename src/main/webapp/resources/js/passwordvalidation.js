function checkPasswordMatch() {
    var password = $("#pass1").val();
    var confirmPassword = $("#pass2").val();

    if (password != confirmPassword)
        $("#checkPasswordMatch").html("Passwords do not match!");
    else
        $("#checkPasswordMatch").html("Passwords match.");
}

$(document).ready(function () {
   $("#pass2").keyup(checkPasswordMatch); 
});
