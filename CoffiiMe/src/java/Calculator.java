package java;

import java.awt.*;
import java.ingredients.Ingredients;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    Map<String, Integer> coffeeIngredients = new HashMap<>();

    public Color calculateNewColor(Color color, int amount){
        return color;
    }

    public double calculateNewVolume(double cm3){
        return cm3;
    }

    public Map<String, Integer> calculateNewIngredients(Ingredients ingredients){
        return coffeeIngredients;
    }
}
