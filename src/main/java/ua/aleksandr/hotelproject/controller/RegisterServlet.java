package ua.aleksandr.hotelproject.controller;

import ua.aleksandr.hotelproject.dao.LoginDao;
import ua.aleksandr.hotelproject.module.LoginData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private LoginDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = (LoginDao) req.getSession().getAttribute("dao");
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("email");
        String password = req.getParameter("password");

        LoginData loginData = new LoginData();

        loginData.setUsername(username);
        loginData.setPassword(password);


        if (dao.createUser(loginData)) {
            req.getSession().setAttribute("role", "user");
            resp.sendRedirect("home");
        } else {
            resp.sendRedirect("registration.jsp");
        }
    }
}
