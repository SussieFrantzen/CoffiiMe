package app.persistence;
import app.coffeeTypes.americano.AmericanoFactory;
import app.coffeeTypes.caffeLatte.CaffeLatteFactory;
import app.coffeeTypes.cappoccino.CappouccionoFactory;
import app.coffeeTypes.cortado.CortadoFactory;
import app.coffeeTypes.customCoffee.CustomCoffeeFactory;
import app.coffeeTypes.expresso.ExpressoFactory;
import app.coffeeTypes.flatWhite.FlatWhiteFactory;
import app.coffeeTypes.latteMacchiato.LatteMacchiatoFactory;
import app.coffeeTypes.lungo.LungoFactory;
import app.coffeeTypes.macchiato.MacchiatoFactory;
import app.coffeeTypes.mocha.MochaFactory;
import app.entities.Coffee;
import app.entities.Users;
import app.ingredients.Milk;
import app.ingredients.Water;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMapper {

    public List<Coffee> favorites = new ArrayList<>();

    public Coffee getExistingCoffee(String beanType, String coffeeType, int totalVolume){

        Coffee existingCoffee = null;
        switch (coffeeType){
            case "americano":
                existingCoffee = new AmericanoFactory().createCoffee(beanType, totalVolume);
                break;
            case "caffeLatte":
                existingCoffee = new CaffeLatteFactory().createCoffee(beanType, totalVolume);
                break;
            case "cappoucciono":
                existingCoffee = new CappouccionoFactory().createCoffee(beanType, totalVolume);
                break;
            case "cortado":
                existingCoffee = new CortadoFactory().createCoffee(beanType, totalVolume);
                break;
            case "expresso":
                existingCoffee = new ExpressoFactory().createCoffee(beanType, totalVolume);
                break;
            case "flatWhite":
                existingCoffee = new FlatWhiteFactory().createCoffee(beanType, totalVolume);
                break;
            case "latteMacchiato":
                existingCoffee = new LatteMacchiatoFactory().createCoffee(beanType, totalVolume);
                break;
            case "lungo":
                existingCoffee = new LungoFactory().createCoffee(beanType, totalVolume);
                break;
            case "macchiato":
                existingCoffee = new MacchiatoFactory().createCoffee(beanType, totalVolume);
                break;
            case "mocha":
                existingCoffee = new MochaFactory().createCoffee(beanType, totalVolume);
                break;
        }
        existingCoffee = new Water(existingCoffee, 0);
        existingCoffee = new Milk(existingCoffee,0);
        return existingCoffee;
    }

    public Coffee createCoffee(String beanType, int totalVolume, int beanPercentages, int milkPercentages, int waterPercentages){

        Coffee customCoffee = new CustomCoffeeFactory().createCoffee(beanType, totalVolume);
        customCoffee = new Water(customCoffee, waterPercentages);
        customCoffee = new Milk(customCoffee,milkPercentages);
        return customCoffee;
    }

    public boolean addToFavorites(Users user_id, Coffee coffename){
        return true;
    }

    public List<Coffee> getFavorites(Users user_id){
        return favorites;
    }
}
