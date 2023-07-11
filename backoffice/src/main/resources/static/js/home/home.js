async function post(url, body, headers = {}) {
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            ...headers,
        },
        body: JSON.stringify(body),
    };
    const res = await fetch(url, options);
    const data = await res.json();
    console.log(data)
    return data;
}

async function get(url,param) {
    const response = await fetch(url,param);
    const data = await response.json()
    console.log(data);
}

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
    var link = 'http://localhost:8080/signUp';
    location.href=link;
}

function test(){
    console.log('test')
    fetchlog('/api/test')
}