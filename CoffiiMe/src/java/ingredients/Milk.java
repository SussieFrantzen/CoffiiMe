package java.ingredients;
import java.awt.*;
import java.util.Map;

public class Milk extends Ingredients {

    int amount;

    Milk(int amount){
        this.amount = amount;
    }

    @Override
    public Color getColor() {
        return calculator.calculateNewColor(Color.BLACK,amount);
    }

    @Override
    public int getVolume() {
        return calculator.calculateNewVolume(amount);
    }

    @Override
    public Map<String, Integer> getIngredients() {
        return calculator.calculateNewIngredients("Milk", amount);
    }
}
