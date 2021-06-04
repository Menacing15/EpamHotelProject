package ua.aleksandr.hotelproject.controller;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class HomeServletTest {

    private HttpServletRequest request = mock(HttpServletRequest.class);
    private HttpServletResponse response = mock(HttpServletResponse.class);
    private HttpSession session = mock(HttpSession.class);
    private RequestDispatcher dispatcher = mock(RequestDispatcher.class);

    @Test
    public void testDoGetAdminCase() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("bundle")).thenReturn(null);
        when(session.getAttribute("role")).thenReturn("admin");
        when(request.getRequestDispatcher("admin.jsp")).thenReturn(dispatcher);

        HomeServlet homeServlet = new HomeServlet();
        homeServlet.doGet(request, response);

        verify(session).setAttribute("bundle", "text");
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoGetGuestCase() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("bundle")).thenReturn("text");
        when(session.getAttribute("role")).thenReturn("guest");
        when(request.getRequestDispatcher("home.jsp")).thenReturn(dispatcher);

        HomeServlet homeServlet = new HomeServlet();
        homeServlet.doGet(request, response);

        verify(dispatcher).forward(request, response);
    }
}
