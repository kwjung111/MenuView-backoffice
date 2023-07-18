function submit() {
    var username = document.getElementById("username").value
    var email = document.getElementById("email").value

    var param = {
        name: username,
        email: email
    }

    post("findPwd", param)
        .then(json => {
            console.log(json)
            let username = json.username
            if(username == null || username == "" || username === undefined){
                alert("일치하는 사용자가 없습니다.")
            }
            else{
                alert("해당하는 사용자의 ID는 " + username + "입니다.");
            }
            //TODO 반환 UI/UX 수정하기
            //document.getElementById("result").value = username
        })
        .catch(json=>{

        })
}

function goLoginPage(){
    goToUrl('')
}
