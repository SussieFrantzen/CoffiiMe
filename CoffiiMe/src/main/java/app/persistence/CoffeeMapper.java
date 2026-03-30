package app.persistence;

import app.entities.Coffee;
import app.entities.CoffeeFavorits;
import app.entities.Users;
import app.exception.DatabaseException;
import app.ingredients.Milk;
import app.ingredients.Water;
import app.ingredients.beansType.BeanKaf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoffeeMapper {

    private ConnectionPool connectionPool;


    public CoffeeMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<CoffeeFavorits> getFavorit(int user_id) {
        List<CoffeeFavorits> favoritList = new ArrayList<>();
        String sql = "SELECT coffeetype, milk, water, bean, brand FROM favorits where user_id = ?";

        try (Connection connection = connectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, user_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    String coffeType = rs.getString("coffeetype");
                    int milk = rs.getInt("milk");
                    int bean = rs.getInt("bean");
                    int water = rs.getInt("water");
                    String brand = rs.getString("brand");


                    CoffeeFavorits favoritCoffe = new CoffeeFavorits(user_id, coffeType, milk, water, bean, brand);
                    favoritList.add(favoritCoffe);
                }
                    return favoritList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
