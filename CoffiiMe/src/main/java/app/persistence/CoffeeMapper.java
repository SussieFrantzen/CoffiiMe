package app.persistence;

import app.coffeeTypes.americano.AmericanoFactory;
import app.entities.Coffee;
import app.entities.Users;
import app.ingredients.Milk;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMapper {

    public List<Coffee> favorites = new ArrayList<>();


    public void createCoffee(){

        Coffee coffee = new AmericanoFactory().createCoffee("BeanMerild");
        coffee = new Milk(coffee,20);

        System.out.println(coffee.getVolume());
    }

    public boolean addToFavorites(Users user_id, Coffee coffename){
        return true;
    }

    public List<Coffee> getFavorites(Users user_id){
        return favorites;
    }
}
