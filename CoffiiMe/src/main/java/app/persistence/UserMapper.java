package app.persistence;

import app.entities.Users;
import app.exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static Users login(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        String sql = """
            SELECT u.user_id, u.firstname, u.lastname, u.email, a.password
            FROM users u
            JOIN account a ON u.user_id = a.user_id
            WHERE u.email = ? AND a.password = ?
            """;

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        )
        {
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                return new Users(
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("user_id")
                );
            }
            else
            {
                throw new DatabaseException("Forkert email eller password");
            }
        }
        catch (SQLException e)
        {
            throw new DatabaseException("Login fejl", e.getMessage());
        }
    }

    public static void createUser(String firstname, String lastname, String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        String insertUserSql = "INSERT INTO users (firstname, lastname, email) VALUES (?, ?, ?)";
        String insertAccountSql = "INSERT INTO account (user_id, password) VALUES (?, ?)";

        try (Connection connection = connectionPool.getConnection())
        {
            connection.setAutoCommit(false);

            int userId;

            // 🔹 Insert i users + hent generated key
            try (PreparedStatement psUser = connection.prepareStatement(insertUserSql, PreparedStatement.RETURN_GENERATED_KEYS))
            {
                psUser.setString(1, firstname);
                psUser.setString(2, lastname);
                psUser.setString(3, email);

                psUser.executeUpdate();

                ResultSet rs = psUser.getGeneratedKeys();
                if (rs.next())
                {
                    userId = rs.getInt(1);
                }
                else
                {
                    throw new DatabaseException("Kunne ikke hente user_id");
                }
            }

            // 🔹 Insert i account
            try (PreparedStatement psAccount = connection.prepareStatement(insertAccountSql))
            {
                psAccount.setInt(1, userId);
                psAccount.setString(2, password);

                psAccount.executeUpdate();
            }

            connection.commit();
        }
        catch (SQLException e)
        {
            throw new DatabaseException("Fejl ved oprettelse af bruger", e.getMessage());
        }
    }
    }

