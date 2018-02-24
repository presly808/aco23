$(document).ready(function () {

    $('#register').click(function () {
        $('#mainDiv').load("join.html #joinDiv");
        $('#header').find('> h1').text('Sign Up');
        $.getScript("join.js");
    });

    $('#loginBtn').click(function () {
        var email = $('#inputEmail').val();
        var pass = $('#inputPassword').val();

        if (email && pass) {
            $.ajax({
                method: "POST",
                url: "/login",
                data: {email: email, pass: pass}
            })
                .done(function (str) {
                    alert(str);
                });
        }
    });
});