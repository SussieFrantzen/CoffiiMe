package java.ingredients;

import java.awt.*;
import java.entities.Coffee;
import java.util.Map;

public abstract class Ingredients implements Coffee {

    private Coffee coffee;

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int getVolume() {
        return 0;
    }

    @Override
    public Map<String, Integer> getIngredients() {
        return Map.of();
    }
}
