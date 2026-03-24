package app;

import app.entities.Coffee;

public interface CoffeeFactory {
    public Coffee createCoffee(String beanType, int totalVolume);
}
