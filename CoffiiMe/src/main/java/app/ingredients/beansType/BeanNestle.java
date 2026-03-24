package app.ingredients.beansType;

import java.awt.*;
import app.entities.Coffee;
import app.ingredients.Ingredients;
import java.util.Map;

public class BeanNestle extends Ingredients {


    int beanPercentages;

    BeanNestle(Coffee coffee, int beanPercentages){
        super(coffee);
        this.beanPercentages = beanPercentages;
    }

    @Override
    public Color getColor() {
        return calculator.calculateNewColor(super.getColor(), new Color(107,20,73), beanPercentages);
    }

    @Override
    public int getVolume() {
        return calculator.calculateNewVolume(super.getVolume());
    }

    @Override
    public Map<String, Double> getIngredients() {
        return calculator.calculateNewIngredients(super.getIngredients(), "beanNestle", beanPercentages);
    }

}
