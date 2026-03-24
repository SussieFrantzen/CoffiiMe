package app.coffeeTypes.americano;

import app.CoffeeFactory;
import app.entities.Coffee;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AmericanoFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee(String beanType, int totalVolume) {

        double waterPercentages = 72.4;            //Found by research
        double milkPercentages = 0;                //Found by research
        double coffeebeanPercentages = 27.6;       //Found by research
        double waterMilliliter = waterPercentages*totalVolume/100;
        double milkMilliliter = milkPercentages*totalVolume/100;
        double coffeebeanKilogram = coffeebeanPercentages*totalVolume/100;;

        Color color = null;
        Map<String, Double> ingredients = new HashMap<>();
        ingredients.put("Water", waterMilliliter);
        ingredients.put("Milk", milkMilliliter);

        switch (beanType) {
            case "BeanDavidoff":
                ingredients.put("BeanDavidoff", coffeebeanKilogram);
                color = new Color(155, 90, 20);
                break;
            case "BeanMerild":
                ingredients.put("BeanMerild", coffeebeanKilogram);
                color = new Color(30, 15, 72);
                break;
            case "BeanNestle":
                ingredients.put("BeanNestle", coffeebeanKilogram);
                color = new Color(82, 42, 120);
                break;
        }

        return new Americano(color, totalVolume, ingredients);
    }
}
