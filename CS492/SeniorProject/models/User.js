const mongoose = require("mongoose");

const userSchema = new mongoose.Schema({
    name: {
        type: String,
        unique: true
    },
    email: {
        type: String,
        unique: true
    },
    password: String,

    // keep track of what Games the User is in
    players: [{
        type: mongoose.Schema.ObjectId,
        ref: "Player"
    }],

    friends: [{
        type: mongoose.Schema.ObjectId,
        ref: "User"
    }],

    stats: {
        wins: Number,
        losses: Number
    }
});

let User = mongoose.model("User", userSchema);

module.exports = User;