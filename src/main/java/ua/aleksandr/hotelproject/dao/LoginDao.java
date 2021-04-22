package ua.aleksandr.hotelproject.dao;

import ua.aleksandr.hotelproject.module.Connector;
import ua.aleksandr.hotelproject.module.ConnectorJDBC;
import ua.aleksandr.hotelproject.module.LoginData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    private Connector connector;

    public boolean validate(LoginData loginData) {
        boolean status = false;

        connector = new ConnectorJDBC("hoteldb","postgres","1234");

        try (PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement("SELECT * FROM login WHERE username = ? AND password = ? ")) {
            preparedStatement.setString(1, loginData.getUsername());
            preparedStatement.setString(2, loginData.getPassword());

            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
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
