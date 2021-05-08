package ua.aleksandr.hotelproject.controller;

import ua.aleksandr.hotelproject.dao.DataBaseDao;
import ua.aleksandr.hotelproject.bean.LoginData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private DataBaseDao dao;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = new DataBaseDao();
        req.getSession().setAttribute("dao", dao);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        LoginData loginData = new LoginData();

        loginData.setUsername(email);
        loginData.setPassword(password);

        String role = dao.authenticate(loginData);

        if(role.equals("admin") || role.equals("user") ) {
            req.getSession().setAttribute("role", role);
            req.getSession().removeAttribute("logError");
            resp.sendRedirect("home");
        }
        else {
            req.getSession().setAttribute("logError", "Bad login or password");
            resp.sendRedirect("login");
        }
    }
}
