package java;

import java.awt.*;
import java.ingredients.Ingredients;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    Map<String, Integer> coffeeIngredients = new HashMap<>();

    public Color calculateNewColor(Color color, int amount){
        return Color.BLACK;
    }

    public int calculateNewVolume(int amount){
        return 0;
    }

    public Map<String, Integer> calculateNewIngredients(String ingredient, int amount){
        return coffeeIngredients;
    }
}
