function () {
    var URL = 'http://localhost:4567'
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    karate.log("API URL: " + URL)
    return {
       baseURL: URL
    };
}