$('#joinHref').click(function () {
    $('#loginDiv').hide();
    $('#joinDiv').show();
    $('#header').find('> h1').text('Sign Up');
});

$('#loginBtn').click(function () {
    var email = $('#loginInputEmail').val();
    var pass = $('#loginInputPassword').val();

    if (email && pass) {
        $.ajax({
            method: "POST",
            url: "/login",
            data: JSON.stringify({email: email, pass: pass})
        })
            .done(function (data) {
                key = data;
                alert(key);
                $('#loginDiv').hide();
                $('#tableDiv').show();
                $('#header').find('> h1').text('Orders');
                refresh();
            })
    }
});
