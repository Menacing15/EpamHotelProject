package ua.aleksandr.hotelproject.controller;

import org.junit.Before;
import org.junit.Test;
import ua.aleksandr.hotelproject.bean.RoomData;
import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.*;

public class TableServletTest {

    private TableServlet tableServlet = new TableServlet();
    private HttpServletRequest request = mock(HttpServletRequest.class);
    private HttpServletResponse response = mock(HttpServletResponse.class);
    private HttpSession session = mock(HttpSession.class);
    private DataBaseDao dao = mock(DataBaseDao.class);
    private RequestDispatcher dispatcher = mock(RequestDispatcher.class);

    @Before
    public void init() {
        when(session.getAttribute("dao")).thenReturn(dao);
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        when(request.getRequestDispatcher("/table.jsp")).thenReturn(dispatcher);
        when(request.getAttribute("ordered")).thenReturn(null);

        List<String> list = new ArrayList<>();
        list.add("number");
        list.add("type");
        list.add("size");
        list.add("price");
        list.add("status");
        when(dao.getColumnNames("rooms")).thenReturn(list);

        List<List<String>> table = new ArrayList<>();
        RoomData someRoom = new RoomData(1, "Premium", 3, 99, "Taken");
        List<RoomData> row = new ArrayList<>();
        row.add(someRoom);

        List<String> parsedRow = new ArrayList<>();
        parsedRow.add("1");
        parsedRow.add("Premium");
        parsedRow.add("3");
        parsedRow.add("99");
        parsedRow.add("Taken");

        table.add(parsedRow);
        when(dao.getTableData("number")).thenReturn(row);

        tableServlet.doGet(request, response);

        verify(request).setAttribute("columns", list);
        verify(request).setAttribute("table", table);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        when(request.getParameter("REMOVE")).thenReturn("REMOVE");
        when(request.getParameter("deleted")).thenReturn("[1, Premium, 3, 99, Taken]");

        when(request.getParameter("EDIT")).thenReturn("EDIT");
        when(request.getParameter("edited")).thenReturn("[1, Premium, 3, 99, Taken]");

        when(request.getParameter("CHOOSE")).thenReturn("CHOOSE");
        when(request.getParameter("chosen")).thenReturn("[1, Premium, 3, 99, Taken]");

        tableServlet.doPost(request, response);

        verify(dao).deleteRoom(1);
        verify(session).setAttribute("edited", request.getParameter("edited"));
        verify(session).setAttribute("chosen", request.getParameter("chosen"));
    }
}
