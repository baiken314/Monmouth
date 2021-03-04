const Game = require("../models/Game");
const Map = require("../models/Map");
const User = require("../models/User");

const router = require("express").Router();

router.route("/").get(async (req, res) => {
    console.log("GET game")
    res.json(await Game.find());
});

/**
 * req.body.users: String[], all usernames in the game
 * req.body.map: String, Map.name
 * 
 * - validate usernames and map name
 * - create Game
 * - create Players for each username
 *  - reference Player -> Game
 *  - reference each User -> Player
 * - reference Game -> Map
 * - create Regions from map.regions
 */
router.route("/create").post(async (req, res) => {
    console.log("POST game/create");

    let game = new Game({
        state: "initialization"
    });

    // popualte game.players
    for (name of req.body.users) {
        let player = {
            game: game._id,
            user: (await User.findOne({ name: name }))._id
        };
        game.players.push(player);
    }

    // populate game.map
    const map = await Map.findOne({ name: req.body.map });
    game.map = map._id;

    // populate game.regions
    for (regionTemplate of map.regions) {
        let region = {
            name: regionTemplate.name,
            type: regionTemplate.type,
            adjacentRegionNames: regionTemplate.adjacentRegionNames,
            isNuked: false,
            units: {
                land: 0,
                marine: 0,
                amphibious: 0,
                atomBombs: 0,
                bioweapons: 0,
                radars: 0
            },
            industrialization: {
                investment: 0,
                active: false,
                agriculture: Math.min(Math.floor(Math.random() * 4), Math.floor(Math.random() * 4)),
                mining: Math.min(Math.floor(Math.random() * 4), Math.floor(Math.random() * 4)),
                synthetics: Math.min(Math.floor(Math.random() * 4), Math.floor(Math.random() * 4))
            }
        };

        game.regions.push(region);
    }

    // push ids of adjacent regions to each region
    for (region of game.regions) {
        adjacentRegions = game.regions.filter(gameRegion => {
            return region.adjacentRegionNames.includes(gameRegion.name);
        });
        for (adjacentRegion of adjacentRegions) {
            region.adjacentRegions.push(adjacentRegion._id);
        }
    }

    // assign players randomly to starting regions
    game.players.sort(() => Math.random() - 0.5);  // randomize player order

    for (let i = 0; i < game.players.length; i++) {
        for (startingRegionName of map.startingRegions[i].regionNames) {
            console.log(startingRegionName);
            let region = game.regions.filter
                (region => startingRegionName == region.name )[0];
            region.player = game.players[i]._id;
            region.units.land = 1;
            region.industrialization = {
                investment: 0,
                active: true,
                agriculture: 1,
                mining: 1,
                synthetics: 1
            }
        }
    }

    game.save();

    console.log("END POST game/create");

    res.json(game);
});

module.exports = router;