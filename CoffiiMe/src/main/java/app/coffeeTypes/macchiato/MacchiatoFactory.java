package app.coffeeTypes.macchiato;

import app.CoffeeFactory;
import app.coffeeTypes.americano.Americano;
import app.entities.Coffee;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MacchiatoFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee(String beanType, int totalVolume) {

        Color color = null;
        Map<String, Double> ingredients = new HashMap<>();

        ingredients.put("Water", 50.0);
        ingredients.put("Milk", 0.0);

        switch (beanType) {
            case "BeanDavidoff":
                ingredients.put("Bean", 30.0);
                color = new Color(155, 90, 20);
                break;
            case "BeanMerild":
                ingredients.put("Bean", 30.0);
                color = new Color(30, 15, 72);
                break;
            case "BeanNestle":
                ingredients.put("Bean", 30.0);
                color = new Color(82, 42, 120);
                break;
        }

        return new Macchiato(color, totalVolume, ingredients);
    }
}
