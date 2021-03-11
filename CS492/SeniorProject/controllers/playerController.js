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
    },

    applyMaintenanceFees: async function (game) {
        for (player of game.players) {
            player.balance -= player.units.land + player.units.naval + player.units.amphibious;
            for (action in player._doc.focus) player._doc.focus[action] = 0;
        }
    },
    
}