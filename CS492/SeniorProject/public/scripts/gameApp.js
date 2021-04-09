const URL = "http://localhost:8000";

async function update() {
    console.log("updating...");

    const playerSessionRequest = await fetch(URL + "/player-session");
    const playerSession = await playerSessionRequest.json();

    gameApp.user = playerSession.user;
    gameApp.game = playerSession.game;
    gameApp.player = playerSession.player;

    console.log(JSON.stringify(playerSession.player));
}

let gameApp = new Vue({
    el: "#game-app",
    data: {
        user: {},
        game: {},
        player: {}
    }
});

update();