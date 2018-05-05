//
// load-test.js
//
module.exports = {
    // createCustomer: createCustomer,
    // logCustomerID: logCustomerID,
    createOrder: createOrder,
    logResponse: logResponse
}

function createOrder(requestParams, context, ee, next) {

    requestParams.json = {
        "customerId": "000001632de8f40c-0242ac1200060000",
        "orderTotal": {
            "amount": 1
        }
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
