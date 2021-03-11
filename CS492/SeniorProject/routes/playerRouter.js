const Game = require("../models/Game");
const Map = require("../models/Map");
const User = require("../models/User");

const router = require("express").Router();

router.route("/").get(async (req, res) => {
    console.log("GET player");
    res.json(await Player.find());
});

/**
 * Assign Player focus and update Game.state if all Players have gone
 * req.body.game: game._id
 * req.body.player: player._id
 * req.body.focusValues: [Number], ordered as "buying", "acting", "selling"
 */
router.route("/focus").post(async (req, res) => {
    let game = await Game.findOne({ _id: req.body.game });
    if (game.state == "focus") {
        let player = game.players.filter(player => player._id == req.body.player)[0];
        player.focus = {
            selling: req.body.focusValues[0],
            acting: req.body.focusValues[1],
            buying: req.body.focusValues[2]
        }
        gameController.checkFocus(game);
        game.save();
    }
});

module.exports = router;