package app.persistence;

import app.entities.Coffee;
import app.entities.Users;
import app.exception.DatabaseException;
import app.ingredients.Milk;
import app.ingredients.Water;
import app.ingredients.beansType.BeanKaf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Coffee createCoffee(String beanType, int totalVolume, int beanPercentages, int milkPercentages, int waterPercentages) {

        Coffee coffee = new BeanKaf(23);
        coffee = new Water(coffee, 23);
        coffee = new Milk(coffee, 23);

        return coffee;
    }

    public boolean addToFavorites(Users user_id, Coffee coffename) {
        return true;
    }

    public List<Coffee> getFavorites(Users user_id) {
        return null;
    }


    public boolean addCoffeTypeToFavorit(String coffeetype, int userId) throws DatabaseException {
        String sql = "INSERT INTO favorits (user_id, coffeetype, milk, water, bean, brand)\n SELECT ?, " +
                "coffeetype, milk_ml, water_ml, beans_g, NULL FROM coffeetypes WHERE coffeetype = ?";

        try (Connection conn = connectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, coffeetype);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            throw new DatabaseException("Kunne ikke kopiere kaffe til favorit.", e.getMessage());
        }
    }

}
