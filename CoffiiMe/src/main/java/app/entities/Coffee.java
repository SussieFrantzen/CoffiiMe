package app.entities;

import app.Calculator;

import java.awt.*;
import java.util.Map;

public abstract class Coffee extends Calculator {

   public abstract Color getColor();
    public abstract double getVolume();
    public abstract   Map<String, Double> getIngredients();

}
