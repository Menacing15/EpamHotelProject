package ua.aleksandr.hotelproject.controller;

import ua.aleksandr.hotelproject.bean.RoomData;
import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddRoomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addRoom.jsp").forward(req, resp);
        req.getSession().removeAttribute("newRoom");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataBaseDao dao = (DataBaseDao) req.getSession().getAttribute("dao");
        if (req.getParameter("CREATE") != null) {
            RoomData room = new RoomData();
            room.setNumber(Integer.parseInt(req.getParameter("number")));
            room.setType(req.getParameter("type"));
            room.setPrice(Integer.parseInt(req.getParameter("price")));
            room.setSize(Integer.parseInt(req.getParameter("size")));
            room.setStatus(req.getParameter("status"));
            if(dao.addRoom(room)) {
                req.getSession().setAttribute("newRoom", "Room added");
            }else {
                req.getSession().setAttribute("newRoom", "Room cannot be added");
            }
            resp.sendRedirect("add");
        }
    }
}
