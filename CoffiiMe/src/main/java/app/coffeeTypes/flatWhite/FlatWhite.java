package app.coffeeTypes.flatWhite;

import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class FlatWhite implements Coffee {


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
