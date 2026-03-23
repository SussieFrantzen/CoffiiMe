package app.coffeeTypes.lungo;

import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class Lungo implements Coffee {

    Color color;
    int volume;
    Map<String, Integer> ingredients;

    public Lungo(Color color, int volume, Map<String, Integer> ingredients) {
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
    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
