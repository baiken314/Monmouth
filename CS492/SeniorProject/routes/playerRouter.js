const Game = require("../models/Game");
const Map = require("../models/Map");
const Player = require("../models/Player").Player;
const Region = require("../models/Region").Region;
const User = require("../models/User");

const router = require("express").Router();

router.route("/").get(async(req, res) => {
    console.log("GET player");
    res.json(await Player.find());
});

module.exports = router;