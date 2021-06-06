package ua.aleksandr.hotelproject.controller;

import ua.aleksandr.hotelproject.bean.BookingData;
import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("chosen") != null) {
            req.getRequestDispatcher("/bookRoom.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/requestRoom.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate arrival = LocalDate.parse(req.getParameter("arrival"));
        LocalDate departure = LocalDate.parse(req.getParameter("arrival"));

        DataBaseDao dao = (DataBaseDao) req.getSession().getAttribute("dao");
        String booker = (String) req.getSession().getAttribute("user");

        LocalDateTime bookingTime = LocalDateTime.now();
        BookingData bookingData = new BookingData(booker, arrival, departure, bookingTime, "Booked");

        String chosenRoom = (String)req.getSession().getAttribute("chosen");
        String [] values = reformatToArrayValues(chosenRoom);
        int roomNumber = Integer.parseInt(values[0]);
        dao.bookRoom(roomNumber, bookingData);
        resp.sendRedirect(req.getContextPath() + "/home/profile");
    }

    private String[] reformatToArrayValues(String values) {
        values = values.substring(1);
        values = values.substring(0, values.length() - 1);
        return values.split(", ");
    }
}
