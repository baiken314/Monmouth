const Game = require("../models/Game");
const Map = require("../models/Map");
const User = require("../models/User");

const gameController = require("../controllers/gameController");

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
            sell: req.body.focusValues[0],
            act: req.body.focusValues[1],
            buy: req.body.focusValues[2]
        }

        gameController.checkFocus(game);

        game.save();
        player.save();

        res.json({
            player: player
        });
    }
    else { console.log("game.state is not focus, " + game.state); }
});

/**
 * req.body.game: game._id
 * req.body.player: player._id
 */
 router.route("/end-turn").post(async (req, res) => {
    console.log("POST player/end-turn");
    let game = await Game.findOne({ _id: req.body.game });
    let player = game.players.filter(player => player._id == req.body.player)[0];

    if (game.playerOrder[0] == player._id) {
        gameController.endPlayerTurn(game);
        game.save();
        player.save();
    }
    else {
        res.json("ERROR - incorrect action or player");
    }
});

/**
 * req.body.game: game._id
 * req.body.player: player._id
 * req.body.resource: String, name of player.resources key
 * req.body.action: String, "buy" or "sell"
 * req.body.amount: Number
 */
router.route("/market-order").post(async (req, res) => {
    console.log("POST player/market-order");

    let game = await Game.findOne({ _id: req.body.game });
    let player = game.players.filter(player => player._id == req.body.player)[0];

    if (game.state == req.body.action && game.playerOrder[0] == player._id) {
        let price = req.body.amount * game._doc.market.prices[req.body.resource];
        if (req.body.action == "sell") {
            if (player._doc.resources[req.body.resource] - req.body.amount < 0) {
                res.send("ERROR - not enough resources");
            }
            player.balance += price;
            player.resources[req.body.resource] -= req.body.amount;
            game.market.prices[req.body.resource] -= req.body.amount;
            console.log(game.market.prices[req.body.resource]);
            if (game.market.prices[req.body.resource] < 1)
                game.market.prices[req.body.resource] = 1;
            gameController.rotatePlayerOrder(game);
        }
        if (req.body.action == "buy") {
            if (player.balance - price < 0) {
                res.send("ERROR - balance too low");
            }
            player.balance -= price;
            player.resources[req.body.resource] += req.body.amount;
            game.market.prices[req.body.resource] += req.body.amount;
            console.log(game.market.prices[req.body.resource]);
            if (game.market.prices[req.body.resource] > game._doc.market.maxPrice)
                game.market.prices[req.body.resource] = game._doc.market.maxPrice;
            gameController.rotatePlayerOrder(game);
        }

        game.save();
        player.save();

        res.json({
            player: player
        });
    }
    else { 
        console.log("incorrect action " + req.body.action + " " + game.playerOrder); 
        res.json("ERROR - incottect action or player");
    }
});

/**
 * req.body.game: game._id
 * req.body.attacker: player._id
 * req.body.originRegion: region._id  // of the region attacking from
 * req.body.targetRegion: region._id  // of the region being attacked
 * req.body.units: Object  // units attacking with
 */
router.route("/attack").post(async (req, res) => {
    console.log("POST player/attack");
    
    let game = await Game.findOne({ _id: req.body.game });
    let player = game.players.filter(player => player._id == req.body.player)[0];
});

/**
 * req.body.game: game._id
 * req.body.defender: player._id
 * req.body.attacker: player._id
 * req.body.accept: Boolean  // does the player want to defend?
 */
router.route("/defend").post(async (req, res) => {

});

/**
 * req.body.game: game._id
 * req.body.player: player._id
 * req.body.originRegion: region._id
 * req.body.targetRegion: reqgion._id
 * req.body.units: {
 *      land: Number,
 *      naval: Number,
 *      amphibious: Number
 * }
 */
router.route("/move").post(async (req, res) => {

});

/**
 * req.body.game: game._id
 * req.body.player: player._id
 * req.body.unit: String  // "land", "naval", "amphibious", "radar", "atomBomb", "bioweapon"
 * req.body.region: region._id  // where the unit will be built
 */
router.route("/build").post(async (req, res) => {

});

/**
 * req.body.game: game._id
 * req.body.player: player._id
 * req.body.action: String  // "agriculture", "mining", "synthetics", "radar", "atomBomb", "bioweapon"
 * req.body.region: region._id  // where to insudtrialize
 */
router.route("/research").post(async (req, res) => {

});

module.exports = router;