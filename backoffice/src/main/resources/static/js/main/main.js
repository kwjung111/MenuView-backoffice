function logout(){
    var link = 'http://localhost:8080/logout';
    location.href=link;
}

function info() {
    post('main/info',{})
        .then(res =>{
            console.log(res)
        })
}