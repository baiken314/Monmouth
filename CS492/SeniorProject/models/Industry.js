const mongoose = require("mongoose");

const industrySchema = new mongoose.Schema({
    name: String,
    cost: Number,
    level: Number,
    investment: Number,
    isOpen: Boolean,  // when not open, cost is 0 and no resources are produced next turn

    // resources produced per turn
    resources: {
        agriculture: Number,
        mining: Number,
        synthetics: Number
    },

    // who owns the Industry
    player: {
        type: mongoose.Schema.ObjectId,
        ref: "Player"
    }
});

let Industry = mongoose.model("Industry", industrySchema);

module.exports = Industry;