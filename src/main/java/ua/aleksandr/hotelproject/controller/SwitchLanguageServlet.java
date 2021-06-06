package ua.aleksandr.hotelproject.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/switchlang")
public class SwitchLanguageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("bundle").equals("text")) {
            req.getSession().setAttribute("bundle", "text_ru");
        } else {
            req.getSession().setAttribute("bundle", "text");
        }
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }
}
