package java.coffeeTypes.caffeLatte;

import java.awt.*;
import java.entities.Coffee;
import java.util.Map;

public class CaffeLatte implements Coffee {


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
