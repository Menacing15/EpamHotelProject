package ua.aleksandr.hotelproject.controller;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LogoutServletTest extends HttpServlet {

    @Test
    public void testDoGet() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        LogoutServlet logoutServlet = new LogoutServlet();
        logoutServlet.doGet(request, response);

        verify(session).invalidate();
        verify(response).sendRedirect("login");
    }
}
