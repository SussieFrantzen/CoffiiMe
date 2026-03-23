package app.ingredients;
import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class Milk extends Ingredients {

    int milkAmount;

    public Milk(Coffee coffee, int milkAmount){
        super(coffee);
        this.milkAmount = milkAmount;
    }

    @Override
    public Color getColor() {
        return calculator.calculateNewColor(super.getColor(), super.getVolume(), new Color(110,20,73), milkAmount);
    }

    @Override
    public int getVolume() {
        return calculator.calculateNewVolume(super.getVolume(), milkAmount);
    }

    @Override
    public Map<String, Integer> getIngredients() {
        return calculator.calculateNewIngredients(super.getIngredients(),"Milk", milkAmount);
    }
}
