package ua.aleksandr.hotelproject.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorJDBC implements Connector {

    private Connection connection;

    public ConnectorJDBC(String database, String user, String password) {
        connect(database,user,password);
    }

    public void connect(String database, String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Please add you PosgreSQL Driver to the project!", e);
        }
        try {
            if (connection != null) {
                connection.close();
            }
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + database, user, password);
        } catch (SQLException e) {
            connection = null;
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
