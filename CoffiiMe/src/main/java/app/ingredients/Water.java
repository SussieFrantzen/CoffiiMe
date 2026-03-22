package app.ingredients;
import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class Water extends Ingredients{

    int waterAmount;

    Water(Coffee coffee, int waterAmount){
        super(coffee);
        this.waterAmount = waterAmount;
    }

    @Override
    public Color getColor() {
        return calculator.calculateNewColor(super.getColor(), Color.BLACK, waterAmount);
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
