package app;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    Map<String, Integer> coffeeIngredients = new HashMap<>();

    public Color calculateNewColor(Color coffeeColor, Color ingredientColor, int amount){
        return Color.BLACK;
    }

    public int calculateNewVolume(int coffeeVolume, int amount){
        return coffeeVolume + amount;
    }

    public Map<String, Integer> calculateNewIngredients(Map<String, Integer> coffeeIngredients, String ingredient, int amount){
        return coffeeIngredients;
    }
}
