const Game = require("../models/Game");
const Map = require("../models/Map");
const User = require("../models/User");

module.exports = {

    // focus -> sell
    checkFocus: async function (game) {
        let ready = true;
        for (player of game.players) {
            sum = 0;
            for (action of player.focus) {
                sum += player._doc.focus[action]
            }
            if (sum == 0) {
                ready = false;
                break;
            }
        }
        if (ready) {
            game.state = "sell";
        }
    }

    

}