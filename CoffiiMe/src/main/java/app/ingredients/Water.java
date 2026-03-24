package app.ingredients;
import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class Water extends Ingredients{

    int waterPercentages;

    public Water(Coffee coffee, int waterPercentages){
        super(coffee);
        this.waterPercentages = waterPercentages;
    }

    @Override
    public Color getColor() {
        return calculator.calculateNewColor(super.getColor(), new Color(42,25,120), waterPercentages);
    }

    @Override
    public int getVolume() {
        return calculator.calculateNewVolume(super.getVolume());
    }

    @Override
    public Map<String, Double> getIngredients() {
        return calculator.calculateNewIngredients(super.getIngredients(), "Water", waterPercentages);
    }
}
