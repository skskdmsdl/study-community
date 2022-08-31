// function inputEvent(e) {
//     if(e.key.match(/[^0-9]/g)){
//         e.target.value =  e.target.value.replace(/[^0-9]/g, '');
//     }
// }

function checkPassword(){
    let password = $("#password").val();
    let passwordCheck = $("#password-check").val();
    let num = password.search(/[0-9]/g);
    let eng = password.search(/[a-z]/ig);
    let spec = password.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    if(password.length < 8 || password.length > 20){
        alert("8자리 ~ 20자리 이내로 입력해주세요.");
        return false;
    }else if(password.search(/\s/) != -1){
        alert("비밀번호는 공백 없이 입력해주세요.");
        return false;
    }else if(num < 0 || eng < 0 || spec < 0 ){
        alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
        return false;
    }else {
        console.log("통과");
        return true;
    }

    if(password != passwordCheck){
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }
}