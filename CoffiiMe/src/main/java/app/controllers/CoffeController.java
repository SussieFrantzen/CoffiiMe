package app.controllers;

import app.entities.Coffee;
import app.persistence.CoffeeMapper;
import app.persistence.ConnectionPool;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.awt.*;

public class CoffeController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {
        //app.post("/index", ctx -> getExistingCoffee(ctx, connectionPool));
        //app.post("/index", ctx -> createCoffee(ctx, connectionPool));
        //app.get("/color", ctx -> ctx.json(new Integer[]{255,200,5}));


        app.get("/color", ctx -> createCoffee(ctx, connectionPool));
    }


    /*
    public static void getExistingCoffee(Context ctx, ConnectionPool connectionPool) {
        String beanType = ctx.formParam("");
        String coffeeType = ctx.formParam("");
        int totalVolume = Integer.parseInt(ctx.formParam(""));

        CoffeeMapper coffeeMapper = new CoffeeMapper(connectionPool);
        coffeeMapper.getExistingCoffee(beanType, totalVolume);
    }
     */

    public static void createCoffee(Context ctx, ConnectionPool connectionPool) {

        String beanType = ctx.formParam("");
        int totalVolume = Integer.parseInt(ctx.formParam(""));
        int beanPercentages = Integer.parseInt(ctx.formParam(""));
        int milkPercentages = Integer.parseInt(ctx.formParam(""));
        int waterPercentages = Integer.parseInt(ctx.formParam(""));

        CoffeeMapper coffee = new CoffeeMapper(connectionPool);
        coffee.createCoffee(beanType, totalVolume, beanPercentages, milkPercentages, waterPercentages);


        Color color = coffee.createCoffee(beanType, totalVolume, beanPercentages, milkPercentages, waterPercentages).getColor();
        String rgb = "rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")";
        ctx.result(rgb);


    }

    public static void addToFavorites() {

    }

    public static void getFavorites() {

    }
}
