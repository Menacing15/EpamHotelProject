package ua.aleksandr.hotelproject.controller;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error")
public class ErrorHandler extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ErrorHandler.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        if(throwable != null) {
            LOGGER.fatal("Exception: " + throwable.getMessage());
        }if (statusCode != null) {
            LOGGER.fatal("Error, status code: " + statusCode);
        }
        req.getRequestDispatcher("/error.jsp").forward(req, resp);
    }
}
