package app.controllers;

import app.entities.Coffee;
import app.exception.DatabaseException;
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


        app.post("/slider", ctx -> createCoffee(ctx, connectionPool));
        app.post("/copi", ctx -> {
            Integer userId = ctx.sessionAttribute("user_id");
            if (userId == null) {
                ctx.status(401).result("Du skal logge ind først!");
                return;
            }
            String coffeetype = ctx.formParam("coffeetype");
            CoffeeMapper coffeeMapper = new CoffeeMapper(connectionPool);
                boolean success = coffeeMapper.addCoffeTypeToFavorit(coffeetype, userId);
            if (success) {
                ctx.result("Kaffen blev tilføjet til dine favoritter!");
            } else {
                ctx.result("Noget gik galt, prøv igen.");
            }
        });


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

        /*
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

         */

        try {
            int sliderValue = ctx.bodyAsClass(SliderValue.class).getSliderValue();
            CoffeeMapper coffeeMapper = new CoffeeMapper(connectionPool);

            ctx.json("Slider value received: " + sliderValue);
        } catch (Exception e) {
            ctx.status(400).result("Invalid data: " + e.getMessage());
        }
    }

    public static class SliderValue {
        private int sliderValue;

        public int getSliderValue() {
            return sliderValue;
        }

        public void setSliderValue(int sliderValue) {
            this.sliderValue = sliderValue;
        }

        public static void addToFavorites() {
            // your existing code
        }

        public static void getFavorites() {
            // your existing code
        }

    }

    public static void addToFavorites() {

    }

    public static void getFavorites() {

    }



}
