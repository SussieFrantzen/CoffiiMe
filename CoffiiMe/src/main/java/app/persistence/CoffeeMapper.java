package app.persistence;

import app.entities.Coffee;
import app.entities.Users;
import app.ingredients.Milk;
import app.ingredients.Water;
import app.ingredients.beansType.BeanDavidoff;
import app.ingredients.beansType.BeanNestle;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMapper {

    private ConnectionPool connectionPool;
    public CoffeeMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    /*
    public List<Coffee> getExistingCoffee(String beanType, double volume){
        List<Coffee> existingCoffee = new ArrayList<>();
        Map<String, Double> ingredient = new HashMap<>();

        String sql =  "SELECT * FROM coffeeTypes where beanBrand = ...." +
                "from CoffeeTypes";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, beanType);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    String coffeType = rs.getString("coffeeType");
                    double milk =  rs.getInt("Milk");
                    double bean =  rs.getInt("Bean");
                    double water =  rs.getInt("Water");

                    ingredient.put("Milk", milk);
                    ingredient.put("Bean", bean);
                    ingredient.put("Water", water);

                    Coffee coffee = new Coffee(coffeType, volume, ingredient,null);
                    existingCoffee.add(coffee);
                    return existingCoffee;


                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
     */

    public Coffee createCoffee(String beanType, int totalVolume, int beanPercentages, int milkPercentages, int waterPercentages){

        Coffee coffee = new BeanNestle(23);
        coffee = new Water(coffee,23);
        coffee = new Milk(coffee,23);

        return coffee;
    }

    public boolean addToFavorites(Users user_id, Coffee coffename){
        return true;
    }

    public List<Coffee> getFavorites(Users user_id){
        return null;
    }
}
