$('#joinBtn').click(function () {
    var email = $('#inputEmail').val();
    var pass = $('#inputPassword').val();

    if (email && pass) {
        $.ajax({
            method: "POST",
            url: "/join",
            data: {email: email, pass: pass}
        })
            .done(function (str) {
                alert(str);
            });
    }
});
