package app.controllers;

import io.javalin.Javalin;

import app.persistence.ConnectionPool;

public class UserController {


    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {
        app.get("CreateAccount", ctx -> ctx.render("CreateAccount.html"));

        app.get("/Login", ctx -> ctx.render("Login.html"));


    }

    public static void creatUser() {
    }

    public static void login() {

    }

    public static void logout() {

    }
}
