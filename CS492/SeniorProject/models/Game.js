const mongoose = require("mongoose");

const regionSchema = require("./Region").regionSchema;
const playerSchema = require("./Player").playerSchema;

const gameSchema = new mongoose.Schema({
    // who is playing the game
    players: [playerSchema],
    playerOrder: [playerSchema],

    // only to be used for as a reference
    map: {
        type: mongoose.Schema.ObjectId,
        ref: "Map"
    },

    // new Regions shall be created based off the map.regions references
    // these will hold the stats of each Region during gameplay
    regions: [regionSchema],

    turn: Number,  // number of turns completed
    state: String,  // control what part of each turn Game is in

    marketPrices: {
        agriculture: Number,
        mining: Number,
        synthetics: Number
    }
});

let Game = mongoose.model("Game", gameSchema);

module.exports = Game;