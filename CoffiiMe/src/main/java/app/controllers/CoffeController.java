package app.controllers;

import app.persistence.CoffeeMapper;
import app.persistence.ConnectionPool;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class CoffeController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {
        app.post("/index", ctx -> getExistingCoffee(ctx, connectionPool));
        app.post("/index", ctx -> createCoffee(ctx, connectionPool));
    }


    public static void getExistingCoffee(Context ctx, ConnectionPool connectionPool) {
        String beanType = ctx.formParam("");
        String coffeeType = ctx.formParam("");
        int totalVolume = Integer.parseInt(ctx.formParam(""));

        CoffeeMapper coffeeMapper = new CoffeeMapper();
        coffeeMapper.getExistingCoffee(beanType, coffeeType, totalVolume);
    }

    public static void createCoffee(Context ctx, ConnectionPool connectionPool) {
        String beanType = ctx.formParam("");
        int totalVolume = Integer.parseInt(ctx.formParam(""));
        int beanPercentages = Integer.parseInt(ctx.formParam(""));
        int milkPercentages = Integer.parseInt(ctx.formParam(""));
        int waterPercentages = Integer.parseInt(ctx.formParam(""));

        CoffeeMapper coffeMapper = new CoffeeMapper();
        coffeMapper.createCoffee(beanType, totalVolume, beanPercentages, milkPercentages, waterPercentages);
    }

    public static void addToFavorites() {

    }

    public static void getFavorites() {

    }
}
