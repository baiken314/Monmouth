module.exports = {

    endPlayerTurn: function (game) {
        console.log("gameController.endPlayerTurn " + game.playerOrder);
        game.playerOrder.shift();
        if (!game.playerOrder.length) {
            if (game.state == "sell") {
                console.log("sell -> act.attack");
                game.state = "act.attack";
                this.updatePlayerOrder(game);  // for act
            }
            else if (game.state.includes("act")) {
                if (game.state == "act.attack") {
                    console.log("act.attack -> act.move");
                    game.state = "act.move";
                }
                else if (game.state == "act.move") {
                    console.log("act.move -> act.build");
                    game.state = "act.build";
                }
                else if (game.state == "act.build") {
                    console.log("act.build -> buy");
                    game.state = "buy";
                    this.updatePlayerOrder(game);  // for buy
                }
            }
            else if (game.state == "buy") {
                console.log("buy -> industrialzation");
                game.state = "industrialization";
            }
        }
    },

    rotatePlayerOrder: function (game) {
        console.log("gameController.rotatePlayerOrder " + game.playerOrder);
        game.playerOrder.push(game.playerOrder.shift());
    },

    // focus -> sell
    checkFocus: function (game) {
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

    updatePlayerOrder: function (game) {
        console.log("gameController.updatePlayerOrder " + game.state);
        let state = game.state;
        if (state == "sell" || state.contains("act") || state == "buy") {
            let playerOrder = game._doc.players.sort((a, b) => {
                if (a.focus[state] > b.focus[state]) return -1;
                if (a.focus[state] < b.focus[state]) return 1;
                if (a.focus[state] == b.focus[state])
                    return Math.random() - 0.5;
            });
            let playerOrderIds = [];  // empty queue
            // add player._ids to game.playerOrder
            for (player of playerOrder) {
                console.log(`player._id: ${player._id}`);
                playerOrderIds.push(player._id);
            }
            game.playerOrder = playerOrderIds;
        }
    },

    updateUnits: function (game) {
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
    applyIndustrializationFees: function (game) {
        console.log("gameController.applyIndustrializationFees");
        if (game.state == "industrialization" || game.state == "initialization" || game.state == "maintenance") {
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

    applyMaintenanceFees: function (game) {
        for (player of game.players) {
            player.balance -=
                player._doc.units.land + player._doc.units.naval +
                player._doc.units.amphibious;
            for (action in player._doc.focus) player._doc.focus[action] = 0;
        }
    },

    checkWinCondition: function (game) {
        
    },

};