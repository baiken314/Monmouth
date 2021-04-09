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
    res.redirect("/userpage");
});

app.get("/index", (req, res) => {
    console.log("GET /index");
    res.sendFile(__dirname + "/views/index.html");
})

app.get("/login", (req, res) => {
    console.log("GET /login");
    if (req.session.user == null) {
        res.sendFile(__dirname + "/views/login.html");
        return;
    }
    else {
        res.sendFile(__dirname + "/views/userpage.html");
    }
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
            res.redirect("/userpage");
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
            res.redirect("/userpage");
        }
        catch (e) {
            res.json({ message: "ERROR"} );
        }
    }
});

app.get("/logout", (req, res) => {
    console.log("GET /logout");
    req.session.user = null;
    res.redirect("/login");
});

app.get("/userpage", (req, res) => {
    console.log("GET /userpage");
    if (req.session.user != null) {
        res.sendFile(__dirname + "/views/userpage.html");
        return;
    }
    res.redirect("/login");
});

app.get("/user-session", async (req, res) => {
    req.session.user = await User.findOne({ _id: req.session.user._id });
    res.json(req.session);
});

const listener = httpServer.listen(PORT, () => {
    console.log(`Listening on ${PORT}`);
});