package app.ingredients;
import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class Milk extends Ingredients {

    int milkPercentages;

    public Milk(Coffee coffee, int milkPercentages){
        super(coffee);
        this.milkPercentages = milkPercentages;
    }

    @Override
    public Color getColor() {
        return calculator.calculateNewColor(super.getColor(), new Color(110,20,73), milkPercentages);
    }

    @Override
    public int getVolume() {
        return calculator.calculateNewVolume(super.getVolume());
    }

    @Override
    public Map<String, Double> getIngredients() {
        return calculator.calculateNewIngredients(super.getIngredients(),"Milk", milkPercentages);
    }
}
