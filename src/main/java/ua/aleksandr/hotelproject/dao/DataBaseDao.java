package ua.aleksandr.hotelproject.dao;

import ua.aleksandr.hotelproject.bean.RoomData;
import ua.aleksandr.hotelproject.module.Connector;
import ua.aleksandr.hotelproject.module.ConnectorJDBC;
import ua.aleksandr.hotelproject.bean.LoginData;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DataBaseDao {

    private Connector connector;

    public DataBaseDao() {
        connector = new ConnectorJDBC();
    }

    public String authenticate(LoginData loginData) {
        String givenUsername = loginData.getUsername();
        String givenPassword = loginData.getPassword();

        try (PreparedStatement preparedStatement = connector.getConnection().
                prepareStatement("SELECT * FROM " + connector.getLoginTable() + " WHERE username = ?")) {

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
                prepareStatement("INSERT INTO " + connector.getLoginTable() + " (username, password, salt, role) VALUES (?, ?, ?, ?)")) {

            SaltPasswordHasher hasher = new SHA512SaltPasswordHasher();
            byte[] salt = hasher.getSalt();
            String hashedPassword = hasher.hash(loginData.getPassword(), salt);

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

    public boolean addRoom(RoomData room) {
        boolean set = false;
        try (PreparedStatement preparedStatement = connector.getConnection().
                prepareStatement("INSERT INTO " + connector.getRoomsTable() + " (number, type, size, price, status) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setInt(1, room.getNumber());
            preparedStatement.setString(2, room.getType());
            preparedStatement.setInt(3, room.getSize());
            preparedStatement.setInt(4, room.getPrice());
            preparedStatement.setString(5, room.getStatus());

            preparedStatement.executeUpdate();
            set = true;
        } catch (SQLException e) {
            printException(e);
        }
        return set;
    }

    public List<RoomData> getTableData(String orderParameter) {
        List<RoomData> result = new ArrayList<>();
        try (PreparedStatement statement =
                     connector.getConnection().prepareStatement("SELECT * FROM " + connector.getRoomsTable() + " ORDER BY " + orderParameter)) {
            ResultSet resultSet = statement.executeQuery();
            RoomData room;
            while (resultSet.next()) {
                room = new RoomData(resultSet.getInt("number"), resultSet.getString("type"), resultSet.getInt("size"),
                        resultSet.getInt("price"), resultSet.getString("status"));
                result.add(room);
            }
            return result;
        } catch (SQLException e) {
            String message = e.getMessage();
            System.out.println(message);
            return result;
        }
    }

    public Set<String> getColumnNames(String tableName) {
        Set<String> names = new LinkedHashSet<>();
        String query = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
        try (PreparedStatement statement = connector.getConnection().prepareStatement(query)) {
            statement.setString(1, tableName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                names.add(resultSet.getString("column_name"));
            }
            return names;
        } catch (SQLException e) {
            String[] message = e.getMessage().split("[\n]");
            throw new RuntimeException(message[0]);
        }
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

    public void deleteRoom(int number) {
        try (PreparedStatement preparedStatement = connector.getConnection().
                prepareStatement("DELETE FROM " + connector.getRoomsTable() + " WHERE number = ?")) {
            preparedStatement.setInt(1, number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printException(e);
        }

    }

    public void updateRoom(String[] data) {
        int number = Integer.parseInt(data[0]);
        String type = data[1];
        int price = Integer.parseInt(data[2]);
        String status = data[3];
        try (PreparedStatement preparedStatement = connector.getConnection().
                prepareStatement("UPDATE " + connector.getRoomsTable() + " SET type = ?, price = ?, status = ? WHERE number = ?")) {
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, price);
            preparedStatement.setString(3, status);
            preparedStatement.setInt(4, number);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printException(e);
        }
    }
}
