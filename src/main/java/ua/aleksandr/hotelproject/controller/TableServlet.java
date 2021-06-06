package ua.aleksandr.hotelproject.controller;

import ua.aleksandr.hotelproject.bean.RoomData;
import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableServlet extends HttpServlet {

    private DataBaseDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = (DataBaseDao) req.getSession().getAttribute("dao");

        List<List<String>> result;
        List<String> columns = dao.getColumnNames("rooms");
        req.setAttribute("columns", columns);

        if (req.getParameter("ordered") != null) {
            result = buildTable(req.getParameter("ordered"));
        } else {
            result = buildTable();
        }

        if (result.size() != 0) {
            if (result.get(0).isEmpty()) {
                req.setAttribute("table", null);
            } else {
                req.setAttribute("table", result);
            }
        } else {
            req.setAttribute("table", null);
        }
        req.getRequestDispatcher("/table.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = (DataBaseDao) req.getSession().getAttribute("dao");

        if (req.getParameter("REMOVE") != null) {
            String values = req.getParameter("deleted");
            int number = createRoomData(values);
            dao.deleteRoom(number);
            resp.sendRedirect("table");
        }
        if (req.getParameter("EDIT") != null) {
            req.getSession().setAttribute("edited", req.getParameter("edited"));
            resp.sendRedirect("table/update");
        }

        if (req.getParameter("CHOOSE") != null) {
            if(req.getParameter("chosen").endsWith("Booked]")) {
                req.setAttribute("bookError", "Room is already booked");
                doGet(req, resp);
            } else {
                req.getSession().setAttribute("chosen", req.getParameter("chosen"));
                resp.sendRedirect(req.getContextPath() + "/home/book");
            }
        }
        if (req.getParameter("ORDER") != null) {
            doGet(req, resp);
        }
    }

    private int createRoomData(String values) {
        values = values.substring(1);
        values = values.substring(0, values.length() - 1);
        String[] data = values.split(", ");
        return Integer.parseInt(data[0]);
    }

    private List<List<String>> buildTable(String orderParameter) {
        List<List<String>> result = new ArrayList<>();

        List<RoomData> tableData = dao.getTableData(orderParameter);


        for (RoomData data : tableData) {
            List<String> row = new ArrayList<>();
            result.add(row);

            row.add(Integer.toString(data.getNumber()));
            row.add(data.getType());
            row.add(Integer.toString(data.getSize()));
            row.add(Integer.toString(data.getPrice()));
            row.add(data.getStatus());
        }
        return result;
    }

    private List<List<String>> buildTable() {
        return buildTable("number");
    }
}
