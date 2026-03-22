package java;

import java.entities.Coffee;

public interface CoffeeFactory {
    Coffee createCoffee(String type);
}
