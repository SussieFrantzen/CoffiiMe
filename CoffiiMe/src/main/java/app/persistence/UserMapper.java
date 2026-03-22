package app.persistence;

import app.entities.Users;
import app.exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static Users login(String email, String password, ConnectionPool connectionPool) throws DatabaseException {

        String sql = "SELECT * FROM users WHERE email=? AND user_password=?";

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                long id = rs.getLong("user_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                return new Users(firstName, lastName, email, password, (int) id);
            } else {
                throw new DatabaseException("Forkert email eller kode");
            }

        } catch (SQLException e) {
            throw new DatabaseException("Database fejl ved login", e.getMessage());
        }
    }


}
