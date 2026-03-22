package java.coffeeTypes.macchiato;

import java.awt.*;
import java.entities.Coffee;
import java.util.Map;

public class Macchiato implements Coffee {
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
