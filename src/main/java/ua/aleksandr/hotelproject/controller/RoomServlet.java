package ua.aleksandr.hotelproject.controller;

import ua.aleksandr.hotelproject.bean.RoomData;
import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoomServlet extends HttpServlet {

    private DataBaseDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/room_menu.jsp").forward(req, resp);
        dao = (DataBaseDao) req.getSession().getAttribute("dao");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("CREATE") != null) {
            RoomData room = new RoomData();
            room.setNumber(req.getParameter("number"));
            room.setType(req.getParameter("type"));
            room.setPrice(Integer.parseInt(req.getParameter("price")));
            room.setSize(Integer.parseInt(req.getParameter("size")));
            room.setStatus(req.getParameter("status"));
            dao.addRoom(room);
            resp.sendRedirect("rooms");
        }
    }
}
