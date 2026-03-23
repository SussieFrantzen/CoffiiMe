package app.persistence;

import app.coffeeTypes.americano.AmericanoFactory;
import app.entities.Coffee;
import app.entities.Users;
import app.ingredients.Milk;
import app.ingredients.Water;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMapper {

    public List<Coffee> favorites = new ArrayList<>();


    public void createCoffee(){

        Coffee coffee = new AmericanoFactory().createCoffee("BeanMerild");
        coffee = new Milk(coffee,25);
        coffee = new Water(coffee, 50);

        System.out.println(coffee.getColor());
        System.out.println(coffee.getIngredients());
        System.out.println(coffee.getVolume());




    }

    public boolean addToFavorites(Users user_id, Coffee coffename){
        return true;
    }

    public List<Coffee> getFavorites(Users user_id){
        return favorites;
    }
}
