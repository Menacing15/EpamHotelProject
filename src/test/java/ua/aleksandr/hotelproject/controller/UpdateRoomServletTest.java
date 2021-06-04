package ua.aleksandr.hotelproject.controller;

import org.junit.Before;
import org.junit.Test;
import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class UpdateRoomServletTest {

    private UpdateRoomServlet updateServlet = new UpdateRoomServlet();
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
        when(request.getRequestDispatcher("/update.jsp")).thenReturn(dispatcher);
        when(session.getAttribute("edited")).thenReturn("[1, Premium, 3, 99, Taken]");

        updateServlet.doGet(request, response);

        verify(request).setAttribute("number", "1");
        verify(request).setAttribute("type", "Premium");
        verify(request).setAttribute("size", "3");
        verify(request).setAttribute("price", "99");
        verify(request).setAttribute("status", "Taken");
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        when(request.getParameter("UPDATE")).thenReturn("UPDATE");

        when(request.getParameter("number")).thenReturn("1");
        when(request.getParameter("type")).thenReturn("Premium");
        when(request.getParameter("price")).thenReturn("159");
        when(request.getParameter("status")).thenReturn("Available");

        updateServlet.doPost(request, response);

        verify(dao).updateRoom(new String[]{"1", "Premium", "159", "Available"});
    }
}
