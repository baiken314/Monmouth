const mongoose = require("mongoose");

const regionSchema = new mongoose.Schema({
    name: String,
    type: String,  // "land", "sea", "ocean"

    adjacentRegionNames: [String],

    /**********************************
     * fields populated during gameplay
    ***********************************/
    traversable: Boolean,

    // Regions accessible by this Region
    adjacentRegions: [{
        type: mongoose.Schema.ObjectId,
        ref: "Region"
    }],

    // who controls the troops in the Region
    player: {
        type: mongoose.Schema.ObjectId,
        ref: "Player"
    },

    units: {
        land: Number,
        naval: Number,
        amphibious: Number,
        atomBombs: Number,
        bioweapons: Number,
        radars: Number
    },

    industrialization: {
        investment: Number,
        active: Boolean,
        agriculture: Number,
        mining: Number,
        synthetics: Number
    }
});

let Region = mongoose.model("Region", regionSchema);

module.exports = {
    Region: Region,
    regionSchema: regionSchema
};