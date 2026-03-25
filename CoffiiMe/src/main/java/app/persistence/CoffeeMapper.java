package app.persistence;

import app.entities.Coffee;
import app.entities.Users;
import app.ingredients.Milk;
import app.ingredients.Water;

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

    public List<Coffee> getExistingCoffee(String beanBrand, double volume){
        List<Coffee> existingCoffee = new ArrayList<>();
        Map<String, Double> ingredient = new HashMap<>();

        String sql =  "SELECT * FROM coffeeTypes where beanBrand = ...." +
                "from CoffeeTypes";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, beanBrand);
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
    }

    public void createCoffee(String beanType, int totalVolume, int beanPercentages, int milkPercentages, int waterPercentages){



    }

    public boolean addToFavorites(Users user_id, Coffee coffename){
        return true;
    }

    public List<Coffee> getFavorites(Users user_id){
        return favorites;
    }
}
