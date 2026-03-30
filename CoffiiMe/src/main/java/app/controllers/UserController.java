package app.controllers;

import app.exception.DatabaseException;
import app.persistence.UserMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import app.persistence.ConnectionPool;

public class UserController {


    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {

        app.get("/aboutUs", ctx -> ctx.render("AboutUs.html"));
        app.get("/coffeeBrands", ctx -> ctx.render("CoffeeBrands.html"));
        app.get("/coffeeType", ctx -> ctx.render("CoffeeType.html"));
        app.get("/colorPanel", ctx -> ctx.render("ColorPanel.html"));
        app.get("/contactUs", ctx -> ctx.render("ContactUs.html"));
        app.get("/createAccount", ctx -> ctx.render("CreateAccount.html"));
        app.get("/creatingPanel", ctx -> ctx.render("CreatingPanel.html"));
        app.get("/favorites", ctx -> ctx.render("Favorites.html"));
        app.get("/index", ctx -> ctx.render("Index.html"));
        app.get("/login", ctx -> ctx.render("Login.html"));
        app.get("/options", ctx -> ctx.render("Options.html"));
        
        //app.post("/index", ctx -> login(ctx, connectionPool));
        app.post("/createAccount", ctx -> createUser(ctx, connectionPool));
        app.post("/login", ctx -> login(ctx,connectionPool));



        // coffee types picture link
        app.get("/americano", ctx -> ctx.render("Americano.html"));
        app.get("/cafeLatte", ctx -> ctx.render("CafféLatte.html"));
        app.get("/cappuccino", ctx -> ctx.render("Cappuccino.html"));
        app.get("/cortado", ctx -> ctx.render("Cortado.html"));
        app.get("/espresso", ctx -> ctx.render("Espresso.html"));
        app.get("/flatWhite", ctx -> ctx.render("FlatWhite.html"));
        app.get("/latteMacchiato", ctx -> ctx.render("LatteMacchiato.html"));
        app.get("/lungo", ctx -> ctx.render("Lungo.html"));
        app.get("/macchiato", ctx -> ctx.render("Macchiato.html"));
        app.get("/mocha", ctx -> ctx.render("Mocha.html"));


        //brands link
        app.get("/coffeDoff", ctx -> ctx.render("CoffeeDoff.html"));
        app.get("/bean", ctx -> ctx.render("Bean.html"));
        app.get("/kaf", ctx -> ctx.render("Kaf.html"));

    }



    public static void createUser(Context ctx, ConnectionPool connectionPool) throws DatabaseException {
        String firstname = ctx.formParam("firstname");
        String lastname = ctx.formParam("lastname");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");
        UserMapper createAccount = new UserMapper(connectionPool);

        if (createAccount.createUser(firstname, lastname, email, password)) {
            ctx.redirect("/");
        } else {
            ctx.result("Something went wrong. Check username or password");
        }
    }

    public static void login(Context ctx, ConnectionPool connectionPool) throws DatabaseException {
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");
        UserMapper user = new UserMapper(connectionPool);

        Integer user_id = user.login(email,password);

        if (user_id != null) {
            ctx.sessionAttribute("user_id", user_id);
            ctx.redirect("/index");
        } else {
            ctx.result("Something went wrong. Check username or password");
        }
    }

    public static void logout() {

    }
}
