package app;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    public Color calculateNewColor(Color coffeeColor, int coffeeAmount, Color ingredientColor, int ingredientAmount){
        int sumVolume = coffeeAmount + ingredientAmount;
        float ingredientRatio = (float) ingredientAmount/sumVolume;

        //Equation: (r3,g3,b3) = (r1,g1,b1)*(1-ingredientRatio)+(r2,g2,b2)*ingredientRatio
        float newR = coffeeColor.getRed()*(1-ingredientRatio)+ingredientColor.getRed()*ingredientRatio;
        float newG = coffeeColor.getGreen()*(1-ingredientRatio)+ingredientColor.getGreen()*ingredientRatio;
        float newB = coffeeColor.getBlue()*(1-ingredientRatio)+ingredientColor.getBlue()*ingredientRatio;

        return new Color(newR/255f,newG/255f,newB/255f);
    }

    public int calculateNewVolume(int coffeeVolume, int amount){
        return coffeeVolume + amount;
    }

    public Map<String, Integer> calculateNewIngredients(Map<String, Integer> coffeeIngredients, String ingredient, int amount){

        if(coffeeIngredients.containsKey(ingredient)){
            coffeeIngredients.put(ingredient, coffeeIngredients.get(ingredient) + amount);
        } else {
            coffeeIngredients.put(ingredient, amount);
        }
        return coffeeIngredients;
    }
}
