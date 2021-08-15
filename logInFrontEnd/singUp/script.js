
$( document ).ready(function() {
    $("#form").submit(function(e){
        e.preventDefault();
        $.ajax({
            url: 'http://localhost:9000/home/addUser',
            type: 'get',
            data:{

                firstName:$("#firstName").val(),
                lastName:$("#lastName").val(),
                email:$("#email").val(),
                username:$("#username").val(),
                password:$("#password").val()
            },
            success: function(response,statusString) {
                if(statusString==="success"){
                    window.location.replace("../user/user.html");
                    Cookies.set('username', $("#username").val());
                    Cookies.set('password', $("#password").val());
                }
            },
            error: function(xhr) {
                //Do Something to handle error
            }
        })
    })
});
