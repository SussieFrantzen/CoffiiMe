package app.coffeeTypes.americano;

import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class Americano implements Coffee {

    private Color color;
    private int volume;
    private Map<String, Double> ingredients;

    public Americano(Color color, int volume, Map<String, Double> ingredients) {
        this.color = color;
        this.volume = volume;
        this.ingredients = ingredients;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public Map<String, Double> getIngredients() {
        return ingredients;
    }
}
