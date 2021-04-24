package ua.aleksandr.hotelproject.dao;

import ua.aleksandr.hotelproject.module.Connector;
import ua.aleksandr.hotelproject.module.ConnectorJDBC;
import ua.aleksandr.hotelproject.module.LoginData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    private Connector connector;

    public LoginDao() {
        connector = new ConnectorJDBC("hoteldb", "postgres", "1234");
    }

    public String authenticate(LoginData loginData) {
        String userName = loginData.getUsername();
        String password = loginData.getPassword();

        try (PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?")) {
            preparedStatement.setString(1, loginData.getUsername());
            preparedStatement.setString(2, loginData.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String userNameDB = resultSet.getString("username");
                String passwordDB = resultSet.getString("password");
                String roleDB = resultSet.getString("role");

                if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("admin"))
                    return "admin";
                else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("user"))
                    return "user";
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return "mismatch";
    }

    public boolean createUser(LoginData loginData) {
        boolean set = false;
        try (PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement("INSERT INTO login (username, password, role) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, loginData.getUsername());
            preparedStatement.setString(2, loginData.getPassword());
            preparedStatement.setString(3, "user");

            preparedStatement.executeUpdate();
            set = true;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return set;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable cause = ex.getCause();
                while (cause != null) {
                    System.out.println("Cause: " + cause);
                    cause = cause.getCause();
                }
            }
        }
    }
}
