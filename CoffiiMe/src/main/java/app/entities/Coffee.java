package app.entities;

import java.awt.*;
import java.util.Map;

public interface Coffee {

    Color getColor();
    int getVolume();
    Map<String, Double> getIngredients();
}
