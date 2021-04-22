package ua.aleksandr.hotelproject.module;

import java.sql.Connection;

public interface Connector {
    void connect(String database, String user, String password);

    Connection getConnection();
}
