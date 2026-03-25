package app.ingredients;
import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public class Water extends Coffee {

    Coffee coffee;
    double totalVolume;

    public Water(Coffee coffee, double totalVolume){
        this.coffee = coffee;
        this.totalVolume = totalVolume;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getVolume() {
        return 0;
    }

    @Override
    public Map<String, Double> getIngredients() {
        return Map.of();
    }

}
