package app.ingredients.beansType;


import app.entities.Coffee;

import java.awt.*;
import java.util.Map;

public class BeanNestle extends Coffee {


    public BeanNestle(String name, double volume, Map<String, Double> ingredient, Color color) {
        super(name, volume, ingredient, color);
    }
}
