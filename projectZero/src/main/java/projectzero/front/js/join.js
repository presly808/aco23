$('#joinBtn').click(function () {
    var email = $('#joinInputEmail').val();
    var pass = $('#joinInputPassword').val();

    if (email && pass) {
        $.ajax({
            method: "POST",
            url: "/join",
            data: JSON.stringify({email: email, pass: pass})
        })
            .done(function (data) {
                var obj = JSON.parse(data);
                if (!obj.error) {
                    alert("Success");
                    $('#joinDiv').hide();
                    $('#loginDiv').show();
                    $('#header').find('> h1').text('Log In');
                } else {
                    alert("Error: " + obj.error);
                }
            });
    }
});
