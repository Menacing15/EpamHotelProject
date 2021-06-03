package ua.aleksandr.hotelproject.controller;

import org.junit.Test;
import ua.aleksandr.hotelproject.bean.LoginData;
import ua.aleksandr.hotelproject.dao.DataBaseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class LoginServletTest {

    @Test
    public void testDoPostExistingEmail() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        DataBaseDao dao = mock(DataBaseDao.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("dao")).thenReturn(dao);
        when(request.getParameter("email")).thenReturn("existingemail@gmail.com");
        when(request.getParameter("password")).thenReturn("1234");

        LoginData loginData = new LoginData();

        loginData.setUsername("existingemail@gmail.com");
        loginData.setPassword("1234");

        when(dao.authenticate(loginData)).thenReturn("user");

        LoginServlet loginServlet = new LoginServlet();
        loginServlet.doPost(request, response);

        verify(response).sendRedirect("home");
    }

    @Test
    public void testDoPostNoSuchEmail() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        DataBaseDao dao = mock(DataBaseDao.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("dao")).thenReturn(dao);
        when(request.getParameter("email")).thenReturn("nosuchemail@gmail.com");
        when(request.getParameter("password")).thenReturn("1234");

        LoginData loginData = new LoginData();

        loginData.setUsername("nosuchemail@gmail.com");
        loginData.setPassword("1234");

        when(dao.authenticate(loginData)).thenReturn("mismatch");

        LoginServlet loginServlet = new LoginServlet();
        loginServlet.doPost(request, response);

        verify(session).setAttribute("logError", "Bad login or password");
        verify(response).sendRedirect("login");
    }
}
