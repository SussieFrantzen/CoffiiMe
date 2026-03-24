package app.ingredients.beansType;


import app.entities.Coffee;

import java.awt.*;
import java.util.Map;

public class BeanNestle extends Coffee {


    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public double getVolume() {
        return 0;
    }

    @Override
    public Map<String, Double> getIngredients() {
        return Map.of();
    }
}
