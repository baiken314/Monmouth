const URL = "http://localhost:8000";

console.log("Starting.....");

async function getUserSession() {
    console.log("Getting user session");

    const userSessionRequest = await fetch(URL + "/user-session");
    const userSession = await userSessionRequest.json();

    console.log("userSession: " + userSession);

    document.getElementById("user-info").innerHTML = JSON.stringify(userSession);
}

getUserSession();  // populate user information

// create game button
let createGameButton = document.getElementById("create-game");
createGameButton.addEventListener("click", async function() {
    let map = document.getElementsByName("map")[0].value;
    let users = document.getElementsByName("users")[0].value.split(" ");
    console.log(map);
    console.log(users);

    const createGameRequest = await fetch(URL + "/game/create", {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            map: map,
            users: users
        })
    });
    const createGameResponse = await createGameRequest.json();

    console.log(createGameResponse);

    getUserSession();
});

// logout button
let logoutButton = document.getElementById("logout");
logoutButton.addEventListener("click", function() {
    console.log("logging out...");
    window.location.href = `${URL}/logout`;
});