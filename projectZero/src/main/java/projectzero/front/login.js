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
            data: JSON.stringify({email: email, pass: pass}),
            success: function (data, status, xhr) {
                alert(xhr.getResponseHeader('key') + " | " + status);
                $('#joinDiv').hide();
                $('#loginDiv').show();
            }
        });
    }
});
