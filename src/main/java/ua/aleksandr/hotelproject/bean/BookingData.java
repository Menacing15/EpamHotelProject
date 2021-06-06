package ua.aleksandr.hotelproject.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingData {
    private String booker;
    private LocalDate arrival;
    private LocalDate departure;
    private LocalDateTime bookingTime;
    private String status;

    public BookingData(String booker, LocalDate arrival, LocalDate departure, LocalDateTime bookingTime, String status) {
        this.arrival = arrival;
        this.departure = departure;
        this.booker = booker;
        this.bookingTime = bookingTime;
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
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
