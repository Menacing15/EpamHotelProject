package ua.aleksandr.hotelproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RoleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("role") == null)
            req.getSession().setAttribute("role", "guest");

        HttpSession session = req.getSession();
        String role =  (String) session.getAttribute("role");
        if(role.equals("admin"))
            req.getRequestDispatcher("admin.jsp").forward(req,resp);
        else if(role.equals("user") || role.equals("guest"))
            req.getRequestDispatcher("home.jsp").forward(req,resp);

    }
}
