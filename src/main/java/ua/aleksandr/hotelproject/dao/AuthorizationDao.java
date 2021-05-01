package ua.aleksandr.hotelproject.dao;

import ua.aleksandr.hotelproject.module.Connector;
import ua.aleksandr.hotelproject.module.ConnectorJDBC;
import ua.aleksandr.hotelproject.module.LoginData;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorizationDao {

    private Connector connector;

    public AuthorizationDao() {
        connector = new ConnectorJDBC("hoteldb", "postgres", "1234");
    }

    public String authenticate(LoginData loginData) {
        String givenUsername = loginData.getUsername();
        String givenPassword = loginData.getPassword();

        try (PreparedStatement preparedStatement = connector.getConnection().
                prepareStatement("SELECT * FROM login WHERE username = ?")) {

            preparedStatement.setString(1, loginData.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String actualUsername = resultSet.getString("username");
                String actualPassword = resultSet.getString("password");
                byte[] salt = resultSet.getBytes("salt");
                String role = resultSet.getString("role");

                SaltPasswordHasher hasher = new SHA512SaltPasswordHasher();
                givenPassword = hasher.hash(givenPassword, salt);

                if (givenUsername.equals(actualUsername)
                        && givenPassword.equals(actualPassword)
                        && role.equals("admin"))
                    return "admin";
                else if (givenUsername.equals(actualUsername)
                        && givenPassword.equals(actualPassword)
                        && role.equals("user"))
                    return "user";
            }

        } catch (SQLException e) {
            printException(e);
        }
        return "mismatch";
    }



    public boolean createUser(LoginData loginData) {
        boolean set = false;
        try (PreparedStatement preparedStatement = connector.getConnection().
                prepareStatement("INSERT INTO login (username, password, salt, role) VALUES (?, ?, ?, ?)")) {

            SaltPasswordHasher hasher = new SHA512SaltPasswordHasher();
            byte[] salt = hasher.getSalt();
            String hashedPassword =  hasher.hash(loginData.getPassword(), salt);

            preparedStatement.setString(1, loginData.getUsername());
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setBytes(3, salt);
            preparedStatement.setString(4, "user");

            preparedStatement.executeUpdate();
            set = true;
        } catch (SQLException | NoSuchAlgorithmException e) {
            printException(e);
        }
        return set;
    }

    //auxiliary  method
    private void printException(Exception ex) {
        System.err.println("Message: " + ex.getMessage());
        Throwable cause = ex.getCause();
        while (cause != null) {
            System.out.println("Cause: " + cause);
            cause = cause.getCause();
        }
    }


}
