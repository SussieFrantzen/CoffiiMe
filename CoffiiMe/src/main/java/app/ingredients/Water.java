package app.ingredients;
import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class Water extends Ingredients{

    int waterAmount;

    public Water(Coffee coffee, int waterAmount){
        super(coffee);
        this.waterAmount = waterAmount;
    }

    @Override
    public Color getColor() {
        return calculator.calculateNewColor(super.getColor(), super.getVolume(), new Color(42,25,120), waterAmount);
    }

    @Override
    public int getVolume() {
        return calculator.calculateNewVolume(super.getVolume(), waterAmount);
    }

    @Override
    public Map<String, Integer> getIngredients() {
        return calculator.calculateNewIngredients(super.getIngredients(), "Water", waterAmount);
    }
}
