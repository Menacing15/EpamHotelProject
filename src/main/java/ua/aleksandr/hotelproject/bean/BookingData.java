package ua.aleksandr.hotelproject.bean;

import java.time.LocalDate;

public class BookingData {
    private String booker;
    private LocalDate arrival;
    private LocalDate departure;

    public BookingData(String booker, LocalDate arrival, LocalDate departure) {
        this.arrival = arrival;
        this.departure = departure;
        this.booker = booker;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public String getBooker() {
        return booker;
    }
}
