

function login() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    console.log(username + password)

    let param = {
        username : username,
        password : password,
    }

    post('login/login', param);
}

function join(){
    var link = 'signUp'
    goToUrl(link);
}

function findId(){
    var link = 'findId';
    goToUrl(link);
}

function findPwd(){
    var link ='findPwd';
    goToUrl(link);
}


function test(){
    console.log('test')
    post('/api/test',{})
}