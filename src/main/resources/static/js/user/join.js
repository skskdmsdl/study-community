// TODO : code develop 예정(alert 지우고 화면상에서 해결)-> 아이디 중복도 화면상 나타내기
function joinBtn(){
    const password = $("#password").val();
    const passwordCheck = $("#password-check").val();
    const num = password.search(/[0-9]/g);
    const eng = password.search(/[a-z]/ig);
    const spec = password.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    if(password.length < 8 || password.length > 20){
        alert("8자리 ~ 20자리 이내로 입력해주세요.");
        return false;
    }else if(password.search(/\s/) != -1){
        alert("비밀번호는 공백 없이 입력해주세요.");
        return false;
    }else if(num < 0 || eng < 0 || spec < 0 ){
        alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
        return false;
    }else if(password != passwordCheck){
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }

    const headers = {
        "Content-Type" : "application/json",
        "X-HTTP-Method-Override" : "POST"
    };
    const userInfo =JSON.stringify({
      userName:$("#join-id").val(),
      password:$("#password").val()
    });

//    $.ajax({
//        url: "/user/join",
//        type: "POST",
//        headers: headers,
//        data: userInfo
//    })
//    .done(function(data) {
//        console.log(data.resultCode);
//        alert("로그인을 해주세요");
//    })
//    .fail(function(data, status, err) {
//        if(data.responseJSON.resultCode = "DUPLICATED_USER_NAME") {
//            alert("아이디가 중복됩니다.");
//        }
//        console.log(data);
//    })

    axios({
        method: "post",
        url: "/user/join",
        headers: headers,
        data: userInfo
    })
    .then((response) => {
        alert("로그인을 해주세요");
        console.log(response.resultCode);
    })
    .catch((error) => {
        console.log(error);
        if(error.response.resultCode = "DUPLICATED_USER_NAME") {
            alert("아이디가 중복됩니다.");
        }
        console.log(error);
    });
    history.pushState(null, null, "/studies");

}
