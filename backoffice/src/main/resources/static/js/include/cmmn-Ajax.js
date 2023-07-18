const baseUrl = "http://localhost:8080/"

function fullUrl(url){
    return baseUrl + url;
}
function goToUrl(url){
    location.href= fullUrl(url);
}


async function post(url, body, headers = {}) {
    const fullUrl = baseUrl + url;
    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            ...headers,
        },
        body: JSON.stringify(body),
    };
    const response = await fetch(fullUrl,options)
    const data = await response.json();

    return data;
}