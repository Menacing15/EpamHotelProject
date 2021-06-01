package ua.aleksandr.hotelproject.controller;

import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBaseDao dao = new DataBaseDao();
        req.getSession().setAttribute("dao", dao);
        if(req.getSession().getAttribute("bundle") == null) {
            req.getSession().setAttribute("bundle", "text");
        }

        if (req.getSession().getAttribute("role") == null)
            req.getSession().setAttribute("role", "guest");

        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");
        if (role.equals("admin"))
            req.getRequestDispatcher("admin.jsp").forward(req, resp);
        else if (role.equals("user") || role.equals("guest"))
            req.getRequestDispatcher("home.jsp").forward(req, resp);

    }
}
