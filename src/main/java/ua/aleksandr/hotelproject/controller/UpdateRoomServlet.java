package ua.aleksandr.hotelproject.controller;

import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateRoomServlet extends HttpServlet {

    private DataBaseDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = (DataBaseDao) req.getSession().getAttribute("dao");
        String edited = (String) req.getSession().getAttribute("edited");

        setRoomAttributes(req, edited);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
        req.getSession().removeAttribute("edited");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = (DataBaseDao) req.getSession().getAttribute("dao");
        if (req.getParameter("UPDATE") != null) {
            String[] dataToUpdate = new String[4];

            dataToUpdate[0] = req.getParameter("number");
            dataToUpdate[1] = req.getParameter("type");
            dataToUpdate[2] = req.getParameter("price");
            dataToUpdate[3] = req.getParameter("status");
            dao.updateRoom(dataToUpdate);
        }
        resp.sendRedirect(req.getContextPath() + "/home/rooms/table");
    }

    private void setRoomAttributes(HttpServletRequest req, String edited) {
        String[] data = reformatToArrayValues(edited);
        req.setAttribute("number", data[0]);
        req.setAttribute("type", data[1]);
        req.setAttribute("size", data[2]);
        req.setAttribute("price", data[3]);
        req.setAttribute("status", data[4]);
    }

    private String[] reformatToArrayValues(String values) {
        values = values.substring(1);
        values = values.substring(0, values.length() - 1);
        return values.split(", ");
    }

}
