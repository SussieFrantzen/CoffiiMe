package app.coffeeTypes.customCoffee;

import app.CoffeeFactory;
import app.entities.Coffee;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CustomCoffeeFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee(String beanType) {

        Color color = null;
        int volume = 50;
        Map<String, Integer> ingredients = new HashMap<>();

        switch (beanType) {
            case "BeanDavidoff":
                ingredients.put("Bean", 30);
                color = new Color(155, 90, 20);
                break;
            case "BeanMerild":
                ingredients.put("Bean", 30);
                color = new Color(30, 15, 72);
                break;
            case "BeanNestle":
                ingredients.put("Bean", 30);
                color = new Color(82, 42, 120);
                break;
        }

        return new CustomCoffee(color, volume, ingredients);
    }
}
