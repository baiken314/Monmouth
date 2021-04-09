const URL = "http://localhost:8000";

console.log("Starting.....");

async function getUserSession() {
    console.log("Getting user session");

    const userSessionRequest = await fetch(URL + "/game");
    const userSession = await userSessionRequest.json();

    console.log("Games: " + userSession);

    document.getElementById("user-info").innerHTML = JSON.stringify(userSession);
}

getUserSession();