package ua.aleksandr.hotelproject.bean;

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

    public void setNumber(String number) {

    }
}
