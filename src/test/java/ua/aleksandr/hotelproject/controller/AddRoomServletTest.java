package ua.aleksandr.hotelproject.controller;

import org.junit.Before;
import org.junit.Test;
import ua.aleksandr.hotelproject.bean.RoomData;
import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class AddRoomServletTest {

    private HttpServletRequest request = mock(HttpServletRequest.class);
    private HttpServletResponse response = mock(HttpServletResponse.class);
    private HttpSession session = mock(HttpSession.class);
    private DataBaseDao dao = mock(DataBaseDao.class);

    @Before
    public void init() {
        when(session.getAttribute("dao")).thenReturn(dao);
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void testDoGetSuccess() throws ServletException, IOException {
        when(request.getParameter("CREATE")).thenReturn("CREATE");
        when(request.getParameter("number")).thenReturn("999");
        when(request.getParameter("type")).thenReturn("Budget");
        when(request.getParameter("size")).thenReturn("1");
        when(request.getParameter("price")).thenReturn("99");
        when(request.getParameter("status")).thenReturn("Taken");
        when(dao.addRoom(new RoomData(999, "Budget", 1, 99, "Taken"))).thenReturn(true);

        AddRoomServlet addRoomServlet = new AddRoomServlet();
        addRoomServlet.doPost(request, response);

        verify(dao).addRoom(new RoomData(999, "Budget", 1, 99, "Taken"));
        verify(session).setAttribute("newRoom", "Room added");
    }

    @Test
    public void testDoGetFail() throws ServletException, IOException {
        when(request.getParameter("CREATE")).thenReturn("CREATE");
        when(request.getParameter("number")).thenReturn("1");
        when(request.getParameter("type")).thenReturn("Budget");
        when(request.getParameter("size")).thenReturn("1");
        when(request.getParameter("price")).thenReturn("99");
        when(request.getParameter("status")).thenReturn("Taken");
        when(dao.addRoom(new RoomData(1, "Budget", 1, 99, "Taken"))).thenReturn(false);

        AddRoomServlet addRoomServlet = new AddRoomServlet();
        addRoomServlet.doPost(request, response);

        verify(dao).addRoom(new RoomData(1, "Budget", 1, 99, "Taken"));
        verify(session).setAttribute("newRoom", "Room cannot be added");
    }
}
