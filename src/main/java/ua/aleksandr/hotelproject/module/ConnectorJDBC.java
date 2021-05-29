package ua.aleksandr.hotelproject.module;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectorJDBC implements Connector {

    private Connection connection;

    private String loginTable;
    private String roomsTable;

    public ConnectorJDBC() {
        connect();
    }

    public void connect() {
        Properties properties = new Properties();
        String driver;
        String database;
        String user;
        String password;

        try (FileReader fileReader = new FileReader("src\\main\\resources\\database.properties")){
            properties.load(fileReader);
            driver = properties.getProperty("driver");
            database = properties.getProperty("database");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            loginTable = properties.getProperty("loginTableName");
            roomsTable = properties.getProperty("roomsTableName");
        } catch (IOException e) {
            throw new RuntimeException("Can't get property!", e);
        }

        try {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException("Please add you PosgreSQL Driver to the project!", e);
        }

        try {
            if (connection != null) {
                connection.close();
            }
            connection = DriverManager.getConnection(database, user, password);
        } catch (SQLException e) {
            connection = null;
            throw new RuntimeException("Can't establish connection", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public String getLoginTable() {
        return loginTable;
    }

    public String getRoomsTable() {
        return roomsTable;
    }
}
