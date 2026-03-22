package java.ingredients;
import java.Calculator;
import java.awt.*;
import java.entities.Coffee;
import java.util.Map;

public abstract class Ingredients implements Coffee {

    Calculator calculator = new Calculator();
    private Coffee coffee;

    @Override
    public abstract Color getColor();

    @Override
    public abstract int getVolume();

    @Override
    public abstract Map<String, Integer> getIngredients();

}
