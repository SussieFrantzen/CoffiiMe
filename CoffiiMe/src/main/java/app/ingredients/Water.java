package app.ingredients;
import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class Water extends Coffee {


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
