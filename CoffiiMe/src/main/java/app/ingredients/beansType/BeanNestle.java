package app.ingredients.beansType;

import java.awt.*;
import app.entities.Coffee;
import app.ingredients.Ingredients;
import java.util.Map;

public class BeanNestle extends Ingredients {


    int beanAmount;

    BeanNestle(Coffee coffee, int beanAmount){
        super(coffee);
        this.beanAmount = beanAmount;
    }

    @Override
    public Color getColor() {
        return calculator.calculateNewColor(super.getColor(), super.getVolume(), new Color(107,20,73), beanAmount);
    }

    @Override
    public int getVolume() {
        return calculator.calculateNewVolume(super.getVolume(), beanAmount);
    }

    @Override
    public Map<String, Integer> getIngredients() {
        return calculator.calculateNewIngredients(super.getIngredients(), "beanNestle", beanAmount);
    }

}
