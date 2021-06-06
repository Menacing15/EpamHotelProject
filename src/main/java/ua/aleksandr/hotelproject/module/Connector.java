package ua.aleksandr.hotelproject.module;

import java.sql.Connection;

public interface Connector {
    void connect();

    Connection getConnection();

    String getLoginTable();

    String getRoomsTable();

    String getBookedRoomTable();
}
