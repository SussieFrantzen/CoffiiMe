package app.persistence;

import app.entities.Coffee;
import app.entities.Users;
import app.ingredients.Milk;
import app.ingredients.Water;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMapper {

    public List<Coffee> favorites = new ArrayList<>();

    public void getExistingCoffee(String beanType, String coffeeType, int totalVolume){


    }

    public void createCoffee(String beanType, int totalVolume, int beanPercentages, int milkPercentages, int waterPercentages){
        Coffee coffee = new Milk();


    }

    public boolean addToFavorites(Users user_id, Coffee coffename){
        return true;
    }

    public List<Coffee> getFavorites(Users user_id){
        return favorites;
    }
}
