package app;

import app.controllers.CoffeController;
import app.persistence.CoffeeMapper;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;

import app.config.SessionConfig;
import app.config.ThymeleafConfig;
import app.controllers.UserController;
import app.persistence.ConnectionPool;

import java.util.Map;


public class App {

    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/%s?currentSchema=public";
    private static final String DB = "coffiime";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance(USER, PASSWORD, URL, DB);

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
            config.jetty.modifyServletContextHandler(handler -> handler.setSessionHandler(SessionConfig.sessionConfig()));
            config.fileRenderer(new JavalinThymeleaf(ThymeleafConfig.templateEngine()));
        }).start(7070);


        app.get("/", ctx -> ctx.render("Index.html"));
        UserController.addRoutes(app, connectionPool);
        CoffeController.addRoutes(app,connectionPool);

    }
}
