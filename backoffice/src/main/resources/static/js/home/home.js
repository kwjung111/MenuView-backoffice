function login(){
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    console.log(username + password)
    axios.get('/api')
        .then(response => {
            console.log(response.data);
        })
        .catch(error => {
            console.error(error);
        });
}

function join(){
    console.log('join')
}