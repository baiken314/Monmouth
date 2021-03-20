module.exports = {

    // focus -> sell
    checkFocus: async function (game) {
        console.log("gameController.checkFocus");
        let ready = true;
        for (player of game.players) {
            let sum = 0;
            for (action in player._doc.focus) {
                sum += player._doc.focus[action];
                console.log(player._doc.focus[action]);
            }
            if (sum < 10) {
                ready = false;
                console.log("focus not ready");
                break;
            }
        }
        if (ready) {
            console.log("game state -> sell");
            game.state = "sell";
            this.updatePlayerOrder(game);
        }
    },

    updatePlayerOrder: async function (game) {
        console.log("gameController.updatePlayerOrder " + game.state);
        let state = game.state;
        if (state == "sell" || state == "act" || state == "buy") {
            game.playerOrder = game.players.sort((a, b) => {
                if (a.focus[state] > b.focus[state]) return -1;
                if (a.focus[state] < b.focus[state]) return 1;
                if (a.focus[state] == b.focus[state])
                    return Math.random() - 0.5;
            });
        }
    },

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
    applyIndustrializationFees: async function (game) {
        console.log("gameController.applyIndustrializationFees");
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
            console.log("industrialization -> focus");
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

    checkWinCondition: async function (game) {
        
    },

};