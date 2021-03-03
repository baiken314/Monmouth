const Map = require("../models/Map");

const router = require("express").Router();

router.route("/").get(async (req, res) => {
    console.log("GET map");
    res.json(await Map.find());
});

module.exports = router;