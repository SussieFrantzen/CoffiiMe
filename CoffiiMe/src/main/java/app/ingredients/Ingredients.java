package app.ingredients;
import app.Calculator;
import java.awt.*;
import app.entities.Coffee;
import java.util.Map;

public abstract class Ingredients implements Coffee {

    protected Coffee coffee;
    protected Calculator calculator = new Calculator();

    protected Ingredients(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public Color getColor(){
        return coffee.getColor();
    }

    @Override
    public int getVolume(){
        return coffee.getVolume();
    }

    @Override
    public Map<String, Integer> getIngredients(){
        return coffee.getIngredients();
    }
}
