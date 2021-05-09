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

public class EditRoomServlet extends HttpServlet {

    private DataBaseDao dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = (DataBaseDao) req.getSession().getAttribute("dao");

        List<List<String>> result = buildTable();

        if (result.get(0).isEmpty()) {
            req.setAttribute("table", null);
        } else {
            req.setAttribute("table", result);
        }

        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private List<List<String>> buildTable() {
        List<List<String>> result = new ArrayList<>();

        List<RoomData> tableData = dao.getTableData();
        List<String> columns = new ArrayList<>(dao.getColumnNames("rooms"));

        result.add(columns);

        for (RoomData data : tableData) {
            List<String> row = new ArrayList<>(columns.size());
            result.add(row);

            row.add(data.getType());
            row.add(Integer.toString(data.getSize()));
            row.add(Integer.toString(data.getPrice()));
            row.add(data.getStatus());
        }
        return result;
    }

}
