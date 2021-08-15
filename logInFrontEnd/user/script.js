$( document ).ready(function() {
    $.ajax({
        url: 'http://localhost:9000/home/getUser',
        type: 'get',
        data:{
            username:Cookies.get('username'),
            password:Cookies.get('password'),
        },
        success: function(response,statusString) {
            if(statusString==="success") {
                $("#fname").text(response.firstName);
                $("#lname").text(response.lastName);
                $("#email").text(response.eMail);
                $("#uname").html(response.userName);
            }
        },
        error: function(xhr) {
                //Do Something to handle error
        }
    })
});
