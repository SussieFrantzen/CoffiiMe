package app.persistence;

import app.coffeeTypes.americano.AmericanoFactory;
import app.coffeeTypes.customCoffee.CustomCoffeeFactory;
import app.entities.Coffee;
import app.entities.Users;
import app.ingredients.Milk;
import app.ingredients.Water;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMapper {

    public List<Coffee> favorites = new ArrayList<>();


    public void createCoffee(){

        Coffee americano = new AmericanoFactory().createCoffee("BeanMerild");
        americano = new Milk(americano,25);
        americano = new Water(americano, 50);

        Coffee customCoffee = new CustomCoffeeFactory().createCoffee("BeanMerild");
        customCoffee = new Water(customCoffee,50);

        System.out.println(customCoffee.getColor());
        System.out.println(americano.getColor());
        System.out.println(americano.getIngredients());
        System.out.println(americano.getVolume());
    }

    public boolean addToFavorites(Users user_id, Coffee coffename){
        return true;
    }

    public List<Coffee> getFavorites(Users user_id){
        return favorites;
    }
}
