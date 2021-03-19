const mongoose = require("mongoose");

const playerSchema = new mongoose.Schema({
    // back reference to Game
    game: {
        type: mongoose.Schema.ObjectId,
        ref: "Game"
    },

    // back reference to User
    user: {
        type: mongoose.Schema.ObjectId,
        ref: "User"
    },

    balance: Number,
    
    focus: {
        sell: Number,
        act: Number,
        buy: Number
    },

    resources: {
        agriculture: Number,
        mining: Number,
        synthetics: Number
    },

    units: {
        land: Number,
        naval: Number,
        amphibious: Number,
        atomBombs: Number,
        bioweapons: Number,
        radars: Number
    }
});

let Player = mongoose.model("Player", playerSchema);

module.exports.playerSchema = playerSchema;
module.exports.Player = Player;