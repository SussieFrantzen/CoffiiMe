package app.ingredients;
import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class Milk extends Coffee {


    public Milk(String name, double volume, Map<String, Double> ingredient, Color color) {
        super(name, volume, ingredient, color);
    }

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
