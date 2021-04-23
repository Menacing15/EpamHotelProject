package ua.aleksandr.hotelproject.controller;

import ua.aleksandr.hotelproject.dao.LoginDao;
import ua.aleksandr.hotelproject.module.LoginData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private LoginDao dao;

    public void init() {
        dao = new LoginDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("login");
        String password = request.getParameter("password");

        LoginData loginData = new LoginData();

        loginData.setUsername(username);
        loginData.setPassword(password);

        String role = dao.authenticate(loginData);

        if(role.equals("admin") || role.equals("user") ) {
            request.getSession().setAttribute("role", role);
            response.sendRedirect("home");
        }
        else {
            request.setAttribute("errMessage", role);
            response.sendRedirect("login");
        }
    }
}