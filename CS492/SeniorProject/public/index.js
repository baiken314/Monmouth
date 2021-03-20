const URL = "http://localhost:8000";

console.log("Starting.....");

async function getGames() {
    console.log("Getting games");

    const gamesRequest = await fetch(URL + "/game");
    const games = await gamesRequest.json();

    console.log("Games: " + games);
    
    document.getElementById("game-info").innerHTML = JSON.stringify(games);
}

getGames();