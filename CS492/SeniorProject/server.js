const express = require("express");
const session = require("express-session");
const mongoose = require("mongoose");
const bodyParser = require("body-parser");

const app = express();
const httpServer = require("http").Server(app);
const io = require("socket.io")(httpServer);

const MongoStore = require("connect-mongo")(session);

const gameRouter = require("./routes/gameRouter");
const mapRouter = require("./routes/mapRouter");
const playerRouter = require("./routes/playerRouter");
const userRouter = require("./routes/userRouter");
const User = require("./models/User");

const MONGO_URI = "mongodb+srv://highlandcentralinc:joenamath2021@cluster0.nz8tm.mongodb.net/senior_project?retryWrites=true&w=majority";
const PORT = 8000;

mongoose.connect(MONGO_URI, {
    useNewUrlParser: true,
    useUnifiedTopology: true
});

app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.json());
app.use(express.static(__dirname + "/public"));

app.use(session({
    secret: "secret",
    resave: true,
    saveUninitialized: false,
    store: new MongoStore({
        url: MONGO_URI
    })
}));

app.use("/game", gameRouter);
app.use("/map", mapRouter);
app.use("/player", playerRouter);
app.use("/user", userRouter);

app.get("/", (req, res) => {
    console.log("GET /")
    req.session.randomKey = req.session.randomKey || Math.random();
    //res.send(`Server running on ${PORT}, your session key is ${req.session.randomKey}`);
    res.sendFile(__dirname + "/views/index.html");
});

app.get("/login", (req, res) => {
    console.log("GET /login")
    res.sendFile(__dirname + "/views/login.html");
});

/**
 * req.body.name: String
 * req.body.email: String
 * req.body.password: String
 */
app.post("/login", async (req, res) => {
    console.log("POST /login");
    // login
    const user = await User.findOne({ name: req.body.name });
    if (user || !req.body.email) {
        if (!user) {
            res.json({ message: "ERROR - user does not exist"});
        }
        else if (req.body.password != user.password) {
            res.json({ message: "ERROR - password does not match"});
        }
        else {
            req.session.user = user;
            res.sendFile(__dirname + "/views/userpage.html");
        }
    }
    // create new account and login
    else {
        try {
            const newUser = await User.create({
                name: req.body.name,
                email: req.body.email,
                password: req.body.password
            });
            req.session.user = newUser;
            res.sendFile(__dirname + "/views/userpage.html");
        }
        catch (e) {
            res.json({ message: "ERROR"} );
        }
    }
});

app.get("/logout", (req, res) => {
    console.log("GET /logout");
    req.session.user = null;
    res.sendFile(__dirname + "/views/userpage.html");
});

app.get("/userpage", (req, res) => {
    console.log("GET /userpage");
});

const listener = httpServer.listen(PORT, () => {
    console.log(`Listening on ${PORT}`);
});