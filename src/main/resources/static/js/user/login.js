$("#login-btn").click(function() {
    const headers = {
        "Content-Type" : "application/json",
        "X-HTTP-Method-Override" : "POST"
    };
    const loginInfo = JSON.stringify({
        userName:$("#login-id").val(),
        password:$("#login-password").val()
    });

//    $.ajax({
//        type: "POST",
//        url: "user/login",
//        headers: headers,
//        data: loginInfo
//    })
//    .done(function(data) {
//        // console.log(data.result.token);
//        // $("#logout-btn").css("display", "block");
//        alert(data);
//        console.log(data);
//    })
//    .fail(function(data) {
//        alert("일치하는 회원정보가 없습니다.");
//    })

    axios({
        method: "post",
        url: "/user/login",
        headers: headers,
        data: loginInfo
    })
    .then((response) => {
        localStorage.setItem('token', response.data.result.token);
        const token = response.data.result.token;
        console.log(response.data.result.token);
//        if(token) {
//            html += '<a class="btn btn-primary order-1 order-lg-0 bg-100 me-lg-2" id="logout">로그아웃</a>';
//            $('#navbarSupportedContent').html(html);
//        }
    })
    .catch(() => {
        alert("일치하는 회원정보가 없습니다.");
    });
});
