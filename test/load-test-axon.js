//
// load-test.js
//
module.exports = {
    createOrder: createOrder,
    logResponse: logResponse
}

function createOrder(requestParams, context, ee, next) {

    requestParams.json = {
        "comment": "load test",
        "price": Math.floor(Math.random() * 1001),
        "productId": makeid()
    };

    return next(); // MUST be called for the scenario to continue
}


function logResponse(requestParams, response, context, ee, next) {
    console.log(response.body);
    return next(); // MUST be called for the scenario to continue
}

// adopted from https://stackoverflow.com/questions/1349404/generate-random-string-characters-in-javascript
function makeid() {
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for (var i = 0; i < 5; i++)
    text += possible.charAt(Math.floor(Math.random() * possible.length));

    return text;
}
