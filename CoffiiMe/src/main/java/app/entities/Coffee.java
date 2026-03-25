package app.entities;

import app.Calculator;

import java.awt.*;
import java.util.Map;

public class Coffee extends Calculator {

    String name;
    double volume;
    Map<String, Double> ingredient;
    Color color;

    public Coffee(String name, double volume, Map<String, Double> ingredient, Color color) {
        this.name = name;
        this.volume = volume;
        this.ingredient = ingredient;
        this.color = color;
    }

    public String getName(){
        return name;
    };

    public double getVolume(){
        return volume;
    };

    public Map<String, Double> getIngredients(){
        return ingredient;
    };

    public Color getColor(){
        return color;
    };

}
