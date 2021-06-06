package ua.aleksandr.hotelproject.controller;

import ua.aleksandr.hotelproject.dao.DataBaseDao;
import ua.aleksandr.hotelproject.bean.LoginData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("loginPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        req.getSession().setAttribute("user", email);

        DataBaseDao dao = (DataBaseDao)req.getSession().getAttribute("dao");

        LoginData loginData = new LoginData();

        loginData.setUsername(email);
        loginData.setPassword(password);

        String role = dao.authenticate(loginData);

        if(role.equals("admin") || role.equals("user")) {
            req.getSession().setAttribute("role", role);
            req.getSession().removeAttribute("logError");

            String referer = req.getHeader("Referer");
            if(referer.endsWith("login")) {
                resp.sendRedirect("home");
            } else {
                resp.sendRedirect(referer);
            }
        }
        else {
            req.getSession().setAttribute("logError", "Bad login or password");
            resp.sendRedirect("login");
        }
    }
}
