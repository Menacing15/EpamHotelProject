package ua.aleksandr.hotelproject.bean;

import java.util.Objects;

public class RoomData {

    public RoomData() {
    }

    public RoomData(int number, String type, int size, int price, String status) {
        this.number = number;
        this.type = type;
        this.size = size;
        this.price = price;
        this.status = status;
    }

    private int number;
    private String type;
    private int size;
    private int price;
    private String status;

    public String getType() {
        return type;
    }

    public void setType(String category) {
        this.type = category;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomData roomData = (RoomData) o;
        return number == roomData.number &&
                size == roomData.size &&
                price == roomData.price &&
                Objects.equals(type, roomData.type) &&
                Objects.equals(status, roomData.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type, size, price, status);
    }
}
