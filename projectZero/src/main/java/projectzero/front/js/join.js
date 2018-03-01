$('#joinBtn').click(function () {
    var email = $('#joinInputEmail').val();
    var pass = $('#joinInputPassword').val();

    if (email && pass) {
        $.ajax({
            method: "POST",
            url: "/join",
            data: JSON.stringify({email: email, pass: pass}),
            success: function (data, status, xhr) {
                var error = JSON.parse(data);
                if (!error) {
                    alert("Success");
                    $('#joinDiv').hide();
                    $('#loginDiv').show();
                } else {
                    alert("Error: " + error);
                }
            }
        });
    }
});
