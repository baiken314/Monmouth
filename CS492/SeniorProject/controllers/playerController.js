module.exports = {

    updateUnits: async function (game) {
        for (player of game.players) {
            for (unit in player._doc.units) {
                player._doc.units[unit] = 0;
            }
            for (region of game.regions) {
                if (region.player == player._id) {
                    for (unit in region._doc.units) {
                        player._doc.units[unit] += region._doc.units[unit];
                    }
                }
            }
        }
    },

    //  industrialization -> focus
    applyIndustrialization: async function (game) {
        if (game.state == "industrialization" || game.state == "initialization") {
            for (player of game.players) {
                for (resource in player._doc.resources) {
                    player._doc.resources[resource] +=
                        game.regions.reduce((total, region) => total +=
                            region.player == player._id ?
                                region._doc.industrialization[resource] : 0,
                            0);
                }
            }
            game.state = "focus";
        }
        else { console.log("game.state is not industrialization or initialization, " + game.state); }
    },

    applyMaintenanceFees: async function (game) {
        for (player of game.players) {
            player.balance -=
                player._doc.units.land + player._doc.units.naval +
                player._doc.units.amphibious;
            for (action in player._doc.focus) player._doc.focus[action] = 0;
        }
    },
    
}