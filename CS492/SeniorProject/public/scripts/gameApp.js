const socket = io();

const URL = "http://localhost:8000";

// grab game information from the player-session and load into gameApp
async function updateGameApp() {
    console.log("updating...");

    const playerSessionRequest = await fetch(URL + "/player-session");
    const playerSession = await playerSessionRequest.json();

    gameApp.user = playerSession.user;
    gameApp.game = playerSession.game;
    gameApp.player = playerSession.player;

    console.log(JSON.stringify(playerSession.player));
}

socket.on("updateGameApp", updateGameApp);

// captures all data from player-session
let gameApp = new Vue({
    el: "#game-app",
    data: {
        user: {},
        game: {},
        player: {}
    }
});

// update the page onload
updateGameApp();